package com.rmgyantraGenericUtils;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.crm.genericutilities.DataBaseUtility;

import static io.restassured.RestAssured.*;

public class BaseApi {
	public DataBaseUtility dbutility=new DataBaseUtility();
	@BeforeSuite
	public void BS() throws Throwable {
		dbutility.connectToDB();
		System.out.println("database connectionn is established");
	baseURI="http;//localhost";
	port=8084;
	}
	@AfterSuite
	public void AS() throws Exception {
		dbutility.closeDB();
		System.out.println("database is closed");
		

	}
	}


