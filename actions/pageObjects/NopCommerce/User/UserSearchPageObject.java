package pageObjects.NopCommerce.User;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BasePage;
import pageUIsNopCommerceUser.UserSearchPageUI;

public class UserSearchPageObject extends BasePage{
	private WebDriver driver;
	public UserSearchPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver, UserSearchPageUI.SEARCH_BUTTON);
		clickToElement(driver, UserSearchPageUI.SEARCH_BUTTON);
	}
	public String getWarningMessageText() {
		waitForElementVisible(driver, UserSearchPageUI.WARNING_MESSAGE);
		return getElementText(driver, UserSearchPageUI.WARNING_MESSAGE );
	}
	public void enterToSearchTextbox(String string) {
		waitForElementVisible(driver, UserSearchPageUI.SEARCH_TEXTBOX);
		sendKeyToElement(driver, UserSearchPageUI.SEARCH_TEXTBOX, string);
	}
	public String getNoResultMessageText() {
		waitForElementVisible(driver, UserSearchPageUI.NO_RESULT_MESSAGE);
		return getElementText(driver, UserSearchPageUI.NO_RESULT_MESSAGE );
	}
	public int getNumberOfElement(String string) {
		int number = 0;
		waitForElementVisible(driver, UserSearchPageUI.PRODUCT_TITLE);
		 List<WebElement> allItems= getElements(driver,UserSearchPageUI.PRODUCT_TITLE);

        for (WebElement item: allItems)
        {
            if (item.getText().contains(string))
            {
            	number = number + 1;
            }
        }
		return number;
	}
	public void checkToAdvancedCheckbox() {
		waitForElementClickable(driver, UserSearchPageUI.ADVANCED_CHECKBOX);
		clickToElement(driver, UserSearchPageUI.ADVANCED_CHECKBOX);
	}
	public void selectItemInCategoryDropDown(String string) {
		waitForElementVisible(driver, UserSearchPageUI.CATEGORY_DROPDOWN);
		selectItemInDefaultDropDown(driver, UserSearchPageUI.CATEGORY_DROPDOWN, string);
	}
	public void checkToSubCategoriesCheckbox() {
		waitForElementClickable(driver, UserSearchPageUI.SUB_CATEGORIES_CHECKBOX);
		clickToElement(driver, UserSearchPageUI.SUB_CATEGORIES_CHECKBOX);
	}
	public void selectItemInManufacturerDropDown(String string) {
		waitForElementVisible(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN);
		selectIteminCustomDropdown(driver, UserSearchPageUI.MANUFACTURER_DROPDOWN, UserSearchPageUI.MANUFACTURER_DROPDOWN_OPTION, string);
	}
	
}
