package pageUIsNopCommerceUser;

public class UserCheckoutPageUI {

	public static final String COUNTRY_DROPDOWN = "xpath=//select[@id='BillingNewAddress_CountryId']";
	public static final String COUNTRY_OPTION = "xpath=//select[@id='BillingNewAddress_CountryId']//option";
	public static final String DYNAMIC_TEXTBOX = "xpath=//input[@name='%s']";
	public static final String CONTINUE_BUTTON_IN_BILLING_ADDRESS = "xpath=//div[@id='billing-buttons-container']/button[@class='button-1 new-address-next-step-button']";
	public static final String DYNAMIC_CHECKBOX = "xpath=//label[text()='%s']//preceding-sibling::input";
	public static final String CONTINUE_BUTTON = "xpath=//button[@class='%s']";
	public static final String DYNAMIC_DETAIL = "xpath=//div[@class='%s']//li[@class='%s']";
	public static final String PAYMENT_METHOD_INFOR = "xpath=//li[@class='payment-method']//span[@class='value']";
	public static final String SHIPPING_METHOD_INFOR = "xpath=//li[@class='shipping-method']//span[@class='value']";
	public static final String GIFT_WRAPPING_DETAIL = "xpath=//div[@class='selected-checkout-attributes']";
	public static final String TOTAL_PRICE = "xpath=//tr[@class='order-total']//span[@class='value-summary']";
	public static final String CONFIRM_BUTTON = "xpath=//button[@class='button-1 confirm-order-next-step-button']";
	public static final String SUCCESS_TITLE = "xpath=//div[@class='page-title']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[@class='section order-completed']/div[@class='title']/strong";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']/strong";
	public static final String COMPLETED_BUTTON = "xpath=//button[@class='button-1 order-completed-continue-button']";

}
