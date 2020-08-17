package digital.vix.pollorchestrator.controller;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import digital.vix.pollorchestrator.dto.EndpointDto;
import digital.vix.pollorchestrator.dto.EndpointHistoryDto;
import digital.vix.pollorchestrator.models.Endpoint;
import digital.vix.pollorchestrator.models.EndpointHistory;
import digital.vix.pollorchestrator.service.OrchestratorService;

@RestController
@CrossOrigin("*")
public class OrchestratorController {

	private OrchestratorService orchestratorController;
	private ModelMapper modelMapper;

	public OrchestratorController(OrchestratorService orchestratorController, ModelMapper modelMapper) {
		super();
		this.orchestratorController = orchestratorController;
		this.modelMapper = modelMapper;
	}

	@RequestMapping(path = "/api/poll", method = { RequestMethod.GET })
	public List<EndpointDto> getAllEndpoints() {
		return orchestratorController.getAllActiveEndpoints().stream()
				.map(endpoint -> modelMapper.map(endpoint, EndpointDto.class)).collect(Collectors.toList());
	}

	@RequestMapping(path = "/api/poll", method = { RequestMethod.POST })
	public String addToPolling(@RequestBody EndpointDto endpointDto) {
		Endpoint endpoint = modelMapper.map(endpointDto, Endpoint.class);
		orchestratorController.addToPolling(endpoint);
		return endpointDto.getEndpoint() + " will be polled every " + endpointDto.getFrequency() + "ms";
	}

	@RequestMapping(path = "/api/poll", method = { RequestMethod.PUT })
	public String updateEndpoint(@RequestBody EndpointDto endpointDto) {
		Endpoint endpoint = modelMapper.map(endpointDto, Endpoint.class);
		orchestratorController.updateEndpoint(endpoint);
		return endpoint.getEndpoint() + " will be polled every " + endpoint.getFrequency() + "ms";
	}

	@RequestMapping(path = "/api/poll/delete", method = { RequestMethod.POST })
	public String deleteEndpoint(@RequestBody String endpoint) {
		orchestratorController.deleteEndpoint(endpoint);
		return endpoint + " has stopped being polled";
	}
	
	@RequestMapping(path = "/api/history", method = {RequestMethod.PUT})
	public List<EndpointHistoryDto> findHistory(@RequestBody String endpoint) {
		List<EndpointHistory> history = orchestratorController.findHistory(endpoint);
		return history.stream().map(piece -> modelMapper.map(piece, EndpointHistoryDto.class)).collect(Collectors.toList());
	}
	

}
