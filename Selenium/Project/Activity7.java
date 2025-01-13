package FST_Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity7 {
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
	 public void salesMenu() throws InterruptedException {
		 WebElement salesMenu = driver.findElement(By.id("grouptab_0"));
		 Actions actions = new Actions(driver);
	        actions.moveToElement(salesMenu).perform();
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		 WebElement  leadOption=  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"moduleTab_9_Leads\"]")));
		   leadOption.click();
		   WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		   System.out.println("found button");
	        WebElement additionalInfo = wait2.until(ExpectedConditions.visibilityOfElementLocated(
	        		By.xpath("//*[@id=\"adspan_77c0ebaa-448d-740d-a00f-605ae70266e9\"]/span")));
	        additionalInfo.click();
	        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(100));
	        WebElement phoneNumber = driver.findElement(By.cssSelector(".phone"));
	        System.out.println("The phone number displayed on the leads pop up is: "+phoneNumber.getText());
			
	 }
	 
	
	 
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
