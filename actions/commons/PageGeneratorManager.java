package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.NopCommerce.Admin.AdminProductsPageObject;
import pageObjects.NopCommerce.Admin.AdminDashboardPageObject;
import pageObjects.NopCommerce.Admin.AdminProductDetailPageObject;
import pageObjects.NopCommerce.User.UserAddressesAddPageObject;
import pageObjects.NopCommerce.User.UserAddressesPageObject;
import pageObjects.NopCommerce.User.UserChangePasswordPageObject;
import pageObjects.NopCommerce.User.UserCheckoutPageObject;
import pageObjects.NopCommerce.User.UserComparePageObject;
import pageObjects.NopCommerce.User.UserCustomerInforPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserListComputerPageObject;
import pageObjects.NopCommerce.User.UserListDesktopsPageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserOrdersPageObject;
import pageObjects.NopCommerce.User.UserProductDetailPageObject;
import pageObjects.NopCommerce.User.UserProductReviewPageObject;
import pageObjects.NopCommerce.User.UserRecentlyViewProductsPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import pageObjects.NopCommerce.User.UserSearchPageObject;
import pageObjects.NopCommerce.User.UserShoppingCartPageObject;
import pageObjects.NopCommerce.User.UserWishListPageObject;

public class PageGeneratorManager {

	public static UserHomePageObject getUserHomePageObject(WebDriver driver)
	{
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getUserLoginPageObject(WebDriver driver)
	{
		return new UserLoginPageObject(driver);
	}
	public static UserRegisterPageObject getUserRegisterPageObject(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	public static UserAddressesPageObject getUserAddressesPageObject(WebDriver driver) {
		return new UserAddressesPageObject(driver);
	}
	public static UserAddressesAddPageObject getUserAddressesAddPageObject(WebDriver driver) {
		return new UserAddressesAddPageObject(driver);
	}
	public static UserChangePasswordPageObject getUserChangePasswordPageObject(WebDriver driver) {
		return new UserChangePasswordPageObject(driver);
	}
	public static UserCustomerInforPageObject getUserCustomerInforPageObject(WebDriver driver) {
		return new UserCustomerInforPageObject(driver);
	}

	public static UserProductReviewPageObject getUserProductReviewPageObject(WebDriver driver) {
		return new UserProductReviewPageObject(driver);
	}
	public static UserProductDetailPageObject getUserProductDetailPageObject(WebDriver driver) {
		return new UserProductDetailPageObject(driver);
	}
	public static UserSearchPageObject getUserSearchPageObject(WebDriver driver) {
		return new UserSearchPageObject(driver);
	}
	public static UserListComputerPageObject getUserListComputerPageObject(WebDriver driver) {
		return new UserListComputerPageObject(driver);
	}
	public static UserListDesktopsPageObject getUserListDesktopsPageObject(WebDriver driver) {
		return new UserListDesktopsPageObject(driver);
	}
	public static UserWishListPageObject getUserWishListPageObject(WebDriver driver) {
		return new UserWishListPageObject(driver);
	}
	public static UserShoppingCartPageObject getUserShoppingCartPageObject(WebDriver driver) {
		return new UserShoppingCartPageObject(driver);
	}
	public static UserComparePageObject getUserComparePageObject(WebDriver driver) {
		return new UserComparePageObject(driver);
	}
	public static UserRecentlyViewProductsPageObject getUserRecentlyViewProductsPageObject(WebDriver driver) {
		return new UserRecentlyViewProductsPageObject(driver);
	}
	public static UserCheckoutPageObject getUserCheckoutPageObject(WebDriver driver) {
		return new UserCheckoutPageObject(driver);
	}
	public static UserOrdersPageObject getUserOrdersPageObject(WebDriver driver) {
		return new UserOrdersPageObject(driver);
	}
	public static AdminDashboardPageObject getAdminDashboardPageObject(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	public static AdminProductsPageObject getAdminProductsPageObject(WebDriver driver) {
		return new AdminProductsPageObject(driver);
	}
	public static AdminProductDetailPageObject getAdminProductDetailPageObject(WebDriver driver) {
		return new AdminProductDetailPageObject(driver);
	}
}
