package com.francaemp.estacionamentodio.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

public class ParkingDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private String license;
	@NotNull
	private String state;
	@NotNull
	private String model;
	@NotNull
	private String color;
	
	public ParkingDTO() {
	}
	
	public ParkingDTO(String license, String state, String model, String color) {
		this.license = license;
		this.state = state;
		this.model = model;
		this.color = color;
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

}
