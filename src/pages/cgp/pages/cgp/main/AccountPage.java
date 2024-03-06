package pages.cgp.pages.cgp.main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
	private WebDriver driver;
	private WebDriverWait wait;

	@FindBy(id = "txtAccountCardSearch")
	private WebElement searchInput;

	@FindBy(id = "btnBlockAccount")
	private WebElement blockUnBlockAccountBtn;

	@FindBy(id = "btnAccountSearch")
	private WebElement accountSearchBtn;

	@FindBy(id = "btnUpdateAlertAccount")
	private WebElement saveBtn;

	@FindBy(id = "btnNewCardBundle")
	private WebElement newCardBundleBtn;

	@FindBy(id = "btnEditCardBundle")
	private WebElement editCardBundleBtn;

	@FindBy(id = "btnDeleteCardBundle")
	private WebElement deleteCardBundleBtn;

	@FindBy(id = "btnAddCardNumber")
	private WebElement addCardNumberBtn;

	@FindBy(id = "btnRemoveCardNumber")
	private WebElement removeCardNumberBtn;

	@FindBy(id = "txtCardBundleDescription")
	private WebElement cardBundleDescriptionInput;

	@FindBy(id = "txtExtID")
	private WebElement extIDInput;

	@FindBy(id = "accountCardsNextNo")
	private WebElement accountCardsNextNo;

	@FindBy(id = "accountCardsPrevNo")
	private WebElement accountCardsPrevNo;

	@FindBy(id = "flip00")
	private WebElement accountSettingsTitle;

	@FindBy(id = "accountStatus")
	private WebElement accountStatus;

	@FindBy(xpath = "//select[@id='selectSystemAlertAccount']")
	private WebElement selectedDropDown;

	@FindBy(id = "selectSystemAlertAccount")
	private WebElement selectedDropDownSystemAlertAccount;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public WebElement getAccountStatus() {
		return wait.until(ExpectedConditions.visibilityOf(accountStatus));
	}

	public void checkVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void selectSystemAlertAccount(String name) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(selectedDropDownSystemAlertAccount)));
		dropdown.selectByVisibleText(name);
	}

	public WebElement getAccount() {
		return wait.until(ExpectedConditions.visibilityOf(accountSettingsTitle));
	}

	public WebElement getSelectedDropDown() {
		return wait.until(ExpectedConditions.visibilityOf(selectedDropDown));
	}

	public void clickBlockUnBlockAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(blockUnBlockAccountBtn)).click();
	}

	public void setSearchInput(String search) {
		wait.until(ExpectedConditions.visibilityOf(searchInput)).sendKeys(search);
	}

	public void setCardDesc(String search) {
		wait.until(ExpectedConditions.visibilityOf(cardBundleDescriptionInput)).sendKeys(search);
	}

	public void setExtID(String search) {
		wait.until(ExpectedConditions.visibilityOf(extIDInput)).sendKeys(search);
	}

	public void clickNext() {
		wait.until(ExpectedConditions.elementToBeClickable(accountCardsNextNo)).click();
	}

	public void clickPrevious() {
		wait.until(ExpectedConditions.elementToBeClickable(accountCardsPrevNo)).click();
	}

	public void clickSaveBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
	}

	public void clickBlockAccount() {
		wait.until(ExpectedConditions.elementToBeClickable(blockUnBlockAccountBtn)).click();
	}

	public void clickAccountSearch() {
		wait.until(ExpectedConditions.elementToBeClickable(accountSearchBtn)).click();
	}

	public void selectEnabled(String name) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(selectedDropDown)));
		dropdown.selectByVisibleText(name);
	}

	public void clicknewCardBundle() {
		wait.until(ExpectedConditions.elementToBeClickable(newCardBundleBtn)).click();
	}

	public void clickEditCardBundle() {
		wait.until(ExpectedConditions.elementToBeClickable(editCardBundleBtn)).click();
	}

	public void clickDeleteCardBundle() {
		wait.until(ExpectedConditions.elementToBeClickable(deleteCardBundleBtn)).click();
	}

	public void clickAddCardNumber() {
		wait.until(ExpectedConditions.elementToBeClickable(addCardNumberBtn)).click();
	}

	public void clickRemoveCardNumber() {
		wait.until(ExpectedConditions.elementToBeClickable(removeCardNumberBtn)).click();
	}

}
