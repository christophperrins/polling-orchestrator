package digital.vix.pollorchestrator.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import digital.vix.pollorchestrator.models.Endpoint;

@Repository
public interface EndpointRepository extends JpaRepository<Endpoint, Long> {

	@Query(value = "SELECT * FROM locations l WHERE l.id in (SELECT distinct(location_id) from locations_responsibility)", nativeQuery = true)
	List<Endpoint> findAllActiveEndpoints();
	
	Optional<Endpoint> findByEndpoint(String endpoint);
}
