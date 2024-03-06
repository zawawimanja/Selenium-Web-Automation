package component;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Time {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "future_product_restrict_start_time")
	private WebElement timeProduct;

	By timeVariant = By.cssSelector("div.xdsoft_time_variant div");

	@FindBy(id = "future_daytime_restrict_start_time")
	private WebElement timeDayTime;

	@FindBy(id = "future_location_restrict_start_time")
	private WebElement timeLocation;

	// @FindBy(className = "xdsoft_next")
	// private WebElement next;

	@FindBy(css = ".xdsoft_prev")
	private WebElement previous;

	@FindBy(css = ".xdsoft_label.xdsoft_year")
	private WebElement year;

	@FindBy(css = ".xdsoft_label.xdsoft_month")
	private WebElement month;

	public Time(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	}

	public WebElement getTime(String name) {
		List<WebElement> links = driver.findElements(By.cssSelector("div.xdsoft_time_variant"));
		switch (name) {
		case "Product":

			return wait.until(ExpectedConditions.visibilityOf(links.get(16)));
		case "Location":
			return wait.until(ExpectedConditions.visibilityOf(links.get(18)));
		case "DayTime":
			return wait.until(ExpectedConditions.visibilityOf(links.get(10)));
		default:
			throw new IllegalArgumentException("Invalid calendar name: " + name);
		}
	}

	public void clickPrevious() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		wait.until(ExpectedConditions.elementToBeClickable(previous));
		previous.click();
	}

	public void clickTime(String name) {
		switch (name) {
		case "Product":

			wait.until(ExpectedConditions.elementToBeClickable(timeProduct));
			timeProduct.click();
			break;
		case "Location":

			wait.until(ExpectedConditions.elementToBeClickable(timeLocation));
			timeLocation.click();
			break;
		case "DayTime":

			wait.until(ExpectedConditions.elementToBeClickable(timeDayTime));
			timeDayTime.click();
			break;
		default:
			throw new IllegalArgumentException("Invalid calendar name: " + name);
		}
	}

	public WebElement getTimeElement(String time) {
		WebElement timeElement = null;

		List<WebElement> timeCells = driver.findElements(timeVariant);
		for (WebElement cell : timeCells) {
			if (cell.getText().equals(time)) {
				timeElement = cell;
				timeElement.click();
				break;
			}
		}
		return timeElement;
	}
}
