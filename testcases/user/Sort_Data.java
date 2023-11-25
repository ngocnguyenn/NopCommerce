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
import pageObjects.NopCommerce.User.UserHomePageObject;
import pageObjects.NopCommerce.User.UserListComputerPageObject;
import pageObjects.NopCommerce.User.UserListDesktopsPageObject;
import reportConfigs.ExtentTestManager;

public class Sort_Data extends BaseTest{
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserListComputerPageObject listComputerPage;
	private UserListDesktopsPageObject listDesktopsPage;
	
	@Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void BeforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion, Method method)
	{
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		homePage = new UserHomePageObject(driver);
		listComputerPage = homePage.clickToComputerLink();
		listDesktopsPage = listComputerPage.clickToDesktopsLink();
	}
	
	@Test
	public void TC_01_Sort_A_to_Z(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Sort A to Z");
		ExtentTestManager.getTest().log(Status.INFO, "Sort A to Z - Step 01: Click to Sort by Dropdown");
		listDesktopsPage.selectItemInSortByText("Name: A to Z");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort A to Z - Step 02: Verify product sort by ascending");
		Assert.assertTrue(listDesktopsPage.isProductNameSortByAscending());
	}
	
	@Test
	public void TC_02_Sort_Z_to_A(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Sort Z to A");
		ExtentTestManager.getTest().log(Status.INFO, "Sort Z to A - Step 01: Click to Sort by Dropdown");
		listDesktopsPage.selectItemInSortByText("Name: Z to A");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort Z to A - Step 02: Verify product sort by Descending");
		Assert.assertTrue(listDesktopsPage.isProductsNameSortByDescending());
	}
	@Test
	public void TC_03_Sort_Price_Low_To_High(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Sort Price Low to High");
		ExtentTestManager.getTest().log(Status.INFO, "Sort Price Low to High - Step 01: Click to Sort by Dropdown");
		listDesktopsPage.selectItemInSortByText("Price: Low to High");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort Price Low to High - Step 02: Verify product sort by price low to high");
		Assert.assertTrue(listDesktopsPage.isProductPriceSortByAscending());
	}
	@Test
	public void TC_04_Sort_Price_High_To_Low(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Sort Price High to Low");
		ExtentTestManager.getTest().log(Status.INFO, "Sort Price High to Low - Step 01: Click to Sort by Dropdown");
		listDesktopsPage.selectItemInSortByText("Price: High to Low");
		
		ExtentTestManager.getTest().log(Status.INFO, "Sort Price High to Low - Step 02: Verify product sort by price high to low");
		Assert.assertTrue(listDesktopsPage.isProductPriceSortByDescending());
	}
	@Test
	public void TC_05_Display_3_Products_Per_Page(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Display 3 products per page");
		ExtentTestManager.getTest().log(Status.INFO, "Display 3 products per page - Step 01: Click to Display Dropdown");
		listDesktopsPage.selectItemInDisplayByValue("3");
		
		ExtentTestManager.getTest().log(Status.INFO, "Display 3 products per page - Step 02: Verify number of product per page");
		Assert.assertTrue(listDesktopsPage.numberOfProducts() <= 3);
	}
	@Test
	public void TC_06_Display_6_Products_Per_Page(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Display 6 products per page");
		ExtentTestManager.getTest().log(Status.INFO, "Display 6 products per page - Step 01: Click to Display Dropdown");
		listDesktopsPage.selectItemInDisplayByValue("3");
		
		ExtentTestManager.getTest().log(Status.INFO, "Display 6 products per page - Step 02: Verify number of product per page");
		Assert.assertTrue(listDesktopsPage.numberOfProducts() <= 6);
	}
	@Test
	public void TC_07_Display_8_Products_Per_Page(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Display 9 products per page");
		ExtentTestManager.getTest().log(Status.INFO, "Display 9 products per page - Step 01: Click to Display Dropdown");
		listDesktopsPage.selectItemInDisplayByValue("3");
		
		ExtentTestManager.getTest().log(Status.INFO, "Display 9 products per page - Step 02: Verify number of product per page");
		Assert.assertTrue(listDesktopsPage.numberOfProducts() <= 9);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
