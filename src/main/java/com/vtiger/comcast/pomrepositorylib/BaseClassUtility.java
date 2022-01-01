package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.genericutilities.ExcelUtility;
import com.crm.genericutilities.FileUtility;
import com.crm.genericutilities.JavaUtility;
import com.crm.genericutilities.WebDriverUtility;

public class BaseClassUtility {
	public WebDriver driver;
	/*Object Creation for Lib*/
		public JavaUtility jlib =new JavaUtility();//are utility should be same as that in "Generic Utility"(spell)
		public WebDriverUtility wlib = new WebDriverUtility();
		public FileUtility flib = new FileUtility();
		public ExcelUtility elib = new ExcelUtility();
		
		
	
	@BeforeSuite
	public void configBS() {
		System.out.println("========================connect to DB========================");
	}
	//@Parameters(value="BROWSER")//multiple prmter
	@BeforeClass
	public void configBC() throws Throwable {
		String BROWSER=flib.getPropertyKeyValue("browser");
		System.out.println("=============Launch the Browser=======");
		if (BROWSER.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}else if (BROWSER.equals("chrome")) {
			driver=new ChromeDriver();
		}else if (BROWSER.equals("IE"))
		{driver=new InternetExplorerDriver();
		}
		else {
			driver=new InternetExplorerDriver();
		}
	}
	
	@BeforeMethod
	public void configBM() throws Throwable {
		/*common Data*/
		String username = flib.getPropertyKeyValue("username");
		String password = flib.getPropertyKeyValue("password");
		String url = flib.getPropertyKeyValue("url");
		String browser = flib.getPropertyKeyValue("browser");
		/* Navigate to app*/
		driver.get(url);
	/* step 1 : login */
	        Login loginPage = new Login(driver);
	loginPage.LoginToApp(username, password);
	}
	
	
	@AfterMethod
	public void configAM() {
	/*step 6 : logout*/
		Home homePage = new Home(driver);
homePage.logout();
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("=============Close the Browser=======");
		driver.quit();
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("========================close DB========================");
	}
}



