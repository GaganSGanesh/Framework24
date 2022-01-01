package practice1;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.DateConversion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MakeMyTripDate {
	public static void main(String[] args) {
		Date date=new Date();
		String sysdate=date.toString();
		System.out.println(sysdate);
		String[] Cdate = sysdate.split(" ");
		String actdate = Cdate[0]+" "+Cdate[1]+" "+Cdate[2]+" "+Cdate[5];
		System.out.println(actdate);
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get("https://www.makemytrip.com");
	driver.findElement(By.xpath("//li[@data-cy='account']")).click();
	driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	driver.findElement(By.xpath("//span[.='From']")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
	driver.findElement(By.xpath("//span[.='To']")).click();
	driver.findElement(By.xpath("//p[contains(text(),'Delhi, India')]")).click();
	driver.findElement(By.xpath("//p[@data-cy='departureDate']")).click();
	driver.findElement(By.xpath("//div[@aria-label='"+actdate+"']")).click();//Dyanmic Xpath
	
	}
}
