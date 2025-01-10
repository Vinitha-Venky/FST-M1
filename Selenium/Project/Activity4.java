package FST_Selenium_Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

public class Activity4 {
	WebDriver driver;
	 WebDriverWait wait;

	    @BeforeMethod
	    public void setUp() {
	        // Initialize driver
	        driver = new FirefoxDriver();
	        // Initialize wait
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        // Open the page
	        driver.get("https://alchemy.hguy.co/crm");
	    }
	    @Test
	    //@Parameters({ "username", "password", "message" })
	    public void loginTestCase() {
	        // Find username and password fields
	        WebElement usernameField = driver.findElement(By.id("user_name"));
	        WebElement passwordField = driver.findElement(By.id("username_password"));

	        // Enter credentials
	        usernameField.sendKeys("admin");
	        passwordField.sendKeys("pa$$w0rd");

	        // Click the submit button
	        driver.findElement(By.id("bigbutton")).click();

	        // Assert login message
	        String loginMessage = driver.findElement(By.id("tab0")).getText();
	        Assert.assertEquals(loginMessage ,"SUITECRM DASHBOARD");
	        }
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
