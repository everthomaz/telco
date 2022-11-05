package br.com.telco.customersetupemailservice.domain;

import org.springframework.stereotype.Service;

import lombok.Data;

@Data
public class SetupOrderSchedule {
	
	private String id;
	private String customer_email;
	private String scheduled_date;
	private String limit_date;
	private String status;
	
	public SetupOrderSchedule() {
		this.id = id;
		this.customer_email = customer_email;
		this.scheduled_date = scheduled_date;
		this.limit_date = limit_date;
		this.status = status;
	}
	
	
	public SetupOrderSchedule(String id, String customer_email, String scheduled_date, String limit_date,
			String status) {
		super();
		this.id = id;
		this.customer_email = customer_email;
		this.scheduled_date = scheduled_date;
		this.limit_date = limit_date;
		this.status = status;
	}
	
}
