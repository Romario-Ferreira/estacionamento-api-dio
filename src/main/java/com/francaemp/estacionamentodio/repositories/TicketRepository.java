package com.francaemp.estacionamentodio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francaemp.estacionamentodio.entities.TicketPayment;

@Repository
public interface TicketRepository extends JpaRepository<TicketPayment, Long>{

}
