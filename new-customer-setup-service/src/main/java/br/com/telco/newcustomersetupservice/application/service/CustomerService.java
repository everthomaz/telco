package br.com.telco.newcustomersetupservice.application.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Service;

import br.com.telco.newcustomersetupservice.application.port.in.CustomerServiceUseCase;
import br.com.telco.newcustomersetupservice.domain.Customer;
import br.com.telco.newcustomersetupservice.framework.adapter.in.kafka.KafkaService;

@Service
public class CustomerService implements CustomerServiceUseCase {
	
	//@Autowired
	//PublishInterface publishInterface;
	
	@Override
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
		System.out.println("Customer received.");
		
		System.out.println("Customer Setup is being scheduled.");
		try {
			CustomerSetupSchedulerService customerSetupSchedulerService = new CustomerSetupSchedulerService();
			customerSetupSchedulerService.publish(record.value());
			System.out.println("Customer Setup is scheduled.");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
