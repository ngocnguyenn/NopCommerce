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
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserLoginPageObject;
import pageObjects.NopCommerce.User.UserSearchPageObject;
import reportConfigs.ExtentTestManager;

public class Search extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private UserSearchPageObject searchPage;
	private String email, password;
	private String relativeData = "Lenovo";
	private String absoluteData = "Lenovo IdeaCentre 600 All-in-One PC";
	private String keyWord = "Apple MacBook Pro";
	private String category = "1";
	
	@Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void BeforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion, Method method)
	{
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		email = UserDataMapper.getUserData().getEmail();
		password = UserDataMapper.getUserData().getPassWord();
		
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
	public void TC_01_Search_With_Empty_Data(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with empty Data");
		ExtentTestManager.getTest().log(Status.INFO, "Search with empty data - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with empty data - Step 02: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with empty data - Step 03: Verify Warning Message is correct");
		Assert.assertEquals(searchPage.getWarningMessageText(),"Search term minimum length is 3 characters");
		
	}
	
	@Test
	public void TC_02_Search_With_Data_Not_Exist(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with data not exist");
		ExtentTestManager.getTest().log(Status.INFO, "Search with data not exist - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with data not exist - Step 02: Enter to Search Textbox");
		searchPage.enterToSearchTextbox("Iphone 30");
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with data not exist - Step 03: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with data not exist - Step 04: Verify No Result Message is correct");
		Assert.assertEquals(searchPage.getNoResultMessageText(),"No products were found that matched your criteria.");
		
	}
	
	@Test
	public void TC_03_Search_With_Relative_Data(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with relative data");
		ExtentTestManager.getTest().log(Status.INFO, "Search with relative data - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with relative data - Step 02: Enter to Search Textbox");
		searchPage.enterToSearchTextbox(relativeData);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with relative data - Step 03: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with relative data - Step 04: Verify 2 products is displayed");
		Assert.assertEquals(searchPage.getNumberOfElement(relativeData),2);
	}
	
	@Test
	public void TC_04_Search_With_Absolute_Data(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with absolute data");
		ExtentTestManager.getTest().log(Status.INFO, "Search with absolute data - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with absolute data - Step 02: Enter to Search Textbox");
		searchPage.enterToSearchTextbox(absoluteData);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with absolute data - Step 03: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with absolute data - Step 04: Verify 1 product is displayed");
		Assert.assertEquals(searchPage.getNumberOfElement(absoluteData),1);
	}
	
	@Test
	public void TC_05_Advanced_Search_With_Parents_Categories(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Advanced Search with Parents Categories");
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Parents Categories - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Parents Categories - Step 02: Enter to Search Textbox");
		searchPage.enterToSearchTextbox(keyWord);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Parents Categories - Step 03: Check to Advanced Search Checkbox");
		searchPage.checkToAdvancedCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Parents Categories - Step 04: Select value in Category");
		searchPage.selectItemInCategoryDropDown(category);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Parents Categories - Step 05: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Parents Categories - Step 06: Verify No Result Message is correct");
		Assert.assertEquals(searchPage.getNoResultMessageText(),"No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_06_Advanced_Search_With_Sub_Categories(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Advanced Search with Sub Categories");
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Sub Categories - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Sub Categories - Step 02: Enter to Search Textbox");
		searchPage.enterToSearchTextbox(keyWord);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Sub Categories - Step 03: Check to Advanced Search Checkbox");
		searchPage.checkToAdvancedCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Sub Categories - Step 04: Select value in Category");
		searchPage.selectItemInCategoryDropDown(category);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Sub Categories - Step 05: Check to Sub Categories Checkbox");
		searchPage.checkToSubCategoriesCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Sub Categories - Step 06: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Sub Categories - Step 07: Verify 1 product is displayed");
		Assert.assertEquals(searchPage.getNumberOfElement(keyWord),1);
	}
	
	@Test
	public void TC_07_Advanced_Search_With_Incorrect_Manufacturer(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Advanced Search with Incorrect Manufacturer");
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 02: Enter to Search Textbox");
		searchPage.enterToSearchTextbox(keyWord);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 03: Check to Advanced Search Checkbox");
		searchPage.checkToAdvancedCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 04: Select value in Category");
		searchPage.selectItemInCategoryDropDown(category);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 05: Check to Sub Categories Checkbox");
		searchPage.checkToSubCategoriesCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 06: Select value in Manufacturer");
		searchPage.selectItemInManufacturerDropDown("HP");
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 07: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Incorrect Manufacturer - Step 08: Verify No Result Message is correct");
		Assert.assertEquals(searchPage.getNoResultMessageText(),"No products were found that matched your criteria.");
	}
	
	@Test
	public void TC_08_Advanced_Search_With_Correct_Manufacturer(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Advanced Search with Incorrect Manufacturer");
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 01: Navigate to Search Page");
		searchPage = homePage.clickToSearchLink();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 02: Enter to Search Textbox");
		searchPage.enterToSearchTextbox(keyWord);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 03: Check to Advanced Search Checkbox");
		searchPage.checkToAdvancedCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 04: Select value in Category");
		searchPage.selectItemInCategoryDropDown(category);
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 05: Check to Sub Categories Checkbox");
		searchPage.checkToSubCategoriesCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 06: Select value in Manufacturer");
		searchPage.selectItemInManufacturerDropDown("Apple");
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 07: Click to Search Button");
		searchPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Advanced Search with Correct Manufacturer - Step 08: Verify 1 product is displayed");
		Assert.assertEquals(searchPage.getNumberOfElement(keyWord),1);
	}
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
