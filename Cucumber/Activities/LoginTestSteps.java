package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestSteps {
	WebDriver driver;
	WebDriverWait wait;
	
	@Given("User is on Login page")
	public void user_login() {
		driver = new FirefoxDriver();
		 wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.get("https://training-support.net/webelements/login-form");
		
	}
	
	@When("User enters username and password")
	public void enters_credentials() {
		WebElement userName =driver.findElement(By.id("username"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement login = driver.findElement(By.cssSelector("button.svelte-1pdjkmx"));
		userName.sendKeys("admin");
		password.sendKeys("password");
		login.click();
		
	}
	
	@Then("Read the page title and confirmation message")
	public void confirmation_message() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h1.text-center")));
		System.out.println("The title of the page is: "+driver.getTitle()) ;
		WebElement confirmationMsg = driver.findElement(By.cssSelector("h1.text-center"));
		System.out.println("The confirmation message is: "+confirmationMsg.getText());	
		
	}
	
	@And("Close the Web Browser")
	public void close_web_browser() {
		driver.quit();
	}

}
