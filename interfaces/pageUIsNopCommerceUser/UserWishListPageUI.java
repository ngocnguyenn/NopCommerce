package pageUIsNopCommerceUser;

public class UserWishListPageUI {

	public static final String PRODUCT_TITLE = "xpath=//td[@class='product']//a[@class='product-name']";
	public static final String WISHLIST_LINK = "xpath=//a[@class='share-link']";
	public static final String WISHLIST_PAGE_TITLE = "xpath=//div[@class='page-title']//h1";
	public static final String ADD_TO_CART_CHECKBOX = "xpath=//a[text()='%s']//parent::td/preceding-sibling::td[@class='add-to-cart']//input";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[@name='addtocartbutton']";
	public static final String NO_DATA_MESSAGE = "xpath=//div[@class='no-data']";
	public static final String REMOVE_BUTTON = "xpath=//a[text()='%s']//parent::td/following-sibling::td[@class='remove-from-cart']//button";

}
