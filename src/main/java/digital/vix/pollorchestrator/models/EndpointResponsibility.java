package digital.vix.pollorchestrator.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations_responsibility")
public class EndpointResponsibility {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "location_id")
	private Long endpointId;
	@Column(name = "poller_id")
	private Long pollerId;

	public EndpointResponsibility() {
		super();
	}

	public EndpointResponsibility(Long id, Long endpointId, Long pollerId) {
		super();
		this.id = id;
		this.endpointId = endpointId;
		this.pollerId = pollerId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEndpointId() {
		return endpointId;
	}

	public void setEndpointId(Long endpointId) {
		this.endpointId = endpointId;
	}

	public Long getPollerId() {
		return pollerId;
	}

	public void setPollerId(Long pollerId) {
		this.pollerId = pollerId;
	}

}
