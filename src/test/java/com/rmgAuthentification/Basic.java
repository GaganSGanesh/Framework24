package com.rmgAuthentification;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;//import and manually type static and * at the end

public class Basic {
	@Test
	public void basicAuth() {
		given()// to get the import statement of resassured first type restassured and import it
		.auth().basic("rmgyantra", "rmgy@9999")
		.when()
		.get("http://localhost:8084/login")
		.then()
		.log().all();
	}



}
