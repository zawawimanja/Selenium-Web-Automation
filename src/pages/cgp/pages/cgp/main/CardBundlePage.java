package pages.cgp.pages.cgp.main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CardBundlePage {


	 private WebDriver driver;
	 WebDriverWait wait;

	    @FindBy(id = "btnNewCardBundle")
	    private WebElement newBtn;

	    @FindBy(id = "btnEditCardBundle")
	    private WebElement editBtn;

	    @FindBy(id = "btnCancelCardBundle")
	    private WebElement cancelBtn;

	    @FindBy(id = "btnSaveCardBundle")
	    private WebElement saveBtn;

	    @FindBy(id = "btnDeleteCardBundle")
	    private WebElement deleteBtn;

	    @FindBy(id = "btnAddCardNumber")
	    private WebElement addBtn;

	    @FindBy(id = "btnRemoveCardNumber")
	    private WebElement removeBtn;

	    @FindBy(id = "txtCardBundleDescription")
	    private WebElement cardBundleDescriptionInput;

	    @FindBy(id = "txtExtID")
	    private WebElement extIDInput;

	    @FindBy(id = "txtCardNumberID")
	    private WebElement cardNumberInput;

	    @FindBy(xpath = "//*[@id='card-bundle-result']/tbody/tr[1]/td[1]")
	    private WebElement selectCardBundle;

	    @FindBy(xpath = "//*[@id='card-list']/tbody")
	    private WebElement selectCardNumber;




	    public CardBundlePage(WebDriver driver) {
	    	this.driver = driver;
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	    }

	    public void setCardDesc(String name) {
	        wait.until(ExpectedConditions.visibilityOf(cardBundleDescriptionInput)).sendKeys(name);
	    }

	    public WebElement getCardDesc() {
	        return wait.until(ExpectedConditions.visibilityOf(cardBundleDescriptionInput));
	    }

	    public void setClearCardDesc() {
	        wait.until(ExpectedConditions.visibilityOf(cardBundleDescriptionInput)).clear();
	    }



	    public void selectCardBundle() {
	        wait.until(ExpectedConditions.elementToBeClickable(selectCardBundle)).click();
	    }

	    public void selectCardNumber() {
	        wait.until(ExpectedConditions.elementToBeClickable(selectCardNumber)).click();
	    }

	    public void setExtID(String name) {
	        wait.until(ExpectedConditions.visibilityOf(extIDInput)).sendKeys(name);
	    }

	    public void setCardNumber(String name) {
	        wait.until(ExpectedConditions.visibilityOf(cardNumberInput)).sendKeys(name);
	    }

	    public void clickEdit() {
	        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
	    }

	    public void clickRemove() {
	        wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
	    }

	    public void clickNew() {
	        wait.until(ExpectedConditions.elementToBeClickable(newBtn)).click();
	    }

	    public void clickCancel() {
	        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
	    }

	    public void clickSave() {
	        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
	    }

	    public void clickAdd() {
	        wait.until(ExpectedConditions.elementToBeClickable(addBtn)).click();
	    }

	    public void clickDelete() {
	        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
	    }
}
