package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutilities.WebDriverUtility;

public class CreateNewConctact {
	

@FindBy(name="lastname") //its mandatory field and Fn is not mandatory
private WebElement lname;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")  //input[@name='account_name'][It is the xpath of organization Text Field(static)]/following-sibling::img
private WebElement lookupbtn;

@FindBy(xpath = "//tbody/tr[1]/td[1]/div[1]/input[1]")//to get this xpath: inspect save button (there are 2 save button and you will find 2 result for inspection),above the inspection you will find the tbody,td part
private WebElement saveBtn;

public CreateNewConctact(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getlastnme() {
	return lname;
}

public WebElement getLookupbtn() {
	return lookupbtn;
}

public WebElement getSaveBtn() {
	return saveBtn;
}
public void CreateNewConctacts(String driver,String lname)
{
	saveBtn.click();
}

WebDriverUtility Wu=new WebDriverUtility();
public void CreateNewConctacts(WebDriver driver,String lastName,String orgName)
{
	lname.sendKeys(lastName);
	lookupbtn.click();
	Wu.switchToWindow(driver, "Accounts&action");
	Organization org=new Organization(driver);
	org.getSearchTxtfld().sendKeys(orgName);
	org.getSearchBtn().click();
	driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
	Wu.switchToWindow(driver, "Contacts&action");
	saveBtn.click();
	
}
	
}


