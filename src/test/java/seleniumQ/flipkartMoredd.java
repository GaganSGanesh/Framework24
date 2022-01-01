package seleniumQ;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class flipkartMoredd {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		//driver.findElement(By.xpath("")).click();
		driver.findElement(By.xpath("//img[@alt='Mobiles']")).click();
		WebElement ele = driver.findElement(By.xpath("//span[@class='_2I9KP_' and contains(.,'Electronics')]"));
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//a[@title='Mi']")).click();
		WebElement element = driver.findElement(By.xpath("//select[@class='_2YxCDZ' and contains(.,'Min')]"));
		Select sel=new Select(element);
		sel.selectByValue("10000");
		WebElement element2 = driver.findElement(By.xpath("//select[@class='_2YxCDZ' and contains(.,'50000+')]"));
		Select sel1=new Select(element2);
		sel.selectByValue("50000");
	
	}

}
