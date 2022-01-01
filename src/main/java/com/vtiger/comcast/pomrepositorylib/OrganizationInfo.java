package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfo {
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//span[@class='dvHeaderText']")
private WebElement successfulMSG;

@FindBy(xpath="//span[@id='dtlview_Industry']")
private WebElement indInfo;

@FindBy(xpath="//span[@id='dtlview_Type']")
private WebElement typeInfo;

public WebElement getsuccessfulMSG() {
	return successfulMSG;
}

public WebElement getIndInfo() {
	return indInfo;
}

public WebElement getTypeInfo() {
	return typeInfo;
}


}
