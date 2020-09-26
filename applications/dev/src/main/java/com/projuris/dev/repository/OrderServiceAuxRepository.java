package com.projuris.dev.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projuris.dev.domain.orderServiceAux.OrderServiceAux;

@Repository
public interface OrderServiceAuxRepository extends JpaRepository<OrderServiceAux, UUID>{

	public List<OrderServiceAux> findAllByOrderId(UUID orderId);
}
