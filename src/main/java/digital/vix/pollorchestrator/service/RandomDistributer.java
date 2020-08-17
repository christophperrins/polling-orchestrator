package digital.vix.pollorchestrator.service;

import java.util.List;

import digital.vix.pollorchestrator.models.EndpointResponsibility;
import digital.vix.pollorchestrator.models.Poller;

public class RandomDistributer implements LoadDistributable{

	@Override
	public Poller distributeLoad(List<Poller> pollers, List<EndpointResponsibility> responsibilities) {
		
		return pollers.get((int) Math.round(Math.floor(Math.random()*pollers.size())));
	}

	

}
