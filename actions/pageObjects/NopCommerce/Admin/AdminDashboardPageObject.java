package pageObjects.NopCommerce.Admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceAdmin.AdminDashboardPageUI;

public class AdminDashboardPageObject extends BasePage{
	WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void openDynamicPageByName(String string) {
		waitForElementClickable(driver, AdminDashboardPageUI.DYNAMIC_LINK, string);
		clickToElement(driver, AdminDashboardPageUI.DYNAMIC_LINK, string);
	}

}
