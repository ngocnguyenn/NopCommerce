package pageUIsNopCommerceUser;

public class UserShoppingCartPageUI {

	public static final String PRODUCT_TITLE = "xpath=//a[@class='product-name']";
	public static final String PRODUCT_DETAIL = "xpath=//td[@class='product']//div[@class='attributes']";
	public static final String PRODUCT_PRICE = "xpath=//td[@class='unit-price']//span";
	public static final String PRODUCT_QUANTITY = "xpath=//td[@class='quantity']//input";
	public static final String EDIT_LINK = "xpath=//div[@class='edit-item']//a";
	public static final String NO_DATA_MESSAGE = "xpath=//div[@class='no-data']";
	public static final String REMOVE_BUTTON = "xpath=//td[@class='product']/a[text()='%s']/parent::td//following-sibling::td[@class='remove-from-cart']//button";
	public static final String UPDATE_BUTTON = "xpath=//button[@id='updatecart']";
	public static final String AGREE_CHECKBOX = "xpath=//input[@id='termsofservice']";
	public static final String CHECKOUT_BUTTON = "xpath=//button[@id='checkout']";
	public static final String PRODUCT_TOTAL_PRICE = "xpath=//td[@class='subtotal']//span";

}
