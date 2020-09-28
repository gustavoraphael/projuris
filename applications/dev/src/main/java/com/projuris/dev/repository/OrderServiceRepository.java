package com.projuris.dev.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.projuris.dev.domain.orderService.OrderService;

/**
 * Repositório da entidade OrderService.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */

@Repository
public interface OrderServiceRepository extends JpaRepository<OrderService, UUID>{

	@Query(value = "select os.number from orderservice os order by os.number desc limit 1", nativeQuery = true)
	public Integer findLastNumber();
}
