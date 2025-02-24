package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GoogleSearchSteps {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User is on Google Home Page")
	public void open_google_home_page() {
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.google.com");
	}
	
	@When("User types in Cheese and hits ENTER")
	public void search_cheese_click_enter() {
		WebElement searchBar = driver.findElement(By.cssSelector("#APjFqb"));
		searchBar.sendKeys("Cheese");
		searchBar.sendKeys(Keys.RETURN);	
	}
	
	@Then("Show how many search results were shown")
	public void print_text() throws Throwable{
		
		
	    WebElement tools = wait.until(ExpectedConditions.elementToBeClickable(By.id("hdtb-tls")));
	    
	    Thread.sleep(5000);
	    tools.click();
	    System.out.println("Clicked the Tools button.");
	    
	    Thread.sleep(5000);
	   
		WebElement resultStatsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("result-stats")));
	    String resultStats = resultStatsElement.getText();
	    System.out.println("Number of results found: " + resultStats);
	}
	
	@And("Close the browser")
	public void close_browser(){
		driver.quit();
		
	}

}
