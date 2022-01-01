package practice1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.crm.genericutilities.FileUtility;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;

public class HandlingDynamicTables {
	@Test
	public void HandlingDynamicTables() throws Throwable{
		WebDriver driver;
		FileUtility flib=new FileUtility();
		String browser=flib.getPropertyKeyValue("browser");
		String url=flib.getPropertyKeyValue("url");
		String username=flib.getPropertyKeyValue("username");
		String password=flib.getPropertyKeyValue("password");
		
		
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
		//To tick all the checkBoxes
		Thread.sleep(3000);
	driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]")).click();
		//all organization name
	String OrgName="OrgName64";
	List<WebElement> orgs = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	for (int i=1;i<orgs.size();i++)
	{
		String Actorg = orgs.get(i).getText();
		System.out.println(Actorg);
		if (Actorg.contains(OrgName)) {
		driver.findElement(By.xpath("//a[contains(text(),'"+OrgName+"')]/parent::td/following-sibling::td[5]/a[2]")).click();	
		System.out.println(OrgName+"is deleted");
		break;
		}
	}
	

	}
}
