package com.projuris.dev.service.orderServiceAux;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.projuris.dev.api.v1.validators.OrderServiceAuxValidator;
import com.projuris.dev.domain.orderServiceAux.OrderServiceAux;
import com.projuris.dev.repository.ClientRepository;
import com.projuris.dev.repository.OrderServiceAuxRepository;

/**
 * Serviço para ordem de serviço auxiliar.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */

@Service
public class OrderServiceAuxService {
	
	@Autowired
	OrderServiceAuxRepository orderServiceAuxRepository;

	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	OrderServiceAuxValidator orderServiceAuxValidator;
	
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<OrderServiceAux> findAllById(UUID id) {
		return orderServiceAuxRepository.findAllByOrderId(id);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public OrderServiceAux save(OrderServiceAux request) {
		orderServiceAuxValidator.validator(request);
		return orderServiceAuxRepository.save(request);
	}
}
