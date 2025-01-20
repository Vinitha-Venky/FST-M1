package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Activity4 {
	public class LoginSteps1 {
	    WebDriver driver;
	    WebDriverWait wait;
	    
	    @Given("^User is on Login page")
	    public void loginPage1() {
	        //Setup instances
	        driver = new FirefoxDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        //Open browser
	        driver.get("https://training-support.net/webelements/login-form");
	    }
	    
	    
	    @When("User enters {string} and {string}")
	    public void user_enters_and(String string, String string2) throws InterruptedException {
	        // Write code here that turns the phrase above into concrete actions
	    	driver.findElement(By.id("username")).sendKeys(string);
	        //Enter password from Feature file
	        driver.findElement(By.id("password")).sendKeys(string2);
	        Thread.sleep(1000);
	        //Click Login
	        driver.findElement(By.xpath("//button[@type='submit']")).click();
	        Thread.sleep(1000);
	    	
	        
	    }
	    
	    
	    @Then("^Read the page title and confirmation message")
	    public void readTitleAndHeading1() {
	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
	        
	        //Read the page title and heading
	        String pageTitle = driver.getTitle();
	        String confirmMessage = driver.findElement(By.id("action-confirmation")).getText();
	        
	        //Print the page title and heading
	        System.out.println("Page title is: " + pageTitle);
	        System.out.println("Login message is: " + confirmMessage);

	        //Assertion
	        Assert.assertEquals(confirmMessage, "Welcome Back, admin");
	    }
	    
	    @And("^Close the Browser")
	    public void closeBrowser1() {
	        //Close browser
	        driver.close();
	    }

	}
}
