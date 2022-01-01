package seleniumQ;

import javax.swing.plaf.basic.BasicTreeUI.TreePageAction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.reactivex.rxjava3.functions.Action;

public class draganddrop { public static void main(String[] args) {
	WebDriver driver=new FirefoxDriver();
	Actions action=new Actions(driver);
	driver.get("http://api.jquery.com/droppable/");
	WebDriverWait wait=new WebDriverWait(driver, 5);
	wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));
	WebElement sourcelocator=driver.findElement(By.cssSelector("#draggable"));
	WebElement targetlocator=driver.findElement(By.cssSelector("#droppable"));
action.dragAndDrop(sourcelocator,targetlocator).perform();
}

}
