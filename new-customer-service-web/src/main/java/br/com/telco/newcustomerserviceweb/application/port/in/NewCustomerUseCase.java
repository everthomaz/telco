package br.com.telco.newcustomerserviceweb.application.port.in;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.telco.newcustomerserviceweb.domain.Customer;

public interface NewCustomerUseCase {
	
	void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException;
	
}
