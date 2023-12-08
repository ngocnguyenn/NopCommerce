package admin;

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
import pageObjects.NopCommerce.Admin.AdminDashboardPageObject;
import pageObjects.NopCommerce.Admin.AdminLoginPageObject;
import pageObjects.NopCommerce.Admin.AdminProductDetailPageObject;
import pageObjects.NopCommerce.Admin.AdminProductsPageObject;
import reportConfigs.ExtentTestManager;

public class Search_Products extends BaseTest{
	private WebDriver driver;
	private AdminLoginPageObject loginPage;
	private AdminDashboardPageObject dashboardPage;
	private AdminProductsPageObject productsPage;
	private AdminProductDetailPageObject productDetailPage;
	private String email, password, productName;
	@Parameters({"envName", "serverName", "browser", "ipAddress", "portNumber", "osName", "osVersion"})
	@BeforeClass
	public void BeforeClass(@Optional("local") String envName, @Optional("dev") String serverName, @Optional("chrome") String browserName, @Optional("localhost") String ipAddress, @Optional("4444") String portNumber, @Optional("Windows") String osName, @Optional("10") String osVersion, Method method)
	{
		driver = getBrowserDriver(envName, serverName, browserName, ipAddress, portNumber, osName, osVersion);
		email = UserDataMapper.getUserData().getAdminEmail();
		password = UserDataMapper.getUserData().getAdminPassword();
		productName = "Lenovo IdeaCentre 600 All-in-One PC";
		
		loginPage = new AdminLoginPageObject(driver);
		loginPage.enterToEmailTextbox(email);
		loginPage.enterToPasswordTextbox(password);
		dashboardPage = loginPage.clickToLoginButton();
		dashboardPage.openDynamicPageByName("Catalog");
		dashboardPage.openDynamicPageByName("Products");
		productsPage = PageGeneratorManager.getAdminProductsPageObject(driver);
	}
	@Test
	public void TC_01_Search_With_Product_Name(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with product name");
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name - Step 01: Enter to Search Textbox");
		productsPage.enterToProductNameTextbox(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name - Step 02: Click to Search button");
		productsPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name - Step 03: Verify 1 product is displayed");
		Assert.assertEquals(productsPage.getNumberOfElement(productName),1);
	}
	
	@Test
	public void TC_02_Search_With_Product_Name_Category_UnSubcategories(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with product name/parent category/Unsubcategories");
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/Unsubcategories - Step 01: Enter to Search Textbox");
		productsPage.enterToProductNameTextbox(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/Unsubcategories - Step 02: Select Item in Category Dropdown");
		productsPage.selectItemInCategoryDropDownByItem("Computers");
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/Unsubcategories - Step 03: Uncheck to Search Subcategories Checkbox");
		productsPage.uncheckToSubCategoriesCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/Unsubcategories - Step 04: Click to Search button");
		productsPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/Unsubcategories  - Step 05: Verify 0 product is displayed");
		Assert.assertEquals(productsPage.getNumberOfElement(productName),0);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/Unsubcategories  - Step 06: Verify No data message is displayed");
		Assert.assertEquals(productsPage.getNoDataMessageText(),"No data available in table");
	}
	
	@Test
	public void TC_03_Search_With_Product_Name_Category_Subcategories(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with product name/parent category/subcategories");
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/subcategories - Step 01: Enter to Search Textbox");
		productsPage.enterToProductNameTextbox(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/subcategories - Step 02: Select Item in Category Dropdown");
		productsPage.selectItemInCategoryDropDownByItem("Computers");
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/subcategories - Step 03: Uncheck to Search Subcategories Checkbox");
		productsPage.checkToSubCategoriesCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/subcategories - Step 04: Click to Search button");
		productsPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/parent category/subcategories  - Step 05: Verify 0 product is displayed");
		Assert.assertEquals(productsPage.getNumberOfElement(productName),1);
	}
	
	@Test
	public void TC_04_Search_With_Product_Name_ChildCategory_UnSubcategories(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with product name/child category/Unsubcategories");
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/child category/Unsubcategories - Step 01: Enter to Search Textbox");
		productsPage.enterToProductNameTextbox(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/child category/Unsubcategories - Step 02: Select Item in Category Dropdown");
		productsPage.selectItemInCategoryDropDownByItem("Computers >> Desktops");
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/child category/Unsubcategories - Step 03: Uncheck to Search Subcategories Checkbox");
		productsPage.uncheckToSubCategoriesCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/child category/Unsubcategories - Step 04: Click to Search button");
		productsPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name/child category/Unsubcategories  - Step 05: Verify 0 product is displayed");
		Assert.assertEquals(productsPage.getNumberOfElement(productName),1);
	}
	
	@Test
	public void TC_05_Search_With_Product_Name_Manufacturer(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Search with product name and manufacturer");
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer - Step 01: Enter to Search Textbox");
		productsPage.enterToProductNameTextbox(productName);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer - Step 02: Select Item in Category Dropdown");
		productsPage.selectItemInCategoryDropDownByItem("All");
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer - Step 03: Uncheck to Search Subcategories Checkbox");
		productsPage.uncheckToSubCategoriesCheckbox();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer - Step 04: Select Item in Manufacturer Dropdown");
		productsPage.selectItemInManufacturerDropDownByItem("Apple");
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer - Step 05: Click to Search button");
		productsPage.clickToSearchButton();
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer  - Step 06: Verify 0 product is displayed");
		Assert.assertEquals(productsPage.getNumberOfElement(productName),0);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer  - Step 07: Verify No data message is displayed");
		Assert.assertEquals(productsPage.getNoDataMessageText(),"No data available in table");
	}
	
	@Test
	public void TC_06_Go_Directly_to_Product_SKU(Method method)
	{
		ExtentTestManager.startTest(method.getName(), "Go directly to product SKU");
		ExtentTestManager.getTest().log(Status.INFO, "Go directly to product SKU - Step 01: Enter to Search Textbox");
		productsPage.enterToSKUTextbox("LE_IC_600");
		
		ExtentTestManager.getTest().log(Status.INFO, "Go directly to product SKU - Step 02: Click to Search button");
		productDetailPage = productsPage.clickToGoButton(driver);
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer  - Step 07: Verify No data message is displayed");
		Assert.assertTrue(productDetailPage.getProductDetailTitle(productName));
		
		ExtentTestManager.getTest().log(Status.INFO, "Search with product name and manufacturer  - Step 07: Verify No data message is displayed");
		Assert.assertEquals(productDetailPage.getProductNameValue("value"),productName);
		
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
