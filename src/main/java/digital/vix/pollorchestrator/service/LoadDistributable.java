package digital.vix.pollorchestrator.service;

import java.util.List;

import digital.vix.pollorchestrator.models.EndpointResponsibility;
import digital.vix.pollorchestrator.models.Poller;

public interface LoadDistributable {
	
	public Poller distributeLoad(List<Poller> pollers, List<EndpointResponsibility> responsibilities);

}
