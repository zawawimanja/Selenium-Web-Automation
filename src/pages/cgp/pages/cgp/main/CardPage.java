package pages.cgp.pages.cgp.main;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CardPage {
	 private WebDriver driver;
	    private WebDriverWait wait;

	    @FindBy(id = "blockUnblockPan")
	    private WebElement editBtn;

	    @FindBy(id = "btnUpdateAlertCard")
	    private WebElement saveBtn;

	    @FindBy(className = "blockUnblockPan")
	    private WebElement cardBtn;

	    @FindBy(id = "selectSystemAlertCard")
	    private WebElement selectedDropDown;

	    @FindBy(xpath = "//*[@id='card-result']/tbody/tr/td[5]")
	    private WebElement status;

	    @FindBy(id = "card-result")
	    private WebElement cardResult;

	 public CardPage(WebDriver driver) {
		 this.driver = driver;
			PageFactory.initElements(driver, this);
			wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	    }

	    public void selectSystemAlertCard(String name) {
	        Select dropdown = new Select(selectedDropDown);
	        dropdown.selectByVisibleText(name);
	    }

	    public void clickSave() {
	        wait.until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
	    }

	    public void clickBlockUnBlockAccount() {
	        wait.until(ExpectedConditions.elementToBeClickable(cardBtn)).click();
	    }

	    public WebElement getCardStatus() {
	        return wait.until(ExpectedConditions.visibilityOf(status));
	    }

	    public WebElement getCardTable() {
	        return wait.until(ExpectedConditions.visibilityOf(cardResult));
	    }

	    public WebElement getSelectedDropDown() {
	        return wait.until(ExpectedConditions.visibilityOf(selectedDropDown));
	    }
}
