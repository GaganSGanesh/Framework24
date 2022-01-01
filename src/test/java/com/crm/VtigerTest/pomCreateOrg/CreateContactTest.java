package com.crm.VtigerTest.pomCreateOrg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.genericutilities.ExcelUtility;
import com.crm.genericutilities.FileUtility;
import com.crm.genericutilities.JavaUtility;
import com.crm.genericutilities.WebDriverUtility;
import com.vtiger.comcast.pomrepositorylib.ContactInfoPage;
import com.vtiger.comcast.pomrepositorylib.ContactsPage;
import com.vtiger.comcast.pomrepositorylib.CreateNewConctact;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;

public class CreateContactTest {
	@Test(groups = "smokeTest")//this is used for group execution
	
	public static void CreateConatctTest() throws Throwable {//NOTE: IF YOU WRITE MAIN METHOD HERE TESTNG WILL THROW EXCEPTION 
		ExcelUtility elib=new ExcelUtility();
		FileUtility flib=new FileUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		WebDriver driver=null;
		
		// **READ COMMON DATA**
		
		String browser=flib.getPropertyKeyValue("browser");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		String url=flib.getPropertyKeyValue("url");
		
		
		//** READ TERST DATA
		String conname=elib.getData("Contact", 1, 2)+"_"+jlib.getRanDomNumber();
		String lastname=elib.getData("Contact", 1, 3)+"_"+jlib.getRanDomNumber();
	
	
	//STEP1: --LAUNCH THE BROWSER --
	if (browser.equals("firefox"))
	{
		driver= new FirefoxDriver();
	}else if (browser.equals("chrome")) {
		driver=new ChromeDriver();
	}else if (browser.equals("IE"))
	{driver=new InternetExplorerDriver();
	}
	else {
		driver=new InternetExplorerDriver();

}
	
	//STEP2:--LOGIN TO APP--
	driver.get(url);
	Login log=new Login(driver);
	log.LoginToApp(username, password);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//STEP3:--NAVIGATE TO CREATE CONTACT
    Home hm=new Home(driver);
    hm.getContactsBtn().click();
    //STEP4:CONTACT BTN
    ContactsPage cp=new ContactsPage(driver);
    cp.getCreateContactBtn().click();
//STEP5: CREATE NEW CONATCT
    CreateNewConctact cn=new CreateNewConctact(driver);
    cn.getlastnme().sendKeys(lastname);
    cn.getSaveBtn().click();
    
    //VERIFY
    ContactInfoPage cip=new ContactInfoPage(driver);
    if (cip.getConvrfy().getText().contains(lastname)) {
    	System.out.println("New Contact-->"+lastname+" Successfully Created ");
    }else
    {
    	System.out.println("Contact creation FAILED");
    }
	driver.close();
    
	}

}
	

