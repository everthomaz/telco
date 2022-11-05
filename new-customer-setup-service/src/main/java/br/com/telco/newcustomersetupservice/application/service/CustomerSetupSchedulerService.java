package br.com.telco.newcustomersetupservice.application.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import br.com.telco.newcustomersetupservice.application.port.out.PublishInterface;
import br.com.telco.newcustomersetupservice.domain.Customer;
import br.com.telco.newcustomersetupservice.domain.SetupOrderSchedule;
import br.com.telco.newcustomersetupservice.framework.adapter.out.kafka.NewCustomerSetupScheduledPublisher;

@Service
public class CustomerSetupSchedulerService implements PublishInterface {
	
	//@Autowired
	//private NewCustomerSetupScheduledPublisherInterface newCustomerSetupScheduledPublisherInterface;
	
	@Override
	public void publish(Customer customer) throws InterruptedException, ExecutionException, IOException {
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		
		Date dt = new Date();
		Calendar calendar_scheduled_date = Calendar.getInstance();
		Calendar calendar_limit_date = Calendar.getInstance();
		calendar_scheduled_date.setTime(dt);
		calendar_limit_date.setTime(dt);
		calendar_scheduled_date.add(Calendar.DATE, 2);
		calendar_limit_date.add(Calendar.DATE, 5);
		
		var setupOrderSchedule = new SetupOrderSchedule();
		
		setupOrderSchedule.setId(UUID.randomUUID().toString());
		setupOrderSchedule.setCustomer_email(customer.getEmail());
		setupOrderSchedule.setScheduled_date(formatter.format(calendar_scheduled_date.getTime()));
		setupOrderSchedule.setLimit_date(formatter.format(calendar_limit_date.getTime()));
		setupOrderSchedule.setStatus("WAITING");
		
		List<String> services = new ArrayList<String>();
		services.add("PHONE");
		services.add("TV");
		services.add("INTERNET");
		setupOrderSchedule.setServices(services);
		
		
		NewCustomerSetupScheduledPublisher newCustomerSetupScheduledPublisher = new NewCustomerSetupScheduledPublisher();
		newCustomerSetupScheduledPublisher.publish(setupOrderSchedule);
		//return null;
	}

}
