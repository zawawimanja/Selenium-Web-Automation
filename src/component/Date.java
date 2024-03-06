package component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Date {
	By EndDate = By.id("currentSpecialMessagesEndDate");

	WebDriver driver = new ChromeDriver();
	public Date(WebDriver driver) {
		this.driver=driver;
	}

	public void setEndDate() {
		driver.findElement(EndDate).click();;

	}
}
