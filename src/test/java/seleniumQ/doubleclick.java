package seleniumQ;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleclick {
public static void main(String[] args) {
	WebDriver driver =new FirefoxDriver();
	driver.get("http://api.jquery.com/dblclick/");
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	Actions action=new Actions(driver);
	WebElement ele = driver.findElement(By.cssSelector("html>body>div"));
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", ele);
	action.doubleClick(ele).perform();
	
}
}
