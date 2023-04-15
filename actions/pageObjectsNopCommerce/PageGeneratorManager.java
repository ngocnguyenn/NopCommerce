package pageObjectsNopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {

	public static HomePageObject getHomePageObject(WebDriver driver)
	{
		return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPageObject(WebDriver driver)
	{
		return new LoginPageObject(driver);
	}
}
