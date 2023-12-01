package pageObjects.NopCommerce.User;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneratorManager;
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
	
	public boolean productDetailIsCorrect(String string) {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_DETAIL);
		String text = getElementText(driver, UserShoppingCartPageUI.PRODUCT_DETAIL);
		if (text.contains(string))
		{
			return true;
		}
		return false;
	}
	public String getProductPriceText() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_PRICE);
		return getElementText(driver, UserShoppingCartPageUI.PRODUCT_PRICE);
	}
	public int getProductQuantity(String attribute) {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY);
		return Integer.valueOf(getElementAttribute(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY, attribute));
	}
	public UserProductDetailPageObject clickToEditLink(WebDriver driver2) {
		waitForElementClickable(driver, UserShoppingCartPageUI.EDIT_LINK);
		clickToElement(driver, UserShoppingCartPageUI.EDIT_LINK);
		return PageGeneratorManager.getUserProductDetailPageObject(driver);
	}
	public boolean verifyProductRemovedToCart(String productTitle) {
		int number = 0;
		List<WebElement> allItems= getElements(driver,UserShoppingCartPageUI.PRODUCT_TITLE);
		int size = allItems.size();
		if (size == 0)
		{
			return getElementText(driver, UserShoppingCartPageUI.NO_DATA_MESSAGE).equals("Your Shopping Cart is empty!");
		}
		else
		{
			for (WebElement item: allItems)
	        {
	            if (item.getText().contains(productTitle))
	            {
	            	number = number + 1;
	            }
	        }
	        if (number == 0)
	        	return true;
	        else return false;
		}
	}
	public void clickToRemoveButton(String productTitle) {
		waitForElementClickable(driver, UserShoppingCartPageUI.REMOVE_BUTTON, productTitle);
		clickToElement(driver, UserShoppingCartPageUI.REMOVE_BUTTON, productTitle);
	}
	public void setProductQuantity(String quantity) {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY);
		sendKeyToElement(driver, UserShoppingCartPageUI.PRODUCT_QUANTITY, quantity);
	}
	public void clickToUpdateButton() {
		waitForElementVisible(driver, UserShoppingCartPageUI.UPDATE_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.UPDATE_BUTTON);
	}
	public void clickToAgreeCheckbox() {
		waitForElementClickable(driver, UserShoppingCartPageUI.AGREE_CHECKBOX);
		clickToElement(driver, UserShoppingCartPageUI.AGREE_CHECKBOX);
	}
	public UserCheckoutPageObject clickToCheckoutButton() {
		waitForElementClickable(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
		clickToElement(driver, UserShoppingCartPageUI.CHECKOUT_BUTTON);
		return PageGeneratorManager.getUserCheckoutPageObject(driver);
	}
	public String getProductTotalPriceText() {
		waitForElementVisible(driver, UserShoppingCartPageUI.PRODUCT_TOTAL_PRICE);
		return getElementText(driver, UserShoppingCartPageUI.PRODUCT_TOTAL_PRICE);
	}
	
}
