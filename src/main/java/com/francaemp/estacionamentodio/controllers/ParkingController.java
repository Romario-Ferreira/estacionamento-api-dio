package com.francaemp.estacionamentodio.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francaemp.estacionamentodio.entities.Parking;

@RestController
@RequestMapping(value = "/parking")
public class ParkingController {

	@GetMapping
	public List<Parking> findAll(){
		var parking = new Parking();
		parking.setColor("PRETO");
		parking.setLicense("MSS-1111");
		parking.setModel("VW");
		parking.setState("SP");
		
		var parking2 = new Parking();
		parking2.setColor("BRANCO");
		parking2.setLicense("MSS-1222");
		parking2.setModel("GM");
		parking2.setState("MG");
		
		return Arrays.asList(parking,parking2);
	}
}
