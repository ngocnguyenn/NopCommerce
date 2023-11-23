package pageObjects.NopCommerce.User;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIsNopCommerceUser.UserProductReviewPageUI;

public class UserProductReviewPageObject extends BasePage{
	private WebDriver driver;
	public UserProductReviewPageObject(WebDriver driver)
	{
		this.driver = driver;
	}
	public void enterToTitleTextbox(String string) {
		waitForElementVisible(driver, UserProductReviewPageUI.TITLE_TEXTBOX);
		sendKeyToElement(driver, UserProductReviewPageUI.TITLE_TEXTBOX, string);
	}
	public void enterToReviewTextbox(String string) {
		waitForElementVisible(driver, UserProductReviewPageUI.REVIEW_TEXTBOX);
		sendKeyToElement(driver, UserProductReviewPageUI.REVIEW_TEXTBOX, string);
	}
	public void clickToRatingRadio() {
		waitForElementClickable(driver, UserProductReviewPageUI.RATING_3_RADIO);
		clickToElement(driver, UserProductReviewPageUI.RATING_3_RADIO);
	}
	public void clickToSubmitButton() {
		waitForElementClickable(driver, UserProductReviewPageUI.SUBMIT_BUTTON);
		clickToElement(driver, UserProductReviewPageUI.SUBMIT_BUTTON);
	}
	
	public String getSuccessMessageText() {
		waitForElementVisible(driver, UserProductReviewPageUI.SUCCESS_MESSAGE);
		return getElementText(driver, UserProductReviewPageUI.SUCCESS_MESSAGE);
	}

}
