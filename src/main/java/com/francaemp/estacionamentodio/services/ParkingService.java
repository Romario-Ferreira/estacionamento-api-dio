package com.francaemp.estacionamentodio.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francaemp.estacionamentodio.dto.ParkingDTO;
import com.francaemp.estacionamentodio.entities.Parking;
import com.francaemp.estacionamentodio.exception.ObjectNotFoundException;
import com.francaemp.estacionamentodio.repositories.ParkingRepository;

@Service
public class ParkingService {

	@Autowired
	private ParkingRepository parkingRepository;
	

	public List<Parking> findAll(){
		return parkingRepository.findAll();
	}
	

	public Parking findById(Long id) {
		var parking = parkingRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException(id));
		return parking;
	}

	public Parking create(ParkingDTO obj) {
		var parking = new Parking(obj);
		parking.setEntryDate(LocalDateTime.now());
		parkingRepository.save(parking);
		return parking;
	}

	public void deleteById(Long id) {
		findById(id);
		parkingRepository.deleteById(id);;
	}

	public Parking update(Long id, ParkingDTO dto) {
		var parkingToUpdate = findById(id);
		parkingToUpdate.setLicense(dto.getLicense());
		parkingToUpdate.setModel(dto.getModel());
		parkingToUpdate.setState(dto.getState());
		parkingToUpdate.setColor(dto.getColor());
		parkingRepository.save(parkingToUpdate);
		return parkingToUpdate;
	}

	
}
