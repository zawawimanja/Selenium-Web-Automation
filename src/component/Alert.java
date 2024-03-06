package component;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Alert {
	 private WebDriver driver;
	    private WebDriverWait wait;

	    public Alert(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	    }

	    public String accept() {
	        String message = "";

	        try {
	            wait.until(ExpectedConditions.alertIsPresent());
	            org.openqa.selenium.Alert alert = driver.switchTo().alert();
	            message = alert.getText();
	            alert.accept();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return message;
	    }

	    public void waitForAlert() {
	        try {
	            wait.until(ExpectedConditions.alertIsPresent());
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
