package br.com.telco.newcustomerserviceweb.application.service;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.telco.newcustomerserviceweb.application.port.in.NewCustomerUseCase;
import br.com.telco.newcustomerserviceweb.application.port.out.NewCustomerPublisherOut;
import br.com.telco.newcustomerserviceweb.domain.Customer;

@Service
public class NewCustomerUseCaseImpl implements NewCustomerUseCase {
	
	@Autowired
	private NewCustomerPublisherOut newCustomerPublisherOut;
	
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            
            Customer customer = new Customer();
            
            //customer.setEmail(req.getParameter("email"));
            customer.setEmail("teste1@teste.com.br");
            customer.setNome_completo("Everton");
            customer.setTelefone("11 12345678");
            customer.setEndereco("Rua Fulado de Tal, 123");
            customer.setCidade("São Paulo");
            
            newCustomerPublisherOut.publish(customer);
            
            System.out.println("New customer sent successfully.");
            resp.setStatus(HttpServletResponse.SC_OK);
            resp.getWriter().println("New customer sent");

        } catch (ExecutionException e) {
            throw new ServletException(e);
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }
	}

}
