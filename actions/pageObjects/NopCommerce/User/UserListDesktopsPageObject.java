package pageObjects.NopCommerce.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIsNopCommerceUser.UserListDesktopsPageUI;

public class UserListDesktopsPageObject extends BasePage{
	WebDriver driver;
	public UserListDesktopsPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void selectItemInSortByText(String string) {
		waitForElementClickable(driver, UserListDesktopsPageUI.SORT_BY_DROPDOWN);
		selectIteminCustomDropdown(driver, UserListDesktopsPageUI.SORT_BY_DROPDOWN, UserListDesktopsPageUI.SORT_BY_OPTION, string);
		sleepInSecond(2);
	}
	public boolean isProductNameSortByAscending() {
		ArrayList<String> productList = new ArrayList<String>();
		
		List<WebElement> productNameList = getElements(driver, UserListDesktopsPageUI.PRODUCT_NAME);
		
		for (WebElement productName : productNameList)
		{
			productList.add(productName.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String product1 : productList)
		{
			sortedList.add(product1);
		}
		Collections.sort(sortedList);
		return sortedList.equals(productList);
	}
	public boolean isProductsNameSortByDescending() {
		ArrayList<String> productList = new ArrayList<String>();
		
		List<WebElement> productNameList = getElements(driver, UserListDesktopsPageUI.PRODUCT_NAME);
		
		for (WebElement productName : productNameList)
		{
			productList.add(productName.getText());
		}
		ArrayList<String> sortedList = new ArrayList<String>();
		for (String product1 : productList)
		{
			sortedList.add(product1);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(productList);
	}
	public boolean isProductPriceSortByAscending() {
		ArrayList<Double> productList = new ArrayList<Double>();
		
		List<WebElement> productNameList = getElements(driver, UserListDesktopsPageUI.PRODUCT_PRICE);
		
		for (WebElement productPrice : productNameList)
		{
			String priceText = productPrice.getText().replaceAll("[^0-9.]", "");
	        double price = Double.parseDouble(priceText);
	        productList.add(price);
		}
		ArrayList<Double> sortedList = new ArrayList<Double>();
		for (Double product1 : productList)
		{
			sortedList.add(product1);
		}
		Collections.sort(sortedList);
		return sortedList.equals(productList);
	}
	public boolean isProductPriceSortByDescending() {
		ArrayList<Double> productList = new ArrayList<Double>();
		
		List<WebElement> productNameList = getElements(driver, UserListDesktopsPageUI.PRODUCT_PRICE);
		
		for (WebElement productPrice : productNameList)
		{
			String priceText = productPrice.getText().replaceAll("[^0-9.]", "");
	        double price = Double.parseDouble(priceText);
	        productList.add(price);
		}
		ArrayList<Double> sortedList = new ArrayList<Double>();
		for (Double product1 : productList)
		{
			sortedList.add(product1);
		}
		Collections.sort(sortedList);
		Collections.reverse(sortedList);
		return sortedList.equals(productList);
	}
	public int numberOfProducts() {
		List<WebElement> productNameList = getElements(driver, UserListDesktopsPageUI.PRODUCT_NAME);
		int Count = productNameList.size();
		return Count;
	}
	public void selectItemInDisplayByValue(String string) {
		waitForElementClickable(driver, UserListDesktopsPageUI.DISPLAY_DROPDOWN);
		clickToElement(driver, UserListDesktopsPageUI.DISPLAY_DROPDOWN);
	}

}
