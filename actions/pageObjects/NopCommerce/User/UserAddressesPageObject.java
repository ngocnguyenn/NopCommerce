package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserAddressesPageUI;

public class UserAddressesPageObject extends BasePage{
	private WebDriver driver;
	public UserAddressesPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public UserAddressesAddPageObject clickToAddNewButton() {
		waitForElementClickable(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
		return PageGeneratorManager.getUserAddressesAddPageObject(driver);
	}
	public String getSuccessMessageText() {
		waitForElementVisible(driver, UserAddressesPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, UserAddressesPageUI.SUCCESS_MESSAGE);
	}
	public String getDynamicText(String string) {
		waitForElementVisible(driver, UserAddressesPageUI.DYNAMIC_LINK, string );
		return getElementText(driver, UserAddressesPageUI.DYNAMIC_LINK, string);
	}

}
