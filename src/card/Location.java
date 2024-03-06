package card;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
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
import pages.cgp.pages.cgp.main.restriction.LocationPage;

public class Location extends Base {
	MainPage mainPage;
	DayTimePage dayTimePage;
	LocationPage locationPage;
	Alert alert;

	Time time;
	Calendar calendar;
	LeftSidePage leftSidePage;

	@Test
	public void Card_CreateCurrentLocation() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set card pan
		TestData testData = new TestData(driver);
		// set account
		search.setCardPAN(testData.getPAN2());

		// click retrieve card pan
		search.clickRetrieveCardSearch();

		// go to next page
		mainPage = new MainPage(driver);
		mainPage.clickLocationRestrictionsTab();
		locationPage = new LocationPage(driver);

		locationPage.clickCurrentEdit();

		locationPage.clickCurrentIncludeCountry();
		List<WebElement> checkboxes = driver.findElements(By.className("currentCountryCheckBox"));
		checkboxes.get(0).click();
		if (checkboxes.get(1).isSelected()) {
			System.out.println("Checkbox is still selected");
		} else {
			System.out.println("Checkbox is deselected successfully");
		}
		// find multiple elements using the CSS selector
		List<WebElement> button = driver.findElements(By.className("currentNetworkSelection"));
		button.get(0).click();
		if (button.get(1).isSelected()) {
			System.out.println("Checkbox is still selected");
		} else {
			System.out.println("Checkbox is deselected successfully");
		}

		locationPage.clickCurrentSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Current location restriction setting is created successfully.");
	}

	@Test(priority = 2)
	public void Card_EditCurrentLocation() throws InterruptedException {
		locationPage = new LocationPage(driver);

		locationPage.clickCurrentEdit();
		List<WebElement> checkboxes = driver.findElements(By.className("currentCountryCheckBox"));
		checkboxes.get(2).click();
		locationPage.clickCurrentSave();
		alert = new Alert(driver);

		String message = alert.accept();

		Assert.assertEquals(message, "Current location restriction setting is updated successfully.");
	}

	@Test(priority = 3)
	public void Card_CreateFutureLocation() throws InterruptedException {
		locationPage = new LocationPage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		// assertFalse(locationPage.getFutureDelete().isEnabled());
		locationPage.clickFutureEdit();

		calendar = new Calendar(driver);
		time = new Time(driver);
		calendar.clickCalendar("Location");

		if (calendar.getCalendar("Location").isDisplayed()) {

			String currentDate = locationPage.getCurrentStartDate().getAttribute("value");

			LocalDate date = LocalDate.parse(currentDate);

			calendar.getCalendarFutureDateLocation().sendKeys(calendar.getFutureStartDate(currentDate));

		}
		locationPage.selectAlertFuture("Alert Only");

		time.clickTime("Location");

		if (time.getTime("Location").isDisplayed()) {
			time.getTimeElement("02:00");
			System.out.println("t");
		} else {
			System.out.println("not d");
		}
		locationPage.clickFutureSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Future location restriction setting is created successfully.");
	}

	@Test(priority = 4)
	public void Card_EditFutureLocation() throws InterruptedException {
		locationPage = new LocationPage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		// assertFalse(locationPage.getFutureDelete().isEnabled());
		locationPage.clickFutureEdit();

		calendar = new Calendar(driver);
		time = new Time(driver);

		time.clickTime("Location");

		if (time.getTime("Location").isDisplayed()) {
			time.getTimeElement("04:00");
			System.out.println("t");
		} else {
			System.out.println("not d");
		}
		locationPage.clickFutureSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Future location restriction setting is updated successfully.");
	}

	//@Test(priority = 5)
	public void Card_CopyFromLocation() throws InterruptedException {

		leftSidePage = new LeftSidePage(driver);
		TestData testData = new TestData(driver);
		leftSidePage.getCopyFrom("Location").sendKeys(testData.getPAN4());

		leftSidePage.clickCopy("Location");

		alert = new Alert(driver);
		String message = alert.accept();

		// Assert.assertEquals(message.trim(), "Day Time Restriction:Do you want to
		// override the setting of this card (700208**********1475) with the current and
		// future settings from the card (707708**********0020) ?");

		String message1 = alert.accept();

		Assert.assertEquals(message1.replaceAll("[\\r\\n]+", ""),
				"Location Restriction: Current and future location restriction profiles are copied successfully.");
	}

	@Test(priority = 6)
	public void Card_DeleteFutureLocation() throws InterruptedException {
		locationPage = new LocationPage(driver);

		locationPage.clickFutureDelete();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete this future setting?");
		String message1 = alert.accept();
		Assert.assertEquals(message1, "The future location restriction setting is deleted successfully.");
	}

	@Test(priority = 7)
	public void Card_DeleteCurrentLocation() throws InterruptedException {
		locationPage = new LocationPage(driver);

		locationPage.clickCurrentDelete();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete this current setting?");
		String message1 = alert.accept();
		Assert.assertEquals(message1, "The current location restriction setting is deleted successfully.");
	}

}