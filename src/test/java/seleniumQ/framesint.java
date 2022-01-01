package seleniumQ;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class framesint {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=new FirefoxDriver();
		driver.get("http://demo.automationtesting.in/Frames.html");
		WebElement ele=driver.findElement(By.xpath("//iframe[@id='singleframe']"));
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		System.out.println("frAme sWitcheD");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Gagan");
		
	}

}
