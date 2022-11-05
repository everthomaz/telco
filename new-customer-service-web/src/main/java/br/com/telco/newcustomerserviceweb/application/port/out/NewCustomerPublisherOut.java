package br.com.telco.newcustomerserviceweb.application.port.out;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.com.telco.newcustomerserviceweb.domain.Customer;

public interface NewCustomerPublisherOut {
	
	void publish(Customer customer) throws InterruptedException, ExecutionException, IOException;

}
