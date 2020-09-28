package com.projuris.dev.api.v1.validators;

import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.projuris.dev.domain.orderServiceAux.OrderServiceAux;
import com.projuris.dev.exception.BadRequestException;
import com.projuris.dev.repository.OrderServiceRepository;
/**
 * Validator da Ordem de Serviço Auxiliar.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */
@Component
public class OrderServiceAuxValidator {

	@Autowired
	OrderServiceRepository orderServiceRepository;

	public void validator(OrderServiceAux orderAux) {
		orderIdisValid(orderAux.getOrderId());
		orderIsValid(orderAux.getOrderId());
	}

	private void orderIdisValid(UUID orderId) {
		if (Objects.isNull(orderId)) {
			throw new BadRequestException("O id da ordem é obrigatório");
		}

	}

	private void orderIsValid(UUID orderId) {
		orderServiceRepository.findById(orderId).ifPresent(ord -> {
			if (Objects.nonNull(ord.getDateInit()) && Objects.nonNull(ord.getDateFim())) {
				throw new BadRequestException("Não é possivel inserir uma ordem auxiliar para uma ordem fechada");
			}
		});

	}
}
