package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public UserRegisterPageObject clickToRegisterLink()
	{
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPageObject(driver);
	}
	public UserLoginPageObject clickToLoginLink() {
		waitForElementClickable(driver, UserHomePageUI.LOGIN_LINK);
		clickToElement(driver, UserHomePageUI.LOGIN_LINK);
		return PageGeneratorManager.getUserLoginPageObject(driver);
	}
	public boolean myAccountLinkIsDisplayed() {
		waitForElementVisible(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver,UserHomePageUI.MY_ACCOUNT_LINK);
	}
	public UserCustomerInforPageObject clickToMyAccountLink() {
		waitForElementClickable(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUI.MY_ACCOUNT_LINK);
		return PageGeneratorManager.getUserCustomerInforPageObject(driver);
	}
	public UserProductDetailPageObject clickToProductByName(String productName) {
		scrollToElementOnDown(driver,UserHomePageUI.PRODUCT_DETAIL_LINK, productName);
		waitForElementClickable(driver, UserHomePageUI.PRODUCT_DETAIL_LINK, productName);
		clickToElement(driver, UserHomePageUI.PRODUCT_DETAIL_LINK, productName);
		return PageGeneratorManager.getUserProductDetailPageObject(driver);
	}
	public UserSearchPageObject clickToSearchLink() {
		waitForElementClickable(driver, UserHomePageUI.SEARCH_LINK);
		clickToElement(driver, UserHomePageUI.SEARCH_LINK);
		return PageGeneratorManager.getUserSearchPageObject(driver);
	}
	public UserListComputerPageObject clickToComputerLink() {
		waitForElementClickable(driver, UserHomePageUI.MENU_COMPUTER_LINK);
		clickToElement(driver, UserHomePageUI.MENU_COMPUTER_LINK);
		return PageGeneratorManager.getUserListComputerPageObject(driver);
	}
	public UserComparePageObject clickToCompareLink(WebDriver driver) {
		waitForElementClickable(driver, UserHomePageUI.COMPARE_LINK);
		clickToElement(driver,UserHomePageUI.COMPARE_LINK);
		return PageGeneratorManager.getUserComparePageObject(driver);
	}
	public void clickToAddCompareListByTitle(String productTitle) {
		sleepInSecond(2);
		waitForElementClickable(driver, UserHomePageUI.COMPARE_BUTTON, productTitle);
		clickToElement(driver,UserHomePageUI.COMPARE_BUTTON, productTitle);
	}
	public UserRecentlyViewProductsPageObject clickToRecentlyViewProductLink(WebDriver driver) {
		waitForElementClickable(driver, UserHomePageUI.RECENTLY_VIEW_PRODUCTS_LINK);
		clickToElement(driver, UserHomePageUI.RECENTLY_VIEW_PRODUCTS_LINK);
		return PageGeneratorManager.getUserRecentlyViewProductsPageObject(driver);
	}
	

}
