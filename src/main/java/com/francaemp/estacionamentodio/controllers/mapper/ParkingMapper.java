package com.francaemp.estacionamentodio.controllers.mapper;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.francaemp.estacionamentodio.dto.ParkingCreateDTO;
import com.francaemp.estacionamentodio.dto.ParkingDTO;
import com.francaemp.estacionamentodio.entities.Parking;

@Component
public class ParkingMapper {

	private static final ModelMapper MODEL_MAPPER = new ModelMapper();
	
	public ParkingDTO parkingDTO (Parking parking) {
		return MODEL_MAPPER.map(parking, ParkingDTO.class);
	}
	
	public List<ParkingDTO> toParkingDTOMapper(List<Parking> list) {
		return list.stream().map(this::parkingDTO).toList();
	}

	public Parking toParking(ParkingCreateDTO createDTO) {
		return MODEL_MAPPER.map(createDTO, Parking.class);
	}

}
