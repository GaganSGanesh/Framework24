package com.rmgAuthentification;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class assign {
	@Test
	public void verify() throws Exception
	{
		JSONObject jsonobj = new JSONObject();
		jsonobj.put("createdBy", "gagan");
		jsonobj.put("projectName", "mad project");
		jsonobj.put("status", "completed");
		
		Response response = given().
			body(jsonobj).
			contentType(ContentType.JSON).
		when().
			post("http://localhost:8084/addProject");
		String proname= response.jsonPath().get("projectName");
		String proid = response.jsonPath().get("projectId");
		
		response.then().assertThat().time(Matchers.lessThan(1000L),TimeUnit.MILLISECONDS)
				.statusCode(201).and()
				.contentType(ContentType.JSON).
				log().all();	
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
		Statement stat = con.createStatement();
		ResultSet set = stat.executeQuery("select project_name from project where project_id='"+proid+"'");
		String act="";
		
		while(set.next()) {
			act=set.getString(1);
		}
		Assert.assertEquals(act, proname);
		
		
	}

}
