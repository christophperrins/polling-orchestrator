package digital.vix.pollorchestrator.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import digital.vix.pollorchestrator.models.EndpointResponsibility;

@Repository
public interface EndpointResponsibilityRepository extends JpaRepository<EndpointResponsibility, Long>{

	List<EndpointResponsibility> findByEndpointId(Long endpointId);
	
	List<EndpointResponsibility> findByPollerId(Long pollerId);
}
