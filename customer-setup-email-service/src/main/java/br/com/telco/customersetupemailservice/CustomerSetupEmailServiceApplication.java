package br.com.telco.customersetupemailservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.telco.customersetupemailservice.framework.adapter.in.kafka.AdapterIn;

@SpringBootApplication
public class CustomerSetupEmailServiceApplication implements CommandLineRunner {
	
	@Autowired
	private AdapterIn adapterIn;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerSetupEmailServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		adapterIn.execute();
	}
	
	
	
}
