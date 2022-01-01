package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateIndustry {
	public CreateIndustry(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	@FindBy(name="industry")
	private WebElement IndustryDw;
	
	@FindBy(linkText ="Energy")
	private WebElement EnergyDD;
	

public void dropdown() {
	Select sel=new Select(EnergyDD);
	sel.selectByVisibleText("Energy");
}
}
