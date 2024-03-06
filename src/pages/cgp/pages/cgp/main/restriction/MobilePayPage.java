package pages.cgp.pages.cgp.main.restriction;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class MobilePayPage {
	WebDriver driver;
	WebDriverWait wait;
	// radiobutton
	 @FindBy(id = "referenceID")
	    private WebElement referenceID;

	    @FindBy(id = "cardNumber")
	    private WebElement cardNumber;

	    @FindBy(id = "searchMobileQuery")
	    private WebElement searchMobileQueryBtn;

	    @FindBy(id = "registerMobile")
	    private WebElement registerMobileBtn;

	    @FindBy(className = "cancelPAN")
	    private WebElement cancelPanBtn;

	    @FindBy(className = "pageNumber")
	    private WebElement pageNumber;

	    @FindBy(id = "error_mobile-register-result")
	    private WebElement error;

	    @FindBy(id = "txtReferenceID")
	    private WebElement referenceIDInput;

	    @FindBy(id = "txtMobileCardNumber")
	    private WebElement mobileCardNumberInput;

	    @FindBy(id = "txtMobileCardExpiry")
	    private WebElement mobileCardExpiryInput;

	    @FindBy(id = "registerReferenceID")
	    private WebElement registerReferenceIDInput;

	    @FindBy(id = "registerExpiryDate")
	    private WebElement registerExpiryDateInput;

	    @FindBy(id = "registerValidity")
	    private WebElement registerValidityInput;

	    @FindBy(id = "mobile-register-result")
	    private WebElement mobileRegisterResult;

	    @FindBy(id = "mobile-query-result")
	    private WebElement mobileQueryResult;

	    @FindBy(id = "registerTokenRequestorId")
	    private WebElement registerTokenRequestorId;

	    @FindBy(id = "referenceID")
	    private WebElement refID;



	public MobilePayPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}
	public WebElement getMobileQueryResult() {
		return wait.until(ExpectedConditions.visibilityOf(mobileQueryResult));

	}
	public void selectTokenRequestorID(String name) {


		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(registerTokenRequestorId)));
		// Get the selected option based on visible text

		dropdown.selectByVisibleText(name);

		//	dropdown.selectByValue("70659990003");
		 // Get the selected option based on visible text
       WebElement selectedOption = dropdown.getFirstSelectedOption();

        // Get the value attribute of the selected option
        String selectedValue = selectedOption.getAttribute("value");

        // Print the selected value (you can do other actions with it as needed)
        System.out.println("Selected Value: " + selectedValue);
       // dropdown.selectByVisibleText(name);


	}


//
//	public void selectTokenRequestorID(String name) {
//		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(registerTokenRequestorId)));
//		dropdown.selectByVisibleText(name);
//	}


	public WebElement getMobileRegisterResult() {
		return wait.until(ExpectedConditions.visibilityOf(mobileRegisterResult));

	}
	public void setreferenceID(String name) {


		wait.until(ExpectedConditions.visibilityOf(referenceIDInput)).clear();
		referenceIDInput.sendKeys(name);
	}
	public WebElement selectreferenceID() {
		return wait.until(ExpectedConditions.visibilityOf(referenceID));

	}
	public WebElement selectcardnumber() {
		return wait.until(ExpectedConditions.visibilityOf(cardNumber));

	}
	public WebElement getErrorText() {
		return wait.until(ExpectedConditions.visibilityOf(error));

	}
	public void setCardNumber() {

		wait.until(ExpectedConditions.visibilityOf(mobileCardNumberInput)).sendKeys();
	}
	public void setCardExpiry(String name) {

		wait.until(ExpectedConditions.visibilityOf(mobileCardExpiryInput)).sendKeys(name);
	}
	public void setRegisterReferenceID(String name) {

		wait.until(ExpectedConditions.visibilityOf(registerReferenceIDInput)).sendKeys(name);
	}
	public void setRegisterCardExpiry(String name) {

		wait.until(ExpectedConditions.visibilityOf(registerExpiryDateInput)).sendKeys(name);
	}
	public void setValidty(String name) {

		wait.until(ExpectedConditions.visibilityOf(registerValidityInput)).sendKeys(name);
	}
	public void clicksearchStatus() {

		wait.until(ExpectedConditions.elementToBeClickable(searchMobileQueryBtn)).click();
	}
	public void clickCancel() {

		wait.until(ExpectedConditions.elementToBeClickable(cancelPanBtn)).click();
	}
	public void clickPageNumber() {

		wait.until(ExpectedConditions.elementToBeClickable(pageNumber)).click();
	}
	public WebElement getCancel() {

		 return	wait.until(ExpectedConditions.elementToBeClickable(cancelPanBtn));
	}
	public void clickregisterMobile() {

		wait.until(ExpectedConditions.elementToBeClickable(registerMobileBtn)).click();
	}
	public void chooseRefID() {

		wait.until(ExpectedConditions.elementToBeClickable(refID)).click();
	}
	public void chooseCardNumber() {

		wait.until(ExpectedConditions.elementToBeClickable(cardNumber)).click();
	}
}
