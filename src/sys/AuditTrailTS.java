package sys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.cgp.CGPPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;
import pages.cgp.systemsettings.AuditTrailPage;
import pages.cgp.systemsettings.SystemSettingsPage;
public class AuditTrailTS  {
	MainPage mainPage;
	SpecialMessagePage specialMessagePage;
	WebDriver driver ;
	By RetrieveIssuerDropDown = By.id("main_search_issuer");
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\muhammadzawawi.manja\\Downloads\\chromedriver.exe");
    	ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		// Navigate to the website
		driver.get("https://cfgwtest.cgi.com:8085/CGPINT3/index.aspx");
		CGPPage cgpPage = new CGPPage(driver);
		// click system settings tab
		cgpPage.clickSystemSettings();
	}
	@Test
	public void test_AuditPageDisplay() throws InterruptedException {
		SystemSettingsPage systemSettingsPage = new SystemSettingsPage(driver);
		// click audit trail
		systemSettingsPage.clickAuditTrail();

		AuditTrailPage auditTrailPage = new AuditTrailPage(driver);
		// verify title
		//Assert.assertTrue(auditTrailPage.getAuditTrail("headerTitle").getText().contains("Audit Trail"));

		// verify sub title
		//Assert.assertTrue(auditTrailPage.getAuditTrail("headerSub").getText().contains("View Audit Trail"));
	}


}
