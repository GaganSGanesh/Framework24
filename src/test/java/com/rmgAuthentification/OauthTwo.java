package com.rmgAuthentification;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class OauthTwo {
	@Test
	public void auth() {
		Response response = given()
				.formParam("client_id", "SDET224")
				.formParam("client_secret", "5d3c7e39b9aad324a0bd15068ca48f11")
				.formParam("grant_type", "client_credentials")
				.formParam("redirect_uri", "http://www.example.com")
				.when()
				.post("http://coop.apps.symfonycasts.com/token");
		String token=response.jsonPath().get("access_token");
		given()
		.auth().oauth2(token).pathParam("USER_ID", 2553)
		.when()
		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
	.then()
	.log().all();
	
	}

}
