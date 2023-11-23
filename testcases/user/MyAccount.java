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
import commons.PageGeneratorManager;
import learn.nopcommerce.data.UserDataMapper;
import pageObjects.NopCommerce.User.UserAddressesAddPageObject;
import pageObjects.NopCommerce.User.UserAddressesPageObject;
import pageObjects.NopCommerce.User.UserChangePasswordPageObject;
import pageObjects.NopCommerce.User.UserCustomerInforPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserProductDetailPageObject;
import pageObjects.NopCommerce.User.UserProductReviewPageObject;
import reportConfigs.ExtentTestManager;

public class MyAccount extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private UserAddressesPageObject addressesPage;
	private UserAddressesAddPageObject addressesAddPage;
	private UserChangePasswordPageObject changePasswordPage;
	private UserProductDetailPageObject productDetailPage;
	private UserProductReviewPageObject productReviewPage;
	private String email = UserDataMapper.getUserData().getEmail();
	private String password = UserDataMapper.getUserData().getPassWord();
	private String firstName = UserDataMapper.getUserData().getFirstName();
	private String lastName = UserDataMapper.getUserData().getLastName();
	private String dateOfBirth = "1";
	private String monthOfBirth = "1";
	private String yearOfBirth = "1999";
	private String companyName = "auto";
	private String countryValue = "82";
	private String countryName = "Viet Nam";
	private String city = "Ho Chi Minh";
	private String address1 = "123/04 Le Lai";
	private String address2 = "234/05 Hai Phong";
	private String zipCode = "123456789";
	private String phoneNumber = "0123456789";
	private String faxNumber = "9876543210";
	private String newPassword = "654321";

	@Parameters({ "envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion" })
	@BeforeClass
	public void BeforeClass(@Optional("local") String envName, @Optional("dev") String serverName,
			@Optional("chrome") String browserName, @Optional("localhost") String ipAddress,
			@Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion,
			Method method) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = new UserHomePageObject(driver);
		loginPage = new UserLoginPageObject(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify My Account link is displayed");
		Assert.assertTrue(homePage.myAccountLinkIsDisplayed());
	}

	@Test
	public void TC_01_Update_Customer_Infor(Method method) {
		ExtentTestManager.startTest(method.getName(), "Update customer infor");
		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 01: Click to My account link");
		customerInforPage = homePage.clickToMyAccountLink();

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 02: Click to Customer Infor Page");
		customerInforPage.openPageAtMyAccountByPageName(driver, "Customer");

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 03: Enter to Firstname Textbox");
		customerInforPage.enterToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 04: Enter to Lastname Textbox");
		customerInforPage.enterToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 05: Enter to Date Combobox");
		customerInforPage.enterToDateOfBirth(dateOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 06: Enter to Month Combobox");
		customerInforPage.enterToMonthOfBirth(monthOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 07: Enter to Year Combobox");
		customerInforPage.enterToYearOfBirth(yearOfBirth);

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 08: Enter to Email Textbox");
		customerInforPage.enterToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 09: Enter to Company name Textbox");
		customerInforPage.enterToCompanyNameTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 10: Click to Save button");
		customerInforPage.clickToSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "Customer Infor - Step 11: Verify Success message is displayed");
		Assert.assertEquals(customerInforPage.getSuccessMessageText(),
				"The customer info has been updated successfully.");
	}

	@Test
	public void TC_02_Update_Addresses(Method method) {
		ExtentTestManager.startTest(method.getName(), "Update Addresses");
		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 01: Click to Addresses Page");
		customerInforPage.openPageAtMyAccountByPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getUserAddressesPageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 02: Click to Add new button");
		addressesAddPage = addressesPage.clickToAddNewButton();

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 03: Enter to Firstname Textbox");
		addressesAddPage.enterToFirstNameTextbox(firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 04: Enter to Lastname Textbox");
		addressesAddPage.enterToLastNameTextbox(lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 05: Enter to Email Textbox");
		addressesAddPage.enterToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 06: Enter to Company Textbox");
		addressesAddPage.enterToCompanyTextbox(companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 07: Enter to Country Textbox");
		addressesAddPage.selectToCountryDropDown(countryValue);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 08: Enter to City Textbox");
		addressesAddPage.enterToCityTextbox(city);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 09: Enter to Address 1 Textbox");
		addressesAddPage.enterToAddress1Textbox(address1);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 10: Enter to Address 2 Textbox");
		addressesAddPage.enterToAddress2Textbox(address2);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 11: Enter to Zipcode Textbox");
		addressesAddPage.enterToZipcodeTextbox(zipCode);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 12: Enter to Phone Number Textbox");
		addressesAddPage.enterToPhoneNumberTextbox(phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 13: Enter to Fax Number Textbox");
		addressesAddPage.enterToFaxNumberTextbox(faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 14: Click to Save Button");
		addressesPage = addressesAddPage.clickToSaveButton();

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 15: Verify Success message is displayed");
		Assert.assertEquals(addressesPage.getSuccessMessageText(), "The new address has been added successfully.");

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 16: Verify Name is correct");
		Assert.assertEquals(addressesPage.getDynamicText("name"), firstName + " " + lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 17: Verify Email is correct");
		Assert.assertEquals(addressesPage.getDynamicText("email"),"Email: " + email);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 18: Verify Phone Number is correct");
		Assert.assertEquals(addressesPage.getDynamicText("phone"),"Phone number: " + phoneNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 19: Verify Fax Number is correct");
		Assert.assertEquals(addressesPage.getDynamicText("fax"), "Fax number: " + faxNumber);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 20: Verify Company is correct");
		Assert.assertEquals(addressesPage.getDynamicText("company"), companyName);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 21: Verify Address 1 is correct");
		Assert.assertEquals(addressesPage.getDynamicText("address1"), address1);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 22: Verify Address 2 is correct");
		Assert.assertEquals(addressesPage.getDynamicText("address2"), address2);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 23: Verify Name is correct");
		Assert.assertEquals(addressesPage.getDynamicText("city-state-zip"), city + ", " + zipCode);

		ExtentTestManager.getTest().log(Status.INFO, "Update Addresses - Step 24: Verify Country is correct");
		Assert.assertEquals(addressesPage.getDynamicText("country"), countryName);
	}

	@Test
	public void TC_03_Change_Password(Method method) {
		ExtentTestManager.startTest(method.getName(), "Change Password");
		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 01: Click to Change Password Page");
		addressesPage.openPageAtMyAccountByPageName(driver, "Change password");
		changePasswordPage = PageGeneratorManager.getUserChangePasswordPageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 02: Enter to Old Password Textbox");
		changePasswordPage.enterToOldPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 03: Enter to New Password Textbox");
		changePasswordPage.enterToNewPasswordTextbox(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 04: Enter to Confirm Password Textbox");
		changePasswordPage.enterToConfirmPasswordTextbox(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 05: Click to Change Password Button");
		changePasswordPage.clickToChangePasswordButton();

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 06: Verify Success message is displayed");
		Assert.assertEquals(changePasswordPage.getSuccessMessageText(), "Password was changed");

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 07: Click to Close success message");
		changePasswordPage.clickToClosePasswordButton();

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 08: Click to Logout Link");
		changePasswordPage.clickToLogOutLink(driver);
		homePage = PageGeneratorManager.getUserHomePageObject(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 09: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 10: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 11: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 12: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 13: Verify Login error message is displayed");
		Assert.assertEquals(loginPage.getLoginErrorMessageText(),
				"Login was unsuccessful. Please correct the errors and try again."
						+ "\nThe credentials provided are incorrect");

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 14: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 15: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(newPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 16: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		ExtentTestManager.getTest().log(Status.INFO, "Change Password - Step 17: Verify My Account link is displayed");
		Assert.assertTrue(homePage.myAccountLinkIsDisplayed());
	}

	@Test
	public void TC_04_Add_Review_Product(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Add Review");
		ExtentTestManager.getTest().log(Status.INFO, "Add Review - Step 01: Click to Product Link");
		productDetailPage = homePage.clickToProductLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add Review - Step 02: Click to Add review");
		productReviewPage = productDetailPage.clickToAddReviewLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add Review - Step 03: Enter to Title textbox");
		productReviewPage.enterToTitleTextbox("Review Title");
		
		ExtentTestManager.getTest().log(Status.INFO, "Add Review - Step 04: Enter to Review Text textbox");
		productReviewPage.enterToReviewTextbox("Review Text");
		
		ExtentTestManager.getTest().log(Status.INFO, "Add Review - Step 05: Click to Rating");
		productReviewPage.clickToRatingRadio();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add Review - Step 06: Click to Submit button");
		productReviewPage.clickToSubmitButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Add Review - Step 07: Verify Success message is displayed");
		Assert.assertEquals(productReviewPage.getSuccessMessageText(), "Product review is successfully added.");
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
