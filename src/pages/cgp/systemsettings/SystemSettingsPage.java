package pages.cgp.systemsettings;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemSettingsPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "module_CVPSettings")
	private WebElement CVPSettings;

	@FindBy(id = "module_SelectionList")
	private WebElement SelectionList;

	@FindBy(id = "module_AuditTrail")
	private WebElement AuditTrail;

	public SystemSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void clickCVPSettings() {
		wait.until(ExpectedConditions.elementToBeClickable(CVPSettings)).click();

	}

	public void clickSelectionList() {
		wait.until(ExpectedConditions.elementToBeClickable(SelectionList)).click();

	}

	public void clickAuditTrail() {
		wait.until(ExpectedConditions.elementToBeClickable(AuditTrail)).click();

	}
}
