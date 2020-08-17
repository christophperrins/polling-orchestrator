package digital.vix.pollorchestrator.persistence;

import java.util.List;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import digital.vix.pollorchestrator.models.Poller;

@Repository
public interface PollerRepository extends JpaRepository<Poller, Long> {

	@Query(value = "SELECT * FROM pollers p WHERE p.last_heartbeat > now() - interval 10 minute", nativeQuery = true)
	List<Poller> findAllActivePollers();
	
	@Query(value = "SELECT * FROM pollers p WHERE p.last_heartbeat < now() - interval 10 minute", nativeQuery = true)
	List<Poller> findAllDeactivePollers();
	
}
