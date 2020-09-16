package com.projuris.dev.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projuris.dev.domain.orderService.OrderService;

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, UUID>{

}
