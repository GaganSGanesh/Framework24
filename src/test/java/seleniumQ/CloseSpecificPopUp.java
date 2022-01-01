package seleniumQ;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CloseSpecificPopUp {//"Tech Mahindra"
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://www.naukri.com");
		Set<String> allWIN = driver.getWindowHandles();
		for (String winds:allWIN)
		{
			driver.switchTo().window(winds);
			String title = driver.getTitle();
			if(title.equals("Tech Mahindra"))
			{
				driver.close();
			}
		}
	}
}
