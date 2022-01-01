package com.crm.RMGYANTRATest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

public class Demo {
	public static void main(String[] args) {
		
WebDriver drv=new FirefoxDriver();
drv.get("http://demo.automationtesting.in/Frames.html");
drv.switchTo().frame(1);
}
