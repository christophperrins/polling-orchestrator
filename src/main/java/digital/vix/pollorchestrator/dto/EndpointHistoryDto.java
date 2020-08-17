package digital.vix.pollorchestrator.dto;

import java.util.Date;

public class EndpointHistoryDto {

	private String status;
	private Long responseTime;
	private Date timedate;
	
	

	public EndpointHistoryDto() {
		super();
	}

	public EndpointHistoryDto(String status, Long responseTime, Date timedate) {
		super();
		this.status = status;
		this.responseTime = responseTime;
		this.timedate = timedate;
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
