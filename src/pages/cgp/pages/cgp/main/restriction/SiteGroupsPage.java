package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteGroupsPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "flip15")
	private WebElement productGroups;

	@FindBy(className = "btitle-class")
	private WebElement maintainProductGroup;

	@FindBy(id = "btnSiteGroupSiteListAddSite")
	private WebElement addButton;

	@FindBy(id = "btnSiteGroupSiteListAddtoGroup")
	private WebElement addToGroupButton;

	@FindBy(id = "btnProductGroupProductListAddProduct")
	private WebElement addProductButton;

	@FindBy(id = "exportshellsitegroup")
	private WebElement exportButton;

	@FindBy(css = "input#editThirdPartySiteGroupSiteList[value='Edit']")
	private WebElement edit3rdButton;

	@FindBy(css = "input#editThirdPartySiteGroupSiteList[value='Save']")
	private WebElement save3rdButton;

	@FindBy(id = "editSiteGroupSiteList")
	private WebElement editSaveButton;

	@FindBy(id = "exportthirdpartysitegroup")
	private WebElement export3rdPartyButton;

	@FindBy(id = "btnSiteGroupSiteListDeleteGroup")
	private WebElement deleteGroupButton;

	@FindBy(id = "btnSiteGroupSiteListNewGroup")
	private WebElement newGroupButton;

	@FindBy(id = "btnThirdPartySiteGroupSiteListAddtoGroup")
	private WebElement addToGroup3rdButton;

	@FindBy(id = "btnThirdPartySiteGroupSiteListAddSite")
	private WebElement addProduct3rdButton;

	@FindBy(id = "btnThirdPartySiteGroupSiteListDeleteGroup")
	private WebElement deleteGroup3rdPartyButton;

	@FindBy(id = "btnThirdPartySiteGroupSiteListNewGroup")
	private WebElement newGroup3rdPartyButton;

	@FindBy(id = "btnSiteGroupSiteListRemoveSite")
	private WebElement removeButton;

	@FindBy(id = "btnThirdPartySiteGroupSiteListRemoveSite")
	private WebElement remove3rdPartyButton;

	@FindBy(id = "txtSiteGroupSiteListAddSite")
	private WebElement inputShellGroup;

	@FindBy(id = "textSiteGroupSiteListText")
	private WebElement inputShellGroupName;

	@FindBy(id = "textThirdPartySiteGroupSiteListText")
	private WebElement input3rdPartyGroupName;

	@FindBy(id = "textProductGroupProductListText")
	private WebElement groupProductText;

	@FindBy(id = "selectSiteGroupSiteListSite")
	private WebElement shellGroupList;

	@FindBy(id = "selectSiteGroupSiteListGroup")
	private WebElement shellGroup;

	@FindBy(id = "selectSiteGroupSiteListSite")
	private WebElement shellSiteList;

	@FindBy(id = "txtThirdPartySiteGroupSiteListAddSite")
	private WebElement thirdPartySiteGroupListAddSite;

	@FindBy(id = "textProductGroupProductListText")
	private WebElement thirdPartyGroupNameInput;

	@FindBy(id = "selectThirdPartySiteGroupSiteListSite")
	private WebElement thirdPartySiteGroupSiteListSite;

	@FindBy(id = "selectThirdPartySiteGroupSiteListGroup")
	private WebElement thirdPartySiteGroupSiteListGroup;

	@FindBy(id = "ProductGroupProductListProductSingle")
	private WebElement selectDropDown;

	public SiteGroupsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}

	public void clickDeleteGroupButton() {

		wait.until(ExpectedConditions.elementToBeClickable(deleteGroupButton)).click();

	}

	public void clickDelete3rdPartyButton() {

		wait.until(ExpectedConditions.elementToBeClickable(deleteGroup3rdPartyButton)).click();

	}

	public void clickEdit3rdButton() {

		wait.until(ExpectedConditions.elementToBeClickable(edit3rdButton)).click();

	}

	public void clickSave3rdButton() {

		wait.until(ExpectedConditions.elementToBeClickable(save3rdButton)).click();

	}

	public void clickEditSaveButton() {

		wait.until(ExpectedConditions.elementToBeClickable(editSaveButton)).click();

	}

	public void clickAddtoGroupButton() {

		wait.until(ExpectedConditions.elementToBeClickable(addToGroupButton)).click();

	}

	public void clickAddtoGroup3rdButton() {

		wait.until(ExpectedConditions.elementToBeClickable(addToGroup3rdButton)).click();
	}

	public void clickAddButton() {

		wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
	}

	public void clickAdd3rdButton() {

		wait.until(ExpectedConditions.elementToBeClickable(addProduct3rdButton)).click();
	}

	public void clickExportButtonShell() {

		wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();
	}

	public void clickExportButton3rdParty() {

		wait.until(ExpectedConditions.elementToBeClickable(export3rdPartyButton)).click();
	}

	public void clickNewGroupShellSite() {

		wait.until(ExpectedConditions.elementToBeClickable(newGroupButton)).click();
	}

	public void clickNewGroup3rdPartySiteGroup() {

		wait.until(ExpectedConditions.elementToBeClickable(newGroup3rdPartyButton)).click();
	}

	public void clickRemove() {

		wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
	}

	public void clickRemove3rdParty() {

		wait.until(ExpectedConditions.elementToBeClickable(remove3rdPartyButton)).click();
	}

	public void setGroupName(String name) {

		wait.until(ExpectedConditions.elementToBeClickable(inputShellGroupName)).sendKeys(name);

	}

	public void setGroupName3rd(String name) {

		wait.until(ExpectedConditions.elementToBeClickable(input3rdPartyGroupName)).sendKeys(name);
	}

	public void setThirdPartySiteGroup(String name) {

		wait.until(ExpectedConditions.elementToBeClickable(thirdPartySiteGroupListAddSite)).sendKeys(name);
	}

	public void setGroupText(String name) {

		wait.until(ExpectedConditions.elementToBeClickable(inputShellGroup)).sendKeys(name);

	}

	public void selectSiteGroup(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(shellGroup)));
		select.selectByVisibleText(name);
	}

	public void selectSiteGroupList(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(shellSiteList)));
		select.selectByVisibleText(name);
	}

	public void select3rdPartySiteGroup(String name) {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(thirdPartySiteGroupSiteListGroup)));
		select.selectByVisibleText(name);
	}

	public void select3rdPartySiteList(String name) {

		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(thirdPartySiteGroupSiteListSite)));
		select.selectByVisibleText(name);
	}

	public void selectShellGroup(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(shellGroup)));
		select.selectByVisibleText(name);
	}

	public void selectShellGroupList(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(shellGroupList)));
		select.selectByVisibleText(name);
	}

	public void addSiteShell(String name) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(selectDropDown)));
		dropdown.selectByVisibleText(name);
	}
}
