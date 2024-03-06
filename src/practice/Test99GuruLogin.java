package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class Test99GuruLogin {

	WebDriver driver;



	@Test(priority = 0)
	public void setup() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\muhammadzawawi.manja\\Downloads\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("http://amazon.com");
		Thread.sleep(2000);
		// Type in “laptop” in the search text box
		WebElement searchTextBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTextBox.sendKeys("laptop");
		// Click on “Search” button
		Thread.sleep(2000);
		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
		searchButton.click();
		// Click on the first result
		// Upon page loaded, assert that the laptop price is more than $100.

	}
	/**
	 *
	 * This test case will login in http://demo.guru99.com/V4/
	 *
	 * Verify login page title as guru99 bank
	 *
	 * Login to application
	 *
	 * Verify the home page using Dashboard message
	 *
	 * @throws InterruptedException
	 *
	 */
//	  @Test(priority=0)
//	    public void test_Home_Page_Appear_Correct(){
//	        //Create Login Page object
//	    objLogin = new Guru99Login(driver);
//	    //Verify login page title
//	    String loginPageTitle = objLogin.getLoginTitle();
//	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
//	    //login to application
//	    objLogin.loginToGuru99("mgr123", "mgr!23");
//	    // go the next page
//	    objHomePage = new Guru99HomePage(driver);
//	    //Verify home page
//	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
//	    objHomePage.clickAccept();
//	    }
//	 // @Test(priority=0)
//	    public void test_Home_Page1_Appear_Correct(){
//	        //Create Login Page object
//	    objLogin = new Guru99Login(driver);
//	    //Verify login page title
//	    String loginPageTitle = objLogin.getLoginTitle();
//	    Assert.assertTrue(loginPageTitle.toLowerCase().contains("guru99 bank"));
//	    //login to application
//	    objLogin.loginToGuru99("mgr123", "mgr!23");
//	    // go the next page
//	    objHomePage = new Guru99HomePage(driver);
//	    //Verify home page
//	    Assert.assertTrue(objHomePage.getHomePageDashboardUserName1().toLowerCase().contains("Welcome To Manager's Page of Guru99 Bank"));
//	    }
}