package br.com.telco.newcustomersetupservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.telco.newcustomersetupservice.framework.adapter.in.kafka.AdapterIn;

@SpringBootApplication
public class NewCustomerSetupServiceApplication implements CommandLineRunner {
	
	@Autowired
	private AdapterIn adapterIn;
	
	public static void main(String[] args) {
		SpringApplication.run(NewCustomerSetupServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		adapterIn.execute();
	}

}
