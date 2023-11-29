package pageObjects.NopCommerce.User;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserWishListPageUI;

public class UserWishListPageObject extends BasePage {
	WebDriver driver;
	public UserWishListPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean verifyProductAddedToWishList(String productTitle) {
		int number = 0;
		waitForElementVisible(driver, UserWishListPageUI.PRODUCT_TITLE);
		 List<WebElement> allItems= getElements(driver,UserWishListPageUI.PRODUCT_TITLE);

        for (WebElement item: allItems)
        {
            if (item.getText().contains(productTitle))
            {
            	number = number + 1;
            }
        }
        if (number == 1)
        	return true;
        else return false;
	}
	public void clickToWishListLinkByLink(WebDriver driver2) {
		sleepInSecond(2);
		waitForElementClickable(driver, UserWishListPageUI.WISHLIST_LINK);
		clickToElement(driver, UserWishListPageUI.WISHLIST_LINK);
	}
	public String getPageTitle() {
		waitForElementVisible(driver, UserWishListPageUI.WISHLIST_PAGE_TITLE);
		return getElementText(driver, UserWishListPageUI.WISHLIST_PAGE_TITLE);
	}
	public void clickToAddToCartCheckbox(String productTitle) {
		sleepInSecond(2);
		waitForElementClickable(driver, UserWishListPageUI.ADD_TO_CART_CHECKBOX, productTitle);
		clickToElement(driver, UserWishListPageUI.ADD_TO_CART_CHECKBOX, productTitle );
	}
	public UserShoppingCartPageObject clickToAddToCartButton() {
		sleepInSecond(2);
		waitForElementClickable(driver, UserWishListPageUI.ADD_TO_CART_BUTTON);
		clickToElement(driver, UserWishListPageUI.ADD_TO_CART_BUTTON);
		sleepInSecond(2);
		return PageGeneratorManager.getUserShoppingCartPageObject(driver);
	}
	public boolean verifyProductRemovedToWishList(String productTitle) {
		int number = 0;
		waitForElementVisible(driver, UserWishListPageUI.WISHLIST_PAGE_TITLE);
		List<WebElement> allItems= getElements(driver,UserWishListPageUI.PRODUCT_TITLE);
		if (allItems.size() != 0)
		{
			for (WebElement item: allItems)
	        {
	            if (item.getText().contains(productTitle))
	            {
	            	number = number + 1;
	            }
	        }
	        if (number == 1)
	        	return false;
	        else return true;
		} else 
		{
			waitForElementVisible(driver, UserWishListPageUI.NO_DATA_MESSAGE);
			return isElementDisplayed(driver, UserWishListPageUI.NO_DATA_MESSAGE);
		}
	}
	public void clickToRemoveButton(String productTitle) {
		waitForElementClickable(driver, UserWishListPageUI.REMOVE_BUTTON, productTitle);
		clickToElement(driver, UserWishListPageUI.REMOVE_BUTTON, productTitle );
	}
}
