package pages.cgp.systemsettings;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuditTrailPage {
	WebDriver driver;
	WebDriverWait wait;
	// text
	@FindBy(className = "header-title")
	private WebElement headerTitle;

	@FindBy(className = "header-sub")
	private WebElement headerSub;

	@FindBy(id = "btn_search_audit_trail")
	private WebElement SearchBtn;

	@FindBy(id = "btn_download_audit_trail")
	private WebElement DwnldBtn;

	@FindBy(id = "module_AuditTrail")
	private WebElement AuditTrailTxt;

	@FindBy(id = "audit_trail_PAN")
	private WebElement PanTxt;

	@FindBy(id = "audit_trail_account_number")
	private WebElement AccNoTxt;

	@FindBy(id = "audit_trail_type_of_restriction")
	private WebElement RestrictionTxt;

	@FindBy(id = "select_audit_trail")
	private WebElement CreatedByTxt;

	@FindBy(id = "select_OU")
	private WebElement OUTxt;

	@FindBy(id = "audit_trail_start_dateaudit_trail_PAN")
	private WebElement StartDateTxt;

	@FindBy(id = "audit_trail_end_date")
	private WebElement EndDateTxt;

	public AuditTrailPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void clickSearch() {

		wait.until(ExpectedConditions.elementToBeClickable(SearchBtn)).click();
	}

	public void clickDwnld() {

		wait.until(ExpectedConditions.elementToBeClickable(DwnldBtn)).click();
	}

	public void setPAN() {

		wait.until(ExpectedConditions.visibilityOf(PanTxt)).sendKeys();
	}

	public void setRestriction() {

		wait.until(ExpectedConditions.visibilityOf(RestrictionTxt)).sendKeys();
	}

	public WebElement getAuditTrail(String text) {
		switch (text) {
		case "headerTitle":

			return wait.until(ExpectedConditions.visibilityOf(headerTitle));
		case "headerSub":

			return wait.until(ExpectedConditions.visibilityOf(headerSub));
		default:
			return null;
		}
	}
}
