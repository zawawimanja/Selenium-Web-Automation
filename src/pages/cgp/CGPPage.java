package pages.cgp;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CGPPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "module_Main")
	private WebElement main;

	@FindBy(id = "module_SystemSettings")
	private WebElement systemSettings;

	public CGPPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void clickMain() {

		wait.until(ExpectedConditions.elementToBeClickable(main)).click();

	}

	public void clickSystemSettings() {

		wait.until(ExpectedConditions.elementToBeClickable(systemSettings)).click();

	}
}
