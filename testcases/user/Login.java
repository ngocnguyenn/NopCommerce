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
import learn.nopcommerce.data.UserData;
import learn.nopcommerce.data.UserDataMapper;
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserRegisterPageObject;
import reportConfigs.ExtentTestManager;

public class Login extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private String  email, password;
	
	@Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void BeforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion, Method method)
	{
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		email = UserDataMapper.getUserData().getEmail();
		password = UserDataMapper.getUserData().getPassWord();
		
		homePage = new UserHomePageObject(driver);
		loginPage = new UserLoginPageObject(driver);
	}
	
	@Test
	public void TC_01_Login_With_Empty_Data(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Login with empty data");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Click to Login button");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Verify Email error message is displayed");
		Assert.assertEquals(loginPage.getEmailErrorMessageText(),"Please enter your email");
	}
	
	@Test
	public void TC_02_Login_With_Invalid_Email(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Login with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox("@2mmms");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Email error message is displayed");
		Assert.assertEquals(loginPage.getEmailErrorMessageText(),"Wrong email");
	}
	
	@Test
	public void TC_03_Login_With_Email_Not_Exists(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Login with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox("noregister@gmail.com");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Login error message is displayed");
		Assert.assertEquals(loginPage.getLoginErrorMessageText(),"Login was unsuccessful. Please correct the errors and try again." + 
						"\nNo customer account found");
	}
	
	@Test
	public void TC_04_Login_With_Empty_Password(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Login with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Click to Login button");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Verify Login error message is displayed");
		Assert.assertEquals(loginPage.getLoginErrorMessageText(),"Login was unsuccessful. Please correct the errors and try again." + 
								"\nThe credentials provided are incorrect" );
		
	}
	
	@Test
	public void TC_05_Login_With_Wrong_Password(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Login with invalid email");
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 01: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 03: Enter to Password textbox");
		loginPage.enterToPasswordTextbox("123456");
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 04: Click to Login button");
		loginPage.clickToLoginButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Login - Step 05: Verify Login error message is displayed");
		Assert.assertEquals(loginPage.getLoginErrorMessageText(),"Login was unsuccessful. Please correct the errors and try again." + 
								"\nThe credentials provided are incorrect" );
	}
	
	@Test
	public void TC_06_Login_With_Valid_Information(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Login with invalid email");
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
	
	@AfterClass(alwaysRun = true)
	public void afterClass()
	{
		closeBrowserDriver();
	}
}
