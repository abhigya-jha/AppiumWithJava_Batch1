package com.w2a.AndroidPageObjects;

import org.openqa.selenium.By;

import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

import io.appium.java_client.AppiumBy;

public class LoginPage extends TestSetUP {

	By userName = AppiumBy.accessibilityId("test-Username");
	By password = AppiumBy.accessibilityId("test-Password");
	By loginButton = AppiumBy.accessibilityId("test-LOGIN");

	public LoginPage enteruserName(String userName) {
		TestUtils.type(this.userName, userName, "UserName");
		return this;
	}

	public LoginPage enterPassword(String password) {
		TestUtils.type(this.password, password, "Password");
		return this;
	}
	
	public ProductPage clickLoginButton() {
		TestUtils.click(this.loginButton,"Login Button");
		return new ProductPage();
	}

}
