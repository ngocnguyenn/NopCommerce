package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.NopCommerce.User.UserAddressesAddPageObject;
import pageObjects.NopCommerce.User.UserAddressesPageObject;
import pageObjects.NopCommerce.User.UserChangePasswordPageObject;
import pageObjects.NopCommerce.User.UserCustomerInforPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserProductDetailPageObject;
import pageObjects.NopCommerce.User.UserProductReviewPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;

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
}
