package com.francaemp.estacionamentodio.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francaemp.estacionamentodio.entities.Parking;
import com.francaemp.estacionamentodio.entities.TicketPayment;
import com.francaemp.estacionamentodio.exception.ObjectNotFoundException;
import com.francaemp.estacionamentodio.repositories.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;
	
	@Transactional
	public TicketPayment generate(Parking parking) {
		TicketPayment ticket = new TicketPayment();
		ticket.setParking(parking);
		ticket.setPayment(parking.getEntryDate(), parking.getExitDate());
		repository.save(ticket);
		return ticket;
	}
	
	public TicketPayment findById(Long id) {
		var ticket = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		return ticket;
	}
	
	
}
