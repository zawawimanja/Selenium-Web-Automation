package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HistoryPage {
	WebDriver driver;
	WebDriverWait wait;
	// button
	@FindBy(id = "trxn_summary_txid")
	private WebElement trxnidInput;

	@FindBy(id = "btn_search_trxn_summary")
	private WebElement searchBtn;

	@FindBy(id = "trxn-query")
	private WebElement trxnquery;

	By TxnHistory = By.xpath("//*[@id=\"trxn-search-query\"]/tbody/tr");

	public HistoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public WebElement getTxQuery() {

		return wait.until(ExpectedConditions.visibilityOf(trxnquery));
	}

	public void clicksearchtrxn() {

		wait.until(ExpectedConditions.visibilityOf(searchBtn)).click();
	}

	public void setTrxnID(String name) {

		wait.until(ExpectedConditions.visibilityOf(trxnidInput)).sendKeys(name);
	}

	public void clicktrxnHistory() {

		driver.findElement(TxnHistory).click();
		// wait.until(ExpectedConditions.elementToBeClickable(TxnHistory)).click();

	}
}
