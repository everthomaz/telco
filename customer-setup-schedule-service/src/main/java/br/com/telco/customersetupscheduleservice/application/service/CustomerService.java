package br.com.telco.customersetupscheduleservice.application.service;

import java.io.IOException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import br.com.telco.customersetupscheduleservice.application.port.in.CustomerServiceUseCase;
import br.com.telco.customersetupscheduleservice.domain.SetupOrderSchedule;
import br.com.telco.customersetupscheduleservice.framework.adapter.in.kafka.KafkaService;

@Service
public class CustomerService implements CustomerServiceUseCase {

	public void execute() throws IOException {
		var customer = new CustomerService();
		try (var service = new KafkaService<SetupOrderSchedule>("customer-setup-schedule-service",
				"NEW_CUSTOMER_SETUP_SCHEDULED",
				customer::parse,
				SetupOrderSchedule.class)) {
			service.run();
		}
	}

	private void parse(ConsumerRecord<String, SetupOrderSchedule> record) {
		System.out.println("-----------------------------------");
		System.out.println("Processing new customer setup scheduled...");
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
