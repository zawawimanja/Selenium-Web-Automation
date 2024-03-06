package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import component.Base;
import pages.cgp.pages.cgp.main.CardBundlePage;
import pages.cgp.pages.cgp.main.LeftSidePage;
import pages.cgp.pages.cgp.main.MainPage;
import pages.cgp.pages.cgp.main.SearchPage;
import pages.cgp.pages.cgp.main.restriction.SpecialMessagePage;

public class SearchTs extends Base {
	MainPage mainPage;
	SpecialMessagePage specialMessagePage;

	By RetrieveIssuerDropDown = By.id("main_search_issuer");
	CardBundlePage cardBundlePage;

	@Test
	public void test_SpecialMessagesPageDisplay() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		// click retrieve issuer
		search.clickRetrieveIssuer();
		// go to next page
		mainPage = new MainPage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight);");

		// verify special message tabs
		Assert.assertTrue(mainPage.getSpecialMessagesTab().getText().contains("Special Messages"));

		// go to next page
		mainPage.getSpecialMessagesTab().click();
		specialMessagePage = new SpecialMessagePage(driver);
		// verify special message page
		Assert.assertTrue(specialMessagePage.getMarketingMessage().getText().contains("Marketing Message"));
	}

	@Test(priority = 1)
	public void test_BackLink() throws InterruptedException {
		SearchPage search = new SearchPage(driver);
		LeftSidePage leftSidePage = new LeftSidePage(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Assert.assertTrue(leftSidePage.BackToMainLink().isDisplayed());
		leftSidePage.BackToMainLink().click();
		// temporary because using list web element cannot use wait.
		Assert.assertTrue(leftSidePage.BackToSearchLink().isDisplayed());
		leftSidePage.BackToSearchLink().click();

		Assert.assertTrue(search.getCountry().getText().contains("Retrieve Profile by Country/Issuer"));
	}

}
