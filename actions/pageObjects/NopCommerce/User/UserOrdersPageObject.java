package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceUser.UserCheckoutPageUI;
import pageUIsNopCommerceUser.UserOrdersPageUI;

public class UserOrdersPageObject extends BasePage{
	WebDriver driver;
	public UserOrdersPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void clickToDetailLink() {
		waitForElementClickable(driver, UserOrdersPageUI.DETAIL_LINK);
		clickToElement(driver, UserOrdersPageUI.DETAIL_LINK);
	}
	public String getDynamicDetail(String string, String string1) {
		waitForElementVisible(driver, UserOrdersPageUI.DYNAMIC_DETAIL, string, string1);
		return getElementText(driver, UserOrdersPageUI.DYNAMIC_DETAIL, string, string1);
	}
	public String getPaymentMethodInfor() {
		waitForElementVisible(driver, UserOrdersPageUI.PAYMENT_METHOD_INFOR);
		return getElementText(driver, UserOrdersPageUI.PAYMENT_METHOD_INFOR);
	}
	public boolean getShippingtMethodInfor(String string) {
		waitForElementVisible(driver, UserOrdersPageUI.SHIPPING_METHOD_INFOR);
		String text = getElementText(driver, UserOrdersPageUI.SHIPPING_METHOD_INFOR);
		if (string.contains(text))
		{
			return true;
		}
		return false;
	}
	public String getGiftWrappingDetail() {
		waitForElementVisible(driver, UserOrdersPageUI.GIFT_WRAPPING_DETAIL);
		return getElementText(driver, UserOrdersPageUI.GIFT_WRAPPING_DETAIL);
	}
	public String getTotalPriceText() {
		waitForElementVisible(driver, UserOrdersPageUI.TOTAL_PRICE);
		return getElementText(driver, UserOrdersPageUI.TOTAL_PRICE);
	}
	public String getOrderNumber() {
		waitForElementVisible(driver, UserCheckoutPageUI.ORDER_NUMBER);
		return getElementText(driver, UserCheckoutPageUI.ORDER_NUMBER);
	}
}
