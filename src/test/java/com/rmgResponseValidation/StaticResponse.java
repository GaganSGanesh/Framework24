package com.rmgResponseValidation;

import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.When;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponse {
	@Test
	public void validation()
	{
		String expectedprojectName="TY_PROJ_001";
		Response response=when()
		.get("http://localhost:8084/projects");
		String actualProjectName=response.jsonPath().get("[1].project_id");
		System.out.println("actual project name"+actualProjectName);
		response.then()
		.assertThat()
		.statusCode(200).and().contentType(ContentType.JSON)
		.log().all();
		Assert.assertEquals(expectedprojectName, actualProjectName);
		
		
				
				
				
	}


}
