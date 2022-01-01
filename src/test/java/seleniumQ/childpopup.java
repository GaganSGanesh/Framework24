package seleniumQ;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class childpopup {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		//get window handles handles all browsers both parent and child, 
		//so finally parent browser also closes
		Set<String> windows = driver.getWindowHandles();
		for (String wh:windows)
		{
			driver.switchTo().window(wh);
			String title = driver.getTitle();
			System.out.println(title);
			driver.close();
		}
		
		
	}

}
