package account;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;
public class SpecialMessage extends Base{
	MainPage mainPage;
	Alert alert;
	SpecialMessagePage specialMessagePage;
	By RetrieveIssuerDropDown = By.id("main_search_issuer");

	@Test(priority = 0)
	public void Account_CreateSpecialMessagesPage() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		TestData testData = new TestData(driver);
		// set account
		search.setAccount(testData.getCustAccNo1());
		// click retrieve account
		search.clickRetrieverAccount();
		// go to next page
		mainPage = new MainPage(driver);

		// go to next page
		mainPage.getSpecialMessagesTab().click();
		specialMessagePage = new SpecialMessagePage(driver);
		// verify special message page
		Assert.assertTrue(specialMessagePage.getMarketingMessage().getText().contains("Marketing Message"));
		// click edit current end date
		specialMessagePage.clickEditSpecialMessagesCurrent();
		// chose enddate
		specialMessagePage.setEndDateCurrent("2024-10-24 17:41");
		// set special message
		specialMessagePage.setMessageCurrent("Hello World 123");
		// click save
		specialMessagePage.clickEditSpecialMessagesCurrent();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Active special message setting is created successfully.");
		// edit dormant
		specialMessagePage.clickEditSpecialMessagesFutureBtn();
		specialMessagePage.clickcopyFromActive();
		specialMessagePage.setEndDateFuture("2024-10-24 17:41");

		specialMessagePage.setMessageFuture("Hello World 123");
		specialMessagePage.clickEditSpecialMessagesFutureBtn();

		alert = new Alert(driver);
		String messageDormant = alert.accept();
		// verify special message page
		Assert.assertEquals(messageDormant, "Dormant special message setting is created successfully.");
	}
	@Test(priority = 1)
	public void Account_EditSpecialMessagesPage() throws InterruptedException {
		// click edit current end date
		specialMessagePage.clickEditSpecialMessagesCurrent();
//		// chose enddate
//		specialMessagePage.setEndDateCurrent("2024-10-24 17:41");
		// set special message
		specialMessagePage.setMessageCurrent("Hello World 123!");
		// click save
		specialMessagePage.clickEditSpecialMessagesCurrent();

		alert= new Alert(driver);
		String message=alert.accept();
		// verify special message page
		Assert.assertEquals(message, "Active Special Message setting is updated successfully.");
		// edit dormant
		specialMessagePage.clickEditSpecialMessagesFutureBtn();
		specialMessagePage.clickcopyFromActive();
//		specialMessagePage.setEndDateFuture("2024-10-24 17:41");
		// set special message
		specialMessagePage.setMessageFuture("Hello World 123!");
		specialMessagePage.clickEditSpecialMessagesFutureBtn();

		alert= new Alert(driver);
		String messageDormant=alert.accept();
		// verify special message page
		Assert.assertEquals(messageDormant, "Dormant Special Message setting is updated successfully.");
	}
//
	@Test(priority = 2)
	public void Account_DeleteSpecialMessagesPage() throws InterruptedException {
		specialMessagePage.clickdeleteSpecialMessagesCurrent();
		alert= new Alert(driver);
		String messageDelete1st=alert.accept();
		// verify special message page
		Assert.assertEquals(messageDelete1st, "Are you sure you want to delete this Active setting?");
		specialMessagePage.clickdeleteSpecialMessagesFuture();
		alert= new Alert(driver);
		String messageDelete2nd=alert.accept();
		// verify special message page
		Assert.assertEquals(messageDelete2nd,
				"The current special authorisation message setting is deleted successfully.");
		specialMessagePage.clickdeleteSpecialMessagesFuture();
		alert= new Alert(driver);
		String messageDelete1stDormant=alert.accept();
		// verify special message page
		Assert.assertEquals(messageDelete1stDormant, "Are you sure you want to delete this setting?");
		specialMessagePage.clickdeleteSpecialMessagesFuture();
		alert= new Alert(driver);
		String messageDelete2ndDormant=alert.accept();
		// verify special message page
		Assert.assertEquals(messageDelete2ndDormant,
				"The dormant special authorisation message setting is deleted successfully.");
	}



}
