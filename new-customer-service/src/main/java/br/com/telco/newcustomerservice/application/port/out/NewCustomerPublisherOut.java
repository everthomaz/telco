package br.com.telco.newcustomerservice.application.port.out;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.com.telco.newcustomerservice.domain.Customer;
import br.com.telco.newcustomerservice.framework.adapter.out.kafka.NewCustomerPublisher;

public interface NewCustomerPublisherOut {
	
	void publish(Customer customer) throws InterruptedException, ExecutionException, IOException;

}
