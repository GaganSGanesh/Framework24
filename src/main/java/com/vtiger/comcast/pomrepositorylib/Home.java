package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
WebDriver driver;//global driver variable
public Home(WebDriver driver) {
this.driver =driver;
PageFactory.initElements(driver, this);
}

@FindBy(linkText ="Organizations")          
private WebElement OrganizationsLnk;

@FindBy(linkText = "Contacts")
private WebElement ContactsBtn;

@FindBy(linkText ="Products")
private WebElement ProductsLnk;

@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
private WebElement administratorImg;

@FindBy(linkText  ="Sign Out")
private WebElement SignOutLnk;

public WebElement getOrganizationsLnk() {//used in baseClass pgm
	return OrganizationsLnk;
}
public WebElement getContactsBtn() {
	return ContactsBtn;
}
public WebElement getProductsLnk() {
	return ProductsLnk;
}
public WebElement getAdministratorImg() {
	return administratorImg;
}
public WebElement getSignOutLnk() {
	return SignOutLnk;
}


public void logout() {
	Actions act= new Actions(driver);
	act.moveToElement(administratorImg).perform();
	SignOutLnk.click();
}
}



