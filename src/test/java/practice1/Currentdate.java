package practice1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Currentdate {
@Test
public void Currentdate() throws InterruptedException {
	
	MakeMyTripDate dateObj=new MakeMyTripDate();
	String Date=dateObj.toString();
	System.out.println(Date);
	String[] today = Date.split(" ");


WebDriver driver=new FirefoxDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
driver.get("https://www.makemytrip.com/");
driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();
driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
driver.findElement(By.xpath("//span[text()='From']")).click();
driver.findElement(By.xpath("//p[text()='Mumbai, India']")).click();
driver.findElement(By.xpath("//input[@placeholder='To']")).click();
driver.findElement(By.xpath("//p[text()='Delhi, India']")).click();
driver.findElement(By.xpath("//label[@for='departure']")).click();
driver.findElement(By.xpath("//div[@aria-label='Fri Nov 12 2021']")).click();

}

}
