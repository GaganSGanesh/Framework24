package com.rmgyantraGenericUtils;

import io.restassured.response.Response;

public class JsonUtility {
	public String getsonresponsevalue(Response response,String jsonpath) {
		String responseJsonvalue=response.jsonPath().get(jsonpath);
		return responseJsonvalue;
	}
	}
