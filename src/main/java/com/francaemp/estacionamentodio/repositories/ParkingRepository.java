package com.francaemp.estacionamentodio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francaemp.estacionamentodio.entities.Parking;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>{

}
