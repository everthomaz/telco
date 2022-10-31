package br.com.telco.newcustomersetupservice.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
	
	private String email;
	private String nome_completo;
	private String telefone;
	private String endereco;
	private String cidade;

}
