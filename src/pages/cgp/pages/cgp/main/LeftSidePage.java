package pages.cgp.pages.cgp.main;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftSidePage {
	WebDriver driver;
	WebDriverWait wait;
	// button
	@FindBy(className = "main_issuer")
	private WebElement issuerDesc;

	@FindBy(className = "main_customerID")
	private WebElement customerIDDesc;

	@FindBy(id = "AccNumberTitle")
	private WebElement accNumberTitle;

	@FindBy(id = "AccNumber")
	private WebElement accNumber;

	@FindBy(id = "CardBundleTitle")
	private WebElement cardBundleTitle;

	@FindBy(id = "CardBundle")
	private WebElement cardBundleDesc;

	@FindBy(id = "CardNumberTitle")
	private WebElement cardNumberTitle;

	@FindBy(id = "CardNumber")
	private WebElement cardNumberDesc;

	@FindBy(id = "CardIdentifierTitle")
	private WebElement cardIdentifierTitle;

	@FindBy(id = "CardIdentifier")
	private WebElement cardIdentifierDesc;

	@FindBy(id = "daytime_restriction_card_copy_text")
	private WebElement daytimeRestrictionCardCopy;

	@FindBy(id = "product_restriction_card_copy_text")
	private WebElement productRestrictionCardCopy;

	@FindBy(id = "location_restriction_card_copy_text")
	private WebElement locationRestrictionCardCopy;

	@FindBy(id = "CardIdentifierTitle")
	private WebElement copyFromTitle;

	@FindBy(id = "daytime_restriction_card_copy_text")
	private WebElement copyFromInput;

	@FindBy(id = "velocity_card_copy")
	private WebElement copyButton;

	@FindBy(id = "daytime_restriction_card_copy")
	private WebElement copyButtonDayTime;

	@FindBy(id = "product_restriction_card_copy")
	private WebElement copyButtonProduct;

	@FindBy(id = "location_restriction_card_copy")
	private WebElement copyButtonLocation;

	By backToSearchLink = By.cssSelector("a.back-to-main");
	By backToMainLink = By.cssSelector("a.back-to-blank");

	public LeftSidePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public WebElement BackToSearchLink() {

		List<WebElement> links = driver.findElements(backToSearchLink);

		return links.get(0);
	}

	public WebElement BackToMainLink() {
		List<WebElement> links = driver.findElements(backToMainLink);

		return links.get(7);
	}

	public WebElement getIssuer(String name) {

		switch (name) {
		case "title": {
			return wait.until(ExpectedConditions.visibilityOf(accNumberTitle));
		}
		case "desc": {
			return wait.until(ExpectedConditions.visibilityOf(issuerDesc));
		}
		default:
			return null;
		}
	}

	public WebElement getCustomerID(String name) {

		switch (name) {
		case "title": {
			return wait.until(ExpectedConditions.visibilityOf(accNumberTitle));
		}
		case "desc": {
			return wait.until(ExpectedConditions.visibilityOf(customerIDDesc));
		}
		default:
			return null;
		}
	}

	public WebElement getAccNumber(String name) {

		switch (name) {
		case "title": {
			return wait.until(ExpectedConditions.visibilityOf(accNumberTitle));
		}
		case "desc": {
			return wait.until(ExpectedConditions.visibilityOf(accNumber));
		}
		default:
			return null;
		}
	}

	public WebElement getCardBundle(String name) {

		switch (name) {
		case "title": {
			return wait.until(ExpectedConditions.visibilityOf(cardBundleTitle));
		}
		case "desc": {
			return wait.until(ExpectedConditions.visibilityOf(cardBundleDesc));
		}
		default:
			return null;
		}
	}

	public WebElement getCardNumber(String name) {

		switch (name) {
		case "title": {
			return wait.until(ExpectedConditions.visibilityOf(cardNumberTitle));
		}
		case "desc": {
			return wait.until(ExpectedConditions.visibilityOf(cardNumberDesc));
		}
		default:
			return null;
		}
	}

	public WebElement getCardIdentifier(String name) {

		switch (name) {
		case "title": {
			return wait.until(ExpectedConditions.visibilityOf(cardIdentifierTitle));
		}
		case "desc": {
			return wait.until(ExpectedConditions.visibilityOf(cardIdentifierDesc));
		}
		default:
			return null;
		}
	}

	public WebElement getCopyFrom(String name) {

		switch (name) {
		case "title": {
			return wait.until(ExpectedConditions.visibilityOf(cardIdentifierTitle));
		}

		default:
			return null;
		}
	}

	public void clickCopy(String name) {
		switch (name) {
		case "velocity": {

			wait.until(ExpectedConditions.elementToBeClickable(copyButton)).click();
			break;
		}
		case "Product": {

			wait.until(ExpectedConditions.elementToBeClickable(copyButtonProduct)).click();
			break;
		}
		case "DayTime": {

			wait.until(ExpectedConditions.elementToBeClickable(copyButtonDayTime)).click();
			break;
		}

		case "Location": {

			wait.until(ExpectedConditions.elementToBeClickable(copyButtonLocation)).click();
			break;
		}
		default:
		}
	}
}
