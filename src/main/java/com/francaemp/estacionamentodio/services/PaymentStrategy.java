package com.francaemp.estacionamentodio.services;

import org.springframework.stereotype.Service;

@Service
public interface PaymentStrategy {

	double total(Long duration);
}
