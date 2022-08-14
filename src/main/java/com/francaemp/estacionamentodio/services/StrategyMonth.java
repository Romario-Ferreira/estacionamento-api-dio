package com.francaemp.estacionamentodio.services;

import org.springframework.stereotype.Service;

@Service
public class StrategyMonth implements PaymentStrategy{

	/*
	 * Poderia settar uma variavel "value" para uma melhor soluçao;
	 * 
	 */
	
	private Double total;
	
	@Override
	public double total(Long duration) {
		this.total = duration * 500.0;
		return total;
	}

}
