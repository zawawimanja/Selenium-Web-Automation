package component;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.cgp.pages.cgp.main.AccountPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.FleetIDPage;

public class LoginPageTest extends Base {

	AccountPage accountPage;
	MainPage mainPage;
	FleetIDPage fleetIDPage;
	Alert alert;

	@Test(priority = 1)
	public void Account_CreateFleetID() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		TestData testData = new TestData(driver);
		search.setAccount(testData.getCustAccNo1());
		// click retrieve customer
		search.clickRetrieverAccount();
		// go to next page
		mainPage = new MainPage(driver);

		accountPage = new AccountPage(driver);
		mainPage.clickFleetIDValidationTab();
		fleetIDPage = new FleetIDPage(driver);
		fleetIDPage.clickAdd();
		fleetIDPage.setID("test");
		fleetIDPage.setDesc("test");
		fleetIDPage.setStart("2023-01-30 11:35");
		fleetIDPage.setEnd("2023-03-08 11:35");
		fleetIDPage.clickEdit();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Fleet id record is created successfully.");
	}
}