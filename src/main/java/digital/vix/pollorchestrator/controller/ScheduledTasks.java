package digital.vix.pollorchestrator.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	

	@Scheduled(fixedRate = 150000)
	public void changeResponsibilityToLivePollers() {
		
	}
}
