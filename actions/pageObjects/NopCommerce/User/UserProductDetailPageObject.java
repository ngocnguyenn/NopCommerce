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

}
