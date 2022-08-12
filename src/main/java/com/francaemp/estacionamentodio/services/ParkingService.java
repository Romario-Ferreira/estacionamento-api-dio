package com.francaemp.estacionamentodio.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.francaemp.estacionamentodio.entities.Parking;

@Service
public class ParkingService {

	public static  Map<String,Parking> parkingsMap = new HashMap<>();
	
	static {
		var id = getUUID();
		Parking p1 = new Parking(id, "AAA-1111", "SC", "CORSA", "BRACO");
		parkingsMap.put(id, p1);
	}

	public List<Parking> findAll(){
		return parkingsMap.values().stream().toList();
	}
	
	private static String getUUID() {
		 return UUID.randomUUID().toString().replace("-", "");
	}
}
