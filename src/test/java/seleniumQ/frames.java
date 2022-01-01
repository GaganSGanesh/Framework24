package seleniumQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class frames {
	public static void main(String[] args) throws Throwable {
		WebDriver driver =new FirefoxDriver();
		driver.get("file:///C:/Users/hp/Desktop/mainpage.html");
		Thread.sleep(2000);
		WebElement f=driver.findElement(By.xpath("//iframe[@id='f1']"));
		driver.findElement(By.xpath("//input [@id='t1']")).sendKeys("ADMIN");
		Thread.sleep(2000);
		//driver.switchTo().frame(0);
		driver.switchTo().frame("f1");
		driver.findElement(By.xpath("//input [@id='t2']")).sendKeys("manager");
		//driver.close();
	}

}
