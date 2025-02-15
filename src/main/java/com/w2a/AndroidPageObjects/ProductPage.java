package com.w2a.AndroidPageObjects;

import org.openqa.selenium.By;

import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

import io.appium.java_client.AppiumBy;

public class ProductPage extends TestSetUP {

	public By productsHeader = AppiumBy.xpath("//android.widget.TextView[@text=\"PRODUCTS\"]");

	public By backToProducts = AppiumBy.accessibilityId("test-BACK TO PRODUCTS");

	public By cartLogo = AppiumBy.xpath(
			"//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView");

	public void addProductTocart(String product) // Sauce Labs Backpack
	{

		String addToCartXpath = "//android.widget.TextView[@text=\"productName\"]/following-sibling::android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]";
		TestUtils.ScrollAndClick(TestSetUP.getDriver(), AppiumBy.xpath(addToCartXpath.replace("productName", product)));

	}

	public void clickOnCartLogo() {
		TestUtils.click(cartLogo, "cartLogo");
	}
	

}
