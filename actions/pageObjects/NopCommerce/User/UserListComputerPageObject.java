package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserListComputerPageUI;

public class UserListComputerPageObject extends BasePage{
	WebDriver driver; 
	public UserListComputerPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public UserListDesktopsPageObject clickToDesktopsLink() {
		waitForElementClickable(driver, UserListComputerPageUI.DESKTOPS_LINK);
		clickToElement(driver, UserListComputerPageUI.DESKTOPS_LINK);
		return PageGeneratorManager.getUserListDesktopsPageObject(driver);
	}
}
