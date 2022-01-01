package com.rmgyantraGenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtilityy {
	public Connection connection=null;
	public void connectToDB()
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void closeDB()
	{
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ResultSet getAllData(String query) {
		try {
			ResultSet result = connection.createStatement().executeQuery(query);
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;	
	}

	public String getDataandVerifyTheData(String query,int columnNumber,String expectedData) throws Exception {
		ResultSet result = connection.createStatement().executeQuery(query);
		boolean flag=false;
		String actualData=null;
		try {
		while(result.next()) {
			if(result.getString(columnNumber).equals(expectedData)) {
				actualData=result.getString(columnNumber);
				flag=true;
				break;
			}
		}
			} catch (SQLException e) {
				e.printStackTrace();
		}
		if(flag) {
			System.out.println("Data is verified and matching in database");
		return actualData;
		}
		else
		{
			System.out.println("Data is not matching in database");
			return actualData;
		}
		
		
		
		
}

}
