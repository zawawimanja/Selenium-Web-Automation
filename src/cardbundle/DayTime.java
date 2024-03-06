package cardbundle;

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

public class DayTime extends Base {
	MainPage mainPage;
	DayTimePage dayTimePage;
	Alert alert;

	LeftSidePage leftSidePage;
	Calendar calendar;
	Time time;

	@Test(priority = 0)
	public void CardBundle_CreateDayTimeCurrent() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// set account
		TestData testData = new TestData(driver);
		// set account
		search.setCardBundle(testData.getCustAccNo1(), testData.getCardBundle());
		// click retrieve account
		search.clickRetrieveCardBundle();

		// go to next page
		mainPage = new MainPage(driver);
		mainPage.clickDayTimeRestrictionsTab();
		dayTimePage = new DayTimePage(driver);
		dayTimePage.clickCurrentEdit();
		dayTimePage.setDayCurrent("Monday");
		dayTimePage.clickCurrentSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Current day time restriction setting is created successfully.");
	}

	@Test(priority = 1)
	public void CardBundle_CreateDayTimeFuture() throws InterruptedException {
		mainPage.clickDayTimeRestrictionsTab();
		dayTimePage = new DayTimePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		dayTimePage.clickFutureEdit();

		calendar = new Calendar(driver);
		time = new Time(driver);
		calendar.clickCalendar("DayTime");

		if (calendar.getCalendar("DayTime").isDisplayed()) {

			String currentDate = dayTimePage.getCurrentStartDate().getAttribute("value");

			LocalDate date = LocalDate.parse(currentDate);

			calendar.getCalendarFutureDateDayTime().sendKeys(calendar.getFutureStartDate(currentDate));

			dayTimePage.setDayFuture("Wednesday");
		}
		time.clickTime("DayTime");

		if (time.getTime("DayTime").isDisplayed()) {
			time.getTimeElement("02:00");
		}
		dayTimePage.clickFutureSave();

		alert = new Alert(driver);
		String message1 = alert.accept();
		Assert.assertEquals(message1, "Future day time restriction setting is created successfully.");
	}

	@Test(priority = 2)
	public void CardBundle_EditDayTimeCurrent() throws InterruptedException {
		dayTimePage = new DayTimePage(driver);
		dayTimePage.clickCurrentEdit();
		dayTimePage.setDayCurrent("Sunday");
		dayTimePage.clickCurrentSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Current day time restriction setting is updated successfully.");
	}

	@Test(priority = 3)
	public void CardBundle_EditDayTimeFuture() throws InterruptedException {
		mainPage.clickDayTimeRestrictionsTab();
		dayTimePage = new DayTimePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		dayTimePage.clickFutureEdit();

		time = new Time(driver);
		time.clickTime("DayTime");

		if (time.getTime("DayTime").isDisplayed()) {
			time.getTimeElement("04:00");
		}
		dayTimePage.clickFutureSave();

		alert = new Alert(driver);
		String message1 = alert.accept();
		Assert.assertEquals(message1, "Future day time restriction setting is updated successfully.");
	}

	@Test(priority = 4)
	public void CardBundle_CancelDayTimeCurrent() throws InterruptedException {
		dayTimePage = new DayTimePage(driver);
		dayTimePage.clickCurrentEdit();
		dayTimePage.clickCurrentSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "No change has been made.");
	}

	@Test(priority = 5)
	public void CardBundle_CancelDayTimeFuture() throws InterruptedException {
		mainPage.clickDayTimeRestrictionsTab();
		dayTimePage = new DayTimePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		dayTimePage.clickFutureEdit();

		dayTimePage.clickFutureSave();

		alert = new Alert(driver);
		String message1 = alert.accept();
		Assert.assertEquals(message1, "No change has been made.");
	}

	@Test(priority = 6)
	public void CardBundle_DeleteDayTime() throws InterruptedException {
		dayTimePage = new DayTimePage(driver);
		dayTimePage.clickCurrentDelete();

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete this current setting?");
		String message1 = alert.accept();
		Assert.assertEquals(message1, "The current day time restriction setting is deleted successfully.");
		dayTimePage.clickFutureDelete();
		String message3 = alert.accept();

		Assert.assertEquals(message3, "Are you sure want to delete this future setting?");
		String message4 = alert.accept();
		Assert.assertEquals(message4, "The future day time restriction setting is deleted successfully.");
	}

}