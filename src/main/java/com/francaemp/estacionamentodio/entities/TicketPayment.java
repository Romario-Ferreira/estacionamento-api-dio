package com.francaemp.estacionamentodio.entities;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Locale;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.francaemp.estacionamentodio.services.PaymentStrategy;
import com.francaemp.estacionamentodio.services.StrategyDaily;
import com.francaemp.estacionamentodio.services.StrategyHour;
import com.francaemp.estacionamentodio.services.StrategyMonth;

@Entity
@Table(name = "tb_ticket_payment")
public class TicketPayment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private static PaymentStrategy payment;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@JoinColumn(name = "id_parking")
	private Parking parking;
	private Double total;
	
	
	public TicketPayment () {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Parking getParking() {
		return parking;
	}

	public void setParking(Parking parking) {
		this.parking = parking;
	}
	
	public void setPayment(LocalDateTime entry, LocalDateTime exit ) {
		
		long minutes = Duration.between(entry, exit).toMinutes();	
		long hours =  Math.round(minutes / (double)60);
		long days =  Math.round(hours/(double)24);
		long month = Math.round(days/(double) 30);
		
		if (hours >= 0 && hours <12) {
			payment = new StrategyHour();
			this.total= payment.total(hours);
		}else if (hours >=12 && days < 15) {
			payment = new StrategyDaily();
			this.total=payment.total(days);
		}else {
			payment = new StrategyMonth();
			this.total=payment.total(month);
		}
	}
	
	public String getTotal() {
		Locale.setDefault(Locale.US);
		return "Total: R$ "+ String.format("%.1f", total);
	}
}
