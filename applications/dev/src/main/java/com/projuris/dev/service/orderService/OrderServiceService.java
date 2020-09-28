package com.projuris.dev.service.orderService;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.projuris.dev.api.v1.dto.OrderServiceDTO;
import com.projuris.dev.api.v1.validators.OrderServiceValidator;
import com.projuris.dev.domain.cliente.Client;
import com.projuris.dev.domain.orderService.OrderService;
import com.projuris.dev.exception.NotFoundException;
import com.projuris.dev.repository.ClientRepository;
import com.projuris.dev.repository.OrderServiceRepository;

/**
 * Serviço para ordem de serviço.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */

@Service
public class OrderServiceService {
	
	@Autowired
	private OrderServiceRepository orderServiceRepository;

	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private OrderServiceValidator orderServiceValidator;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrderService findById(UUID id) {
		return orderServiceRepository.findById(id).orElseThrow(() -> new NotFoundException("Ordem não encontrada"));
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public OrderService save(OrderServiceDTO dto) {
		orderServiceValidator.validator(dto);
		Client client = clientRepository.save(convertToClient(dto));
		OrderService order = orderServiceRepository.save(convertToOrderService(dto, client.getId()));
		return order;
	}
	
	private OrderService convertToOrderService(OrderServiceDTO dto, UUID clientId) {
		OrderService order = getOrder(dto.getIdOrder());
		
		if(!Objects.nonNull(dto.getNumber()) && !Objects.nonNull(dto.getIdOrder()))
			order.setNumber(getNumberOrder());
		
		order.setProblem(dto.getProblem());
		order.setClientId(clientId);
		order.setProduct(dto.getProduct());
		order.setDateInit(dto.getDateInit());		
		order.setDateFim(dto.getDateFim());
		return order;
	}
	
	private OrderService getOrder(UUID orderId) {
		if(Objects.nonNull(orderId)) {
			Optional<OrderService> order = orderServiceRepository.findById(orderId);
			if(!order.isEmpty())
				return order.get();
		}
		return new OrderService();
	}
	
	private Client getClient(UUID clientId) {
		if(Objects.nonNull(clientId)) {
			Optional<Client> client = clientRepository.findById(clientId);
			if(!client.isEmpty())
				return client.get();
		}
		return new Client();
	}


	private Integer getNumberOrder() {
		Integer number = orderServiceRepository.findLastNumber();		
		return number != null ? number+1 : 1;
	}


	private Client convertToClient(OrderServiceDTO dto) {
		Client client = getClient(dto.getClient().getId());
		client.setId(UUID.randomUUID());
		client.setAdress(dto.getClient().getAdress());
		client.setEmail(dto.getClient().getEmail());
		client.setFone(dto.getClient().getFone());
		client.setName(dto.getClient().getName());		
		return client;
	}
}
