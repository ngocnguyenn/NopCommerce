package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceUser.UserRecentlyViewProductsPageUI;

public class UserRecentlyViewProductsPageObject extends BasePage{
	WebDriver driver;
	public UserRecentlyViewProductsPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean verifyProductNameisUndisplayed(String productTitle) {
		waitForElementInVisible(driver, UserRecentlyViewProductsPageUI.PRODUCT_TITLE, productTitle);
		return isElementUndisplayed(driver, UserRecentlyViewProductsPageUI.PRODUCT_TITLE, productTitle);
	}
	public boolean verifyProductNameisDisplayed(String productTitle) {
		waitForElementVisible(driver, UserRecentlyViewProductsPageUI.PRODUCT_TITLE, productTitle);
		return isElementDisplayed(driver, UserRecentlyViewProductsPageUI.PRODUCT_TITLE, productTitle);
	}

}
