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
	public UserProductDetailPageObject clickToProductLink() {
		waitForElementClickable(driver, UserHomePageUI.PRODUCT_DETAIL_LINK);
		clickToElement(driver, UserHomePageUI.PRODUCT_DETAIL_LINK);
		return PageGeneratorManager.getUserProductDetailPageObject(driver);
	}

}
