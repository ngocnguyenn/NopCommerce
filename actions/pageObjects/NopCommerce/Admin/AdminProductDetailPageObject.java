package pageObjects.NopCommerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceAdmin.AdminProductDetailPageUI;

public class AdminProductDetailPageObject extends BasePage{
	WebDriver driver;
	public AdminProductDetailPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean getProductDetailTitle(String productName) {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_DETAIL_TITLE);
		String string = getElementText(driver, AdminProductDetailPageUI.PRODUCT_DETAIL_TITLE);
		if (string.contains(productName))
		{
			return true;
		}
		return false;
	}
	public String getProductNameValue(String attribute) {
		waitForElementVisible(driver, AdminProductDetailPageUI.PRODUCT_NAME_VALUE);
		return getElementAttribute(driver, AdminProductDetailPageUI.PRODUCT_NAME_VALUE, attribute);
	}

}
