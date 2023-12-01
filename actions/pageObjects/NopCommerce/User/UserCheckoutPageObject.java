package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserCheckoutPageUI;
import pageUIsNopCommerceUser.UserShoppingCartPageUI;

public class UserCheckoutPageObject extends BasePage{
	WebDriver driver;
	public UserCheckoutPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void selectITemInCountryDropDownByText(String countryName) {
		waitForElementVisible(driver, UserCheckoutPageUI.COUNTRY_DROPDOWN);
		selectIteminCustomDropdown(driver,UserCheckoutPageUI.COUNTRY_DROPDOWN, UserCheckoutPageUI.COUNTRY_OPTION, countryName);
	}
	public void enterToDynamicTextbox(String text, String string) {
		waitForElementVisible(driver, UserCheckoutPageUI.DYNAMIC_TEXTBOX, string);
		sendKeyToElement(driver, UserCheckoutPageUI.DYNAMIC_TEXTBOX, text, string);
	}
	public void clickToContinueButtoninBillingAddress() {
		waitForElementClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_BILLING_ADDRESS);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON_IN_BILLING_ADDRESS);
	}
	public void clickToDynamicCheckboxByText(String text) {
		waitForElementClickable(driver, UserCheckoutPageUI.DYNAMIC_CHECKBOX, text);
		clickToElement(driver, UserCheckoutPageUI.DYNAMIC_CHECKBOX, text);
	}
	public void clickToContinueButton(String text) {
		waitForElementClickable(driver, UserCheckoutPageUI.CONTINUE_BUTTON, text);
		clickToElement(driver, UserCheckoutPageUI.CONTINUE_BUTTON, text);
	}
	public String getDynamicDetail(String string, String string1) {
		waitForElementVisible(driver, UserCheckoutPageUI.DYNAMIC_DETAIL, string, string1);
		return getElementText(driver, UserCheckoutPageUI.DYNAMIC_DETAIL, string, string1);
	}
	public String getPaymentMethodInfor() {
		waitForElementVisible(driver, UserCheckoutPageUI.PAYMENT_METHOD_INFOR);
		return getElementText(driver, UserCheckoutPageUI.PAYMENT_METHOD_INFOR);
	}
	public boolean getShippingtMethodInfor(String string) {
		waitForElementVisible(driver, UserCheckoutPageUI.SHIPPING_METHOD_INFOR);
		String text = getElementText(driver, UserCheckoutPageUI.SHIPPING_METHOD_INFOR);
		if (string.contains(text))
		{
			return true;
		}
		return false;
	}
	public String getGiftWrappingDetail() {
		waitForElementVisible(driver, UserCheckoutPageUI.GIFT_WRAPPING_DETAIL);
		return getElementText(driver, UserCheckoutPageUI.GIFT_WRAPPING_DETAIL);
	}
	public String getTotalPriceText() {
		waitForElementVisible(driver, UserCheckoutPageUI.TOTAL_PRICE);
		return getElementText(driver, UserCheckoutPageUI.TOTAL_PRICE);
	}
	public void clickToConfirmButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.CONFIRM_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.CONFIRM_BUTTON);
	}
	public String getSuccessTitle() {
		waitForElementVisible(driver, UserCheckoutPageUI.SUCCESS_TITLE);
		return getElementText(driver, UserCheckoutPageUI.SUCCESS_TITLE);
	}
	public String getSuccessMessage() {
		waitForElementVisible(driver, UserCheckoutPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, UserCheckoutPageUI.SUCCESS_MESSAGE);
	}
	public String getOrderNumber() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}
	public UserHomePageObject clickToContinueButton() {
		waitForElementClickable(driver, UserCheckoutPageUI.COMPLETED_BUTTON);
		clickToElement(driver, UserCheckoutPageUI.COMPLETED_BUTTON);
		return PageGeneratorManager.getUserHomePageObject(driver);
	}

}
