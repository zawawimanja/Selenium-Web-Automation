package pages.cgp.pages.cgp.main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "module_LocationRestrictions")
	private WebElement LocationRestrictionsTab;

	@FindBy(css = "a.back-to-main")
	private WebElement backToSearchLink;

	@FindBy(css = "a.back-to-blank")
	private WebElement backToMainLink;

	@FindBy(id = "module_SpecialMessages")
	private WebElement specialMessagesTab;

	@FindBy(id = "module_SiteGroups")
	private WebElement siteGroupsTab;

	@FindBy(id = "module_ReferenceData")
	private WebElement fleetIDValidationTab;

	@FindBy(id = "module_VolumeVelocity")
	private WebElement velocitiesTab;

	@FindBy(id = "module_DayTimeRestrictions")
	private WebElement dayTimeRestrictionsTab;

	@FindBy(id = "module_ProductRestrictions")
	private WebElement productRestrictionsTab;

	@FindBy(id = "module_ProductGroups")
	private WebElement productGroupsTab;

	@FindBy(id = "module_MobilePayment")
	private WebElement mobilePayTab;

	@FindBy(id = "module_OneCard")
	private WebElement oneOffTab;

	@FindBy(id = "module_TransactionSummary")
	private WebElement historyTab;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void checkVisible(WebElement element) {

		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickSpecialMessagesTab() {

		wait.until(ExpectedConditions.elementToBeClickable(specialMessagesTab)).click();

	}

	public void clickOneOffTab() {

		wait.until(ExpectedConditions.elementToBeClickable(oneOffTab)).click();

	}

	public void clickHistoryTab() {

		wait.until(ExpectedConditions.elementToBeClickable(historyTab)).click();

	}

	public void clickMobilePayTab() {

		wait.until(ExpectedConditions.elementToBeClickable(mobilePayTab)).click();

	}

	public void clickLocationRestrictionsTab() {

		wait.until(ExpectedConditions.elementToBeClickable(LocationRestrictionsTab)).click();

	}

	public void clickSiteGroupsTab() {

		wait.until(ExpectedConditions.elementToBeClickable(siteGroupsTab)).click();

	}

	public WebElement getSpecialMessagesTab() {

		return wait.until(ExpectedConditions.visibilityOf(specialMessagesTab));
	}

	public WebElement getFleetIDValidationTab() {

		return wait.until(ExpectedConditions.visibilityOf(fleetIDValidationTab));
	}

	public void clickFleetIDValidationTab() {

		wait.until(ExpectedConditions.elementToBeClickable(fleetIDValidationTab)).click();

	}

	public void clickVelocitiesTab() {

		wait.until(ExpectedConditions.elementToBeClickable(velocitiesTab)).click();

	}

	public void clickDayTimeRestrictionsTab() {

		wait.until(ExpectedConditions.elementToBeClickable(dayTimeRestrictionsTab)).click();

	}

	public void clickProductRestrictionsTab() {

		wait.until(ExpectedConditions.elementToBeClickable(productRestrictionsTab)).click();


	}

	public void clickProductGroupTab() {

		wait.until(ExpectedConditions.elementToBeClickable(productGroupsTab)).click();

	}

	public WebElement BackToSearchLink() {

		return wait.until(ExpectedConditions.visibilityOf(backToSearchLink));
	}

	public WebElement BackToMainLink() {

		return wait.until(ExpectedConditions.visibilityOf(backToMainLink));
	}
}
