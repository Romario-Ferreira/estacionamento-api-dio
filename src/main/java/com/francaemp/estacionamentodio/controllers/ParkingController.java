package com.francaemp.estacionamentodio.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francaemp.estacionamentodio.controllers.mapper.ParkingMapper;
import com.francaemp.estacionamentodio.dto.ParkingCreateDTO;
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
	public ResponseEntity<List<ParkingDTO>> findAll(){
		List<Parking> parkings = service.findAll();
		List<ParkingDTO> result = parkingMapper.toParkingDTOMapper(parkings);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ParkingDTO> findById(@PathVariable String id){
		var dto = parkingMapper.parkingDTO(service.findById(id));
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<ParkingDTO> create(@RequestBody ParkingCreateDTO createDTO){
		Parking newParking = parkingMapper.toParking(createDTO);
		service.create(newParking);
		var newParkingDTO = parkingMapper.parkingDTO(newParking);
		return ResponseEntity.status(HttpStatus.CREATED).body(newParkingDTO);
	}
}
