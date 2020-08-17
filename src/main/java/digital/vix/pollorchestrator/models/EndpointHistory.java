package digital.vix.pollorchestrator.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "locations_history")
public class EndpointHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "location_id")
	private Long endpointId;
	@Column(name = "poller_id")
	private Long pollerId;
	private String status;
	@Column(name = "response_time_milliseconds")
	private Long responseTime;
	private Date timedate;
	
	

	public EndpointHistory() {
		super();
	}

	public EndpointHistory(Long id, Long endpointId, Long pollerId, String status, Long responseTime, Date timedate) {
		super();
		this.id = id;
		this.endpointId = endpointId;
		this.pollerId = pollerId;
		this.status = status;
		this.responseTime = responseTime;
		this.timedate = timedate;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Long responseTime) {
		this.responseTime = responseTime;
	}

	public Date getTimedate() {
		return timedate;
	}

	public void setTimedate(Date timedate) {
		this.timedate = timedate;
	}

}
