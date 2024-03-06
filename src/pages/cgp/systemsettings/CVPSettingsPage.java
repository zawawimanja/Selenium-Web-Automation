package pages.cgp.systemsettings;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class CVPSettingsPage {
	WebDriver driver;
	WebDriverWait wait;
	 @FindBy(id = "tblCVPCountryIssuerList")
	    private WebElement issuerCountryListBy;

	    @FindBy(id = "editSaveCVPCountrySetting")
	    private WebElement editSaveCVPCountrySettingBtn;

	    @FindBy(id = "cancelCVPIssuerCountrySetting")
	    private WebElement cancelCVPCountrySettingBtn;

	    @FindBy(id = "editSaveCVPDisplayName")
	    private WebElement editSaveCVPDisplayNameBtn;

	    @FindBy(id = "editSaveCVPNetworkSetting")
	    private WebElement editSaveCVPNetworkSettingBtn;

	    @FindBy(id = "cancelCVPNetworkSetting")
	    private WebElement cancelCVPNetworkSettingBtn;

	    @FindBy(id = "cvp_issuer_country_available_loyalty_countries")
	    private WebElement AvalaibleCountries;

	    @FindBy(id = "cvp_issuer_country_selected_loyalty_countries")
	    private WebElement SelectedCountries;

	    @FindBy(id = "cvp_available_national_issuers")
	    private WebElement AvalaibleNationalIssuers;

	    @FindBy(id = "cvp_selected_national_issuers")
	    private WebElement SelectedNationalIssuers;

	    @FindBy(id = "cvp_available_releaseCodeIssueCountries")
	    private WebElement AvalaibleReleaseCodeIssueCountries;

	    @FindBy(id = "cvp_selected_releaseCodeIssueCountries")
	    private WebElement selectedreleaseCodeIssueCountries;

	    @FindBy(id = "addLoyaltyCountries")
	    private WebElement addLoyaltyCountries;

	    @FindBy(id = "removeLoyaltyCountries")
	    private WebElement removeLoyaltyCountries;

	    @FindBy(id = "addNationalIssuers")
	    private WebElement addNationalIssuers;

	    @FindBy(id = "removeNationalIssuers")
	    private WebElement removeNationalIssuers;

	    @FindBy(id = "addReleaseCodeIssueCountries")
	    private WebElement addReleaseCodeIssueCountries;

	    @FindBy(id = "removeReleaseCodeIssueCountries")
	    private WebElement removeReleaseCodeIssueCountries;

	    @FindBy(id = "CVPAcceptanceNetworks_releaseCode")
	    private WebElement CVPAcceptanceNetworksreleaseCode;

	    @FindBy(id = "CVPDisplayNameText")
	    private WebElement CVPDisplayNameInput;

	public void selectFutureProduct(String name) {
		Select select = new Select(	wait.until(ExpectedConditions.visibilityOf(issuerCountryListBy)));

		select.selectByVisibleText(name);
	}
	public CVPSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}
	public void clickEditSaveCVPCountrySetting() {

		wait.until(ExpectedConditions.elementToBeClickable(editSaveCVPCountrySettingBtn)).click();
	}
	public void clickCancelCVPCountrySetting() {


		wait.until(ExpectedConditions.elementToBeClickable(cancelCVPCountrySettingBtn)).click();
	}
	public void clickEditSaveCVPDisplayName() {


		wait.until(ExpectedConditions.elementToBeClickable(editSaveCVPDisplayNameBtn)).click();
	}
	public void clickEditSaveCVPNetworkSetting() {


		wait.until(ExpectedConditions.elementToBeClickable(editSaveCVPNetworkSettingBtn)).click();
	}
	public void clickCancelCVPNetworkSetting() {


		wait.until(ExpectedConditions.elementToBeClickable(cancelCVPNetworkSettingBtn)).click();
	}
	public void clickDwnld() {

		wait.until(ExpectedConditions.elementToBeClickable(cancelCVPNetworkSettingBtn)).click();
	}
	public void selectReleaseCodeIssuingCountry(String name) {
		Select dropdown = new Select(	wait.until(ExpectedConditions.visibilityOf(CVPAcceptanceNetworksreleaseCode)));
		dropdown.selectByVisibleText(name);
	}
	public void selectNationalIssuing(String name) {
		Select select = new Select(	wait.until(ExpectedConditions.visibilityOf(AvalaibleNationalIssuers)));
		select.selectByVisibleText(name);
	}
	public void addNationalIssuers() {

		wait.until(ExpectedConditions.elementToBeClickable(addNationalIssuers)).click();
	}
	public void removeNationalIssuers() {

		wait.until(ExpectedConditions.elementToBeClickable(removeNationalIssuers)).click();
	}
	public void addIssuingCountry() {

		wait.until(ExpectedConditions.elementToBeClickable(addNationalIssuers)).click();
	}
	public void removeIssuingCountry() {

		wait.until(ExpectedConditions.elementToBeClickable(removeNationalIssuers)).click();
	}
	public void setCVPDisplayName(String name) {
		wait.until(ExpectedConditions.visibilityOf(CVPDisplayNameInput)).sendKeys();
	}
}
