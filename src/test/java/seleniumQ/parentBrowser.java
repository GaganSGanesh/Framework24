package seleniumQ;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class parentBrowser {
public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	driver.get("https://www.naukri.com");
	String parentWiN = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();
	for (String All:windows)
	{
	if (All.equals(parentWiN))
	{
		driver.switchTo().window(All);
		driver.close();
	}
	}
}
}
