package account;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.AccountPage;
import pages.cgp.pages.cgp.main.CardBundlePage;
import pages.cgp.pages.cgp.main.LeftSidePage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;

public class Account extends Base {

	AccountPage accountPage;
	MainPage mainPage;
	SpecialMessagePage specialMessagePage;
	LeftSidePage leftSidePage;
	TestData testData;
	By RetrieveIssuerDropDown = By.id("main_search_issuer");
	Alert alert;

	@Test(priority = 0)
	public void Account_BlockUnBlock() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		TestData testData = new TestData(driver);
		// set account
		search.setAccount(testData.getCustAccNo2());
		// click retrieve account
		search.clickRetrieverAccount();
		// go to next page

		accountPage = new AccountPage(driver);
		for (int i = 0; i < 2; i++) {
			// click block/unblock account
			accountPage.clickBlockUnBlockAccount();
			// click ok
			alert = new Alert(driver);
			String message = alert.accept();

			String message1 = alert.accept();
			leftSidePage = new LeftSidePage(driver);
			String issuerString = leftSidePage.getIssuer("desc").getText().substring(4);
			String accNumber = leftSidePage.getAccNumber("desc").getText();
			if (message.equals("Are you sure you want to block this account?")) {
				Assert.assertEquals(message1, "Account " + issuerString + accNumber + " is blocked successfully.");
			} else {
				Assert.assertEquals(message1, "Account " + issuerString + accNumber + " is unblocked successfully.");
			}
			boolean unblockAcc = accountPage.getAccountStatus().getText().trim().contains("Status: Active");
			boolean blockAcc = accountPage.getAccountStatus().getText().trim().contains("Status: Account blocked");
			if (unblockAcc == true) {
				Assert.assertTrue(unblockAcc);
			} else {
				Assert.assertTrue(blockAcc);
			}
		}
	}

	@Test(priority = 1)
	public void Account_SystematicAlert() throws InterruptedException {
		accountPage = new AccountPage(driver);
		String sysAlert[] = { "Yes", "No" };
		for (int i = 0; i < sysAlert.length; i++) {
			// select enable
			accountPage.selectSystemAlertAccount(sysAlert[i]);
			// click save
			accountPage.clickSaveBtn();

			// click ok
			alert = new Alert(driver);
			String message = alert.accept();
			boolean sysAlertYes = accountPage.getSelectedDropDown().getText().trim().contains("Yes");
			boolean sysAlertNo = accountPage.getSelectedDropDown().getText().trim().contains("No");
			boolean sysAlertInherit = accountPage.getSelectedDropDown().getText().trim()
					.contains("Inherit from account");
			if (sysAlertYes == true) {
				Assert.assertTrue(sysAlertYes);
			} else if (sysAlertNo == true) {
				Assert.assertTrue(sysAlertNo);
			}
			Assert.assertEquals(message, "The alert enabled is updated successfully.");
		}
	}

	@Test(priority = 2)
	public void Account_NewCardBundle() throws InterruptedException {
		CardBundlePage cardBundlePage = new CardBundlePage(driver);
		TestData testData = new TestData(driver);
		cardBundlePage.clickNew();
		cardBundlePage.setExtID("test");
		cardBundlePage.setCardDesc("test");
		cardBundlePage.setCardNumber(testData.getPAN2());
		cardBundlePage.clickAdd();
		cardBundlePage.clickSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Card bundle has been created successfully.");
	}

	@Test(priority = 3)
	public void Account_EditCardBundle() throws InterruptedException {
		CardBundlePage cardBundlePage = new CardBundlePage(driver);
		// click 1st row
		cardBundlePage.selectCardBundle();
		cardBundlePage.clickEdit();
		cardBundlePage.setExtID("test1");
		cardBundlePage.setCardDesc("test1");
		cardBundlePage.clickSave();
		;
		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Card bundle has been updated successfully.");
	}

	@Test(priority = 4)
	public void Account_RemoveCardBundle() throws InterruptedException {
		CardBundlePage cardBundlePage = new CardBundlePage(driver);
		cardBundlePage.clickEdit();
		List<WebElement> datagrid = driver.findElements(By.className("datagrid"));
		// Get the number of rows in the table
		int rowCount = datagrid.get(4).findElements(By.tagName("tr")).size();

		// Iterate through each row and check for the desired value
		for (int i = 1; i <= rowCount; i++) {
			WebElement sCellValue = driver.findElement(By.xpath("//*[@id=\"card-list\"]/tbody/tr[" + i + "]"));

			if (i == 1) {
				sCellValue.click();
			}
			break;
		}
		cardBundlePage.clickRemove();
		cardBundlePage.clickSave();
		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Card(s) has been removed successfully.");
	}

	@Test(priority = 5)
	public void Account_DeleteCardBundle() throws InterruptedException {
		CardBundlePage cardBundlePage = new CardBundlePage(driver);
		// click 1st row
		List<WebElement> datagrid = driver.findElements(By.className("datagrid"));
		// Get the number of rows in the table
		int rowCount = datagrid.get(3).findElements(By.tagName("tr")).size();

		// Iterate through each row and check for the desired value
		for (int i = 1; i <= rowCount; i++) {
			WebElement sCellValue = driver.findElement(By.xpath("//*[@id=\"card-bundle-result\"]/tbody/tr[" + i + "]"));

			if (i == 1) {
				sCellValue.click();
			}
			break;
		}
		cardBundlePage.clickDelete();

		alert = new Alert(driver);
		String message = alert.accept();

		String message1 = alert.accept();
		Assert.assertEquals(message, "Are you sure want to delete this card bundle?");
		Assert.assertEquals(message1, "The card bundle is deleted successfully.");
	}

}
