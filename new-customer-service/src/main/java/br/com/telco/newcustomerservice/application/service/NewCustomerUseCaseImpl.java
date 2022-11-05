package br.com.telco.newcustomerservice.application.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telco.newcustomerservice.application.port.in.NewCustomerUseCase;
import br.com.telco.newcustomerservice.application.port.out.NewCustomerPublisherOut;
import br.com.telco.newcustomerservice.domain.Customer;

@Service
public class NewCustomerUseCaseImpl implements NewCustomerUseCase {

	@Autowired
	private NewCustomerPublisherOut newCustomerPublisherOut;
	
	@Override
	public void createNewCustomer(Customer customer) throws InterruptedException, ExecutionException, IOException {
		
		newCustomerPublisherOut.publish(customer);
		
		System.out.println("OK");
		//return customer;
	}
	
}
