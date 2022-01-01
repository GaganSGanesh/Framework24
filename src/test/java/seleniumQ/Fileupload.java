package seleniumQ;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Fileupload {
	public static void main(String[] args) {
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Register.html");
		WebDriverWait wait=new WebDriverWait(driver, 10);
		WebElement button = driver.findElement(By.xpath("//input[@id='imagesrc' and @onchange='uploadimg()']"));
		wait.until(ExpectedConditions.visibilityOf(button));
		button.click();
		button.sendKeys("‪C:\\Users\\hp\\Downloads\\maxresdefault.jpg");
	}
}
