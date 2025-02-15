package com.w2a.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends TestSetUP {

	public LoginPage() {
		
		PageFactory.initElements(new AppiumFieldDecorator(TestSetUP.getDriver()), this);
	}

	// Initializing the PageFacotry -> Always Initialize the PageFactory in the Each
	// Page Class

	
	@AndroidFindBy(accessibility = "test-Username")
	@iOSXCUITFindBy(accessibility = "test-Username")
	public WebElement userName;

	@AndroidFindBy(accessibility = "test-Password")
	@iOSXCUITFindBy(accessibility = "test-Password")
	public WebElement password;

	@AndroidFindBy(accessibility = "test-LOGIN")
	@iOSXCUITFindBy(accessibility = "test-LOGIN")
	public WebElement loginButton;
	


	public LoginPage enteruserName(String userName) {
		TestUtils.type(this.userName, userName,"UserName");
		return this;
	}

	public LoginPage enterPassword(String password) {
		TestUtils.type(this.password, password,"Password");
		return this;
	}

	public ProductPage clickLoginButton() {
		TestUtils.click(this.loginButton,"Login Button");
		return new ProductPage();
	}

}
