package pages.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class Guru99HomePage {
	WebDriver driver;
	By homePageUserName = By.xpath("//table//tr[@class='heading3']");
	By Heading3 = By.className("heading3");
	By accept = By.xpath("//*[@id=\"save\"]/span[1]/div/span");
	public Guru99HomePage(WebDriver driver) {
		this.driver = driver;
	}
	// Get the User name from Home Page
	public String getHomePageDashboardUserName() {
		return driver.findElement(homePageUserName).getText();
	}
	public String getHomePageDashboardUserName1() {
		return driver.findElement(Heading3).getText();
	}
	public void clickAccept() {
		driver.findElement(accept).click();
	}
}