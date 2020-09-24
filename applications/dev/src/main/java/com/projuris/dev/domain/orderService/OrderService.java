package com.projuris.dev.domain.orderService;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "orderservice")
public class OrderService {
	
	@Id
	@Column(name="id")
	private UUID id;	
	
	@Column(name="client_id")
	private UUID clientId;
	
	@Column(name="number")
	private Integer number;
	
	@Column(name="product")
	private String product;
	
	@Column(name="problem")
	private String problem;
	
	@Column(name="dateinit")
	private Date dateInit;
	
	@Column(name="datefim")
	private Date dateFim;
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public UUID getClientId() {
		return clientId;
	}
	public void setClientId(UUID clientId) {
		this.clientId = clientId;
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
}
