package FST_Selenium_Project;

import java.time.Duration;
import java.util.List;

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

public class Activity9 {
	 WebDriver driver;
	    @BeforeClass
	    public void setUp() {
	        driver = new FirefoxDriver();
	        driver.get("https://alchemy.hguy.co/crm/");
	        WebElement userName = driver.findElement(By.id("user_name"));
	        WebElement password = driver.findElement(By.id("username_password"));
	        WebElement login = driver.findElement(By.id("bigbutton"));
	        userName.sendKeys("admin");
	        password.sendKeys("pa$$w0rd");
	        login.click();
	    }
	    @Test
	    public void readaPopUp() {
	        WebElement salesButton = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(salesButton).perform();
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement leadOption = wait1.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//*[@id=\"moduleTab_9_Leads\"]")));
	        leadOption.click();
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement listTable = wait2.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector(".list")));
	        List<WebElement> rows = listTable.findElements(By.tagName("tr"));
	        System.out.println("Total rows (including headers): " + rows.size());
	        int nameCount = 0;  // This will track how many valid names we have printed
	        for (int i = 2; i < rows.size(); i++) {  // Start from the 3rd row (index 2)
	            WebElement row = rows.get(i);
	            // Check if the row contains <td> elements
	            List<WebElement> cells = row.findElements(By.tagName("td"));
	            // Skip rows that don't contain enough <td> elements (header or other irrelevant rows)
	            if (cells.size() <= 7) {
	                continue; // Skip rows with less than 8 cells
	            }
	            String name = cells.get(2).getText();  // Assuming name is in the 3rd column (index 2)
	            String leadUserName = cells.get(7).getText();  // Assuming userName is in the 8th column (index 7)
	            // Skip rows with empty or non-relevant names
	            if (name.equals("(1 - 20 of 54)")) {
	                continue; // Skip rows with empty or non-relevant names
	            }
	            // Print Name and UserName for the first 10 valid rows
	            System.out.println("Name: " + name + ", UserName: " + leadUserName);
	            nameCount++;
	            // Stop after printing 10 valid names
	            if (nameCount == 10) {
	                break;
	            }
	        }
	    }
	    @AfterClass
	    public void tearDown() {
	    	driver.quit();
	    }
}
