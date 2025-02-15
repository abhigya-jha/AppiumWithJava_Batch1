package com.w2a.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CartPage extends TestSetUP {
	
	public CartPage() {
		PageFactory.initElements(new AppiumFieldDecorator(TestSetUP.getDriver()), this);
	}

	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"YOUR CART\"`]")
	public WebElement cartPageHeader;
	
	@iOSXCUITFindBy(accessibility = "test-CHECKOUT")
	public WebElement checkoutButton;
	
	public String getCartHeaderText() {
		return cartPageHeader.getText();
	}
	
	public CheckoutInfoPage clickOnCheckoutButton() {
		TestUtils.click(checkoutButton,"checkoutButton");
		return new CheckoutInfoPage();
	}

}
