package br.com.telco.newcustomerconsumerservice.framework.adapter.in.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.telco.newcustomerconsumerservice.application.port.in.CustomerServiceUseCase;

@Component
public class AdapterIn {
	
	@Autowired
	private CustomerServiceUseCase customerServiceUseCase;
	
	public void execute() throws IOException {
		customerServiceUseCase.execute();
	}
}
