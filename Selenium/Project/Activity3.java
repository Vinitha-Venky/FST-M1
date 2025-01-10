package FST_Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity3 {
	WebDriver driver;
	@BeforeClass
	    public void setUp() {
	        // Initialize Firefox driver
	        driver = new FirefoxDriver();
	        // Open the page
	        driver.get("http://alchemy.hguy.co/crm");
	        }
	@Test
    public void testCase1() {
    	WebElement pageFooter = driver.findElement(By.xpath("//*[@id=\"admin_options\"]"));
        String footerText=pageFooter.getText();
    	Reporter.log("content at the footer: "+footerText);
        System.out.println("content in footer: "+footerText);
    	
    }
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}

