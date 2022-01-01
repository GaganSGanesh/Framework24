package seleniumQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class singleormultidd {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hp/Desktop/dropdown.html");
		WebElement ele = driver.findElement(By.id("al-bek"));
		Select s=new Select(ele);
		boolean b=s.isMultiple();
		if(b)
		{
			System.out.println("multiple");
		}
		else
		{System.out.println("not multiple");}
		
	}

}
