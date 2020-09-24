package com.projuris.dev.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projuris.dev.domain.orderService.OrderService;

@Repository
public interface OrderServiceAuxRepository extends JpaRepository<OrderService, UUID>{

}
