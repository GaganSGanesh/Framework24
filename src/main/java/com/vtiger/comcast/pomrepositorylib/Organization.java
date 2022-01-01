package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organization {
	public Organization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath = "//img[@title='Create Organization...']")
private WebElement createOrgImage;

@FindBy(name = "search_text")
private WebElement searchTxtfld;

@FindBy(name = "search")
private WebElement searchBtn;

public WebElement getCreateOrgImage() {
	return createOrgImage;
}

public WebElement getSearchTxtfld() {
	return searchTxtfld;
}

public WebElement getSearchBtn() {
	return searchBtn;
}

}
