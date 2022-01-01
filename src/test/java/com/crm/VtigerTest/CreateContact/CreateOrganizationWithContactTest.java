
package com.crm.VtigerTest.CreateContact;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.genericutilities.ExcelUtility;
import com.crm.genericutilities.FileUtility;

public class CreateOrganizationWithContactTest {
	@Test
	public void CreateOrganizationWithContact1() throws Throwable{
		
	
	Random ran=new Random();
	int ranweb=ran.nextInt(1000);
	
	FileUtility flib=new FileUtility();//called from genericutilities package 
	ExcelUtility elib=new ExcelUtility();
	String url=flib.getPropertyKeyValue("url");
	String username=flib.getPropertyKeyValue("username");
	String password=flib.getPropertyKeyValue("password");
	String browser=flib.getPropertyKeyValue("browser");
	String Orgname=elib.getData("Sheet1",1, 2)+"_"+ranweb;
	String conname=elib.getData("Contact", 1, 2)+"_"+ranweb;
	System.setProperty("webdriver.gecko.driver", "./geckodriver.exe");
	System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
	WebDriver driver=null;
	if(browser.equals("firefox")) {
		driver =new FirefoxDriver();
		}
	else if(browser.equals("chrome")) {
		driver=new ChromeDriver();
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get(url);
    driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
	driver.findElement(By.xpath("//input[@type='submit']")).click();
	driver.findElement(By.linkText("Organizations")).click();
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	driver.findElement(By.name("accountname")).sendKeys(Orgname);
	driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
	WebElement ele = driver.findElement(By.xpath("//span[@class='dvHeaderText']"));//used to compare the title 
	String text = ele.getText();
	if(text.contains("Organization Information"))
		{
			System.out.println("organization is created===>pass");
		}else{
			System.out.println("organization is not created===>fail");
		}
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Contacts"))));
	driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(conname);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(conname);   
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		Set<String> set = driver.getWindowHandles();
		String parentid = driver.getWindowHandle();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String windowid = it.next();
			driver.switchTo().window(windowid);
			if((driver.getTitle()).contains("Accounts&action"))
			{
				break;
			}
		}
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(Orgname);
	    driver.findElement(By.xpath("//input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='"+Orgname+"']")).click();
		driver.switchTo().window(parentid);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		WebElement ele1 = driver.findElement(By.xpath("//span[contains(text(),'Contact Information')]"));
 		String txt = ele1.getText();
 		if(txt.contains(conname))
 		{
 			System.out.println("organization is created===>pass");
 		}else{
 			System.out.println("organization is not created===>fail");
 		}
 		driver.close();
     }

}