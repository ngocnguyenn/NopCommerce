package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserAddressesAddPageUI;

public class UserAddressesAddPageObject extends BasePage{
	WebDriver driver;
	public UserAddressesAddPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserAddressesAddPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserAddressesAddPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, UserAddressesAddPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.EMAIL_TEXTBOX, email);
	}
	public void enterToCompanyTextbox(String companyName) {
		waitForElementVisible(driver, UserAddressesAddPageUI.COMPANY_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.COMPANY_TEXTBOX, companyName);
	}
	public void selectToCountryDropDown(String country) {
		waitForElementVisible(driver, UserAddressesAddPageUI.COUNTRY_DROPDOWN);
		selectItemInDefaultDropDown(driver,UserAddressesAddPageUI.COUNTRY_DROPDOWN, country);
	}
	public void enterToCityTextbox(String city) {
		waitForElementVisible(driver, UserAddressesAddPageUI.CITY_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.CITY_TEXTBOX, city);
	}
	public void enterToAddress1Textbox(String address1) {
		waitForElementVisible(driver, UserAddressesAddPageUI.ADDRESS_1_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.ADDRESS_1_TEXTBOX, address1);
	}
	public void enterToAddress2Textbox(String address2) {
		waitForElementVisible(driver, UserAddressesAddPageUI.ADDRESS_2_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.ADDRESS_2_TEXTBOX, address2);
	}
	public void enterToZipcodeTextbox(String zipCode) {
		waitForElementVisible(driver, UserAddressesAddPageUI.ZIP_CODE_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.ZIP_CODE_TEXTBOX, zipCode);
	}
	public void enterToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, UserAddressesAddPageUI.PHONE_NUMBER_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}
	public void enterToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, UserAddressesAddPageUI.FAX_NUMBER_TEXTBOX);
		sendKeyToElement(driver, UserAddressesAddPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}
	public UserAddressesPageObject clickToSaveButton()
	{
		waitForElementClickable(driver, UserAddressesAddPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressesAddPageUI.SAVE_BUTTON);
		return PageGeneratorManager.getUserAddressesPageObject(driver);
	}
}
