package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FleetIDPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "flip7")
	private WebElement accountFleetIDList;
	@FindBy(id = "addNewFleedIDRecord")
	private WebElement addNewRecord;
	@FindBy(id = "exportFleedIDRecord")
	private WebElement export;
	@FindBy(className = "addEditRow")
	private WebElement edit;
	@FindBy(className = "cancelDeleteRow")
	private WebElement delete;
	@FindBy(xpath = "//*[@id='reference-data-result']/tbody/tr[1]/td[2]/input")
	private WebElement idInput;
	@FindBy(xpath = "//*[@id='reference-data-result']/tbody/tr[1]/td[3]/input")
	private WebElement descriptionInput;
	@FindBy(xpath = "//*[@id='reference-data-result']/tbody/tr[1]/td[4]/input")
	private WebElement startDateInput;
	@FindBy(xpath = "//*[@id='reference-data-result']/tbody/tr[1]/td[5]/input")
	private WebElement endDateInput;
	@FindBy(id = "reference_card_copy_text")
	private WebElement copyInput;
	@FindBy(id = "reference_card_copy")
	private WebElement copyBtn;
	@FindBy(id = "fleedIdDisableAccountEditText")
	private WebElement disableText;

	public FleetIDPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void clickEdit() {

		wait.until(ExpectedConditions.elementToBeClickable(edit)).click();
	}

	public void clickCopy() {

		wait.until(ExpectedConditions.elementToBeClickable(copyBtn)).click();
	}

	public WebElement getDisabledText() {

		return wait.until(ExpectedConditions.visibilityOf(disableText));
	}

	public void copyInput(String name) {

		wait.until(ExpectedConditions.elementToBeClickable(copyInput)).sendKeys(name);
	}

	public void clickDelete() {

		wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
	}

	public void clickAdd() {

		wait.until(ExpectedConditions.elementToBeClickable(addNewRecord)).click();
	}

	public void clickExport() {

		wait.until(ExpectedConditions.elementToBeClickable(export)).click();
	}

	public void setID(String name) {

		wait.until(ExpectedConditions.visibilityOf(idInput)).sendKeys(name);
	}

	public void setDesc(String name) {

		wait.until(ExpectedConditions.visibilityOf(descriptionInput)).sendKeys(name);
	}

	public void setStart(String date) {

		wait.until(ExpectedConditions.visibilityOf(startDateInput)).sendKeys(date);
	}

	public void setEnd(String date) {

		wait.until(ExpectedConditions.visibilityOf(endDateInput)).sendKeys(date);
	}
}
