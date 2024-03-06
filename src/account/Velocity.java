package account;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.AccountPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;
import pages.cgp.pages.cgp.main.restriction.VelocityPage;
public class Velocity extends Base {
	AccountPage accountPage;
	MainPage mainPage;
	VelocityPage velocityPage;
	Alert alert;
	SpecialMessagePage specialMessagePage;
	By RetrieveIssuerDropDown = By.id("main_search_issuer");

	@Test
	public void Account_NewVelocity() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		TestData testData = new TestData(driver);
		// set account
		search.setAccount(testData.getCustAccNo1());
		// click retrieve account
		search.clickRetrieverAccount();

		// go to next page
		mainPage = new MainPage(driver);
		mainPage.clickVelocitiesTab();

		velocityPage = new VelocityPage(driver);
		velocityPage.clickEdit();

		velocityPage.setGeneralVelocity("txn", "value", "1");

		velocityPage.setGeneralVelocity("txn", "volume", "1");
		velocityPage.setGeneralVelocity("value", "daily", "1");
		velocityPage.setGeneralVelocity("value", "weekly", "1");
		velocityPage.setGeneralVelocity("value", "monthly", "1");
		velocityPage.setGeneralVelocity("value", "yearly", "1");
		velocityPage.setGeneralVelocity("value", "lifetime", "1");
		velocityPage.setGeneralVelocity("volume", "daily", "1");
		velocityPage.setGeneralVelocity("volume", "weekly", "1");
		velocityPage.setGeneralVelocity("volume", "monthly", "1");
		velocityPage.setGeneralVelocity("volume", "yearly", "1");
		velocityPage.setGeneralVelocity("volume", "lifetime", "1");
		velocityPage.setGeneralVelocity("txnCount", "daily", "1");
		velocityPage.setGeneralVelocity("txnCount", "weekly", "1");
		velocityPage.setGeneralVelocity("txnCount", "monthly", "1");
		velocityPage.setGeneralVelocity("txnCount", "yearly", "1");
		velocityPage.setGeneralVelocity("txnCount", "lifetime", "1");
		velocityPage.setGeneralVelocity("alert", "value", "1");
		velocityPage.setGeneralVelocity("alert", "volume", "1");
		// set pdv
		//
		// to perform scroll on an application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		velocityPage.setPDV("txn", "value", "1");
		velocityPage.setPDV("value", "daily", "1");
		velocityPage.setPDV("value", "weekly", "1");
		velocityPage.setPDV("value", "monthly", "1");
		velocityPage.setPDV("value", "yearly", "1");
		velocityPage.setPDV("value", "lifetime", "1");
		velocityPage.setPDV("txnCount", "daily", "1");
		velocityPage.setPDV("txnCount", "weekly", "1");
		velocityPage.setPDV("txnCount", "monthly", "1");
		velocityPage.setPDV("txnCount", "yearly", "1");
		velocityPage.setPDV("txnCount", "lifetime", "1");
		velocityPage.selectRefProduct("Unleaded");
		velocityPage.clickEdit();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Velocity setting is Updated Successfully.");
	}
	@Test(priority = 1)
	public void Account_DeleteVelocity() throws InterruptedException {
		velocityPage = new VelocityPage(driver);
		velocityPage.clickDelete();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure you want to delete this Velocity setting?");
		String message1 = alert.accept();
		Assert.assertEquals(message1, "The Velocity setting is Deleted successfully");
	}


}
