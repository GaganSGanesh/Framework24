package seleniumQ;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class tablehandling {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		driver.get("https://www.icc-cricket.com");
		driver.findElement(By.xpath("//div[contains(.,'Rankings ') and @class='global-navigation__link']")).click();
		driver.findElement(By.xpath("//a[@href='/rankings/mens/team-rankings']")).click();
		driver.findElement(By.xpath("//a[text()='T20I']")).click();
		WebElement ele = driver.findElement(By.xpath("//table/tbody/tr[contains(.,'India')]/td[5]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
		String Rating = ele.getText();
		System.out.println("India Rating in T20I"+" "+Rating);
	
	}

}
