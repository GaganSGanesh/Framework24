package seleniumQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class idd {public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	driver.get("http://demo.automationtesting.in/Frames.html");
	WebElement ele=driver.findElement(By.xpath("//a[.='Widgets']"));
	Select s=new Select(ele);
	s.selectByVisibleText("Slider");
	
}

}
