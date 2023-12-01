package user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import learn.nopcommerce.data.UserDataMapper;
import pageObjects.NopCommerce.User.UserComparePageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserProductDetailPageObject;
import pageObjects.NopCommerce.User.UserRecentlyViewProductsPageObject;
import pageObjects.NopCommerce.User.UserShoppingCartPageObject;
import pageObjects.NopCommerce.User.UserWishListPageObject;
import reportConfigs.ExtentTestManager;

public class WishList extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserProductDetailPageObject productDetailPage;
	private UserWishListPageObject wishListPage;
	private UserShoppingCartPageObject shoppingCartPage;
	private UserComparePageObject comparePage;
	private UserRecentlyViewProductsPageObject recentlyViewProductPage;
	private String email, password, firstName, lastName;
	private String productTitle = "Apple MacBook Pro 13-inch";
	private String productTitle2 = "Build your own computer";
	private String productTitle3 = "HTC One M8 Android L 5.0 Lollipop";
	private String productTitle4 = "$25 Virtual Gift Card";
	
	@Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void BeforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion, Method method)
	{
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		email = UserDataMapper.getUserData().getEmail();
		password = UserDataMapper.getUserData().getPassWord();
		firstName = UserDataMapper.getUserData().getFirstName();
		lastName = UserDataMapper.getUserData().getLastName();
		
		homePage = new UserHomePageObject(driver);
		
		loginPage = homePage.clickToLoginLink();
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		Assert.assertTrue(homePage.myAccountLinkIsDisplayed());
		
		productDetailPage = homePage.clickToProductByName(productTitle);
	}
	
	@Test
	public void TC_01_Add_To_WishList(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Add to WishList");
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 01: Click to Add to WishList Button");
		productDetailPage.clickToAddWishListButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 02: Verify Success Message is displayed");
		Assert.assertEquals(productDetailPage.getSuccessMessageText(driver),"The product has been added to your wishlist");
		
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 03: Click to Close Message Button");
		productDetailPage.clickToCloseMessageButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 04: Navigate to WishList Page");
		wishListPage = productDetailPage.clickToWishListLinkFromHeader(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 05: Verify Product added successfully ");
		Assert.assertTrue(wishListPage.verifyProductAddedToWishList(productTitle));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 06: Navigate to WishList Page by Link");
		wishListPage.clickToWishListLinkByLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 07: Verify WishList Page is displayed");
		Assert.assertEquals(wishListPage.getPageTitle(),"Wishlist of " + firstName + " " + lastName );
		
		ExtentTestManager.getTest().log(Status.INFO, "Add to WishList - Step 08: Navigate to HomePage");
		homePage = wishListPage.clickToLogoImage(driver);
		
	}
	
	@Test
	public void TC_02_Add_Product_To_Cart_From_WishList(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Add product to Cart from WishList");
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart from WishList - Step 01: Navigate to WishList Page");
		wishListPage.clickToWishListLinkFromHeader(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart from WishList - Step 02: Click to Add to Cart Checkbox");
		wishListPage.clickToAddToCartCheckbox(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart from WishList - Step 03: Click to Add to Cart Button");
		shoppingCartPage = wishListPage.clickToAddToCartButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart from WishList - Step 04: Verify Product added successfully");
		Assert.assertTrue(shoppingCartPage.verifyProductAddedToCart(productTitle));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart from WishList - Step 05: Navigate to WishList Page");
		wishListPage = shoppingCartPage.clickToWishListLinkFromHeader(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add product to Cart from WishList - Step 05: Verify Product removed successfully");
		Assert.assertTrue(wishListPage.verifyProductRemovedToWishList(productTitle));
	}
	
	@Test
	public void TC_03_Remove_Product_From_WishList(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Remove product from WishList");
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 01: Navigate to HomePage");
		homePage = wishListPage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 02: Navigate to Product Detail Page");
		productDetailPage = homePage.clickToProductByName(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 03: Click to Add to WishList Button");
		productDetailPage.clickToAddWishListButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 04: Verify Success Message is displayed");
		Assert.assertEquals(productDetailPage.getSuccessMessageText(driver),"The product has been added to your wishlist");
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 05: Click to Close Message Button");
		productDetailPage.clickToCloseMessageButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 06: Navigate to WishList Page");
		wishListPage = productDetailPage.clickToWishListLinkFromHeader(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 07: Click to Remove Button");
		wishListPage.clickToRemoveButton(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Remove product from WishList - Step 08: Verify Product removed successfully");
		Assert.assertTrue(wishListPage.verifyProductRemovedToWishList(productTitle));
	}
	
	@Test
	public void TC_04_Add_Product_To_Compare(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Add products to compare");
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 01: Navigate to HomePage");
		homePage = wishListPage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 02: Add product 1 to Compare");
		homePage.clickToAddCompareListByTitle(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 03: Verify success message is displayed");
		Assert.assertEquals(homePage.getSuccessMessageText(driver),"The product has been added to your " + "product comparison");
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 04: Click to Close Message Button");
		homePage.clickToCloseMessageButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 05: Add product 2 to Compare");
		homePage.clickToAddCompareListByTitle(productTitle2);
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 06: Click to Close Message Button");
		homePage.clickToCloseMessageButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 07: Verify success message is displayed");
		Assert.assertEquals(homePage.getSuccessMessageText(driver),"The product has been added to your " + "product comparison");
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 08: Navigate to Compare Page");
		comparePage = homePage.clickToCompareLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 09: Verify Clear List Button is displayed");
		Assert.assertTrue(comparePage.verifyClearListButtonisDisplayed());
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 10: Verify Remove Button of product 1 is displayed");
		Assert.assertTrue(comparePage.verifyRemoveButtonisDisplayed(productTitle));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 11: Verify Remove Button of product 2 is displayed");
		Assert.assertTrue(comparePage.verifyRemoveButtonisDisplayed(productTitle2));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 12: Verify Price of product 1 is displayed");
		Assert.assertTrue(comparePage.verifyPriceisDisplayed(productTitle));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 13: Verify Price of product 2 is displayed");
		Assert.assertTrue(comparePage.verifyPriceisDisplayed(productTitle2));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 14: Click to Clear Button");
		comparePage.clickToClearListButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 15: Verify No Data is displayed");
		Assert.assertEquals(comparePage.getNoDataText(),"You have no items to compare.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 16: Verify Name of product 1 is Undisplayed");
		Assert.assertTrue(comparePage.verifyProductNameisUndisplayed(productTitle));
		
		ExtentTestManager.getTest().log(Status.INFO, "Add products to compare - Step 17: Verify Name of product 2 is displayed");
		Assert.assertTrue(comparePage.verifyProductNameisUndisplayed(productTitle2));
	}
	
	@Test
	public void TC_05_Recently_View_Products(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Recently View Products");
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 01: Navigate to HomePage");
		homePage = comparePage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 02: Navigate to Product 1 Detail Page");
		productDetailPage = homePage.clickToProductByName(productTitle);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 03: Navigate to HomePage");
		homePage = productDetailPage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 04: Navigate to Product 2 Detail Page");
		productDetailPage = homePage.clickToProductByName(productTitle2);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 05: Navigate to HomePage");
		homePage = productDetailPage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 06: Navigate to Product 3 Detail Page");
		productDetailPage = homePage.clickToProductByName(productTitle3);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 07: Navigate to HomePage");
		homePage = productDetailPage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 08: Navigate to Product 4 Detail Page");
		productDetailPage = homePage.clickToProductByName(productTitle4);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 09: Navigate to HomePage");
		homePage = productDetailPage.clickToLogoImage(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 10: Navigate to Recently View Products Page");
		recentlyViewProductPage = homePage.clickToRecentlyViewProductLink(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 11: Verify Name of product 1 is Undisplayed");
		Assert.assertTrue(recentlyViewProductPage.verifyProductNameisUndisplayed(productTitle));
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 12: Verify Name of product 2 is Displayed");
		Assert.assertTrue(recentlyViewProductPage.verifyProductNameisDisplayed(productTitle2));
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 13: Verify Name of product 3 is Displayed");
		Assert.assertTrue(recentlyViewProductPage.verifyProductNameisDisplayed(productTitle3));
		
		ExtentTestManager.getTest().log(Status.INFO, "Recently View Products - Step 14: Verify Name of product 4 is Displayed");
		Assert.assertTrue(recentlyViewProductPage.verifyProductNameisDisplayed(productTitle4));
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
