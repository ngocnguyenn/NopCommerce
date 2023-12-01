package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserProductDetailPageUI;

public class UserProductDetailPageObject extends BasePage{
	private WebDriver driver;
	public UserProductDetailPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public UserProductReviewPageObject clickToAddReviewLink() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
		clickToElement(driver, UserProductDetailPageUI.ADD_REVIEW_LINK);
		return PageGeneratorManager.getUserProductReviewPageObject(driver);
	}
	public UserWishListPageObject clickToAddWishListButton() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_WISHLIST_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.ADD_WISHLIST_BUTTON);
		return PageGeneratorManager.getUserWishListPageObject(driver);
	}
	public void selectItemInDynamicDropDownByText(String dynamicValue, String text) {
		waitForElementClickable(driver, UserProductDetailPageUI.DYNAMIC_DROPDOWN, dynamicValue);
		selectIteminCustomDropdown(driver, UserProductDetailPageUI.DYNAMIC_DROPDOWN, UserProductDetailPageUI.DYNAMIC_DROPDOWN_OPTION, text, dynamicValue);
	}
	public void selectItemByText(String text) {
		waitForElementClickable(driver, UserProductDetailPageUI.DYNAMIC_INPUT, text);
		clickToElement(driver, UserProductDetailPageUI.DYNAMIC_INPUT, text);
		sleepInSecond(3);
	}
	public void clickToAddToCartButton() {
		waitForElementClickable(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserProductDetailPageUI.ADD_TO_CART_BUTTON);
	}
	public String getPriceText() {
		sleepInSecond(2);
		waitForElementVisible(driver, UserProductDetailPageUI.PRICE_TEXT);
		return getElementText(driver, UserProductDetailPageUI.PRICE_TEXT);
	}
	public int getProductQuantity(String attribute) {
		waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_QUANTITY);
		return Integer.valueOf(getElementAttribute(driver, UserProductDetailPageUI.PRODUCT_QUANTITY, attribute));
	}
	public void unSelectItemByText(String text) {
		waitForElementClickable(driver, UserProductDetailPageUI.DYNAMIC_INPUT, text);
		uncheckToDefaultCheckbox(driver, UserProductDetailPageUI.DYNAMIC_INPUT, text);
	}
	public void enterToProductQuantity(String quantity) {
		waitForElementVisible(driver, UserProductDetailPageUI.PRODUCT_QUANTITY);
		sendKeyToElement(driver, UserProductDetailPageUI.PRODUCT_QUANTITY, quantity);
	}

}
