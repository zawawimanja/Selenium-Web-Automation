package component;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import pages.cgp.CGPPage;

public class Base {
    protected WebDriver driver;

    @BeforeTest
    public void setUp() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\muhammadzawawi.manja\\Downloads\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");

		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		 driver.manage().window().maximize();
		// Navigate to the website
		driver.get("https://cfgwtest.cgi.com:8085/CGPINT3/index.aspx");
		CGPPage cgpPage = new CGPPage(driver);
		cgpPage.clickMain();
    }

	@AfterTest
	public void quit() {
		driver.quit();
	}


}