package main;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import pages.cgp.pages.cgp.main.AccountPage;
import pages.cgp.pages.cgp.main.CustomerPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;

public class Customer extends Base {
	AccountPage accountPage;
	MainPage mainPage;
	CustomerPage customerPage;
	SpecialMessagePage specialMessagePage;

	Alert alert;
	By RetrieveIssuerDropDown = By.id("main_search_issuer");

	@Test
	public void test_CustomerBlockUnBlock() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set customerid
		search.setCustomerID("00000005");
		// click retrieve customer
		search.clickRetrieveCustomer();

		customerPage = new CustomerPage(driver);
		for (int i = 0; i < 2; i++) {
			// click block/unblock account
			customerPage.clickBlockUnBlockAccount();
			alert = new Alert(driver);

			String message = alert.accept();
			alert.waitForAlert();
			String message1 = alert.accept();
			if (message.equals("Are you sure you want to block this customer?")) {
				Assert.assertEquals(message1,
						"Customer ID: " + customerPage.getAccountLink().getText() + " is blocked successfully.");
			} else {
				Assert.assertEquals(message1,
						"Customer ID: " + customerPage.getAccountLink().getText() + " is unblocked successfully.");
			}
			boolean unblockAcc = customerPage.getCustomerStatus().getText().trim().contains("Status: Active");
			boolean blockAcc = customerPage.getCustomerStatus().getText().trim().contains("Status: Customer blocked");
			if (unblockAcc == true) {
				Assert.assertTrue(unblockAcc);
			} else {
				Assert.assertTrue(blockAcc);
			}
		}
	}

	@Test(priority = 1)
	public void test_ClickAccountNumber() throws InterruptedException {
		customerPage = new CustomerPage(driver);

		// click account number
		customerPage.clickAccountNumber();
		// go to next page
		accountPage = new AccountPage(driver);

		accountPage.checkVisible(accountPage.getAccount());

		// verify page
		Assert.assertTrue(accountPage.getAccount().getText().trim().contains("Account Settings"));
	}

}
