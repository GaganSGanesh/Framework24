package seleniumQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class cleartrip {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new FirefoxDriver();
		Thread.sleep(2000);
		driver.get("https://www.cleartrip.com");
		driver.findElement(By.xpath("//input[@placeholder='Any worldwide city or airport']"));
		driver.findElement(By.xpath("//p[.='Bangalore, IN - Kempegowda International Airport (BLR)']\"")).click();
		
		}

}
