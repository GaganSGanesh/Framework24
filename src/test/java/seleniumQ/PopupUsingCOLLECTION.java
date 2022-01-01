package seleniumQ;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupUsingCOLLECTION {//CLOSING ONLY CHILD BROWSER POPUP
	
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		String parent = driver.getWindowHandle();
		Set<String> allwin = driver.getWindowHandles();
		allwin.remove(parent);
		for (String actual:allwin)
		{
			driver.switchTo().window(actual);//switch to assigned variable in foreach
			driver.close();
		
		}
		
	}
}
