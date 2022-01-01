package seleniumQ;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class dropdown {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.get("file:///C:/Users/hp/Desktop/dropdown.html");
		WebElement ele=driver.findElement(By.id("al-bek"));
		Select s=new Select(ele);
		List<WebElement> options = s.getOptions();
		//int count=options.size();
//System.out.println(count);
for (WebElement we:options)
{
	String text = we.getText();
	System.out.println(text);
	}
	}

}
