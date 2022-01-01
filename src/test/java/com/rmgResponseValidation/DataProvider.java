package com.rmgResponseValidation;

import org.testng.annotations.*;

import com.vtiger.comcast.pomrepositorylib.PojoLibrary;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProvider {
	@Test(dataProvider = "getData")
	public void create(String createdBy,String projectName,String status,int teamsize) {
		PojoLibrary pobj=new PojoLibrary(createdBy, projectName, status, teamsize);
		given()
			.body(pobj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.and()
			.statusCode(201)
			.log().all();				
	}
	 
	@org.testng.annotations.DataProvider
	public Object[][] getData()
	{
		Object[][] objarr=new Object[2][4];
		objarr[0][0]="data3";
		objarr[0][1]="data3 project1";
		objarr[0][2]="completed";
		objarr[0][3]=02;
		
		objarr[1][0]="data1";
		objarr[1][1]="data1 project2";
		objarr[1][2]="completed";
		objarr[1][3]=05;
		return objarr;
		

	}
}
