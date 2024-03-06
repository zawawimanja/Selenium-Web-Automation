package account;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.AccountPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.FleetIDPage;
public class FleetId extends Base{
	AccountPage accountPage;
	MainPage mainPage;
	FleetIDPage fleetIDPage;
	Alert alert;


	@Test
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
	@Test(priority = 1)
	public void Account_EditFleetID() throws InterruptedException {
		fleetIDPage = new FleetIDPage(driver);
		fleetIDPage.clickEdit();
		fleetIDPage.setDesc("test2");
		fleetIDPage.clickEdit();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Fleet id record is updated successfully.");
	}
	@Test(priority = 2)
	public void Account_DeleteFleetID() throws InterruptedException {
		fleetIDPage = new FleetIDPage(driver);

		fleetIDPage.clickDelete();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete this fleet id record?");

		String message1 = alert.accept();
		Assert.assertEquals(message1, "Fleet id is deleted successfully.");
	}
//
	@Test
	public void Account_ExportFleetID() throws InterruptedException {
		fleetIDPage.clickExport();
	}

}