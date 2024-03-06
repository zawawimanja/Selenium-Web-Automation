package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VelocityPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "flip18")
	private WebElement ExtendedVelocity;

	@FindBy(xpath = "//*[@id=\"editGeneralVelocity\"]")
	private WebElement EditButton;

	@FindBy(id = "deleteGeneralVelocity")
	private WebElement DeleteButton;

	@FindBy(id = "cancelGeneralVelocity")
	private WebElement CancelButton;

	@FindBy(id = "clearLimits")
	private WebElement ClearButton;

	@FindBy(id = "clearPrdLimits")
	private WebElement ClearPrdButton;

	@FindBy(xpath = "//*[@id=\"editGeneralVelocity\" and @value='Save' or @value=\"Cancel\"]")
	private WebElement SaveButton;

	@FindBy(xpath = "//*[@id=\"gen_pertrx_value_limit\"]/input")
	private WebElement InputTxnValue;

	@FindBy(xpath = "//*[@id=\"gen_pertrx_volume_limit\"]/input")
	private WebElement InputTxnVolume;

	@FindBy(xpath = "//*[@id=\"gen_lifetime_value_threshold\"]/input")
	private WebElement InputalertValue;

	@FindBy(xpath = "//*[@id=\"gen_lifetime_volume_threshold\"]/input")
	private WebElement InputalertVolume;

	@FindBy(xpath = "//*[@id=\"gen_daily_value_limit\"]/input")
	private WebElement InputDailyValueLimit;

	@FindBy(xpath = "//*[@id=\"gen_weekly_value_limit\"]/input")
	private WebElement InputWeeklyValueLimit;

	@FindBy(xpath = "//*[@id=\"gen_monthly_value_limit\"]/input")
	private WebElement InputMonthlyValueLimit;

	@FindBy(xpath = "//*[@id=\"gen_annual_value_limit\"]/input")
	private WebElement InputYearlyValueLimit;

	@FindBy(xpath = "//*[@id=\"gen_lifetime_value_limit\"]/input")
	private WebElement InputLifeTimeValueLimit;

	@FindBy(xpath = "//*[@id=\"gen_daily_volume_limit\"]/input")
	private WebElement InputDailyVolumeLimit;

	@FindBy(xpath = "//*[@id=\"gen_weekly_volume_limit\"]/input")
	private WebElement InputWeeklyVolumeLimit;

	@FindBy(xpath = "//*[@id=\"gen_monthly_volume_limit\"]/input")
	private WebElement InputMonthlyVolumeLimit;

	@FindBy(xpath = "//*[@id=\"gen_annual_volume_limit\"]/input")
	private WebElement InputYearlyVolumeLimit;

	@FindBy(xpath = "//*[@id=\"gen_lifetime_volume_limit\"]/input")
	private WebElement InputLifeTimeVolumeLimit;

	@FindBy(xpath = "//*[@id=\"gen_daily_count_limit\"]/input")
	private WebElement InputDailyTxnLimit;

	@FindBy(xpath = "//*[@id=\"gen_weekly_count_limit\"]/input")
	private WebElement InputWeeklyTxnLimit;

	@FindBy(xpath = "//*[@id=\"gen_monthly_count_limit\"]/input")
	private WebElement InputMonthlyTxnLimit;

	@FindBy(xpath = "//*[@id=\"gen_annual_count_limit\"]/input")
	private WebElement InputYearlyTxnLimit;

	@FindBy(xpath = "//*[@id=\"gen_lifetime_count_limit\"]/input")
	private WebElement InputLifeTimeTxnLimit;

	@FindBy(xpath = "//*[@id=\"prd_pertrx_value_limit\"]/input")
	private WebElement InputTxnValuePDV;

	@FindBy(xpath = "//*[@id=\"prd_daily_value_limit\"]/input")
	private WebElement InputDailyValueLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_weekly_value_limit\"]/input")
	private WebElement InputWeeklyValueLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_monthly_value_limit\"]/input")
	private WebElement InputMonthlyValueLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_annual_value_limit\"]/input")
	private WebElement InputYearlyValueLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_lifetime_value_limit\"]/input")
	private WebElement InputLifeTimeValueLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_daily_count_limit\"]/input")
	private WebElement InputDailyTxnLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_weekly_count_limit\"]/input")
	private WebElement InputWeeklyTxnLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_monthly_count_limit\"]/input")
	private WebElement InputMonthlyTxnLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_annual_count_limit\"]/input")
	private WebElement InputYearlyTxnLimitPDV;

	@FindBy(xpath = "//*[@id=\"prd_lifetime_count_limit\"]/input")
	private WebElement InputLifeTimeTxnLimitPDV;

	@FindBy(id = "velocity_product_reference")
	private WebElement selectReferenceProductBy;

	@FindBy(id = "text_velocity_card_expiry")
	private WebElement expiredDate;

	@FindBy(id = "VelocityExpiryDate")
	private WebElement submitExpDateBtn;

	public VelocityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void selectRefProduct(String name) {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(selectReferenceProductBy)));
		select.selectByVisibleText(name);
	}

	public void clickSubmit() {

		wait.until(ExpectedConditions.elementToBeClickable(submitExpDateBtn)).click();
	}

	public void setExpDate(String date) {

		wait.until(ExpectedConditions.visibilityOf(expiredDate)).sendKeys(date);
	}

	public void getExtendedVelocity() {

		wait.until(ExpectedConditions.visibilityOf(ExtendedVelocity));
	}

	public void clickEdit() {

		wait.until(ExpectedConditions.elementToBeClickable(EditButton)).click();
	}

	public void clickDelete() {

		wait.until(ExpectedConditions.elementToBeClickable(DeleteButton)).click();
	}

	public void setGeneralVelocity(String title, String name, String value) {
		switch (title) {
		case "txn":
			switch (name) {
			case "value":

				wait.until(ExpectedConditions.visibilityOf(InputTxnValue)).sendKeys(value);
				break;
			case "volume":

				wait.until(ExpectedConditions.visibilityOf(InputTxnVolume)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		case "alert":
			switch (name) {
			case "value":

				wait.until(ExpectedConditions.visibilityOf(InputalertValue)).sendKeys(value);
				break;
			case "volume":

				wait.until(ExpectedConditions.visibilityOf(InputalertVolume)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		case "value":
			switch (name) {
			case "daily":

				wait.until(ExpectedConditions.visibilityOf(InputDailyValueLimit)).sendKeys(value);
				break;
			case "weekly":

				wait.until(ExpectedConditions.visibilityOf(InputWeeklyValueLimit)).sendKeys(value);
				break;
			case "monthly":

				wait.until(ExpectedConditions.visibilityOf(InputMonthlyValueLimit)).sendKeys(value);
				break;
			case "yearly":

				wait.until(ExpectedConditions.visibilityOf(InputYearlyValueLimit)).sendKeys(value);
				break;
			case "lifetime":

				wait.until(ExpectedConditions.visibilityOf(InputLifeTimeValueLimit)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		case "volume":
			switch (name) {
			case "daily":

				wait.until(ExpectedConditions.visibilityOf(InputDailyVolumeLimit)).sendKeys(value);
				break;
			case "weekly":

				wait.until(ExpectedConditions.visibilityOf(InputWeeklyVolumeLimit)).sendKeys(value);
				break;
			case "monthly":

				wait.until(ExpectedConditions.visibilityOf(InputMonthlyVolumeLimit)).sendKeys(value);
				break;
			case "yearly":

				wait.until(ExpectedConditions.visibilityOf(InputYearlyVolumeLimit)).sendKeys(value);
				break;
			case "lifetime":

				wait.until(ExpectedConditions.visibilityOf(InputLifeTimeVolumeLimit)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		case "txnCount":
			switch (name) {
			case "daily":

				wait.until(ExpectedConditions.visibilityOf(InputDailyTxnLimit)).sendKeys(value);
				break;
			case "weekly":

				wait.until(ExpectedConditions.visibilityOf(InputWeeklyTxnLimit)).sendKeys(value);
				break;
			case "monthly":

				wait.until(ExpectedConditions.visibilityOf(InputMonthlyTxnLimit)).sendKeys(value);
				break;
			case "yearly":

				wait.until(ExpectedConditions.visibilityOf(InputYearlyTxnLimit)).sendKeys(value);
				break;
			case "lifetime":

				wait.until(ExpectedConditions.visibilityOf(InputLifeTimeTxnLimit)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}

	public void setPDV(String title, String name, String value) {
		switch (title) {
		case "txn":
			switch (name) {
			case "value":

				wait.until(ExpectedConditions.visibilityOf(InputTxnValuePDV)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		case "value":
			switch (name) {
			case "daily":

				wait.until(ExpectedConditions.visibilityOf(InputDailyValueLimitPDV)).sendKeys(value);
				break;
			case "weekly":

				wait.until(ExpectedConditions.visibilityOf(InputWeeklyValueLimitPDV)).sendKeys(value);
				break;
			case "monthly":

				wait.until(ExpectedConditions.visibilityOf(InputMonthlyValueLimitPDV)).sendKeys(value);
				break;
			case "yearly":

				wait.until(ExpectedConditions.visibilityOf(InputYearlyValueLimitPDV)).sendKeys(value);
				break;
			case "lifetime":

				wait.until(ExpectedConditions.visibilityOf(InputLifeTimeValueLimitPDV)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		case "txnCount":
			switch (name) {
			case "daily":

				wait.until(ExpectedConditions.visibilityOf(InputDailyTxnLimitPDV)).sendKeys(value);
				break;
			case "weekly":

				wait.until(ExpectedConditions.visibilityOf(InputWeeklyTxnLimitPDV)).sendKeys(value);
				break;
			case "monthly":

				wait.until(ExpectedConditions.visibilityOf(InputMonthlyTxnLimitPDV)).sendKeys(value);
				break;
			case "yearly":

				wait.until(ExpectedConditions.visibilityOf(InputYearlyTxnLimitPDV)).sendKeys(value);
				break;
			case "lifetime":

				wait.until(ExpectedConditions.visibilityOf(InputLifeTimeTxnLimitPDV)).sendKeys(value);
				break;
			default:
				break;
			}
			break;
		default:
			break;
		}
	}
}
