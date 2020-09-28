package com.projuris.dev.api.v1.validators;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projuris.dev.api.v1.dto.OrderServiceDTO;
import com.projuris.dev.domain.cliente.Client;
import com.projuris.dev.exception.BadRequestException;
import com.projuris.dev.repository.OrderServiceRepository;

/**
 * Validator da Ordem de Serviço.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */

@Component
public class OrderServiceValidator {
	
	@Autowired
	OrderServiceRepository orderServiceRepository;

	public void validator(OrderServiceDTO dto) {
		orderIsValid(dto);
		clientRequired(dto.getClient());
	}
	
	private void orderIsValid(OrderServiceDTO order) {
		if(Objects.nonNull(order.getIdOrder())) {
			orderServiceRepository.findById(order.getIdOrder()).ifPresent(ord -> {
				if(Objects.nonNull(ord.getDateInit()) && Objects.nonNull(ord.getDateFim())) {
					throw new BadRequestException("Não é possivel alterar uma ordem fechada");
				}
			});
		}
	}

	private void clientRequired(Client client) {
		if(Objects.isNull(client)) {
			throw new BadRequestException("O cliente é obrigatório");
		}
	}
}
