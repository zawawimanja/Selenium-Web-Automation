package pages.cgp.pages.cgp.main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "main_search_issuer")
	private WebElement mainSearchIssuer;

	@FindBy(id = "main_search_issuer_customer")
	private WebElement mainSearchIssuerCustomer;

	@FindBy(id = "main_search_issuer_account")
	private WebElement mainSearchIssuerAccount;

	@FindBy(id = "main_search_issuer_cardBundle")
	private WebElement mainSearchIssuerCardBundle;

	@FindBy(id = "main_search_issuer_card_ID")
	private WebElement mainSearchIssuerCardID;

	@FindBy(id = "CustomerSearch")
	private WebElement RetrieveCustomerBtn;
	@FindBy(id = "main_search_customerId")
	private WebElement CustomerIDInput;

	@FindBy(id = "main_search_account")
	private WebElement AccountInput;

	@FindBy(id = "AccountSearch")
	private WebElement RetrieveAccountBtn;
	@FindBy(id = "flip5A")
	private WebElement retrieveCountryBy;

	@FindBy(id = "IssuerSearch")
	private WebElement retrieveIssuerBtn;

	@FindBy(id = "CardBundleSearch")
	private WebElement retrieveCardBundleBtn;

	@FindBy(id = "CardSearch")
	private WebElement retrieveCardSearchBtn;

	@FindBy(id = "CardIDSearch")
	private WebElement retrieveCardIDSearchBtn;

	@FindBy(id = "TransactionSearch")
	private WebElement retrieveTransactionBtn;

	@FindBy(id = "main_search_issuer")
	private WebElement retrieveIssuerDropDown;

	// input

	@FindBy(id = "main_search_account_cardBundle")
	private WebElement accountCardBundleInput;

	@FindBy(id = "main_search_cardBundleId")
	private WebElement cardBundleInput;

	@FindBy(id = "main_search_card")
	private WebElement cardInput;

	@FindBy(id = "main_search_card_ID")
	private WebElement cardIDInput;

	@FindBy(id = "textTrxnSearchFirst6Bin")
	private WebElement cardNumberFirst6Input;

	@FindBy(id = "textTrxnSearchLast4")
	private WebElement cardNumberLast4Input;

	@FindBy(id = "textTrxnSearchExpiryDate")
	private WebElement cardNumberExpiryDate;

	@FindBy(id = "textTrxnSearchAuthCode")
	private WebElement cardNumberAuthCode;

	@FindBy(id = "textTrxnSearchLocalDate")
	private WebElement cardNumberLocalDate;

	@FindBy(id = "textTrxnSearchLocalTime")
	private WebElement cardNumberLocalTime;

	@FindBy(id = "textTrxnSearchUniqTransID")
	private WebElement cardNumberUniqTransID;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	}

	public void setCardBundle(String account, String cardBundleID) {

		wait.until(ExpectedConditions.visibilityOf(accountCardBundleInput)).sendKeys(account);
		wait.until(ExpectedConditions.visibilityOf(cardBundleInput)).sendKeys(cardBundleID);
	}

	public void setCardPAN(String account) {

		wait.until(ExpectedConditions.visibilityOf(cardInput)).sendKeys(account);
	}

	public void setCardID(String account) {
		wait.until(ExpectedConditions.visibilityOf(cardInput)).sendKeys(account);
	}

	public WebElement getCountry() {

		return wait.until(ExpectedConditions.visibilityOf(retrieveCountryBy));
	}

	public void selectCountry(String name) {

		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(mainSearchIssuer)));
		dropdown.selectByVisibleText(name);
	}

	public void selectCustomer(String name) {

		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(mainSearchIssuerCustomer)));
		dropdown.selectByVisibleText(name);
	}

	public void selectAccount(String name) {

		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(mainSearchIssuerAccount)));
		dropdown.selectByVisibleText(name);
	}

	public void selectCardBundle(String name) {

		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(mainSearchIssuerCardBundle)));
		dropdown.selectByVisibleText(name);
	}

	public void selectCard(String name) {

		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(mainSearchIssuerCardID)));
		dropdown.selectByVisibleText(name);
	}

	public void setTransaction(String account, String account1, String account2, String account3, String account4,
			String account5, String account6) {

		wait.until(ExpectedConditions.visibilityOf(cardNumberFirst6Input)).sendKeys(account);
		wait.until(ExpectedConditions.visibilityOf(cardNumberLast4Input)).sendKeys(account1);
		wait.until(ExpectedConditions.visibilityOf(cardNumberExpiryDate)).sendKeys(account2);
		wait.until(ExpectedConditions.visibilityOf(cardNumberAuthCode)).sendKeys(account3);
		wait.until(ExpectedConditions.visibilityOf(cardNumberLocalDate)).sendKeys(account4);
		wait.until(ExpectedConditions.visibilityOf(cardNumberLocalTime)).sendKeys(account5);
		wait.until(ExpectedConditions.visibilityOf(cardNumberUniqTransID)).sendKeys(account6);
	}

	public void setTransactionID(String name) {

		wait.until(ExpectedConditions.visibilityOf(cardNumberUniqTransID)).sendKeys(name);
	}

	public void setCustomerID(String user) {

		wait.until(ExpectedConditions.visibilityOf(CustomerIDInput)).sendKeys(user);

	}

	public void setAccount(String user) {

		wait.until(ExpectedConditions.visibilityOf(AccountInput)).sendKeys(user);

	}

	public void clickRetrieveIssuer() {
		wait.until(ExpectedConditions.elementToBeClickable(retrieveIssuerBtn)).click();

	}

	public void clickRetrieveCustomer() {

		wait.until(ExpectedConditions.elementToBeClickable(RetrieveCustomerBtn)).click();

	}

	public void clickRetrieverAccount() {

		wait.until(ExpectedConditions.elementToBeClickable(RetrieveAccountBtn)).click();

	}

	public void clickRetrieveCardBundle() {

		wait.until(ExpectedConditions.elementToBeClickable(retrieveCardBundleBtn)).click();

	}

	public void clickRetrieveCardSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(retrieveCardSearchBtn)).click();

	}

	public void clickRetrieveCardIDSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(retrieveCardIDSearchBtn)).click();

	}

	public void clickRetrieveTransaction() {
		wait.until(ExpectedConditions.elementToBeClickable(retrieveTransactionBtn)).click();

	}

	public String getclickRetrieve() {

		return wait.until(ExpectedConditions.visibilityOf(retrieveIssuerBtn)).getText();
	}
}
