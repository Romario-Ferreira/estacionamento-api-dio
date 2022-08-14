package com.francaemp.estacionamentodio.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francaemp.estacionamentodio.dto.ParkingDTO;
import com.francaemp.estacionamentodio.entities.Parking;
import com.francaemp.estacionamentodio.entities.TicketPayment;
import com.francaemp.estacionamentodio.services.ParkingService;
import com.francaemp.estacionamentodio.services.TicketService;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {

	@Autowired
	private ParkingService service;
	
	@Autowired
	private TicketService ticketService;
	
	@GetMapping
	public ResponseEntity<List<Parking>> findAll(){
		List<Parking> parkings = service.findAll();
		return ResponseEntity.ok(parkings);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Parking> findById(@PathVariable Long id){
		var parking = service.findById(id);
		return ResponseEntity.ok(parking);
	}
	
	@PostMapping(value = "/save")
	public ResponseEntity<Parking> create(@RequestBody ParkingDTO dto){
		var parking = service.create(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(parking);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Parking> update(@PathVariable Long id, @RequestBody ParkingDTO dto){
		return ResponseEntity.ok(service.update(id, dto));
	}
	
	@PutMapping("/{id}/exit")
	public ResponseEntity<TicketPayment> exit(@PathVariable Long id){
		var parking = service.findById(id);
		parking.setExitDate(LocalDateTime.now());
		TicketPayment ticket = ticketService.generate(parking);
		parking.setTicket(ticket);
		return ResponseEntity.ok(ticket);
	}
}
