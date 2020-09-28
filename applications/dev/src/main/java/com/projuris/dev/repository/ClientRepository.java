package com.projuris.dev.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projuris.dev.domain.cliente.Client;

/**
 * Repositório da entidade Client.
 *
 * @author Gustavo Raphael Laurindo Pereira
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID>{

}
