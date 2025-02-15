package com.w2a.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CheckoutInfoPage extends TestSetUP {

	public CheckoutInfoPage() {
		PageFactory.initElements(new AppiumFieldDecorator(TestSetUP.getDriver()), this);
	}

	@iOSXCUITFindBy(accessibility = "test-First Name")
	public WebElement firstName;

	@iOSXCUITFindBy(accessibility = "test-Last Name")
	public WebElement lastName;

	@iOSXCUITFindBy(accessibility = "test-Zip/Postal Code")
	public WebElement zipCode;

	@iOSXCUITFindBy(accessibility = "test-CONTINUE")
	public WebElement continueButton;
	
	
	
	public void enterFirstName(String value) {
		TestUtils.type(firstName, value);
	}
	
	public void enterLastName(String value) {
		TestUtils.type(lastName, value);
	}
	
	public void enterZipCode(String value) {
		TestUtils.type(zipCode, value);
	}
	
	public CheckoutOverviewPage clickOnContinue() {
		TestUtils.click(continueButton,"continueButton");
		return new CheckoutOverviewPage();
		
	}

}
