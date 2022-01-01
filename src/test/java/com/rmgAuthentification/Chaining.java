package com.rmgAuthentification;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.When;

import io.restassured.response.Response;
import io.restassured.specification.RequestSender;

import static io.restassured.RestAssured.*;

public class Chaining {
	@Test
	public void endtoend() {
		Response response = when()
				.get("http://localhost:8084/projects");
		String proId = response.jsonPath().get("[2].projectId");
		given()
		.pathParam("projectID", proId)
		.when()
		.delete("http://localhost:8084/projects/{projectID}");
		response.then().log().all();

	}

}
