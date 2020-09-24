package com.projuris.dev.domain.orderServiceAux;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "orderserviceaux")
public class OrderServiceAux {
	
	@Id
	@Column(name="id")
	private UUID id;	
	
	@Column(name="order_id")
	private UUID clientId;
	
	@Column(name="date")
	private Date date;
	
	@Column(name="description")
	private String description;

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
