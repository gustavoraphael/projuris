package com.projuris.dev.api.v1.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projuris.dev.domain.orderServiceAux.OrderServiceAux;
import com.projuris.dev.service.orderServiceAux.OrderServiceAuxService;

@RestController
@RequestMapping("/orderServiceAux")
public class OrderServiceAuxController {
	
	@Autowired
	private OrderServiceAuxService service;

	@GetMapping(value = "/getAll/{id}")
	public ResponseEntity<List<OrderServiceAux>> listOrdersAux(@PathVariable("id") String id) {
		return ResponseEntity.ok(service.findAllById(UUID.fromString(id)));
	}
	
	@PostMapping(value = "/save")	
	public ResponseEntity<OrderServiceAux> create(@RequestBody OrderServiceAux request)  {
		return ResponseEntity.ok(service.save(request));
	}

}
