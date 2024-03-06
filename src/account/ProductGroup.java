package account;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.TestData;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.ProductGroupsPage;
public class ProductGroup extends Base {
	MainPage mainPage;
	ProductGroupsPage productGroupsPage;
	Alert alert;


	@Test(priority = 0)
	public void Account_CreateProductGroup() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set account
		TestData testData = new TestData(driver);
		// set account
		search.setAccount(testData.getCustAccNo1());
		// click retrieve account
		search.clickRetrieverAccount();

		// go to next page

		mainPage = new MainPage(driver);
		mainPage.clickProductGroupTab();
		productGroupsPage = new ProductGroupsPage(driver);
		productGroupsPage.clickNewGroup();
		// already put wait but cannot find the element.
				Thread.sleep(2000);
		productGroupsPage.selectProductGroup("011 - Tunnel/Bridges");
		productGroupsPage.clickAddProductButton();
		productGroupsPage.setGroupProductText("test2");
		productGroupsPage.clickAddtoGroupButton();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "test2 is successfully added into product group.");
	}

	@Test(priority = 1)
	public void Account_RemoveProductGroup() throws InterruptedException {
		productGroupsPage = new ProductGroupsPage(driver);

		productGroupsPage.selectProductGroupName("test2");
		// already put wait but cannot find the element.
		Thread.sleep(2000);
		productGroupsPage.selectProductGroupAfter("011 - Tunnel/Bridges");
		productGroupsPage.clickRemove();
		productGroupsPage.clickSave();

		// click ok
		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "test2 is updated successfully.");
	}

	@Test(priority = 2)
	public void Account_DeleteProductGroup() throws InterruptedException {
		productGroupsPage = new ProductGroupsPage(driver);
		// find and select the element

		productGroupsPage.selectProductGroupName("test2");
		productGroupsPage.clickDeleteGroupButton();
		// click ok
		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete test2?");
		String message1 = alert.accept();

		Assert.assertEquals(message1, "test2 is successully deleted from product group list.");
	}

	// @Test
	public void Account_ExportProductGroup() throws InterruptedException {
		productGroupsPage = new ProductGroupsPage(driver);
		// find and select the element

		productGroupsPage.selectProductGroupName("test2");
		productGroupsPage.clickExportButton();
	}

}