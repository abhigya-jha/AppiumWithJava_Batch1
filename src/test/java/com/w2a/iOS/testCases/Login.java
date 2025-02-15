package com.w2a.iOS.testCases;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.w2a.PageObjects.LoginPage;
import com.w2a.PageObjects.ProductPage;
import com.w2a.TestSetUp.TestSetUP;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;

public class Login extends TestSetUP {
	LoginPage loginPage;

	/**
	 * This testcase will verify the login feature with valid UserName and Password
	 * 
	 * @author Abhigya
	 * @param
	 * @return Null
	 * @since 10-27-2024
	 * @version 1.0
	 * @exception
	 */

	@BeforeMethod
	public void beforeMethod(Method m) {
		extentTest.assignAuthor("Abhigya");
		System.out.println();
		loginPage = new LoginPage();
	}

	@Test
	public void VerifyLoginWithValidCredential() throws MalformedURLException {
		SoftAssert softAssert = new SoftAssert();
		

		loginPage.enteruserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		ProductPage product =loginPage.clickLoginButton();
		
		Assert.assertTrue(product.productsHeader.isDisplayed());
		
	}


//name == "test-Item title" AND label == "Sauce Labs Bike Light"
	
//**/XCUIElementTypeOther[`name == "test-ADD TO CART"`][2]
	

}
