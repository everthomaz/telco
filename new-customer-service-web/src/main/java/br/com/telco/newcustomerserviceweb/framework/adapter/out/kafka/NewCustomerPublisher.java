package br.com.telco.newcustomerserviceweb.framework.adapter.out.kafka;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import br.com.telco.newcustomerserviceweb.application.port.out.NewCustomerPublisherOut;
import br.com.telco.newcustomerserviceweb.domain.Customer;

@Service
public class NewCustomerPublisher implements NewCustomerPublisherOut {
	
	public void publish(Customer customer) throws InterruptedException, ExecutionException, IOException {
		
		try (var dispatcher = new KafkaDispatcher<Customer>()) {
			var nome = customer.getNome_completo();
			var email = customer.getEmail();
			var telefone = customer.getTelefone();
			var endereco = customer.getEndereco();
			var cidade = customer.getCidade();
			var value = nome + "," + email + "," + telefone + "," + endereco + "," + cidade;
			
			dispatcher.send("NEW_CUSTOMER", email, customer);
		}
	}
}