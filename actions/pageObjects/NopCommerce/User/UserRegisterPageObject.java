package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserRegisterPageUI;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;
	
	public UserRegisterPageObject (WebDriver driver)
	{
		this.driver = driver;
	}
	public UserHomePageObject clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUI.REGISTER_BUTTON);
		return PageGeneratorManager.getUserHomePageObject(driver);
	}
	public String getFirstNameErrorMessage()
	{
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.FIRSTNAME_ERROR_MESSAGE);
	}
	public String getLastNameErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.LASTNAME_ERROR_MESSAGE);
	}
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}
	public String getConfirmPasswordErrorMessage() {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, UserRegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserRegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeyToElement(driver,UserRegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}
	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserRegisterPageUI.LASTNAME_TEXTBOX);
		sendKeyToElement(driver,UserRegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, UserRegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver,UserRegisterPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver,UserRegisterPageUI.PASSWORD_TEXTBOX, password);
	}
	public void enterToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeyToElement(driver,UserRegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}
	public String getSuccessMessageText() {
		waitForElementVisible(driver, UserRegisterPageUI.SUCCESSFULL_MESSAGE);
		return getElementText(driver,  UserRegisterPageUI.SUCCESSFULL_MESSAGE);
	}
	public String getEmailExistsMessageText() {
		waitForElementVisible(driver, UserRegisterPageUI.EXISTS_EMAIL_MESSAGE);
		return getElementText(driver,  UserRegisterPageUI.EXISTS_EMAIL_MESSAGE);
	}
}
