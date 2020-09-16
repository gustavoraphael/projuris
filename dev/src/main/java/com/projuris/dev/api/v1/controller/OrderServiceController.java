package com.projuris.dev.api.v1.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projuris.dev.domain.orderService.OrderService;
import com.projuris.dev.service.orderService.OrderServiceService;

@RestController
@RequestMapping("/orderService")
public class OrderServiceController {
	
	@Autowired
	private OrderServiceService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OrderService> listOrders(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.findById(UUID.fromString(id)));
	}
}
