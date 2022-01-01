package com.rmgAuthentification;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositorylib.PojoLibrary;

public class Deserilization {
	@Test
	public void deserial() throws Throwable, Throwable, IOException {
		ObjectMapper mapper=new ObjectMapper();
		PojoLibrary pojo=mapper.readValue(new File("./JsonValue"), PojoLibrary.class);
		System.out.println(pojo.getCreatedBy());
		System.out.println(pojo.getProjectName());
		System.out.println(pojo.getStatus());
		System.out.println(pojo.getTeamSize());
	}

}
