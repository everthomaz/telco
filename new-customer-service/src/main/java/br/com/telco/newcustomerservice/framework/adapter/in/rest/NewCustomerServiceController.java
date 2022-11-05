package br.com.telco.newcustomerservice.framework.adapter.in.rest;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.telco.newcustomerservice.application.port.in.NewCustomerUseCase;
import br.com.telco.newcustomerservice.domain.Customer;

@RestController
@RequestMapping("/")
public class NewCustomerServiceController {
	
	@Autowired
	private NewCustomerUseCase newCustomerUseCase;
	
	@PostMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
	public void createNewCustomer(
			//@RequestHeader(value = "Authorization") String jwt
			//,
			//@PathVariable(value = "xxx") String xxx
			@RequestBody Customer customer
			) throws InterruptedException, ExecutionException, IOException
			{
		newCustomerUseCase.createNewCustomer(customer);
		//var response =  newCustomerUseCase.createNewCustomer(customer);
		//return (ResponseEntity<Customer>) ResponseEntity.ok();
	}
	
}
