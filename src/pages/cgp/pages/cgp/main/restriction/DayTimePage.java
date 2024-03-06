package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DayTimePage {
	WebDriver driver;
	WebDriverWait wait;
	// button
	@FindBy(id = "current_daytime_restrict_start_date")
	private WebElement currentDaytimeStartDate;

	@FindBy(id = "copy_from_current_daytime_restrict")
	private WebElement copyFromCurrent;

	@FindBy(id = "deleteDayTimeCurrent")
	private WebElement CurrentDelete;

	@FindBy(css = "input#editDayTimeCurrent[value='Edit']")
	private WebElement CurrentEdit;

	@FindBy(css = "input#editDayTimeCurrent[value='Save']")
	private WebElement CurrentSave;

	@FindBy(id = "cancelDayTimeCurrent")
	private WebElement CurrentCancel;

	@FindBy(css = "input#editDayTimeFuture[value='Edit']")
	private WebElement FutureEdit;

	@FindBy(css = "input#editDayTimeFuture[value='Save']")
	private WebElement FutureSave;

	@FindBy(id = "deleteDayTimeFuture")
	private WebElement FutureDelete;

	@FindBy(id = "cancelDayTimeFuture")
	private WebElement FutureCancel;

	@FindBy(id = "flip16")
	private WebElement DayTime;

	@FindBy(id = "current_daytime_alert_decline")
	private WebElement CurrentAlertList;

	@FindBy(id = "current_daytime_all_days")
	private WebElement CurrentAllDays;

	@FindBy(id = "current_daytime_full_days")
	private WebElement CurrentFullDays;

	@FindBy(id = "current_daytime_TUE")
	private WebElement CurrentMon;

	@FindBy(id = "current_daytime_all_days")
	private WebElement CurrentTue;

	@FindBy(id = "current_daytime_WED")
	private WebElement CurrentWed;

	@FindBy(id = "current_daytime_THU")
	private WebElement CurrentThur;

	@FindBy(id = "current_daytime_FRI")
	private WebElement CurrentFri;

	@FindBy(id = "current_daytime_SAT")
	private WebElement CurrentSatur;

	@FindBy(id = "current_daytime_SUN")
	private WebElement CurrentSunday;

	@FindBy(id = "current_daytime_restrict_starttime")
	private WebElement currentFrom;

	@FindBy(id = "current_daytime_restrict_endtime")
	private WebElement currentTo;

	@FindBy(id = "future_daytime_alert_decline")
	private WebElement futureAlertList;

	@FindBy(id = "future_daytime_all_days")
	private WebElement futureAllDays;

	@FindBy(id = "future_daytime_full_days")
	private WebElement futureFullDays;

	@FindBy(id = "future_daytime_TUE")
	private WebElement futureMon;

	@FindBy(id = "future_daytime_all_days")
	private WebElement futureTue;

	@FindBy(id = "future_daytime_WED")
	private WebElement futureWed;

	@FindBy(id = "future_daytime_THU")
	private WebElement futureThur;

	@FindBy(id = "future_daytime_FRI")
	private WebElement futureFri;

	@FindBy(id = "future_daytime_SAT")
	private WebElement futureSatur;

	@FindBy(id = "future_daytime_SUN")
	private WebElement futureSunday;

	@FindBy(id = "future_daytime_restrict_starttime")
	private WebElement futureFrom;

	@FindBy(id = "future_daytime_restrict_endtime")
	private WebElement futureTo;

	@FindBy(id = "future_daytime_restrict_start_time")
	private WebElement futureStartTime;

	@FindBy(id = "future_daytime_restrict_start_date")
	private WebElement futureStartDate;

	public DayTimePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void clickCurrentEdit() {

		wait.until(ExpectedConditions.elementToBeClickable(CurrentEdit)).click();
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

	public void getDayTime() {

		wait.until(ExpectedConditions.elementToBeClickable(DayTime));
	}

	public WebElement getCurrentStartDate() {

		return wait.until(ExpectedConditions.visibilityOf(currentDaytimeStartDate));

	}

	public void selectAlertCurrent(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(CurrentAlertList)));
		select.selectByVisibleText(name);
	}

	public void selectAlertFuture(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(futureAlertList)));
		select.selectByVisibleText(name);
	}

	public void selectFromCurrent(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(currentFrom)));
		select.selectByVisibleText(name);
	}

	public void selectFromFuture(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(futureFrom)));
		select.selectByVisibleText(name);
	}

	public void selectToFuture(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(futureTo)));
		select.selectByVisibleText(name);
	}

	public void setStartDateFuture(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureStartDate)).sendKeys(name);
	}

	public void setStartDateFuture1() {

		wait.until(ExpectedConditions.elementToBeClickable(futureStartDate)).click();
	}

	public void setStartTimeFuture(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureStartTime)).sendKeys(name);
	}

	public void setDayCurrent(String name) {
		List<WebElement> checkboxes = driver.findElements(By.className("current_daytime_controls"));
		switch (name) {
		case "All Days":
			checkboxes.get(1).click();
			break;
		case "Full Days":
			checkboxes.get(9).click();
			break;
		case "Sunday":
			checkboxes.get(8).click();
			break;
		case "Monday":
			checkboxes.get(2).click();
			break;
		case "Tuesday":
			checkboxes.get(3).click();
			break;
		case "Wednesday":
			checkboxes.get(4).click();
			break;
		case "Thursday":
			checkboxes.get(5).click();
			break;
		case "Friday":
			checkboxes.get(6).click();
			break;
		case "Saturday":
			checkboxes.get(7).click();
			break;
		default:
			break;
		}
	}

	// get latest time and set calendar to choose today date
	public void setDayFuture(String name) {
		List<WebElement> checkboxes = driver.findElements(By.cssSelector(".future_days.future_daytime_controls"));
		switch (name) {
		case "All Days":
			checkboxes.get(1).click();
			break;
		case "Full Days":
			checkboxes.get(9).click();
			break;
		case "Sunday":
			checkboxes.get(8).click();
			break;
		case "Monday":
			checkboxes.get(2).click();
			break;
		case "Tuesday":
			checkboxes.get(3).click();
			break;
		case "Wednesday":
			checkboxes.get(4).click();
			break;
		case "Thursday":
			checkboxes.get(5).click();
			break;
		case "Friday":
			checkboxes.get(6).click();
			break;
		case "Saturday":
			checkboxes.get(7).click();
			break;
		default:
			break;
		}
	}
}
