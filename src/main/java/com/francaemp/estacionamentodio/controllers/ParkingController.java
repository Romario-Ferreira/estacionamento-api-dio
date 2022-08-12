package com.francaemp.estacionamentodio.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francaemp.estacionamentodio.controllers.mapper.ParkingMapper;
import com.francaemp.estacionamentodio.dto.ParkingDTO;
import com.francaemp.estacionamentodio.entities.Parking;
import com.francaemp.estacionamentodio.services.ParkingService;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {

	private final ParkingService service;
	
	private final ParkingMapper parkingMapper;
	
	public ParkingController(ParkingService service, ParkingMapper parkingMapper) {
		this.service = service;
		this.parkingMapper = parkingMapper;
	}
	
	@GetMapping
	public List<ParkingDTO> findAll(){
		List<Parking> parkings = service.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOMapper(parkings);
		return result;
	}
}
