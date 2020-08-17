package digital.vix.pollorchestrator.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pollers")
public class Poller {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Date last_heartbeat;

	public Poller() {
		super();
	}

	public Poller(Long id, String name, Date last_heartbeat) {
		super();
		this.id = id;
		this.name = name;
		this.last_heartbeat = last_heartbeat;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLast_heartbeat() {
		return last_heartbeat;
	}

	public void setLast_heartbeat(Date last_heartbeat) {
		this.last_heartbeat = last_heartbeat;
	}

}
