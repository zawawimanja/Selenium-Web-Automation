package pages.cgp.pages.cgp.main.restriction;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ProductGroupsPage {
	WebDriver driver;
	WebDriverWait wait;
	@FindBy(id = "flip15")
    private WebElement ProductGroups;

    @FindBy(className = "btitle-class")
    private WebElement MaintainProductGroup;

    @FindBy(id = "btnProductGroupProductListDeleteGroup")
    private WebElement DeleteGroupButton;

    @FindBy(id = "btnProductGroupProductListAddtoGroup")
    private WebElement AddtoGroupButton;

    @FindBy(id = "btnProductGroupProductListAddProduct")
    private WebElement AddProductButton;

    @FindBy(id = "exportProductList")
    private WebElement exportButton;

    @FindBy(id = "btnProductGroupProductListNewGroup")
    private WebElement NewGroupButton;

    @FindBy(id = "btnProductGroupProductListRemoveProduct")
    private WebElement removeButton;

    @FindBy(id = "editProductGroupProductList")
    private WebElement saveButton;

    @FindBy(id = "selectProductGroupProductListGroup")
    private WebElement ProductGroupSelect;

    @FindBy(id = "textProductGroupProductListText")
    private WebElement GroupProductText;

    @FindBy(id = "selectProductGroupProductListProduct")
    private WebElement GroupListProductSelect;

    @FindBy(id = "ProductGroupProductListProductSingle")
    private WebElement selectDropDown;
	public ProductGroupsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	}
	public void getProductGroups() {


		wait.until(ExpectedConditions.visibilityOf(ProductGroups));
	}

	public void getMaintainProductGroup() {


		wait.until(ExpectedConditions.visibilityOf(MaintainProductGroup));
	}
	public void clickDeleteGroupButton() {


		wait.until(ExpectedConditions.elementToBeClickable(DeleteGroupButton)).click();

	}
	public void clickAddtoGroupButton() {


		wait.until(ExpectedConditions.elementToBeClickable(AddtoGroupButton)).click();
	}
	public void clickSave() {


		wait.until(ExpectedConditions.elementToBeClickable(saveButton)).click();
	}
	public void clickAddProductButton() {


		wait.until(ExpectedConditions.elementToBeClickable(AddProductButton)).click();
	}
	public void clickExportButton() {


		wait.until(ExpectedConditions.elementToBeClickable(exportButton)).click();
	}
	public void clickNewGroup() {

		wait.until(ExpectedConditions.elementToBeClickable(NewGroupButton)).click();
	}
	public void clickRemove() {


		wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();

	}
	public void getProductGroupSelect() {


		wait.until(ExpectedConditions.elementToBeClickable(ProductGroupSelect)).click();
	}
	public void setGroupProductText(String name) {


		wait.until(ExpectedConditions.elementToBeClickable(GroupProductText)).sendKeys(name);;
	}
	public void selectProductGroupName(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(ProductGroupSelect)));
		select.selectByVisibleText(name);
	}
	public void selectProductGroupAfter(String name) {
		Select select = new Select(wait.until(ExpectedConditions.visibilityOf(GroupListProductSelect)));
		select.selectByVisibleText(name);
	}
	public void selectProductGroup(String name) {
		Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOf(selectDropDown)));
		dropdown.selectByVisibleText(name);
	}
}
