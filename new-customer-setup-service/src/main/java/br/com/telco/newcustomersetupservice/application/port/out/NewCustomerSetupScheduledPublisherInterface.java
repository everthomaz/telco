package br.com.telco.newcustomersetupservice.application.port.out;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.com.telco.newcustomersetupservice.domain.SetupOrderSchedule;

public interface NewCustomerSetupScheduledPublisherInterface {
	
	public void publish(SetupOrderSchedule setupOrderSchedule) throws InterruptedException, ExecutionException, IOException;
	
}
