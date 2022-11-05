package br.com.telco.newcustomerserviceweb.framework.adapter.in.http;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.jetty.JettyServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.telco.newcustomerserviceweb.application.port.in.NewCustomerUseCase;

@Controller
public class NewCustomerServiceController {

	@Autowired
	private NewCustomerUseCase newCustomerUseCase;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        	
        	newCustomerUseCase.publish(req, resp);
        	
        } finally {
        	//Do nothing.
        }
	}
	
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() 
	{
	    JettyServletWebServerFactory factory = new JettyServletWebServerFactory();
	    factory.setPort(8090);
	    //factory.setContextPath("/new");
	    factory.addErrorPages(new ErrorPage("/notfound.html"));
	    return factory;
	}	
}
