package seleniumQ;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class multiselectdd {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hp/Desktop/dropdown.html");
		WebElement ele=driver.findElement(By.id("al-bek"));
		Select s=new Select(ele);
		//s.selectByIndex(1);
		//Thread.sleep(2000);
		//s.selectByValue("k");
		//Thread.sleep(2000);
		s.selectByVisibleText("jeera rice");
		Thread.sleep(2000);
		//s.deselectAll();
		
	}

}
