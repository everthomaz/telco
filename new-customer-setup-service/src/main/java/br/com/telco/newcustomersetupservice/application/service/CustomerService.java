package br.com.telco.newcustomersetupservice.application.service;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import br.com.telco.newcustomersetupservice.domain.Customer;
import br.com.telco.newcustomersetupservice.framework.adapter.in.kafka.KafkaService;
import br.com.telco.newcustomersetupservice.framework.port.in.CustomerServiceUseCase;

@Service
public class CustomerService implements CustomerServiceUseCase {

	public void execute() throws IOException {
		var customer = new CustomerService();
		try (var service = new KafkaService<Customer>(CustomerService.class.getSimpleName() + " - Group 2",
				"NEW_CUSTOMER",
				customer::parse,
				Customer.class)) {
			service.run();
		}
	}

	private void parse(ConsumerRecord<String, Customer> record) {
		System.out.println("-----------------------------------");
		System.out.println("Processing new customer...");
		System.out.println(record.key());
		System.out.println(record.value());
		System.out.println(record.partition());
		System.out.println(record.offset());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Customer received.");
	}
	
}
