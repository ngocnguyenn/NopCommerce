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
import pageFactoryNopCommerce.RegisterPageObject;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import reportConfigs.ExtentTestManager;

public class Register extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName = "automation";
	private String lastName = "test";
	private String email = firstName + lastName + getRandomNumber() + "@gmail.com";
	private String password = "12345678";
	
	@Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void beforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion) {
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		
		homePage = new UserHomePageObject(driver);
		registerPage = new UserRegisterPageObject(driver);
	}
	
	@Test
	public void TC_01_Register_With_Empty_Data(Method method)
	{
		ExtentTestManager.startTest(method.getName(),"Register with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 03: Verify Firstname error message is diplayed");
		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 04: Verify Lastname error message is diplayed");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 05: Verify Email error message is diplayed");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");

		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 06: Verify Password error message is diplayed");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		
		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 07: Verify Confirm password error message is diplayed");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}
	@Test 
	public void TC_02_Register_With_Invalid_Email(Method method)
	{
		ExtentTestManager.startTest(method.getName(),"Register with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to First Name Textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Last Name Textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email Textbox");
		registerPage.enterToEmailTextbox("asmamsasa");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password Textbox");
		registerPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 08: Verify Email error message is diplayed");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");
	}
	
	@Test 
	public void TC_03_Register_With_Valid_Information(Method method)
	{
		ExtentTestManager.startTest(method.getName(),"Register with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to First Name Textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Last Name Textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email Textbox");
		registerPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password Textbox");
		registerPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify Register successful message is displayed");
		Assert.assertEquals(registerPage.getSuccessMessageText(), "Your registration completed");
		
		
	}
	@Test 
	public void TC_04_Register_With_Exists_Email(Method method)
	{
		ExtentTestManager.startTest(method.getName(),"Register with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to First Name Textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Last Name Textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email Textbox");
		registerPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password Textbox");
		registerPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 08: Verify Email already exists message is displayed");
		Assert.assertEquals(registerPage.getEmailExistsMessageText(), "The specified email already exists");
	}
	
	@Test 
	public void TC_05_Register_With_Password_Less_6_Characters(Method method)
	{
		ExtentTestManager.startTest(method.getName(),"Register with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to First Name Textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Last Name Textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email Textbox");
		registerPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password Textbox");
		registerPage.enterToPasswordTextbox("12345");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextbox("12345");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 08: Verify Password error message is diplayed");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:"
				+ "\nmust have at least 6 characters");
	}
	@Test 
	public void TC_06_Register_With_Confirm_Password_Not_Match(Method method)
	{
		ExtentTestManager.startTest(method.getName(),"Register with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 01: Navigate to Register page");
		registerPage = homePage.clickToRegisterLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 02: Enter to First Name Textbox");
		registerPage.enterToFirstNameTextbox(firstName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 03: Enter to Last Name Textbox");
		registerPage.enterToLastNameTextbox(lastName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 04: Enter to Email Textbox");
		registerPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 05: Enter to Password Textbox");
		registerPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 06: Enter to Confirm Password Textbox");
		registerPage.enterToConfirmPasswordTextbox("1234567");
		
		ExtentTestManager.getTest().log(Status.INFO, "Register - Step 07: Click to Register button");
		registerPage.clickToRegisterButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Rgister - Step 08: Verify Confirm Password error message is diplayed");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		closeBrowserDriver();
	}
}
