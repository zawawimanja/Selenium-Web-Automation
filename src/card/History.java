package card;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.CardPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.HistoryPage;
public class History extends Base {
	HistoryPage historyPage;
	MainPage mainPage;
	CardPage cardPage;
	String txID = "300057F8E221116CEB3";


	// @Test
	public void Card_ViewTransactionHistory() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set txn id
		search.setTransactionID("3000677AA2302092064");
		// click transaction
		search.clickRetrieveTransaction();
		historyPage = new HistoryPage(driver);

		// click first row txn id
		historyPage.clicktrxnHistory();
		// verify
	}
	//@Test
	public void Card_SearchHistory() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set card pan
		TestData testData = new TestData(driver);
		search.setCardPAN(testData.getPAN1());
		// click retrieve card pan
		search.clickRetrieveCardSearch();

		// go to next page
		mainPage = new MainPage(driver);
		mainPage.clickHistoryTab();
		historyPage = new HistoryPage(driver);

		historyPage.clicksearchtrxn();
		assertTrue(historyPage.getTxQuery().isDisplayed());
		// click search
		// display list
		historyPage.setTrxnID(txID);
		historyPage.clicksearchtrxn();
		// Get the number of rows in the table
		int rowCount = historyPage.getTxQuery().findElements(By.tagName("tr")).size();


		// Iterate through each row and check for the desired value
		for (int i = 1; i < rowCount; i++) {
		    WebElement row = driver.findElement(By.xpath("//*[@id=\"trxn-query\"]/tbody/tr[" + i + "]"));
		    String rowText = row.getText();
		    if (rowText.contains(txID)) {

		        row.click(); // click on the row or a child element as needed
		        break; // exit the loop since the desired value has been found
		    }
		}
	}


}