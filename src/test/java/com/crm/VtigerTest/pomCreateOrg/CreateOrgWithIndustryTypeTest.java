package com.crm.VtigerTest.pomCreateOrg;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.genericutilities.ExcelUtility;
import com.crm.genericutilities.FileUtility;
import com.crm.genericutilities.JavaUtility;
import com.crm.genericutilities.WebDriverUtility;

public class CreateOrgWithIndustryTypeTest {
	@Test(groups = "RegressionTest")//this is used for group execution
	  public void createOrgWithIndustries()throws Throwable
	  {
	ExcelUtility elib=new ExcelUtility();
	FileUtility flib=new FileUtility();
	JavaUtility jlib=new JavaUtility();
	WebDriverUtility wlib=new WebDriverUtility();
	WebDriver driver=null;
	
		System.out.println("CREATEEE");
		String browser=flib.getPropertyKeyValue("browser");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		String url=flib.getPropertyKeyValue("url");
		  	
		  	Random random=new Random();
		  	int RanDomNumber = random.nextInt(100);
		  	Thread.sleep(1000);
		  	String orgname=elib.getData("Sheet1", 1, 2)+"_"+jlib.getRanDomNumber();
		  	Thread.sleep(1000);
		  	String industries=elib.getData("Sheet1", 1, 3);
		  	Thread.sleep(1000);
		  	String type=elib.getData("Sheet1", 1, 4);
	
			if(browser.equals("firefox")){
				driver=new FirefoxDriver();
			}else if(browser.equals("chrome")){
				driver=new ChromeDriver();
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			driver.findElement(By.linkText("Organizations")).click();
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
			driver.findElement(By.name("accountname")).sendKeys(orgname);
			WebElement industry = driver.findElement(By.name("industry"));
			Select s1=new Select(industry);
			s1.selectByVisibleText(industries);
			WebElement types=driver.findElement(By.name("accounttype"));
			Select s2=new Select(types);
			s2.selectByVisibleText(type);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
			WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));
			String text = ele.getText();
			if(text.contains(orgname))
			{
				System.out.println("organization is created===>pass");
			}else{
				System.out.println("organization is not created===>fail");
			}
			driver.close();
		}

}