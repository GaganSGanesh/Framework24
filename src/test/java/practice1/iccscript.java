package practice1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class iccscript {
@Test
public void iccdropdn() {
	WebDriver driver=new FirefoxDriver();
	driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
	driver.get("https://www.icc-cricket.com/rankings/mens/player-rankings/test");
	WebElement ele = driver.findElement(By.xpath("//div[@data-type='RANKINGS_YEAR']"));
	ele.click();
	Select s=new Select(ele);
s.selectByVisibleText("May ");
}
}
