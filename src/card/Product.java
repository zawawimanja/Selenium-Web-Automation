package card;

import java.time.LocalDate;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Alert;
import component.Base;
import component.Calendar;
import component.TestData;
import component.Time;
import pages.cgp.pages.cgp.main.LeftSidePage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.DayTimePage;
import pages.cgp.pages.cgp.main.restriction.ProductPage;

public class Product extends Base {
	MainPage mainPage;
	DayTimePage dayTimePage;
	ProductPage productPage;
	Alert alert;

	Calendar calendar;
	Time time;
	LeftSidePage leftSidePage;

	@Test(priority = 0)
	public void Card_CreateCurrentProduct() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set card pan
		TestData testData = new TestData(driver);
		// set account
		search.setCardPAN(testData.getPAN2());

		// click retrieve card pan
		search.clickRetrieveCardSearch();
		// click retrieve card pan

		mainPage = new MainPage(driver);
		mainPage.clickProductRestrictionsTab();
		productPage = new ProductPage(driver);

		productPage.clickCurrentEdit();
		productPage.selectCurrentIncludeExclude("Include");
		productPage.clickAddProductGroupsCurrent();
		productPage.clickAddProduct();
		productPage.clickCurrentSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Current product restriction setting is created successfully.");
	}

	@Test(priority = 1)
	public void Card_EditCurrentProduct() throws InterruptedException {
		productPage = new ProductPage(driver);

		productPage.clickCurrentEdit();
		productPage.selectCurrentIncludeExclude("Exclude");
		productPage.clickAddProductGroupsCurrent();
		productPage.clickAddProduct();
		productPage.clickCurrentSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Current product restriction setting is updated successfully.");
	}

	@Test(priority = 2)
	public void Card_CreateFutureProduct() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		productPage = new ProductPage(driver);

		productPage.clickFutureEdit();

		calendar = new Calendar(driver);
		time = new Time(driver);
		calendar.clickCalendar("Product");

		if (calendar.getCalendar("Product").isDisplayed()) {

			String currentDate = productPage.getCurrentStartDate().getAttribute("value");

			LocalDate date = LocalDate.parse(currentDate);

			calendar.getCalendarFutureDateProduct().sendKeys(calendar.getFutureStartDate(currentDate));

		}

		productPage.selectAlertFuture("Alert Only");

		time.clickTime("Product");

		if (time.getTime("Product").isDisplayed()) {
			time.getTimeElement("02:00");
		}
		productPage.clickFutureSave();

		alert = new Alert(driver);
		String message1 = alert.accept();
		Assert.assertEquals(message1, "Future product restriction setting is created successfully.");
	}

	@Test(priority = 3)
	public void Card_EditFutureProduct() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		productPage = new ProductPage(driver);

		productPage.clickFutureEdit();

		calendar = new Calendar(driver);
		time = new Time(driver);

		time.clickTime("Product");

		if (time.getTime("Product").isDisplayed()) {
			time.getTimeElement("04:00");
		}
		productPage.clickFutureSave();

		alert = new Alert(driver);
		String message1 = alert.accept();
		Assert.assertEquals(message1, "Future product restriction setting is updated successfully.");
	}

	//@Test(priority = 4)
	public void Card_CopyFromProduct() throws InterruptedException {

		leftSidePage = new LeftSidePage(driver);
		TestData testData = new TestData(driver);
		leftSidePage.getCopyFrom("Product").sendKeys(testData.getPAN4());

		leftSidePage.clickCopy("Product");

		alert = new Alert(driver);
		String message = alert.accept();

		// Assert.assertEquals(message.trim(), "Day Time Restriction:Do you want to
		// override the setting of this card (700208**********1475) with the current and
		// future settings from the card (707708**********0020) ?");

		String message1 = alert.accept();

		Assert.assertEquals(message1.replaceAll("[\\r\\n]+", ""),
				"Product Restriction: Current and future product restriction profiles are copied successfully.");
	}

	@Test(priority = 5)
	public void Card_DeleteProduct() throws InterruptedException {
		productPage = new ProductPage(driver);
		productPage.clickCurrentDelete();
		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete this current setting?");
		String message1 = alert.accept();
		Assert.assertEquals(message1, "The current product restriction setting is deleted successfully.");
		productPage.clickFutureDelete();

		alert = new Alert(driver);
		String message3 = alert.accept();

		Assert.assertEquals(message3, "Are you sure want to delete this future setting?");
		String message4 = alert.accept();
		Assert.assertEquals(message4, "The future product restriction setting is deleted successfully.");
	}

}