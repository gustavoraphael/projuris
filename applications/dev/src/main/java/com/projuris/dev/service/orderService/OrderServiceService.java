package com.projuris.dev.service.orderService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.projuris.dev.domain.orderService.OrderService;
import com.projuris.dev.exception.NotFoundException;
import com.projuris.dev.repository.OrderServiceRepository;

@Service
public class OrderServiceService {
	
	@Autowired
	OrderServiceRepository repository;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public OrderService findById(UUID id) {
		return repository.findById(id).orElseThrow(() -> new NotFoundException("Item não encontrado"));
	}
	
}
