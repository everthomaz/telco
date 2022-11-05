package br.com.telco.newcustomersetupservice.framework.adapter.out.kafka;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import br.com.telco.newcustomersetupservice.application.port.out.NewCustomerSetupScheduledPublisherInterface;
import br.com.telco.newcustomersetupservice.domain.SetupOrderSchedule;

@Service
public class NewCustomerSetupScheduledPublisher implements NewCustomerSetupScheduledPublisherInterface {
	
	public void publish(SetupOrderSchedule setupOrderSchedule) throws InterruptedException, ExecutionException, IOException {
		
		try (var dispatcher = new KafkaDispatcher<SetupOrderSchedule>()) {
			dispatcher.send("NEW_CUSTOMER_SETUP_SCHEDULED", setupOrderSchedule.getCustomer_email(), setupOrderSchedule);
		}
		
	}
	
}