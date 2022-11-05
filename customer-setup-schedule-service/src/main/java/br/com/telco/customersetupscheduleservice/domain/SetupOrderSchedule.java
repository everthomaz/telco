package br.com.telco.customersetupscheduleservice.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SetupOrderSchedule {
	
	private String id;
	private String customer_email;
	private String scheduled_date;
	private String limit_date;
	private String status;
	private List<String> services = new ArrayList<String>();
	
	public SetupOrderSchedule() {
		this.id = id;
		this.customer_email = customer_email;
		this.scheduled_date = scheduled_date;
		this.limit_date = limit_date;
		this.status = status;
		this.services = services;
	}
	
	
	public SetupOrderSchedule(String id, String customer_email, String scheduled_date, String limit_date,
			String status, List<String> services) {
		super();
		this.id = id;
		this.customer_email = customer_email;
		this.scheduled_date = scheduled_date;
		this.limit_date = limit_date;
		this.status = status;
		this.services = services;
	}
	
}
