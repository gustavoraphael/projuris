package com.projuris.dev.api.v1.dto;

import java.util.Date;
import java.util.UUID;

import com.projuris.dev.domain.cliente.Client;
import com.sun.istack.NotNull;

public class OrderServiceDTO {	
	
	private UUID idOrder;
	
	@NotNull
	private Client client;
	
	@NotNull
	private String product;
	
	@NotNull
	private String problem;
	
	@NotNull
	private Date dateInit;
	
	private Date dateFim;
	
	private Integer number;
	
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

	
	
	public UUID getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(UUID idOrder) {
		this.idOrder = idOrder;
	}

		public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
}
