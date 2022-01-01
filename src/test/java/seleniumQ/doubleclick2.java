package seleniumQ;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class doubleclick2 {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.guru99.com/");
		//creating object for action class
		Actions action=new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//h4[.='China Firewall Test']"));
		//using javaScript Executor for scrolling
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView()", ele);
		action.doubleClick(ele).perform();
	
	}

}
