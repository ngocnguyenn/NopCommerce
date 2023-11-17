package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneratorManager;
import pageUIsNopCommerceUser.UserHomePageUI;

public class UserHomePageObject extends BasePage{
	
	private WebDriver driver;
	public UserHomePageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public UserRegisterPageObject clickToRegisterLink()
	{
		waitForElementClickable(driver, UserHomePageUI.REGISTER_LINK);
		clickToElement(driver, UserHomePageUI.REGISTER_LINK);
		return PageGeneratorManager.getUserRegisterPageObject(driver);
	}

}
