package card;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.CardPage;
import pages.cgp.pages.cgp.main.CustomerPage;
import pages.cgp.pages.cgp.main.LeftSidePage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;

public class Card extends Base {
	CardPage cardPage;
	MainPage mainPage;
	CustomerPage customerPage;
	SpecialMessagePage specialMessagePage;
	By RetrieveIssuerDropDown = By.id("main_search_issuer");
	Alert alert;
	LeftSidePage leftSidePage;

	@Test
	public void Card_CardBlockUnBlock() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set card pan

		TestData testData = new TestData(driver);
		// set account
		search.setCardPAN(testData.getPAN1());

		// click retrieve card pan
		search.clickRetrieveCardSearch();

		cardPage = new CardPage(driver);
		for (int i = 0; i < 1; i++) {
			// click block/unblock account
			cardPage.clickBlockUnBlockAccount();
			// click ok
			alert = new Alert(driver);
			String message = alert.accept();

			String message1 = alert.accept();
			boolean unblockAcc = cardPage.getCardStatus().getText().trim().contains("Active");
			boolean blockAcc = cardPage.getCardStatus().getText().trim().contains("Blocked");
			leftSidePage = new LeftSidePage(driver);
			int rowCount = cardPage.getCardTable().findElements(By.tagName("tr")).size();

			String panValue = driver.findElement(By.xpath("//*[@id=\"card-result\"]/tbody/tr/td[1]")).getText();
			String sCellValue = driver.findElement(By.xpath("//*[@id=\"card-result\"]/tbody/tr/td[2]")).getText();

			// contain 4character invert behind to front
			String expiredDate = sCellValue.substring(2) + sCellValue.substring(0, 2);

			if (message.equals("Are you sure you want to block this card?")) {
				Assert.assertEquals(message1,
						"Card " + panValue + ", expiry date " + expiredDate + " is blocked successfully.");
				// Card 707708**********0020, expriy date 2407 is unblocked successfully.
			} else {
				Assert.assertEquals(message1,
						"Card " + panValue + ", expiry date " + expiredDate + " is unblocked successfully.");
			}
			// Error expriry
			// pan number tak sama card number
			if (unblockAcc == true) {
				Assert.assertTrue(unblockAcc);
			} else {
				Assert.assertTrue(blockAcc);
			}
		}
	}

	@Test(priority = 1)
	public void Card_SystematicAlert() throws InterruptedException {
		cardPage = new CardPage(driver);
		String sysAlert[] = { "Yes", "No", "Inherit from account" };
		for (int i = 0; i < sysAlert.length; i++) {
			// select enable
			cardPage.selectSystemAlertCard(sysAlert[i]);
			// click save
			cardPage.clickSave();

			alert = new Alert(driver);
			String message = alert.accept();
			boolean sysAlertYes = cardPage.getSelectedDropDown().getText().trim().contains("Yes");
			boolean sysAlertNo = cardPage.getSelectedDropDown().getText().trim().contains("No");
			boolean sysAlertInherit = cardPage.getSelectedDropDown().getText().trim().contains("Inherit from account");
			if (sysAlertYes == true) {
				Assert.assertTrue(sysAlertYes);
			} else if (sysAlertNo == true) {
				Assert.assertTrue(sysAlertNo);
			} else {
				Assert.assertTrue(sysAlertInherit);
			}
			Assert.assertEquals(message, "The alert enabled is updated successfully.");
		}
	}

}
