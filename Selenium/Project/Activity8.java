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

public class Activity8 {
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
	 public void readaPopUp() {
	        WebElement salesButton = driver.findElement(By.xpath("//*[@id=\"grouptab_0\"]"));
	        Actions actions = new Actions(driver);
	        actions.moveToElement(salesButton).perform();
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement accounts = wait1.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//*[@id=\"moduleTab_9_Accounts\"]")));
	        accounts.click();
	        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement accountsTable = wait2.until(ExpectedConditions.visibilityOfElementLocated(
	                By.cssSelector(".list")));
	        // Get all rows
	        List<WebElement> rows = accountsTable.findElements(By.tagName("tr"));
	        System.out.println("Total rows (including headers): " + rows.size());
	        int nameCount = 0;  // This will track how many odd-numbered names we have printed
	        int rowNumber = 1;  // Start counting from row 1 (which will be the 3rd row)
	        for (int i = 2; i < rows.size(); i++) {  // Start from the 3rd row (index 2)
	            WebElement row = rows.get(i);
	            // Check if the row contains <td> elements
	            List<WebElement> cells = row.findElements(By.tagName("td"));
	            // Skip rows that don't contain <td> elements (header or other irrelevant rows)
	            if (cells.isEmpty()) {
	                continue; // Skip header rows or non-relevant rows
	            }
	            // Identify the correct column for "Name" (3rd <td>)
	            String name = cells.get(2).getText(); // "Name" is in the 3rd <td> (index 2)
	            // Skip any row that contains non-useful data like "Name: (1 - 20 of 54)"
	            if (name.isEmpty() || name.equals("(1 - 20 of 54)")) {
	                continue; // Skip rows with empty or non-relevant names
	            }
	            // Consider row 3 as row 1, row 5 as row 2, etc.
	            if (rowNumber % 2 != 0) {  // This ensures odd-numbered rows starting from row 3
	                System.out.println("Name: " + name);
	                nameCount++;  // Increment valid odd-numbered name count
	                // Stop after printing 5 odd-numbered names
	                if (nameCount == 5) {
	                    break;  // Exit the loop after printing 5 valid odd-numbered names
	                }
	            }
	            rowNumber++;  // Increment the row counter
	        }
	    }
	 
	
	 
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
