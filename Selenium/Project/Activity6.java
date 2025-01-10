package FST_Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
	
@BeforeClass
public void setUp() {
	driver = new FirefoxDriver();
	driver.get("http://alchemy.hguy.co/crm");
	WebElement userName = driver.findElement(By.id("user_name"));
	WebElement password = driver.findElement(By.id("username_password"));
	WebElement login = driver.findElement(By.id("bigbutton"));
	
	userName.sendKeys("admin");
	password.sendKeys("pa$$w0rd");
	login.click();
}
 @Test
 public void activitiesMenu() {
	 WebElement activitiesMenu = driver.findElement(By.id("grouptab_3"));
	 if(activitiesMenu.isDisplayed()) {
		 activitiesMenu.click();
		 System.out.println("is clicked: ");
	 }
	 
	 
 }
 
 
 
@AfterClass
public void tearDown() {
	driver.quit();
}
}
