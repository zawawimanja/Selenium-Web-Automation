package account;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.SiteGroupsPage;

public class SiteGroups extends Base {
	MainPage mainPage;
	SiteGroupsPage siteGroupsPage;
	Alert alert;

	 @Test(priority = 0)
	public void Account_AddGroupShellSite() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set account
		TestData testData = new TestData(driver);
		// set account
		search.setAccount(testData.getCustAccNo1());
		// click retrieve account
		search.clickRetrieverAccount();

		// go to next page
		mainPage = new MainPage(driver);
		mainPage.clickSiteGroupsTab();
		siteGroupsPage = new SiteGroupsPage(driver);

		siteGroupsPage.clickNewGroupShellSite();
		siteGroupsPage.setGroupText("DE0189");
		siteGroupsPage.clickAddButton();
		siteGroupsPage.setGroupName("a12345");
		siteGroupsPage.clickAddtoGroupButton();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "a12345 is successfully added into site group.");
	}

	 @Test(priority = 1)
	public void Account_RemoveGroupShellSite() throws InterruptedException {
		siteGroupsPage = new SiteGroupsPage(driver);

		siteGroupsPage.selectShellGroup("a12345");
		// already put wait but cannot find the element.
		Thread.sleep(2000);
		siteGroupsPage.selectSiteGroupList("DE0189");
		siteGroupsPage.clickRemove();
		siteGroupsPage.clickEditSaveButton();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "a12345 is updated successfully.");
	}

//	 @Test(priority = 2)
//	public void Account_ExportGroupShellSite() throws InterruptedException {
//		siteGroupsPage = new SiteGroupsPage(driver);

//		siteGroupsPage.selectShellGroup("a12345");

//		siteGroupsPage.clickExportButtonShell();
//	}
	 @Test(priority = 3)
	public void Account_DeleteGroupShellSite() throws InterruptedException {
		siteGroupsPage = new SiteGroupsPage(driver);

		siteGroupsPage.selectSiteGroup("a12345");
		siteGroupsPage.clickDeleteGroupButton();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete a12345?");
		String message1 = alert.accept();

		Assert.assertEquals(message1, "a12345 is successully deleted from site group list.");
	}

	 @Test(priority = 4)
	public void Account_Add3rdPartySiteGroup() throws InterruptedException {
		siteGroupsPage = new SiteGroupsPage(driver);
		//
		// to perform scroll on an application using Selenium
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		siteGroupsPage.clickNewGroup3rdPartySiteGroup();

		siteGroupsPage.setThirdPartySiteGroup("a12345");
		siteGroupsPage.clickAdd3rdButton();
		siteGroupsPage.setGroupName3rd("a12345");
		siteGroupsPage.clickAddtoGroup3rdButton();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "a12345 is successfully added into site group.");
	}

	 @Test(priority = 5)
	public void Account_Remove3rdPartySiteGroup() throws InterruptedException {
		siteGroupsPage = new SiteGroupsPage(driver);

		siteGroupsPage.select3rdPartySiteGroup("a12345");
		// already put wait but cannot find the element.
				Thread.sleep(2000);
		siteGroupsPage.select3rdPartySiteList("Shell SK (Mobile?)/A12345");
		siteGroupsPage.clickRemove3rdParty();
		siteGroupsPage.clickSave3rdButton();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "a12345 is updated successfully.");
	}

	 @Test(priority = 6)
	public void Account_Delete3rdPartySite() throws InterruptedException {
		siteGroupsPage = new SiteGroupsPage(driver);

		siteGroupsPage.select3rdPartySiteGroup("a12345");
		siteGroupsPage.clickDelete3rdPartyButton();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete a12345?");
		String message1 = alert.accept();

		Assert.assertEquals(message1, "a12345 is successully deleted from site group list.");
	}

	// @Test
	public void Account_Export3rdPartySiteGroup() throws InterruptedException {
		siteGroupsPage = new SiteGroupsPage(driver);

		siteGroupsPage.select3rdPartySiteGroup("a12345");

		siteGroupsPage.clickExportButton3rdParty();
	}

}