package com.w2a.android.testcases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w2a.AndroidPageObjects.LoginPage;
import com.w2a.AndroidPageObjects.ProductPage;
import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

public class ProductPageTest extends TestSetUP {

	@BeforeMethod
	public void beforeMethod(Method m) {
		extentTest.assignAuthor("Abhigya");
		System.out.println();
	}

	@Test
	public void verifyAddTOCart() {

		LoginPage login = new LoginPage();

		login.enteruserName("standard_user");
		login.enterPassword("secret_sauce");
		ProductPage product = login.clickLoginButton();
		Assert.assertTrue(TestUtils.isElementDisplayed(product.productsHeader));
		product.addProductTocart("Sauce Labs Backpack");
		product.addProductTocart("Sauce Labs Bike Light");
		product.addProductTocart("Sauce Labs Onesie");
		product.clickOnCartLogo();
		

	}

}
