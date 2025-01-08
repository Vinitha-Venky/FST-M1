import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity20 {
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new FirefoxDriver();       
        driver.get("https://training-support.net/webelements/alerts");        
        System.out.println("Page title: " + driver.getTitle());

        driver.findElement(By.id("prompt")).click();

        
        Alert promptAlert = driver.switchTo().alert();
        String alertText = promptAlert.getText();
        System.out.println("Text in alert: " + alertText);
        promptAlert.sendKeys("Vinitha prompted this");
        Thread.sleep(500);
       
       promptAlert.accept();
        //promptAlert.dismiss();
        
        System.out.println(driver.findElement(By.id("result")).getText());
        driver.quit();
    }
}