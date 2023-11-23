package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceUser.UserChangePasswordPageUI;

public class UserChangePasswordPageObject extends BasePage{
	WebDriver driver;
	public UserChangePasswordPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void enterToOldPasswordTextbox(String password) {
		waitForElementVisible(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserChangePasswordPageUI.OLD_PASSWORD_TEXTBOX, password);
	}
	public void enterToNewPasswordTextbox(String newPassword) {
		waitForElementVisible(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserChangePasswordPageUI.NEW_PASSWORD_TEXTBOX, newPassword);
	}
	public void enterToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, UserChangePasswordPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}
	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CHANGE_PASSWORD_BUTTON);
	}
	public String getSuccessMessageText() {
		waitForElementVisible(driver, UserChangePasswordPageUI.SUCCESS_MESSAGE);
		return getElementText(driver,UserChangePasswordPageUI.SUCCESS_MESSAGE);
	}
	public void clickToClosePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUI.CLOSE_MESSAGE_BUTTON);
		clickToElement(driver, UserChangePasswordPageUI.CLOSE_MESSAGE_BUTTON);
	}
}
