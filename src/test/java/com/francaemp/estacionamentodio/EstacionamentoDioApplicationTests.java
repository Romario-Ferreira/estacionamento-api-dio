package com.francaemp.estacionamentodio;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import com.francaemp.estacionamentodio.controllers.ParkingController;

import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EstacionamentoDioApplicationTests {

	@Autowired
	private ParkingController controller;
	
	@LocalServerPort
	private int randomPort;
	
	@BeforeEach
	public void setUpTest() {
		RestAssured.port= randomPort;
	}
	
	@Test
	void mustReturnAllParkings() {
		RestAssured.given()
		.when()
		.get("/parking")
		.then()
		.statusCode(200);
	}

}
