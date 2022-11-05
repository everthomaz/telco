package br.com.telco.newcustomerserviceweb.domain;

import lombok.Builder;
import lombok.Data;

@Data
public class Customer {
	
	private String email;
	private String nome_completo;
	private String telefone;
	private String endereco;
	private String cidade;
	
	public Customer() {
		super();
		this.email = email;
		this.nome_completo = nome_completo;
		this.telefone = telefone;
		this.endereco = endereco;
		this.cidade = cidade;
	}
	
	

}
