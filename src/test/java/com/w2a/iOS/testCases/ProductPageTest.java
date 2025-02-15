package com.w2a.iOS.testCases;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.w2a.PageObjects.CartPage;
import com.w2a.PageObjects.LoginPage;
import com.w2a.PageObjects.ProductPage;
import com.w2a.TestSetUp.TestSetUP;

public class ProductPageTest extends TestSetUP {

	LoginPage loginPage;

	@BeforeMethod
	public void beforeMethod(Method m) {
		extentTest.assignAuthor("Abhigya");
		System.out.println();
		loginPage = new LoginPage();
	}

	@Test
	public void verifyAddTOCart() {

		loginPage.enteruserName("standard_user");
		loginPage.enterPassword("secret_sauce");
		ProductPage productPage = loginPage.clickLoginButton();

		Assert.assertTrue(productPage.productsHeader.isDisplayed());

		// productPage.addProductToCart("Sauce Labs Bike Light");
		productPage.addProductToCart("Sauce Labs Bolt T-Shirt", productPage);
		productPage.addProductToCart("Sauce Labs Onesie", productPage);
		CartPage cartPage=productPage.clickOnCartLogo();

		Assert.assertTrue(cartPage.cartPageHeader.isDisplayed());
		Assert.assertEquals(cartPage.getCartHeaderText(), "YOUR CART");
	}

}
