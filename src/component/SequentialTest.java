package component;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class SequentialTest {
	protected static WebDriver driver;

	public SequentialTest(WebDriver driver) {

		this.driver = driver;
	}

	@AfterMethod
	public void afterMethod() {
		if (driver != null) {
			driver.quit();
		}
	}

}
