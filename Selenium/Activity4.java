

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

public class Activity4 {
	 public static void main(String[] args) {
	        // Initialize the Firefox driver
	        WebDriver driver = new FirefoxDriver();

	        // Open the page
	        driver.get("https://training-support.net/webelements/target-practice");
	        // Print the title of the page
	        System.out.println("Home page title: " + driver.getTitle());
	        String thirdHeaderText = driver.findElement(By.xpath("//h3[contains(text(), '#3')]")).getText();
	        System.out.println(thirdHeaderText);
	        Color fifthHeaderColor = Color.fromString(driver.findElement(By.xpath("//h5[contains(text(), '#5')]")).getCssValue("color"));
	        //System.out.println("fifthHeadercolour"+fifthHeaderColor);
	        System.out.println("Color as RGB: " + fifthHeaderColor.asRgb());
	       System.out.println("Color as hexcode: " + fifthHeaderColor.asHex());
	        String purpleButtonClass = driver.findElement(By.xpath("//button[text()='Purple']")).getDomAttribute("class");
	        System.out.println("Purple button's classes are: "+ purpleButtonClass);
	        String slateButtonText = driver.findElement(By.xpath("//button[contains(@class, 'slate')]")).getText();
	        System.out.println(slateButtonText);
	        driver.quit();
}
}