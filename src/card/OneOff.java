package card;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.MobilePayPage;
import pages.cgp.pages.cgp.main.restriction.OneOffCardPage;
public class OneOff extends Base {
	MobilePayPage mobilePayPage;
	OneOffCardPage oneOffCardPage;
	MainPage mainPage;

	Alert alert;

	@Test(priority = 1)
	public void Card_GenerateOffCard() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set card pan
		TestData testData = new TestData(driver);
		// set account
		search.setCardPAN(testData.getPANTokenRequest());

		// click retrieve card pan
		search.clickRetrieveCardSearch();

		// go to next page
		mainPage = new MainPage(driver);
		mainPage.clickOneOffTab();
		oneOffCardPage = new OneOffCardPage(driver);

		oneOffCardPage.setgenOneCardExpDate(testData.getCardExpiryTokenRequestor());
		oneOffCardPage.clickgenerateOneCardBtn();

		Assert.assertTrue(oneOffCardPage.getOneCardGenerateResult().isDisplayed());
	}
	@Test(priority = 1)
	public void Card_SearchCard() throws InterruptedException {
		oneOffCardPage = new OneOffCardPage(driver);

		oneOffCardPage.clicksearchOneCard();

		Assert.assertTrue(oneOffCardPage.getOneCardManageResult().isDisplayed());
	}
	@Test(priority = 2)
	public void Card_CancelOneOff() throws InterruptedException {
		mobilePayPage = new MobilePayPage(driver);
		oneOffCardPage = new OneOffCardPage(driver);

		oneOffCardPage.clicksearchOneCard();

		Assert.assertTrue(oneOffCardPage.getOneCardManageResult().isDisplayed());
		// Get the number of rows in the table
		int rowCount = oneOffCardPage.getOneCardManageResult().findElements(By.tagName("tr")).size();
		String dpan = null;


		// Iterate through each row and check for the desired value
		for (int i = 1; i <= rowCount - 2; i++) {
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"onecard-manage-result\"]/tbody/tr[" + i + "]"))
					.getText();
			if (sCellValue.contains("ACTIVE")) {

				int startIndex = sCellValue.indexOf(" ") + 1; // Get the index of the first space and add 1 to skip it
				int endIndex = sCellValue.indexOf(" ", startIndex); // Get the index of the second space after the first
																	// space
				dpan = sCellValue.split(" ")[0];; // Extract the substring between the first and second
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