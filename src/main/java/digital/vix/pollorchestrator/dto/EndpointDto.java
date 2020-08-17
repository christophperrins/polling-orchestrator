package digital.vix.pollorchestrator.dto;

public class EndpointDto {

	private String name;
	private String endpoint;
	private int frequency;

	public EndpointDto() {
		super();
	}

	public EndpointDto(String name, String endpoint, int frequency) {
		super();
		this.name = name;
		this.endpoint = endpoint;
		this.frequency = frequency;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEndpoint() {
		return endpoint;
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

}
