package pages.cgp.pages.cgp.main.restriction;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
	WebDriver driver;
	WebDriverWait wait;

	@FindBy(id = "flip23")
	private WebElement productText;

	@FindBy(id = "current_product_exclude_include")
	private WebElement currentIncludeExclude;

	@FindBy(id = "cancelProductCurrent")
	private WebElement currentCancel;

	@FindBy(id = "deleteProductCurrent")
	private WebElement currentDelete;

	@FindBy(css = "input#editProductCurrent[value='Edit']")
	private WebElement currentEdit;

	@FindBy(css = "input#editProductCurrent[value='Save']")
	private WebElement currentSave;

	@FindBy(id = "current_product_alert_decline")
	private WebElement currentAlertList;

	@FindBy(id = "current_product_groups_list")
	private WebElement currentProductGroupsList;

	@FindBy(id = "current_product_group_templates")
	private WebElement currentProductGroupTemplate;

	@FindBy(id = "current_product_list")
	private WebElement currentProductList;

	@FindBy(id = "current_restrict_product_groups_add")
	private WebElement addProductGroupCurrent;

	@FindBy(id = "future_restrict_product_groups_add")
	private WebElement addProductGroupFuture;

	@FindBy(id = "current_product_groups_restrict_remove")
	private WebElement removeProductGroup;

	@FindBy(id = "current_restrict_product_add")
	private WebElement addProductButton;

	@FindBy(id = "current_product_restrict_remove")
	private WebElement removeProductButton;

	@FindBy(id = "current_product_groups_restrict_list")
	private WebElement currentProductGroupsRestrictList;

	@FindBy(id = "current_product_restrict_list")
	private WebElement currentProductRestrictList;

	@FindBy(id = "future_product_restrict_start_date")
	private WebElement futureStartDate;

	@FindBy(id = "future_product_restrict_start_time")
	private WebElement futureStartTime;

	@FindBy(id = "future_product_exclude_include")
	private WebElement futureIncludeExclude;

	@FindBy(id = "future_product_alert_decline")
	private WebElement futureAlertList;

	@FindBy(css = "input#editProductFuture[value='Edit']")
	private WebElement futureEdit;

	@FindBy(css = "input#editProductFuture[value='Save']")
	private WebElement futureSave;

	@FindBy(id = "deleteProductFuture")
	private WebElement futureDelete;

	@FindBy(id = "cancelProductFuture")
	private WebElement futureCancel;

	@FindBy(id = "future_product_groups_list")
	private WebElement futureProductGroupsList;

	@FindBy(id = "future_product_group_templates")
	private WebElement futureProductGroupTemplate;

	@FindBy(id = "future_product_list")
	private WebElement futureProductList;

	@FindBy(id = "future_restrict_product_groups_add")
	private WebElement futureAddProductGroup;

	@FindBy(id = "future_product_groups_restrict_remove")
	private WebElement futureRemoveProductGroup;

	@FindBy(id = "future_restrict_product_add")
	private WebElement futureAddProductButton;

	@FindBy(id = "future_product_restrict_remove")
	private WebElement futureRemoveProductButton;

	@FindBy(id = "future_product_groups_restrict_list")
	private WebElement futureProductGroupsRestrictList;

	@FindBy(id = "future_product_restrict_list")
	private WebElement futureProductRestrictList;

	@FindBy(id = "copy_from_current_product_restrict")
	private WebElement copyFromCurrent;

	@FindBy(id = "future_product_restrict_start_date")
	private WebElement calendarBy;

	@FindBy(id = "current_product_restrict_start_date")
	private WebElement currentProductStartDate;

	// Additional methods and functionality for your page object class

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));

	}

	public WebElement getCurrentStartDate() {

		return wait.until(ExpectedConditions.visibilityOf(currentProductStartDate));

	}

	public WebElement getProductText() {

		wait.until(ExpectedConditions.visibilityOf(productText));
		return productText;
	}

	public void clickAddProductGroupsCurrent() {

		wait.until(ExpectedConditions.elementToBeClickable(addProductGroupCurrent)).click();

	}

	public void clickAddProductGroupsFuture() {

		wait.until(ExpectedConditions.elementToBeClickable(addProductGroupFuture)).click();
		;
	}

	public void clickCalendar() {
		wait.until(ExpectedConditions.elementToBeClickable(calendarBy)).click();

	}

	public void clickAddProduct() {

		wait.until(ExpectedConditions.elementToBeClickable(addProductButton)).click();

	}

	public void clickFutureAddProductGroups() {

		wait.until(ExpectedConditions.elementToBeClickable(futureAddProductGroup)).click();

	}

	public void clickFutureAddProduct() {

		wait.until(ExpectedConditions.elementToBeClickable(futureAddProductButton)).click();

	}

	public void clickRemoveProductGroups() {

		wait.until(ExpectedConditions.elementToBeClickable(futureAddProductButton)).click();

	}

	public void clickRemoveProduct() {

		wait.until(ExpectedConditions.elementToBeClickable(futureAddProductButton)).click();

	}

	public void clickCurrentEdit() {

		wait.until(ExpectedConditions.elementToBeClickable(currentEdit)).click();

	}

	public void clickCurrentSave() {

		wait.until(ExpectedConditions.elementToBeClickable(currentSave)).click();
		;
	}

	public void clickCurrentCancel() {

		wait.until(ExpectedConditions.elementToBeClickable(currentCancel)).click();

	}

	public void clickCurrentDelete() {

		wait.until(ExpectedConditions.elementToBeClickable(currentDelete)).click();

	}

	public void clickCopyCurrent() {

		wait.until(ExpectedConditions.elementToBeClickable(copyFromCurrent)).click();

	}

	public void clickFutureEdit() {

		wait.until(ExpectedConditions.elementToBeClickable(futureEdit)).click();

	}

	public void clickFutureSave() {

		wait.until(ExpectedConditions.elementToBeClickable(futureSave)).click();

	}

	public void clickFutureCancel() {

		wait.until(ExpectedConditions.elementToBeClickable(futureCancel)).click();

	}

	public void clickFutureDelete() {

		wait.until(ExpectedConditions.elementToBeClickable(futureDelete)).click();

	}

	public void selectCurrentProductGroupList(String name) {

		wait.until(ExpectedConditions.visibilityOf(currentProductGroupsList));

		Select select = new Select(currentProductGroupsList);
		select.selectByVisibleText(name);

	}

	public void selectCurrentProductGroupTemplates(String name) {

		wait.until(ExpectedConditions.visibilityOf(currentProductGroupTemplate));

		Select select = new Select(currentProductGroupTemplate);
		select.selectByVisibleText(name);
	}

	public void selectCurrentProductGroupRestricList(String name) {

		wait.until(ExpectedConditions.visibilityOf(currentProductGroupsRestrictList));

		Select select = new Select(currentProductGroupsRestrictList);
		select.selectByVisibleText(name);
	}

	public void selectCurrentProduct(String name) {

		wait.until(ExpectedConditions.visibilityOf(currentProductList));

		Select select = new Select(currentProductList);
		select.selectByVisibleText(name);
	}

	public void selectCurrentProductRestricList(String name) {

		wait.until(ExpectedConditions.visibilityOf(currentProductRestrictList));

		Select select = new Select(currentProductRestrictList);
		select.selectByVisibleText(name);
	}

	//
	public void selectFutureProductGroupList(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureProductGroupsList));

		Select select = new Select(futureProductGroupsList);
		select.selectByVisibleText(name);
	}

	public void selectFutureProductGroupTemplates(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureProductGroupTemplate));

		Select select = new Select(futureProductGroupTemplate);
		select.selectByVisibleText(name);
	}

	public void selectFutureProductGroupRestricList(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureProductGroupsRestrictList));

		Select select = new Select(futureProductGroupsRestrictList);
		select.selectByVisibleText(name);
	}

	public void selectFutureProduct(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureProductList));

		Select select = new Select(futureProductList);
		select.selectByVisibleText(name);
	}

	public void selectFutureProductRestricList(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureProductRestrictList));

		Select select = new Select(futureProductRestrictList);
		select.selectByVisibleText(name);
	}

	public void selectAlertCurrent(String name) {

		wait.until(ExpectedConditions.visibilityOf(currentAlertList));

		Select select = new Select(currentAlertList);
		select.selectByVisibleText(name);
	}

	public void selectAlertFuture(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureAlertList));

		Select select = new Select(futureAlertList);
		select.selectByVisibleText(name);
	}

	public void setStartDateFuture(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureStartDate));

		Select select = new Select(futureStartDate);
		select.selectByVisibleText(name);
	}

	public void setStartTimeFuture(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureStartTime));

		Select select = new Select(futureStartTime);
		select.selectByVisibleText(name);
	}

	public void selectCurrentIncludeExclude(String name) {

		wait.until(ExpectedConditions.visibilityOf(currentIncludeExclude));

		Select select = new Select(currentIncludeExclude);
		select.selectByVisibleText(name);
	}

	public void selectFutureIncludeExclude(String name) {

		wait.until(ExpectedConditions.visibilityOf(futureIncludeExclude));

		Select select = new Select(futureIncludeExclude);
		select.selectByVisibleText(name);
	}

}
