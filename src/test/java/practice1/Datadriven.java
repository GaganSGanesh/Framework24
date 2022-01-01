package practice1;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Datadriven {
	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("./data/Data2.properties");
		Properties pobj=new Properties();
		pobj.load(file);
	//	String BROWSER=pobj.getProperty("browser");
		String URL=pobj.getProperty("url");
		String USERNAME=pobj.getProperty("username");
		String PASSWORD=pobj.getProperty("password");
	
	WebDriver driver=new FirefoxDriver();
	driver.get(URL);
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
    driver.findElement(By.xpath("//input[@type='submit']")).click();

}
}


