package cardbundle;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.CardBundlePage;
import pages.cgp.pages.cgp.main.LeftSidePage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.DayTimePage;

public class Cardbundle extends Base {
	MainPage mainPage;
	DayTimePage dayTimePage;
	Alert alert;
	LeftSidePage leftSidePage;

	@Test(priority = 0)
	public void CardBundle_EditCardBundle() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set account
		TestData testData = new TestData(driver);
		// set account
		search.setCardBundle(testData.getCustAccNo1(), testData.getCardBundle());
		// click retrieve account
		search.clickRetrieveCardBundle();
		CardBundlePage cardBundlePage = new CardBundlePage(driver);

		cardBundlePage.clickEdit();

		cardBundlePage.getCardDesc();
		WebElement cardDescElement = cardBundlePage.getCardDesc();
		String currentText = cardDescElement.getAttribute("value");
		System.out.println(currentText);
		String numericPart = currentText.substring(currentText.length() - 1);
		System.out.println();
		try {
			int currentValue = Integer.parseInt(numericPart);
			int newValue = currentValue + 1;

			cardBundlePage.setClearCardDesc();
			cardBundlePage.setCardDesc("test" + newValue + " ");

		} catch (NumberFormatException e) {
			// Handle parsing error
			e.printStackTrace();
		}

		cardBundlePage.clickSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Card bundle has been updated successfully.");
	}

	// @Test(priority = 1)
	public void CardBundle_RemoveCardBundle() throws InterruptedException {
		CardBundlePage cardBundlePage = new CardBundlePage(driver);
		// click 1st row card bundle id
		cardBundlePage.clickEdit();
		// select card number
		cardBundlePage.selectCardNumber();
		cardBundlePage.clickRemove();
		cardBundlePage.clickSave();
		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Card(s) has been removed successfully.");
	}

}
