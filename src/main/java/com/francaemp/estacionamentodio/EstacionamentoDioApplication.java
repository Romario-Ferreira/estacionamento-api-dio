package com.francaemp.estacionamentodio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Parking API", version = "1.0", description = "Management parking API"))
public class EstacionamentoDioApplication {

	public static void main(String[] args) {
		SpringApplication.run(EstacionamentoDioApplication.class, args);
	}
	
}
