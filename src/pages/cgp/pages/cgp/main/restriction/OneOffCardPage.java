package pages.cgp.pages.cgp.main.restriction;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class OneOffCardPage {
	WebDriver driver;
	WebDriverWait wait;
    @FindBy(id = "searchOneCard")
    private WebElement searchOneCardBtn;

    @FindBy(id = "generateOneCard")
    private WebElement generateOneCardBtn;

    @FindBy(id = "txtGenOneCardExpDate")
    private WebElement genOneCardExpDateInput;

    @FindBy(id = "registerOneCardValidity")
    private WebElement registerOneCardValidityInput;

    @FindBy(className = "cancelPAN")
    private WebElement cancelPanBtn;

    @FindBy(id = "onecard-generate-result")
    private WebElement onecardGenerateResult;

    @FindBy(id = "onecard-manage-result")
    private WebElement onecardManageResult;

	public OneOffCardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public WebElement getOneCardManageResult() {

		return wait.until(ExpectedConditions.visibilityOf(onecardGenerateResult));
	}
	public WebElement getOneCardGenerateResult() {

		return wait.until(ExpectedConditions.visibilityOf(onecardGenerateResult));
	}
	public void clicksearchOneCard() {

		wait.until(ExpectedConditions.elementToBeClickable(searchOneCardBtn)).click();
	}
	public void clickCancel() {

		wait.until(ExpectedConditions.elementToBeClickable(cancelPanBtn)).click();
	}
	public void clickgenerateOneCardBtn() {

		wait.until(ExpectedConditions.elementToBeClickable(generateOneCardBtn)).click();

	}
	public void setgenOneCardExpDate(String name) {

		wait.until(ExpectedConditions.visibilityOf(genOneCardExpDateInput)).sendKeys(name);
	}
	public void setregisterOneCardValidity(String name) {

		wait.until(ExpectedConditions.visibilityOf(registerOneCardValidityInput)).sendKeys(name);
	}
}
