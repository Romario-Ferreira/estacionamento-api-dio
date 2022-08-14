package com.francaemp.estacionamentodio.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.francaemp.estacionamentodio.dto.ParkingDTO;

@Entity
@Table(name = "tb_parking")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Parking implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String license;
	@NotNull
	private String state;
	@NotNull
	private String model;
	@NotNull
	private String color;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime entryDate;
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime exitDate;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private TicketPayment ticket;
	
	public Parking() {
		
	}
	
	public Parking(ParkingDTO dto) {
		this.license = dto.getLicense();
		this.state = dto.getState();
		this.model = dto.getModel();
		this.color = dto.getColor();
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getLicense() {
		return license;
	}
	
	public void setLicense(String license) {
		this.license = license;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}
	
	public LocalDateTime getExitDate() {
		return exitDate;
	}
	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}
	
	public TicketPayment getTicket() {
		return ticket;
	}

	public void setTicket(TicketPayment ticket) {
		this.ticket = ticket;
	}
	
	
	
}
