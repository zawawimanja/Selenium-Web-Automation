package pages.practice;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.cgp.pages.cgp.main.AccountPage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;
public class Priority_In_testNG {
    AccountPage accountPage;
	MainPage mainPage;
	WebDriver driver;
	SpecialMessagePage specialMessagePage;
	By RetrieveIssuerDropDown = By.id("main_search_issuer");
    // Method 1: Open Browser say Firefox
    @BeforeTest
    public void openBrowser() throws InterruptedException {
    	WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable notifications");
		DesiredCapabilities cp = new DesiredCapabilities();
		cp.setCapability(ChromeOptions.CAPABILITY, options);
		options.merge(cp);
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
//		driver.get("https://cfgwtest.cgi.com:8085/CGPINT3/index.aspx");
//		CGPPage cgpPage = new CGPPage(driver);
//		cgpPage.clickMain();
//		driver.get("https://www.guru99.com/");
//
//		driver.findElement(By.xpath("//*[@id=\"java_technologies\"]/li[3]/a")).click();
		Thread.sleep(5000);

		//ChromeOptions options=new ChromeOptions();
		//options.addArguments("headless");
		driver=new ChromeDriver(options);
		driver.get("https://www.browserstack.com/");

		Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
		driver.quit();
		}
    }
//	@Test (priority=1)
//	public void test_AccountBlockUnBlock() throws InterruptedException {
//		SearchPage search = new SearchPage(driver);
//		// set account
//		search.setAccount("00000005");
//		// click retrieve account
//		search.clickRetrieverAccount();
//		// go to next page
//		mainPage = new MainPage(driver);
//		// elements not interactable
//		Thread.sleep(5000);
//		accountPage = new AccountPage(driver);
//		for (int i = 0; i < 2; i++) {
//			// click block/unblock account
//			accountPage.clickBlockUnBlockAccount();
//			// click ok
//			Thread.sleep(3000);
//			driver.switchTo().alert().accept();
//			// click ok
//			Thread.sleep(3000);
//			driver.switchTo().alert().accept();
//			boolean unblockAcc = accountPage.getAccountStatus().getText().trim().contains("Status: Active");
//			boolean blockAcc = accountPage.getAccountStatus().getText().trim().contains("Status: Account blocked");
//			if (unblockAcc == true) {
//				Assert.assertTrue(unblockAcc);
//			} else {
//				Assert.assertTrue(blockAcc);
//			}
//		}
//	}
//    @Test (priority=1)
//	public void test_SystematicAlert() throws InterruptedException {
//		accountPage = new AccountPage(driver);
//		String sysAlert[] = { "Yes", "No" };
//		for (int i = 0; i < sysAlert.length; i++) {
//			// select enable
//			accountPage.selectSystemAlertAccount(sysAlert[i]);
//			// click save
//			accountPage.clickSaveBtn();
//			Thread.sleep(3000);
//			// click ok
//			driver.switchTo().alert().accept();
//			boolean sysAlertYes = accountPage.getSelectedDropDown().getText().trim().contains("Yes");
//			boolean sysAlertNo = accountPage.getSelectedDropDown().getText().trim().contains("No");
//			boolean sysAlertInherit = accountPage.getSelectedDropDown().getText().trim()
//					.contains("Inherit from account");
//			if (sysAlertYes == true) {
//				Assert.assertTrue(sysAlertYes);
//			}
//			else if (sysAlertNo == true) {
//				Assert.assertTrue(sysAlertNo);
//			} else {
//				Assert.assertTrue(sysAlertInherit);
//			}
//		}
//	}
//   @Test (priority=2)
//	public void test_AccountBlockUnBlock1() throws InterruptedException {
//
//	   openBrowser();
//
//	   .println(driver.findElement(By.id("flip5")).getText().toLowerCase().trim());
//
//		Assert.assertTrue(driver.findElement(By.id("flip5")).getText().toLowerCase().trim().contains("retrieve profile by account"));
//
//
//		SearchPage search = new SearchPage(driver);
//
//		// set account
//		search.setAccount("00000005");
//
//		// click retrieve account
//		search.clickRetrieverAccount();
//
//		// go to next page
//		mainPage = new MainPage(driver);
//
//		// elements not interactable
//		Thread.sleep(5000);
//
//		accountPage = new AccountPage(driver);
//
//
//
//	}
//
//   @Test (priority=2)
//	public void test_AccountBlockUnBlock() throws InterruptedException {
//
//	   openBrowser();
//
//	   .println(driver.findElement(By.id("flip5-1")).getText().toLowerCase().trim());
//
//		Assert.assertTrue(driver.findElement(By.id("flip5-1")).getText().toLowerCase().trim().contains("retrieve profile by customer"));
//
//
//		SearchPage search = new SearchPage(driver);
//
//		// set account
//		search.setAccount("00000005");
//
//		// click retrieve account
//		search.clickRetrieverAccount();
//
//		// go to next page
//		mainPage = new MainPage(driver);
//
//		// elements not interactable
//		Thread.sleep(5000);
//
//		accountPage = new AccountPage(driver);
//
//
//	}
    // Method 2: Launch Google.com
//    @Test (priority=2)
//    public void launchGoogle() throws InterruptedException {
//    	Assert.assertTrue(driver.findElement(By.className("entry-title")).getText().toLowerCase().contains("selenium tutorial"));
//    }
//
//    @Test (priority=2)
//    public void launchGoogle1() throws InterruptedException {
//    	Assert.assertTrue(driver.findElement(By.className("entry-date")).getText().toLowerCase().contains("march 4, 2023"));
//    }
    // Method 3: Perform a search using "Facebook"
//    @Test (priority=3)
//    public void peformSeachAndClick1stLink() {
//        driver.findElement(By.xpath(".//*[@title='Search']")).sendKeys("Facebook");
//    }
//
//    // Method 4: Verify Google search page title.
//    @Test (priority=4)
//    public void FaceBookPageTitleVerification() throws Exception {
//        driver.findElement(By.xpath(".//*[@value='Search']")).click();
//        Thread.sleep(3000);
//        Assert.assertEquals(driver.getTitle().contains("Facebook - Google Search"), true);
//    }
