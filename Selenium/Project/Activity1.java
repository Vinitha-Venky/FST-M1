package FST_Selenium_Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
    
    // Setup function
    @BeforeClass
    public void setUp() {
        // Initialize Firefox driver
        driver = new FirefoxDriver();
        // Open the page
        driver.get("http://alchemy.hguy.co/crm");
    }
    
    // Test function
    @Test
    public void homePageTest() {
        // Assert page title
        Assert.assertEquals(driver.getTitle(), "SuiteCRM");
    }
   
    
    @AfterClass
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}