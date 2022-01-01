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
import com.vtiger.comcast.pomrepositorylib.CreatenewOrganization;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;
import com.vtiger.comcast.pomrepositorylib.Organization;
import com.vtiger.comcast.pomrepositorylib.OrganizationInfo;

public class CreateOrgWithContactTest {
	@Test(groups = "RegressionTest")//this is used for group execution(mention the group name in .xml in groups to execute the particular T.CASE)
	public static void CreateOrgWithContact() throws Throwable {
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
	String orgname=elib.getData("Sheet1", 1, 2)+"_"+jlib.getRanDomNumber();
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
	
	//STEP3:--NAVIGATE TO CREATE ORG--
	//Thread.sleep(5000);
	Home hp=new Home(driver);
	hp.getOrganizationsLnk().click();
	
	
//STEP4:-- NAVIGATE TO CREATE NEW ORG PAGE --
//	Thread.sleep(5000);
	Organization org=new Organization(driver);
	org.getCreateOrgImage().click();
	
	
//STEP5:--CREATE ORG--
	CreatenewOrganization cno= new CreatenewOrganization(driver);
	cno.createOrg(orgname);
	
	//STEP6:--VERIFY--
	OrganizationInfo orginfo=new OrganizationInfo(driver);
	wlib.waitForElementVisibility(driver, orginfo.getsuccessfulMSG());
	String actsuccMSG=orginfo.getsuccessfulMSG().getText();
//	System.out.println(actsuccMSG);//THese statements allow to see what does variable consist of and what might your if condition  ight return
//System.out.println(orgname);
	if(actsuccMSG.contains(orgname)) {
		System.out.println("ORGANIZATION IS CREATED SUCCESSFULLY");
		
	}
	else {
		System.out.println("ORGANIZATION IS not CREATED");
		}
	//STEP7:NAVIGATE TO CREATE CONTACT
    Home hm=new Home(driver);
    hm.getContactsBtn().click();
    //STEP8:--CONTACT BTN
    ContactsPage cp=new ContactsPage(driver);
    cp.getCreateContactBtn().click();
//STEP9:-- CREATE NEW CONATCT
    CreateNewConctact cn=new CreateNewConctact(driver);
    cn.getlastnme().sendKeys(lastname);
    cn.getSaveBtn().click();
    
    //STEP10:--VERIFY
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
