import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
	 public static void main(String[] args) {
	        // Initialize the Firefox Driver
	        WebDriver driver = new FirefoxDriver();

	        // Open the page
	        driver.get("https://training-support.net/webelements/login-form");

	        // Verify the page title
	        System.out.println("Page title is: " + driver.getTitle());
	        driver.findElement(By.id("username")).sendKeys("admin");
	        driver.findElement(By.id("password")).sendKeys("password");
	        driver.findElement(By.xpath("//button[text()='Submit']")).click();

	        // Print the confirmation message
	        String message = driver.findElement(By.tagName("h1")).getText();
	        System.out.println(message);

	        // Close the browser
	        driver.quit();
	 }
}
