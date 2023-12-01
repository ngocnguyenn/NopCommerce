package user;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import commons.PageGeneratorManager;
import learn.nopcommerce.data.UserDataMapper;
import pageObjects.NopCommerce.User.UserCheckoutPageObject;
import pageObjects.NopCommerce.User.UserCustomerInforPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserOrdersPageObject;
import pageObjects.NopCommerce.User.UserProductDetailPageObject;
import pageObjects.NopCommerce.User.UserSearchPageObject;
import pageObjects.NopCommerce.User.UserShoppingCartPageObject;
import reportConfigs.ExtentTestManager;

public class Order extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserProductDetailPageObject productDetailPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserCheckoutPageObject checkoutPage;
	private UserSearchPageObject searchPage;
	private UserOrdersPageObject ordersPage;
	private String email, password, productTitle;
	private String processor, ram, HDD, OS, software1, software2, software3, price, orderNumber;  
	private int quantity;
	private String attribute = "value";
	private String firstName, lastName, countryName, city, address, phoneNumber, zipCode, paymentMethod, shippingMethod;
	@Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void BeforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion, Method method)
	{
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		email = UserDataMapper.getUserData().getEmail();
		password = UserDataMapper.getUserData().getPassWord();
		productTitle = "Build your own computer";
		processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		ram = "4GB [+$20.00]";
		HDD = "400 GB [+$100.00]"; 
		OS = "Vista Premium [+$60.00]";
		software1 = "Microsoft Office [+$50.00]";
		software2 = "Acrobat Reader [+$10.00]"; 
		software3 = "Total Commander [+$5.00]";
		
		homePage = new UserHomePageObject(driver);
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.myAccountLinkIsDisplayed());
		
		productDetailPage = homePage.clickToProductByName(productTitle);
	}
	
	@Test
	public void TC_01_Add_Product_To_Cart(Method method)
	{
		processor = "2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]";
		ram = "4GB [+$20.00]";
		HDD = "400 GB [+$100.00]"; 
		OS = "Vista Premium [+$60.00]";
		software1 = "Microsoft Office [+$50.00]";
		software2 = "Acrobat Reader [+$10.00]"; 
		software3 = "Total Commander [+$5.00]";
		ExtentTestManager.startTest(method.getName(), "Add product to Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 01: Select Value in Processor DropDown");
		productDetailPage.selectItemInDynamicDropDownByText("1", processor);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 02: Select Value in Ram DropDown");
		productDetailPage.selectItemInDynamicDropDownByText("2", ram);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 03: Select Value in HDD Ratio");
		productDetailPage.selectItemByText(HDD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 04: Select Value in OS Ratio");
		productDetailPage.selectItemByText(OS);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 06: Select Value in Sofware Checkbox");
		productDetailPage.selectItemByText(software2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 07: Select Value in Sofware Checkbox");
		productDetailPage.selectItemByText(software3);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 08: Get Product Price");
		price = productDetailPage.getPriceText();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 09: Get Product Quantity");
		quantity = productDetailPage.getProductQuantity(attribute);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 10: Click Add to Cart Button");
		productDetailPage.clickToAddToCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 11: Verify Success Message is displayed");
		Assert.assertEquals(productDetailPage.getSuccessMessageText(driver), "The product has been added to your shopping cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 12: Click Close Message Button");
		productDetailPage.clickToCloseMessageButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 13: Navigate To Shopping Cart Page");
		shoppingCartPage = productDetailPage.clickToShoppingCartLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 14: Verify Product Added To Cart");
		shoppingCartPage.verifyProductAddedToCart(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 15: Verify Product Detail is correct");
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(processor));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(ram));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(HDD));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(OS));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(software2));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(software3));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 16: Verify Product Price is correct");
		Assert.assertEquals(shoppingCartPage.getProductPriceText(), price);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart - Step 17: Verify Product Quantity is correct");
		Assert.assertEquals(shoppingCartPage.getProductQuantity(attribute), quantity);
	}
	
	@Test
	public void TC_02_Edit_Product_In_Shopping_Cart(Method method)
	{
		processor = "2.2 GHz Intel Pentium Dual-Core E2200";
		ram = "8GB [+$60.00]";
		HDD = "320 GB"; 
		OS = "Vista Home [+$50.00]";
		software1 = "Microsoft Office [+$50.00]";
		software2 = "Acrobat Reader [+$10.00]"; 
		software3 = "Total Commander [+$5.00]";
		quantity = 2;
		
		ExtentTestManager.startTest(method.getName(), "Edit product in Shopping Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 01: Navigate to Product Detail");
		productDetailPage = shoppingCartPage.clickToEditLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 02: Select Value in Processor DropDown");
		productDetailPage.selectItemInDynamicDropDownByText("1", processor);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 03: Select Value in Ram DropDown");
		productDetailPage.selectItemInDynamicDropDownByText("2", ram);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 04: Select Value in HDD Ratio");
		productDetailPage.selectItemByText(HDD);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 05: Select Value in OS Ratio");
		productDetailPage.selectItemByText(OS);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 06: Un select Value in Sofware Checkbox");
		productDetailPage.unSelectItemByText(software1);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 07: Select Value in Sofware Checkbox");
		productDetailPage.selectItemByText(software2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 08: Select Value in Sofware Checkbox");
		productDetailPage.selectItemByText(software3);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 09: Set Product Quantity");
		productDetailPage.enterToProductQuantity(String.valueOf(quantity));
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 10: Get Product Price");
		price = productDetailPage.getPriceText();
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 11: Click Add to Cart Button");
		productDetailPage.clickToAddToCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 12: Verify Success Message is displayed");
		Assert.assertEquals(productDetailPage.getSuccessMessageText(driver), "The product has been added to your shopping cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 13: Click Close Message Button");
		productDetailPage.clickToCloseMessageButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 14: Navigate To Shopping Cart Page");
		shoppingCartPage = productDetailPage.clickToShoppingCartLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 15: Verify Product Added To Cart");
		shoppingCartPage.verifyProductAddedToCart(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 16: Verify Product Detail is correct");
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(processor));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(ram));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(HDD));
		Assert.assertTrue(shoppingCartPage.productDetailIsCorrect(OS));
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 17: Verify Product Price is correct");
		Assert.assertEquals(shoppingCartPage.getProductPriceText(), price);
		
		ExtentTestManager.getTest().log(Status.INFO, "Edit product in Shopping Cart - Step 18: Verify Product Quantity is correct");
		Assert.assertEquals(shoppingCartPage.getProductQuantity(attribute), quantity);
	}
	
	@Test
	public void TC_03_Remove_Product_From_Shopping_Cart(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Remove product from shopping Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from shopping Cart - Step 01: Click to Remove Button");
		shoppingCartPage.clickToRemoveButton(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from shopping Cart - Step 02: Verify product removed successfull");
		Assert.assertTrue(shoppingCartPage.verifyProductRemovedToCart(productTitle));
	}
	
	@Test
	public void TC_04_Update_In_Shopping_Cart(Method method)
	{
		productTitle = "Lenovo IdeaCentre 600 All-in-One PC";
		ExtentTestManager.startTest(method.getName(), "Update In Shopping Cart");
		ExtentTestManager.getTest().log(Status.INFO, "Update In Shopping Cart - Step 01: Navigate to HomePage");
		homePage = shoppingCartPage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Update In Shopping Cart - Step 02: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Update In Shopping Cart - Step 03: Enter to Search Textbox");
		searchPage.enterToSearchTextbox(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Update In Shopping Cart - Step 04: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 05: Add product to Shopping Cart");
		productDetailPage = searchPage.clickToProductByName(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 06: Click Add to Cart Button");
		productDetailPage.clickToAddToCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 07: Verify Success Message is displayed");
		Assert.assertEquals(productDetailPage.getSuccessMessageText(driver), "The product has been added to your shopping cart");
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 08: Click Close Message Button");
		productDetailPage.clickToCloseMessageButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 09: Navigate To Shopping Cart Page");
		shoppingCartPage = productDetailPage.clickToShoppingCartLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 10: Verify Product Added To Cart");
		shoppingCartPage.verifyProductAddedToCart(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 11: Verify Product Added To Cart");
		shoppingCartPage.setProductQuantity("5");
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 12: Click to Update Button");
		shoppingCartPage.clickToUpdateButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Update in Shopping Cart - Step 17: Verify Product Price is correct");
		Assert.assertEquals(shoppingCartPage.getProductTotalPriceText(), "$2,500.00");
	}
	
	@Test
	public void TC_05_Checkout(Method method)
	{
		firstName = UserDataMapper.getUserData().getFirstName();
		lastName = UserDataMapper.getUserData().getLastName();
		countryName = "Viet Nam";
		city = "Ho Chi Minh";
		address = "123/04 Le Lai";
		phoneNumber = "0123456789";
		zipCode = "987";
		paymentMethod = "Check / Money Order";
		shippingMethod = "2nd Day Air ($0.00)";
		
		ExtentTestManager.startTest(method.getName(), "Checkout");
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 01: Click to Agree Checkbox");
		shoppingCartPage.clickToAgreeCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 02: Click to Checkout Button");
		checkoutPage = shoppingCartPage.clickToCheckoutButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 03: Select Item in Country Dropdown");
		checkoutPage.selectITemInCountryDropDownByText(countryName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 04: Enter to City Textbox");
		checkoutPage.enterToDynamicTextbox(city, "BillingNewAddress.City");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 05: Enter to Address 1 Textbox");
		checkoutPage.enterToDynamicTextbox(address, "BillingNewAddress.Address1");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 06: Enter to Zipcode Textbox");
		checkoutPage.enterToDynamicTextbox(zipCode, "BillingNewAddress.ZipPostalCode");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 07: Enter to Phone Number Textbox");
		checkoutPage.enterToDynamicTextbox(phoneNumber, "BillingNewAddress.PhoneNumber");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 08: Click to Continue Button");
		checkoutPage.clickToContinueButtoninBillingAddress();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 09: Click to Shipping Method");
		checkoutPage.clickToDynamicCheckboxByText(shippingMethod);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 10: Click to Continue Button");
		checkoutPage.clickToContinueButton("button-1 shipping-method-next-step-button");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 11: Click to Payment Method");
		checkoutPage.clickToDynamicCheckboxByText(paymentMethod);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 12: Click to Continue Button");
		checkoutPage.clickToContinueButton("button-1 payment-method-next-step-button");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 13: Click to Continue Button");
		checkoutPage.clickToContinueButton("button-1 payment-info-next-step-button");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 14: Verify information in Billing Address");
		Assert.assertEquals(checkoutPage.getDynamicDetail("billing-info","name"),firstName + " " + lastName);
		Assert.assertEquals(checkoutPage.getDynamicDetail("billing-info","email"),"Email: " + email);
		Assert.assertEquals(checkoutPage.getDynamicDetail("billing-info","phone"),"Phone: " + phoneNumber);
		Assert.assertEquals(checkoutPage.getDynamicDetail("billing-info","address1"),address);
		Assert.assertEquals(checkoutPage.getDynamicDetail("billing-info","city-state-zip"),city + "," +zipCode);
		Assert.assertEquals(checkoutPage.getDynamicDetail("billing-info","country"),countryName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 15: Verify Payment Method");
		Assert.assertEquals(checkoutPage.getPaymentMethodInfor(),paymentMethod);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 16: Verify information in Shipping Address");
		Assert.assertEquals(checkoutPage.getDynamicDetail("shipping-info","name"),firstName + " " + lastName);
		Assert.assertEquals(checkoutPage.getDynamicDetail("shipping-info","email"),"Email: " + email);
		Assert.assertEquals(checkoutPage.getDynamicDetail("shipping-info","phone"),"Phone: " + phoneNumber);
		Assert.assertEquals(checkoutPage.getDynamicDetail("shipping-info","address1"),address);
		Assert.assertEquals(checkoutPage.getDynamicDetail("shipping-info","city-state-zip"),city + "," +zipCode);
		Assert.assertEquals(checkoutPage.getDynamicDetail("shipping-info","country"),countryName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 17: Verify Shipping Method");
		Assert.assertTrue(checkoutPage.getShippingtMethodInfor(shippingMethod));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 18: Verify Gift Wrapping Detail");
		Assert.assertEquals(checkoutPage.getGiftWrappingDetail(),"Gift wrapping: No");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 19: Verify Total Price");
		Assert.assertEquals(checkoutPage.getTotalPriceText(), "$2,500.00");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 20: Click to Confirm Button");
		checkoutPage.clickToConfirmButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 21: Verify Success Message is displayed");
		//Assert.assertEquals(checkoutPage.getSuccessTitle(), "Thank you");
		Assert.assertEquals(checkoutPage.getSuccessMessage(),"Your order has been successfully processed!");
		
		orderNumber = StringUtils.getDigits(checkoutPage.getOrderNumber());
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 22: Click to Continue Button");
		homePage = checkoutPage.clickToContinueButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 23: Click to My Account Link");
		customerInforPage = homePage.clickToMyAccountLink(); 
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 24: Navigate to Orders Page");
		customerInforPage.openPageAtMyAccountByPageName(driver, "Orders");
		ordersPage = PageGeneratorManager.getUserOrdersPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 25: Click to Detail link");
		ordersPage.clickToDetailLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 26: Verify information in Billing Address");
		Assert.assertEquals(ordersPage.getDynamicDetail("billing-info","name"),firstName + " " + lastName);
		Assert.assertEquals(ordersPage.getDynamicDetail("billing-info","email"),"Email: " + email);
		Assert.assertEquals(ordersPage.getDynamicDetail("billing-info","phone"),"Phone: " + phoneNumber);
		Assert.assertEquals(ordersPage.getDynamicDetail("billing-info","address1"),address);
		Assert.assertEquals(ordersPage.getDynamicDetail("billing-info","city-state-zip"),city + "," +zipCode);
		Assert.assertEquals(ordersPage.getDynamicDetail("billing-info","country"),countryName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 27: Verify Payment Method");
		Assert.assertEquals(ordersPage.getPaymentMethodInfor(),paymentMethod);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 28: Verify information in Shipping Address");
		Assert.assertEquals(ordersPage.getDynamicDetail("shipping-info","name"),firstName + " " + lastName);
		Assert.assertEquals(ordersPage.getDynamicDetail("shipping-info","email"),"Email: " + email);
		Assert.assertEquals(ordersPage.getDynamicDetail("shipping-info","phone"),"Phone: " + phoneNumber);
		Assert.assertEquals(ordersPage.getDynamicDetail("shipping-info","address1"),address);
		Assert.assertEquals(ordersPage.getDynamicDetail("shipping-info","city-state-zip"),city + "," +zipCode);
		Assert.assertEquals(ordersPage.getDynamicDetail("shipping-info","country"),countryName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 29: Verify Shipping Method");
		Assert.assertTrue(ordersPage.getShippingtMethodInfor(shippingMethod));
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 30: Verify Gift Wrapping Detail");
		Assert.assertEquals(ordersPage.getGiftWrappingDetail(),"Gift wrapping: No");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 31: Verify Total Price");
		Assert.assertEquals(ordersPage.getTotalPriceText(), "$2,500.00");
		
		ExtentTestManager.getTest().log(Status.INFO, "Checkout - Step 32: Verify Order Number");
		Assert.assertEquals(StringUtils.getDigits(ordersPage.getOrderNumber()), orderNumber);
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
