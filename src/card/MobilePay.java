package card;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.MobilePayPage;

public class MobilePay extends Base {
	MobilePayPage mobilePayPage;
	MainPage mainPage;

	Alert alert;

	@Test
	public void Card_RegisterMobilePay() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set card pan
		TestData testData = new TestData(driver);
		// set account
		search.setCardPAN(testData.getPANTokenRequest());

		// click retrieve card pan
		search.clickRetrieveCardSearch();

		// go to next page
		mainPage = new MainPage(driver);
		mainPage.clickMobilePayTab();
		mobilePayPage = new MobilePayPage(driver);

		mobilePayPage.setRegisterReferenceID("testing10");
		// already put wait but cannot find the element.
		Thread.sleep(2000);
		mobilePayPage.selectTokenRequestorID("70659990001 - MPP");
		mobilePayPage.setRegisterCardExpiry(testData.getCardExpiryTokenRequestor());
		mobilePayPage.setValidty("42");
		mobilePayPage.clickregisterMobile();

		Assert.assertTrue(mobilePayPage.getMobileRegisterResult().isDisplayed());
	}

	@Test(priority = 1)
	public void Card_SearchMobilePay() throws InterruptedException {

		mobilePayPage = new MobilePayPage(driver);

		mobilePayPage.selectreferenceID().click();
		mobilePayPage.setreferenceID("testing10");
		// already put wait but cannot find the element.
		Thread.sleep(2000);
		mobilePayPage.selectTokenRequestorID("70659990001 - MPP");
		mobilePayPage.clicksearchStatus();
		List<WebElement> datagrid = driver.findElements(By.className("datagrid"));
		// Get the number of rows in the table
		int rowCount = datagrid.get(7).findElements(By.tagName("tr")).size();
		Thread.sleep(2000);
		// Iterate through each row and check for the desired value
		for (int i = 1; i <= rowCount; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"mobile-query-result\"]/tbody/tr[" + i + "]"))
					.getText();

			System.out.println(sCellValue);

			Assert.assertTrue(sCellValue.contains("testing10"));
		}
		mobilePayPage.selectcardnumber().click();
		// search by card number
		TestData testData = new TestData(driver);
		mobilePayPage.setCardExpiry(testData.getCardExpiryTokenRequestor());
		mobilePayPage.clicksearchStatus();

		Assert.assertTrue(mobilePayPage.getMobileQueryResult().isDisplayed());
	}

	@Test(priority = 2)
	public void Card_CancelMobilePay() throws InterruptedException {
		mobilePayPage = new MobilePayPage(driver);

		mobilePayPage.selectreferenceID().click();

		mobilePayPage.setreferenceID("testing10");
		mobilePayPage.clicksearchStatus();

		Assert.assertTrue(mobilePayPage.getMobileQueryResult().isDisplayed());
		// Get the number of rows in the table
		int rowCount = mobilePayPage.getMobileQueryResult().findElements(By.tagName("tr")).size();
		String dpan = null;

		// Iterate through each row and check for the desired value
		for (int i = 1; i <= rowCount - 2; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"mobile-query-result\"]/tbody/tr[" + i + "]"))
					.getText();
			// find active button
			if (sCellValue.contains("ACTIVE")) {

				int startIndex = sCellValue.indexOf(" ") + 1; // Get the index of the first space and add 1 to skip it
				int endIndex = sCellValue.indexOf(" ", startIndex); // Get the index of the second space after the first
																	// space
				dpan = sCellValue.substring(startIndex, endIndex); // Extract the substring between the first and second
																	// space
				// Output: 7065086110183532290
				// find cancel
				if (mobilePayPage.getCancel().isDisplayed()) {
					mobilePayPage.clickCancel();
				} else {
					mobilePayPage.clickPageNumber();
				}
				alert = new Alert(driver);
				String message = alert.accept();

				String message1 = alert.accept();
				Assert.assertEquals(message, "Are you sure want to cancel this DPAN?");
				Assert.assertEquals(message1, dpan + " has been cancelled successfully.");
			}
		}
	}

}