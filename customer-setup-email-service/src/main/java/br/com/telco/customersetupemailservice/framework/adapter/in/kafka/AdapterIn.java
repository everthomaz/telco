package br.com.telco.customersetupemailservice.framework.adapter.in.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.telco.customersetupemailservice.application.port.in.CustomerServiceUseCase;

@Component
public class AdapterIn {
	
	@Autowired
	private CustomerServiceUseCase customerServiceUseCase;
	
	public void execute() throws IOException {
		customerServiceUseCase.execute();
	}
}
