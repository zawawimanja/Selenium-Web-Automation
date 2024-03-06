package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test99GuruLogin2 {

	private static WebDriver driver;
	By searchTextBox = By.id("twotabsearchtextbox");
	By searchButton = By.id("nav-search-submit-button");


	public static void main() {
		setup();
		performAmazonSearch("laptop");
		 checkLaptopPriceGreaterThan100();
	}

	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\muhammadzawawi.manja\\Downloads\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://amazon.com");
	}

	public void performAmazonSearch(String searchText) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("twotabsearchtextbox")));

		WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextBox.sendKeys(searchText);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-search-submit-button")));

		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();

		// Wait for the results page to visible
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".s-result-list")));

		// Click on the first result
		WebElement firstResult = driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"))
				.get(0);

		firstResult.click();
	}

	public void checkLaptopPriceGreaterThan100() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".a-offscreen"))).get(10);
		WebElement priceElement = driver.findElements(By.cssSelector(".a-offscreen")).get(10);

		// Wait for the product price element to be visible

		// Get the price text and convert it to a numeric value (remove "$" and parse)
		String priceText = priceElement.getText().replace("$", "");
		System.out.println(priceText);
		double price = Double.parseDouble(priceText);

		// Assert that the laptop price is more than $100
		if (price > 100) {
			System.out.println("The laptop price is greater than $100.");
		} else {
			System.out.println("The laptop price is not greater than $100.");
		}
	}

}
