package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpecialMessagePage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "editSpecialMessagesCurrent")
	private WebElement editSpecialMessagesCurrentBtn;

	@FindBy(id = "cancelSpecialMessagesCurrent")
	private WebElement cancelSpecialMessagesCurrentBtn;

	@FindBy(id = "cancelSpecialMessagesFuture")
	private WebElement cancelSpecialMessagesFutureBtn;

	@FindBy(id = "deleteSpecialMessagesCurrent")
	private WebElement deleteSpecialMessagesCurrentBtn;

	@FindBy(id = "editSpecialMessagesFuture")
	private WebElement editSpecialMessagesFutureBtn;

	@FindBy(id = "deleteSpecialMessagesFuture")
	private WebElement deleteSpecialMessagesFutureBtn;

	@FindBy(id = "copy_from_current_special_messages")
	private WebElement copyFromActiveBtn;

	@FindBy(id = "currentSpecialMessagesEndDate")
	private WebElement currentSpecialMessagesEndDate;

	@FindBy(id = "futureSpecialMessagesEndDate")
	private WebElement futureSpecialMessagesEndDate;

	@FindBy(id = "currentSpecialMessagesText1")
	private WebElement currentSpecialMessagesText1;

	@FindBy(id = "futureSpecialMessagesText1")
	private WebElement futureSpecialMessagesText1;

	@FindBy(id = "tab_CustomerSettings")
	private WebElement tabCustomerSettings;

	@FindBy(id = "flip24")
	private WebElement MarketingMessage;

	public SpecialMessagePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public WebElement getMarketingMessage() {

		return wait.until(ExpectedConditions.visibilityOf(MarketingMessage));
	}

	public WebElement getTabCustomerSettings() {

		return wait.until(ExpectedConditions.visibilityOf(tabCustomerSettings));
	}

	public void clickEditSpecialMessagesCurrent() {

		wait.until(ExpectedConditions.elementToBeClickable(editSpecialMessagesCurrentBtn)).click();
	}

	public void clickcancelSpecialMessagesCurrent() {

		wait.until(ExpectedConditions.elementToBeClickable(cancelSpecialMessagesCurrentBtn)).click();
	}

	public void clickEditSpecialMessagesFutureBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(editSpecialMessagesFutureBtn)).click();
	}

	public void clickdeleteSpecialMessagesFuture() {

		wait.until(ExpectedConditions.elementToBeClickable(deleteSpecialMessagesFutureBtn)).click();
	}

	public void clickdeleteSpecialMessagesCurrent() {

		wait.until(ExpectedConditions.elementToBeClickable(deleteSpecialMessagesCurrentBtn)).click();
	}

	public void clickcopyFromActive() {

		wait.until(ExpectedConditions.elementToBeClickable(copyFromActiveBtn)).click();
	}

	public void setEndDateCurrent(String date) {

		wait.until(ExpectedConditions.visibilityOf(currentSpecialMessagesEndDate)).sendKeys(date);
	}

	public void setEndDateFuture(String date) {

		wait.until(ExpectedConditions.visibilityOf(futureSpecialMessagesEndDate)).sendKeys(date);

	}

	public void setMessageCurrent(String message) {

		wait.until(ExpectedConditions.visibilityOf(currentSpecialMessagesText1)).clear();
		wait.until(ExpectedConditions.visibilityOf(currentSpecialMessagesText1)).sendKeys(message);
	}

	public void setMessageFuture(String message) {

		wait.until(ExpectedConditions.visibilityOf(futureSpecialMessagesText1)).clear();
		wait.until(ExpectedConditions.visibilityOf(futureSpecialMessagesText1)).sendKeys(message);
	}

	public void clickcancelSpecialMessagesFutureBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(cancelSpecialMessagesFutureBtn)).click();
	}
}
