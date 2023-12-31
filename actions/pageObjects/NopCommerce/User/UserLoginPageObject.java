package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserLoginPageUI;

public class UserLoginPageObject extends BasePage{
	private WebDriver driver;
	public UserLoginPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public UserHomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePageObject(driver);
	}
	public String getEmailErrorMessageText() {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.EMAIL_ERROR_MESSAGE);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, UserLoginPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserLoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserLoginPageUI.PASSWORD_TEXTBOX, password);
	}
	public String getLoginErrorMessageText() {
		waitForElementVisible(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
		return getElementText(driver, UserLoginPageUI.LOGIN_ERROR_MESSAGE);
	}

}
