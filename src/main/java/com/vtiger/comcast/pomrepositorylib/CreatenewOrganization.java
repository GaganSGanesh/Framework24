package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.genericutilities.ExcelUtility;
import com.crm.genericutilities.WebDriverUtility;

public class CreatenewOrganization {
	public CreatenewOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
@FindBy(name="accountname")
private WebElement orgnameEdt;

@FindBy(name="industry")
private WebElement IndustryDropdwn;


@FindBy(xpath ="//input[@value='  Save  ']")
private WebElement saveBtn;

public void createOrg(String orgName) {
	WebDriverUtility wu=new WebDriverUtility();
	ExcelUtility eu=new ExcelUtility();
	orgnameEdt.sendKeys(orgName);

	wu.select(IndustryDropdwn, eu.getData("Contact", 1, 4));
	//wu.select(IndustryDropdwn, eu.getData("Contact", 1, 4));
	saveBtn.click();
}
}
