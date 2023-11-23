package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceUser.UserCustomerInforPageUI;

public class UserCustomerInforPageObject extends BasePage{
	private WebDriver driver;
	
	public UserCustomerInforPageObject(WebDriver driver)
	{
		this.driver = driver;
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX);
		sendKeyToElement(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX, lastName);
	}

	public void enterToDateOfBirth(String dateOfBirth) {
		waitForElementVisible(driver, UserCustomerInforPageUI.DATE_OF_BIRTH_COMBOBOX);
		selectItemInDefaultDropDown(driver,UserCustomerInforPageUI.DATE_OF_BIRTH_COMBOBOX, dateOfBirth);
	}
	public void enterToMonthOfBirth(String monthOfBirth) {
		waitForElementVisible(driver, UserCustomerInforPageUI.MONTH_OF_BIRTH_COMBOBOX);
		selectItemInDefaultDropDown(driver,UserCustomerInforPageUI.MONTH_OF_BIRTH_COMBOBOX, monthOfBirth);
	}

	public void enterToYearOfBirth(String yearOfBirth) {
		waitForElementVisible(driver, UserCustomerInforPageUI.YEAR_OF_BIRTH_COMBOBOX);
		selectItemInDefaultDropDown(driver,UserCustomerInforPageUI.YEAR_OF_BIRTH_COMBOBOX, yearOfBirth);
	}

	public void enterToEmailTextbox(String email) {
		waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver,UserCustomerInforPageUI.EMAIL_TEXTBOX, email);
	}

	public void enterToCompanyNameTextbox(String companyName) {
		waitForElementVisible(driver, UserCustomerInforPageUI.COMPANY_NAME_TEXTBOX);
		sendKeyToElement(driver,UserCustomerInforPageUI.COMPANY_NAME_TEXTBOX, companyName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInforPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInforPageUI.SAVE_BUTTON);
	}

	public String getSuccessMessageText() {
		waitForElementVisible(driver, UserCustomerInforPageUI.SUCCESS_MESSAGE);
		return getElementText(driver,UserCustomerInforPageUI.SUCCESS_MESSAGE);
	}

	
}
