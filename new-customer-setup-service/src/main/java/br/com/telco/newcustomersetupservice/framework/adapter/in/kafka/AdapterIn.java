package br.com.telco.newcustomersetupservice.framework.adapter.in.kafka;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.telco.newcustomersetupservice.application.port.in.CustomerServiceUseCase;

@Service
public class AdapterIn {
	
	@Autowired
	private CustomerServiceUseCase customerServiceUseCase;
	
	public void execute() throws IOException {
		customerServiceUseCase.execute();
	}
}
