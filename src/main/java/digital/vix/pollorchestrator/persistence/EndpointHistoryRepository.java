package digital.vix.pollorchestrator.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import digital.vix.pollorchestrator.models.EndpointHistory;

@Repository
public interface EndpointHistoryRepository extends JpaRepository<EndpointHistory, Long> {

	@Query(value = "SELECT * FROM locations_history lh WHERE lh.timedate > now() - interval 60 minute and location_id  = ?1", nativeQuery = true)
	List<EndpointHistory> findByEndpointId(Long id);
}
