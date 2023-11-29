package pageObjects.NopCommerce.User;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIsNopCommerceUser.UserComparePageUI;

public class UserComparePageObject extends BasePage{
	WebDriver driver;
	public UserComparePageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean verifyClearListButtonisDisplayed() {
		waitForElementVisible(driver, UserComparePageUI.CLEAR_BUTTON);
		return isElementDisplayed(driver, UserComparePageUI.CLEAR_BUTTON);
	}
	public boolean verifyRemoveButtonisDisplayed(String productTitle) {
		waitForElementVisible(driver,UserComparePageUI.PRODUCT_LIST);
		List<WebElement> allItems = getElements(driver,UserComparePageUI.PRODUCT_LIST);
		WebElement targetElement = getElement(driver, UserComparePageUI.PRODUCT_TITLE, productTitle);
		String index = Integer.toString(allItems.indexOf(targetElement)+1);
		
		waitForElementVisible(driver, UserComparePageUI.REMOVE_BUTTON, index);
		return isElementDisplayed(driver, UserComparePageUI.REMOVE_BUTTON, index);
	}
	public boolean verifyPriceisDisplayed(String productTitle) {
		waitForElementVisible(driver,UserComparePageUI.PRODUCT_LIST);
		List<WebElement> allItems = getElements(driver,UserComparePageUI.PRODUCT_LIST);
		WebElement targetElement = getElement(driver, UserComparePageUI.PRODUCT_TITLE, productTitle);
		String index = Integer.toString(allItems.indexOf(targetElement));
		
		waitForElementVisible(driver, UserComparePageUI.PRICE_TEXT, index);
		return isElementDisplayed(driver, UserComparePageUI.PRICE_TEXT, index);
	}
	public void clickToClearListButton() {
		waitForElementClickable(driver, UserComparePageUI.CLEAR_BUTTON);
		clickToElement(driver, UserComparePageUI.CLEAR_BUTTON);
	}
	public String getNoDataText() {
		waitForElementVisible(driver, UserComparePageUI.NO_DATA_TEXT);
		return getElementText(driver, UserComparePageUI.NO_DATA_TEXT);
	}
	public boolean verifyProductNameisUndisplayed(String productTitle) {
		waitForElementInVisible(driver, UserComparePageUI.PRODUCT_TITLE, productTitle);
		return isElementUndisplayed(driver, UserComparePageUI.PRODUCT_TITLE, productTitle);
	}

}
