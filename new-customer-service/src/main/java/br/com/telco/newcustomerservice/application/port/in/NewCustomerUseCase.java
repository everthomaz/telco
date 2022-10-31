package br.com.telco.newcustomerservice.application.port.in;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import br.com.telco.newcustomerservice.domain.Customer;

public interface NewCustomerUseCase {
	
	Customer createNewCustomer(Customer customer) throws InterruptedException, ExecutionException, IOException;
	
}
