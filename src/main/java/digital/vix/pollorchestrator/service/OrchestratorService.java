package digital.vix.pollorchestrator.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import digital.vix.pollorchestrator.models.Endpoint;
import digital.vix.pollorchestrator.models.EndpointHistory;
import digital.vix.pollorchestrator.models.EndpointResponsibility;
import digital.vix.pollorchestrator.models.Poller;
import digital.vix.pollorchestrator.persistence.EndpointHistoryRepository;
import digital.vix.pollorchestrator.persistence.EndpointRepository;
import digital.vix.pollorchestrator.persistence.EndpointResponsibilityRepository;
import digital.vix.pollorchestrator.persistence.PollerRepository;

@Service
public class OrchestratorService {

	private LoadDistributable distributable;
	private EndpointRepository endpointRepository;
	private PollerRepository pollerRepository;
	private EndpointResponsibilityRepository endpointResponsibilityRepository;
	private EndpointHistoryRepository endpointHistoryRepository;

	public OrchestratorService(LoadDistributable distributable, EndpointRepository endpointRepository,
			PollerRepository pollerRepository, EndpointResponsibilityRepository endpointResponsibilityRepository,
			EndpointHistoryRepository endpointHistoryRepository) {
		super();
		this.distributable = distributable;
		this.endpointRepository = endpointRepository;
		this.pollerRepository = pollerRepository;
		this.endpointResponsibilityRepository = endpointResponsibilityRepository;
		this.endpointHistoryRepository = endpointHistoryRepository;
	}

	public List<Endpoint> getAllActiveEndpoints() {
		return endpointRepository.findAllActiveEndpoints();
	}

	public void addToPolling(Endpoint endpoint) {
		Optional<Endpoint> searched = endpointRepository.findByEndpoint(endpoint.getEndpoint());
		Endpoint found;
		if (searched.isPresent()) {
			found = searched.get();
		} else {
			found = endpointRepository.saveAndFlush(endpoint);
		}

		List<Poller> pollers = pollerRepository.findAllActivePollers();
		if (pollers.size() == 0) {
			throw new RuntimeException("No polling services available");
		}
		Poller poller = distributable.distributeLoad(pollers, null);
		EndpointResponsibility endpointResponsibility = new EndpointResponsibility(null, found.getId(), poller.getId());
		endpointResponsibilityRepository.saveAndFlush(endpointResponsibility);
	}

	public void updateEndpoint(Endpoint endpoint) {
		Endpoint found = endpointRepository.findByEndpoint(endpoint.getEndpoint())
				.orElseThrow(() -> new RuntimeException("Not found"));
		endpoint.setId(found.getId());
		endpointRepository.saveAndFlush(endpoint);
	}

	public void deleteEndpoint(String endpoint) {
		Endpoint found = endpointRepository.findByEndpoint(endpoint)
				.orElseThrow(() -> new RuntimeException("Not found"));

		for (EndpointResponsibility endpointResponsibility : endpointResponsibilityRepository
				.findByEndpointId(found.getId())) {
			endpointResponsibilityRepository.delete(endpointResponsibility);
		}

	}

	public List<EndpointHistory> findHistory(String endpoint) {
		Endpoint found = endpointRepository.findByEndpoint(endpoint)
				.orElseThrow(() -> new RuntimeException("Not found"));
		return endpointHistoryRepository.findByEndpointId(found.getId());
	}

	public void swapResponsibility() {
		List<Poller> pollers = pollerRepository.findAllDeactivePollers();
		for (Poller poller : pollers) {
			List<EndpointResponsibility> responsibilities = endpointResponsibilityRepository
					.findByPollerId(poller.getId());
			List<Endpoint> endpointIdsToRedistribute = responsibilities.stream()
					.map(responsibility -> responsibility.getEndpointId())
					.map(endpointId -> endpointRepository.getOne(endpointId)).collect(Collectors.toList());
			for(Endpoint endpoint : endpointIdsToRedistribute) {
				addToPolling(endpoint);
			}
		}
	}
}
