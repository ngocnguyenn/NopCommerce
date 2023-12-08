package pageObjects.NopCommerce.Admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceAdmin.AdminProductPageUI;

public class AdminProductsPageObject extends BasePage {
	WebDriver driver;
	public AdminProductsPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void enterToProductNameTextbox(String productName) {
		waitForElementVisible(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX);
		sendKeyToElement(driver, AdminProductPageUI.PRODUCT_NAME_TEXTBOX, productName);
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminProductPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductPageUI.SEARCH_BUTTON);
		sleepInSecond(3);
	}
	public int getNumberOfElement(String string) {
		int number = 0;
		List<WebElement> allItems= getElements(driver, AdminProductPageUI.PRODUCT_NAME, string);
		number = allItems.size();
		return number;
	}
	public void selectItemInCategoryDropDownByItem(String string) {
		waitForElementVisible(driver, AdminProductPageUI.CATEGORY_DROPDOWN);
		selectIteminCustomDropdown(driver, AdminProductPageUI.CATEGORY_DROPDOWN, AdminProductPageUI.CATEGORY_OPTION, string);
	}
	public void uncheckToSubCategoriesCheckbox() {
		waitForElementClickable(driver, AdminProductPageUI.SUBCATEGORIES_CHECKBOX);
		uncheckToDefaultCheckbox(driver, AdminProductPageUI.SUBCATEGORIES_CHECKBOX);
	}
	public String getNoDataMessageText() {
		waitForElementVisible(driver, AdminProductPageUI.NO_DATA_MESSAGE);
		return getElementText(driver, AdminProductPageUI.NO_DATA_MESSAGE);
	}
	public void checkToSubCategoriesCheckbox() {
		waitForElementClickable(driver, AdminProductPageUI.SUBCATEGORIES_CHECKBOX);
		checkToDefaultCheckboxRadio(driver, AdminProductPageUI.SUBCATEGORIES_CHECKBOX);
	}
	public void selectItemInManufacturerDropDownByItem(String string) {
		waitForElementVisible(driver, AdminProductPageUI.MANUFACTURER_DROPDOWN);
		selectIteminCustomDropdown(driver, AdminProductPageUI.MANUFACTURER_DROPDOWN, AdminProductPageUI.MANUFACTURER_OPTION, string);
	}
	public void enterToSKUTextbox(String string) {
		waitForElementVisible(driver, AdminProductPageUI.SKU_TEXTBOX);
		sendKeyToElement(driver, AdminProductPageUI.SKU_TEXTBOX, string);
	}
	public AdminProductDetailPageObject clickToGoButton(WebDriver driver) {
		waitForElementClickable(driver, AdminProductPageUI.GO_BUTTON);
		clickToElement(driver, AdminProductPageUI.GO_BUTTON);
		return PageGeneratorManager.getAdminProductDetailPageObject(driver);
	}

}
