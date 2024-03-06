package pages.cgp.pages.cgp.main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "btnCustomer")
	private WebElement customerBtn;

	@FindBy(xpath = "//a[normalize-space()='00000005']")
	private WebElement AccountLink;

	@FindBy(id = "customerStatus")
	private WebElement customerStatus;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		PageFactory.initElements(driver, this);
	}

	public WebElement getCustomerStatus() {
		wait.until(ExpectedConditions.visibilityOf(customerStatus));
		return customerStatus;
	}

	public WebElement getAccountLink() {

		wait.until(ExpectedConditions.elementToBeClickable(AccountLink));
		return AccountLink;

	}

	public void clickBlockUnBlockAccount() {

		wait.until(ExpectedConditions.elementToBeClickable(customerBtn));
		customerBtn.click();
	}

	public void clickAccountNumber() {

		wait.until(ExpectedConditions.elementToBeClickable(AccountLink));
		AccountLink.click();
	}
}
