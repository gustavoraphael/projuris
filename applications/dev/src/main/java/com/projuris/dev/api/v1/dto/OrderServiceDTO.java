package com.projuris.dev.api.v1.dto;

import java.util.Date;

import com.projuris.dev.domain.cliente.Client;

public class OrderServiceDTO {	
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public Date getDateInit() {
		return dateInit;
	}

	public void setDateInit(Date dateInit) {
		this.dateInit = dateInit;
	}

	public Date getDateFim() {
		return dateFim;
	}

	public void setDateFim(Date dateFim) {
		this.dateFim = dateFim;
	}

	private Client client;
	
	private String product;
	
	private String problem;
	
	private Date dateInit;
	
	private Date dateFim;
	
}
