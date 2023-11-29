package pageObjects.NopCommerce.User;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIsNopCommerceUser.UserShoppingCartPageUI;

public class UserShoppingCartPageObject extends BasePage{
	WebDriver driver;
	public UserShoppingCartPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public boolean verifyProductAddedToCart(String productTitle) {
		int number = 0;
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_TITLE);
		 List<WebElement> allItems= getElements(driver,UserShoppingCartPageUI.PRODUCT_TITLE);

        for (WebElement item: allItems)
        {
            if (item.getText().contains(productTitle))
            {
            	number = number + 1;
            }
        }
        if (number == 1)
        	return true;
        else return false;
	}

}
