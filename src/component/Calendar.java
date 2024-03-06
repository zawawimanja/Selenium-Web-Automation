package component;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	WebDriver driver;
	WebDriverWait wait;

	By datetimepicker = By.cssSelector("div.xdsoft_datetimepicker");

	@FindBy(id = "future_daytime_restrict_start_date")
	private WebElement futureDaytimeStartDate;

	@FindBy(id = "future_product_restrict_start_date")
	private WebElement futureProductStartDate;

	@FindBy(id = "future_location_restrict_start_date")
	private WebElement futureLocationStartDate;

	@FindBy(css = ".xdsoft_label.xdsoft_month")
	private WebElement calendarMonth;

	@FindBy(id = "future_product_restrict_start_date")
	private WebElement calendar;

	@FindBy(id = "future_location_restrict_start_date")
	private WebElement calendarLocation;

	@FindBy(id = "future_daytime_restrict_start_date")
	private WebElement calendarDayTime;

	// @FindBy(className = "xdsoft_next")
	// private WebElement next;

	@FindBy(css = ".xdsoft_prev")
	private WebElement previous;

	@FindBy(css = ".xdsoft_label.xdsoft_year")
	private WebElement year;

	@FindBy(css = ".xdsoft_label.xdsoft_month")
	private WebElement month;

	public Calendar(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	}

	public void clickNext(String name) {
		// Get the third link from the array using the get() method
		List<WebElement> next = driver.findElements(By.cssSelector(".xdsoft_datepicker.active .xdsoft_next"));
		switch (name) {
		case "Product":
			next.get(10).click();
			break;
		case "Location":
			next.get(11).click();
			break;
		case "DayTime":
			next.get(9).click();
			break;
		}
	}

	public WebElement getCalendar(String name) {

		List<WebElement> links = driver.findElements(datetimepicker);

		switch (name) {
		case "Product":
			return wait.until(ExpectedConditions.visibilityOf(links.get(15))); // Wait for element to be visible

		case "Location":
			return wait.until(ExpectedConditions.visibilityOf(links.get(17))); // Wait for element to be visible

		case "DayTime":
			return wait.until(ExpectedConditions.visibilityOf(links.get(9))); // Wait for element to be visible

		default:
			throw new IllegalArgumentException("Invalid calendar name: " + name);
		}
	}

	public void clickPrevious() {

		wait.until(ExpectedConditions.elementToBeClickable(previous));
		previous.click();
	}

	public WebElement getCalendarMonth() {

		wait.until(ExpectedConditions.visibilityOf(calendarMonth));
		return calendarMonth;

	}

	public WebElement getCalendarFutureDateDayTime() {

		wait.until(ExpectedConditions.visibilityOf(futureDaytimeStartDate));

		return futureDaytimeStartDate;

	}

	public WebElement getCalendarFutureDateProduct() {

		wait.until(ExpectedConditions.visibilityOf(futureProductStartDate));

		return futureProductStartDate;

	}

	public WebElement getCalendarFutureDateLocation() {

		wait.until(ExpectedConditions.visibilityOf(futureLocationStartDate));

		return futureLocationStartDate;

	}

	public String getFutureStartDate(String currentDate) {
		LocalDate date = LocalDate.parse(currentDate);

		// Increment the date by 1 month
		LocalDate futureDate = date.plusMonths(1);

		// Reset month to 1 and increment year if current month is December
		if (date.getMonthValue() == 12) {
			futureDate = futureDate.withMonth(1).plusYears(1);
		}

		String futureDateString = futureDate.toString();
		return futureDateString;

	}

	public void clickCalendar(String name) {
		switch (name) {
		case "Product":

			wait.until(ExpectedConditions.elementToBeClickable(calendar));
			calendar.click();
			break;
		case "Location":

			wait.until(ExpectedConditions.elementToBeClickable(calendarLocation));
			calendarLocation.click();
			break;
		case "DayTime":

			wait.until(ExpectedConditions.elementToBeClickable(calendarDayTime));
			calendarDayTime.click();
			break;
		}
	}

	public void chooseDate(int year, int month, int day, String name, String currentDate) {
		// Locate the calendar table element
		List<WebElement> links = driver.findElements(By.cssSelector("div.xdsoft_datetimepicker"));
		// Get the third link from the array using the get() method
		List<WebElement> dateCells = null;
		switch (name) {
		case "Product":
			dateCells = links.get(15).findElements(By.cssSelector("td"));

			break;
		case "Location":
			dateCells = links.get(17).findElements(By.cssSelector("td"));

			break;
		case "DayTime":
			dateCells = links.get(9).findElements(By.cssSelector("td"));

			break;
		default:
			throw new IllegalArgumentException("Invalid calendar name: " + name);
		}

		List<WebElement> eligibleDateCells = new ArrayList<>();

		// Iterate through each date cell and check for a match with the desired date
//		for (WebElement dateCell : dateCells) {
//			String dataYear = dateCell.getAttribute("data-year");
//			String dataMonth = dateCell.getAttribute("data-month");
//			String dataDate = dateCell.getAttribute("data-date");
//
//			int cellMonth = Integer.parseInt(dataMonth);
//			int cellDate = Integer.parseInt(dataDate);
//
//			if (cellMonth == month && cellDate > day) {
//				JavascriptExecutor js = (JavascriptExecutor) driver; // Replace 'driver' with your WebDriver instance
//
//				// Scroll to the element
//				js.executeScript("arguments[0].scrollIntoView(true);", dateCell);
//				Random random = new Random();
//			    int randomIndex = random.nextInt(eligibleDateCells.size());
//
//			    // Click on the randomly selected date cell
//			    WebElement randomDateCell = eligibleDateCells.get(randomIndex);
//				randomDateCell.click();
//				break;
//			}
//
//		}

	}
}
