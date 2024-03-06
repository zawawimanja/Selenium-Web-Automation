package card;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.AccountPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.FleetIDPage;
public class FleetId extends Base {
	AccountPage accountPage;
	MainPage mainPage;
	FleetIDPage fleetIDPage;
	Alert alert;


	@Test
	public void Card_AddFleetID() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set card pan
		TestData testData = new TestData(driver);
		// set account
		search.setCardPAN(testData.getPAN1());

		// click retrieve card pan
		search.clickRetrieveCardSearch();

		// go to next page
		mainPage = new MainPage(driver);

		accountPage = new AccountPage(driver);
		mainPage.clickFleetIDValidationTab();
		fleetIDPage = new FleetIDPage(driver);
		String message = fleetIDPage.getDisabledText().getText();
		Assert.assertEquals(message, "These settings are configured at account level");
	}
//

	@Test
	public void Card_ExportFleetID() throws InterruptedException {
		fleetIDPage.clickExport();
	}

}