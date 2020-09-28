package com.projuris.dev.service.orderService;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.projuris.dev.api.v1.dto.OrderServiceDTO;
import com.projuris.dev.api.v1.validators.OrderServiceValidator;
import com.projuris.dev.domain.cliente.Client;
import com.projuris.dev.domain.orderService.OrderService;
import com.projuris.dev.repository.ClientRepository;
import com.projuris.dev.repository.OrderServiceRepository;

public class OrderServiceServiceTest {
	
	@InjectMocks
	OrderServiceService service;

	@Mock
	OrderServiceValidator validator;
	
	@Mock
	private OrderServiceRepository orderServiceRepository;

	@Mock
	private ClientRepository clientRepository;
	
	private OrderServiceDTO orderDTO;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
		setDataDto();
	}	
	
	@Test
	public void testSaveOrder() {		
		when(clientRepository.findById(UUID.randomUUID())).thenReturn(Optional.ofNullable(null));
		when(orderServiceRepository.findById(UUID.randomUUID())).thenReturn(Optional.ofNullable(null));
		when(orderServiceRepository.save(any())).thenReturn(new OrderService());
		when(clientRepository.save(any())).thenReturn(new Client());		
		
		OrderService result = service.save(orderDTO);
		
		verify(orderServiceRepository, times(1)).save(any());
		assertNotNull(result);
	}


	private void setDataDto() {
		orderDTO = new OrderServiceDTO();
		orderDTO.setClient(new Client());
		orderDTO.setDateInit(new Date());
		orderDTO.setProblem("Problem test");
		orderDTO.setProduct("Product One");
	}
}
