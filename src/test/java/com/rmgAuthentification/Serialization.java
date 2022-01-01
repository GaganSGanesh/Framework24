package com.rmgAuthentification;
import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import com.vtiger.comcast.pomrepositorylib.PojoLibrary;

public class Serialization {
	@Test
	public void serial() throws Throwable, Throwable, IOException {
		PojoLibrary pobj=new PojoLibrary("Gagan G", "TestYantra", "Completed", 10);
		ObjectMapper mapper=new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValue(new File("./JsonValue"), pobj);;
	}

}
