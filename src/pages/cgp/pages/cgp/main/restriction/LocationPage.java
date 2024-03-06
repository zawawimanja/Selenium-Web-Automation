package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LocationPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(css = "input#editLocationCurrent[value='Edit']")
	private WebElement currentEdit;

	@FindBy(css = "input#editLocationCurrent[value='Edit']")
	private WebElement CurrentEdit;

	@FindBy(css = "input#editLocationCurrent[value='Save']")
	private WebElement CurrentSave;

	@FindBy(id = "deleteLocationCurrent")
	private WebElement CurrentDelete;

	@FindBy(id = "cancelLocationCurrent")
	private WebElement CurrentCancel;

	@FindBy(id = "current_location_alert_decline")
	private WebElement CurrentAlertList;

	@FindBy(xpath = "//*[@id='dataTableCurrentLocRestriction']/tfoot/tr/td[1]/input[2]")
	private WebElement CurrentincludeCountry;

	@FindBy(xpath = "//*[@id='dataTableCurrentLocRestriction']/tfoot/tr/td[2]/input[1]")
	private WebElement CurrentexcludeNetwork;

	@FindBy(xpath = "//*[@id='dataTableCurrentLocRestriction']/tfoot/tr/td[2]/input[2]")
	private WebElement CurrentincludeNetwork;

	@FindBy(xpath = "//*[@id='dataTableCurrentLocRestriction']/tfoot/tr/td[3]/input[1]")
	private WebElement CurrentexcludeSite;

	@FindBy(xpath = "//*[@id='dataTableCurrentLocRestriction']/tfoot/tr/td[3]/input[2]")
	private WebElement CurrentincludeSite;

	@FindBy(id = "copy_from_current_location_restrict")
	private WebElement copyFromCurrent;

	@FindBy(css = "input#editLocationFuture[value='Edit']")
	private WebElement FutureEdit;

	@FindBy(css = "input#editLocationFuture[value='Save']")
	private WebElement FutureSave;

	@FindBy(id = "deleteLocationFuture")
	private WebElement FutureDelete;

	@FindBy(id = "cancelLocationFuture")
	private WebElement FutureCancel;

	@FindBy(id = "future_location_alert_decline")
	private WebElement FutureAlertList;

	@FindBy(id = "future_location_restrict_start_date")
	private WebElement FutureStartDate;

	@FindBy(id = "future_location_restrict_start_time")
	private WebElement FutureStartTIme;

	@FindBy(xpath = "//*[@id='dataTableFutureLocRestriction']/tfoot/tr/td[1]/input[1]")
	private WebElement FutureexcludeCountry;

	@FindBy(xpath = "//*[@id='dataTableFutureLocRestriction']/tfoot/tr/td[1]/input[2]")
	private WebElement FutureincludeCountry;

	@FindBy(xpath = "//*[@id='dataTableFutureLocRestriction']/tfoot/tr/td[2]/input[1]")
	private WebElement FutureexcludeNetwork;

	@FindBy(xpath = "//*[@id=\\\"dataTableCurrentLocRestriction\\\"]/tfoot/tr/td[1]/input[1]")
	private WebElement CurrentexcludeCountry;

	@FindBy(xpath = "//*[@id='dataTableFutureLocRestriction']/tfoot/tr/td[2]/input[2]")
	private WebElement FutureincludeNetwork;

	@FindBy(xpath = "//*[@id='dataTableFutureLocRestriction']/tfoot/tr/td[3]/input[1]")
	private WebElement FutureexcludeSite;

	@FindBy(xpath = "//*[@id='dataTableFutureLocRestriction']/tfoot/tr/td[3]/input[2]")
	private WebElement FutureincludeSite;

	@FindBy(id = "current_location_restrict_start_date")
	private WebElement currentLocationStartDate;

	// network selection
	String cssSelector = "[data-country='056']";

	public LocationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public WebElement getCurrentStartDate() {

		return wait.until(ExpectedConditions.visibilityOf(currentLocationStartDate));

	}

	public void clickFutureExcludeCountry() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureexcludeCountry)).click();
	}

	public void clickFutureIncludeCountry() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureincludeCountry)).click();
	}

	public void clickFutureExcludeNetwork() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureexcludeNetwork)).click();
	}

	public void clickFutureIncludeNetwork() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureincludeNetwork)).click();
	}

	public void clickFutureExcludeSite() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureexcludeSite)).click();
	}

	public void clickFutureIncludeSite() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureincludeSite)).click();
	}

	public void clickCurrentExcludeCountry() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentexcludeCountry)).click();
	}

	public void clickCurrentExcludeNetwork() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentexcludeNetwork)).click();
	}

	public void clickCurrentIncludeNetwork() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentincludeNetwork)).click();
	}

	public void clickCurrentExcludeSite() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentexcludeSite)).click();
	}

	public void clickCurrentIncludeSite() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentincludeSite)).click();
	}

	public void clickCurrentEdit() {

		wait.until(ExpectedConditions.elementToBeClickable(currentEdit)).click();
		;

	}

	public void clickCurrentIncludeCountry() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentincludeCountry)).click();
		;

	}

	public void clickCurrentSave() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentSave)).click();

	}

	public void clickCurrentCancel() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentCancel)).click();
	}

	public void clickCurrentDelete() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentDelete)).click();
	}

	public WebElement getCurrentDelete() {

		return wait.until(ExpectedConditions.visibilityOf(CurrentDelete));
	}

	public void clickCopyCurrent() {

		wait.until(ExpectedConditions.elementToBeClickable(copyFromCurrent)).click();
	}

	public void clickFutureEdit() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureEdit)).click();
	}

	public void clickFutureSave() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureSave)).click();
	}

	public void clickFutureCancel() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureCancel)).click();
	}

	public void clickFutureDelete() {

		wait.until(ExpectedConditions.elementToBeClickable(FutureDelete)).click();
	}

	public WebElement getFutureDelete() {

		return wait.until(ExpectedConditions.visibilityOf(FutureDelete));
	}

	public void selectAlertCurrent(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(CurrentAlertList)));
		select.selectByVisibleText(name);
	}

	public void selectAlertFuture(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(FutureAlertList)));
		select.selectByVisibleText(name);
	}

	public void setStartDateFuture(String name) {

		wait.until(ExpectedConditions.visibilityOf(FutureStartDate)).sendKeys(name);
	}

	public void setStartTimeFuture(String name) {

		wait.until(ExpectedConditions.visibilityOf(FutureStartTIme)).sendKeys(name);
	}
}
