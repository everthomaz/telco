package br.com.telco.newcustomersetupservice.application.port.out;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.com.telco.newcustomersetupservice.domain.Customer;

public interface PublishInterface {

	void publish(Customer customer) throws InterruptedException, ExecutionException, IOException;

}
