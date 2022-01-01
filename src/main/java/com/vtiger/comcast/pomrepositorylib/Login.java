package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login { //Rule1: create a seperate class for every page in a application

	public Login(WebDriver driver) {//Rule3: execute all the elements and initialize the elements pageFactory.initElements(initialization)
PageFactory.initElements(driver, this);
	}
	@FindBy(name ="user_name") //Rule2: identify all the elements using @findby & findbys ,findall (declaration)
	private WebElement userNameEdt;
	
	@FindBy(name ="user_password")
	private WebElement userPasswordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@id='submitButton']")})
	private WebElement loginBtn;
	//rule4: declare all the method as private and provide getters method,business method for (utilization)

	public WebElement getUserNameEt() {// To get these getters and setters automatically Go to "Source" at top left and click on "Generate getters and setters" and then choose either setter or getter) 
		return userNameEdt;
	}

	public WebElement getUserPasswordEt() {
		return userPasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
public void LoginToApp(String username , String password) {
	//step1: Login 
	userNameEdt.sendKeys(username);
	userPasswordEdt.sendKeys(password);
	loginBtn.click();
}
}
	
	
