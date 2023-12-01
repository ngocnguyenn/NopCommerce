package pageUIsNopCommerceUser;

public class UserOrdersPageUI {

	public static final String DETAIL_LINK = "xpath=//button[@class='button-2 order-details-button']";
	public static final String DYNAMIC_DETAIL = "xpath=//div[@class='%s']//li[@class='%s']";
	public static final String PAYMENT_METHOD_INFOR = "xpath=//li[@class='payment-method']//span[@class='value']";
	public static final String SHIPPING_METHOD_INFOR = "xpath=//li[@class='shipping-method']//span[@class='value']";
	public static final String GIFT_WRAPPING_DETAIL = "xpath=//div[@class='selected-checkout-attributes']";
	public static final String TOTAL_PRICE = "xpath=//label[text()='Order Total:']/parent::td/following-sibling::td//strong";
	public static final String ORDER_NUMBER = "xpath=//div[@class='section order-completed']//div[@class='order-number']/strong";
}
