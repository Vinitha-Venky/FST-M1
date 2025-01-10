package FST_Selenium_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

	 WebDriver driver;
	    
	    // Setup function
	    @BeforeClass
	    public void setUp() {
	        // Initialize Firefox driver
	        driver = new FirefoxDriver();
	        // Open the page
	        driver.get("http://alchemy.hguy.co/crm");
	    }
	    @Test
	    public void testCase1() {
	    	WebElement pageHeading = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
	        String imgHeader=pageHeading.getDomAttribute("src");
	    	Reporter.log("Found the url opened "+imgHeader);
	        System.out.println("url is  : "+imgHeader);
	    	
	    }
	    @AfterClass
	    public void tearDown() {
	        // Close the browser
	        driver.quit();
	    }
		
}
