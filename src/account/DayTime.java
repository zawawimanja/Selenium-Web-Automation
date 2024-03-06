package account;

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
	public void Account_CreateDayTimeCurrent() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		TestData testData = new TestData(driver);
		// set account
		search.setAccount(testData.getCustAccNo1());
		// click retrieve account
		search.clickRetrieverAccount();

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
	public void Account_EditDayTimeCurrent() throws InterruptedException {
		dayTimePage = new DayTimePage(driver);

		dayTimePage.clickCurrentEdit();
		dayTimePage.setDayCurrent("All Days");
		dayTimePage.setDayCurrent("Sunday");
		dayTimePage.clickCurrentSave();

		alert = new Alert(driver);
		String message = alert.accept();
		Assert.assertEquals(message, "Current day time restriction setting is updated successfully.");
	}

	@Test(priority = 2)
	public void Account_CreateDayTimeFuture() throws InterruptedException {
		dayTimePage = new DayTimePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		dayTimePage.clickFutureEdit();

		calendar = new Calendar(driver);
		time = new Time(driver);

		calendar.clickCalendar("DayTime");

		if (calendar.getCalendar("DayTime").isDisplayed()) {
			System.out.println(" ada");

			// wait for current date element to be visible
			String currentDate = dayTimePage.getCurrentStartDate().getAttribute("value");

			LocalDate date = LocalDate.parse(currentDate);

			System.out.println(" ada");
			calendar.getCalendarFutureDateDayTime().sendKeys(calendar.getFutureStartDate(currentDate));

			dayTimePage.setDayFuture("Wednesday");
		} else {
			System.out.println("tak ada");
		}

		time.clickTime("DayTime");

		if (time.getTime("DayTime").isDisplayed()) {
			time.getTimeElement("02:00");
		} else {
			System.out.println("tak ada");
		}
		dayTimePage.clickFutureSave();

		alert = new Alert(driver);
		String message1 = alert.accept();
		Assert.assertEquals(message1, "Future day time restriction setting is created successfully.");
	}

	@Test(priority = 3)
	public void Account_EditDayTimeFuture() throws InterruptedException {
		dayTimePage = new DayTimePage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		dayTimePage.clickFutureEdit();

		calendar = new Calendar(driver);
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
	public void Account_DeleteDayTimeCurrent() throws InterruptedException {

		dayTimePage = new DayTimePage(driver);
		dayTimePage.clickCurrentDelete();
		// click ok

		alert = new Alert(driver);
		String message = alert.accept();

		Assert.assertEquals(message, "Are you sure want to delete this current setting?");
		String message1 = alert.accept();
		Assert.assertEquals(message1, "The current day time restriction setting is deleted successfully.");
	}

	@Test(priority = 5)
	public void Account_DeleteDayTimeFuture() throws InterruptedException {
		dayTimePage = new DayTimePage(driver);
		dayTimePage.clickFutureDelete();
		String message3 = alert.accept();

		Assert.assertEquals(message3, "Are you sure want to delete this future setting?");
		String message4 = alert.accept();
		Assert.assertEquals(message4, "The future day time restriction setting is deleted successfully.");
	}

}