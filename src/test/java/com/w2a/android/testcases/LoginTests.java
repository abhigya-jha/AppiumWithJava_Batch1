package com.w2a.android.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.AndroidPageObjects.LoginPage;
import com.w2a.AndroidPageObjects.ProductPage;
import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

public class LoginTests extends TestSetUP {
	
	
	@Test
	public void loginTest() throws InterruptedException {
		
		LoginPage login = new LoginPage();
		System.out.println("hiii");
		login.enteruserName("standard_user");
		login.enterPassword("secret_sauce");
		ProductPage product=login.clickLoginButton();
		Assert.assertTrue(TestUtils.isElementDisplayed(product.productsHeader));
		
		
	}

}
