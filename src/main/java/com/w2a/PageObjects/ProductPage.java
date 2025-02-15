package com.w2a.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBys;

public class ProductPage extends TestSetUP {

	public ProductPage() {
		PageFactory.initElements(new AppiumFieldDecorator(TestSetUP.getDriver()), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text=\"PRODUCTS\"]")
	@iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"PRODUCTS\"`]")
	public WebElement productsHeader;

	@AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
	@iOSXCUITFindBys({ @iOSXCUITBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"test-Item title\"`]") })
	public List<WebElement> listOfProducts;

	@iOSXCUITFindBys({ @iOSXCUITBy(xpath = "//XCUIElementTypeOther[@name=\"test-ADD TO CART\"]") })
	public List<WebElement> addToCardButton;

	@iOSXCUITFindBy(accessibility = "test-ADD TO CART")
	public WebElement addTOCart;

	@iOSXCUITFindBy(accessibility = "test-BACK TO PRODUCTS")
	public WebElement backToProducts;

	@iOSXCUITFindBy(xpath ="//XCUIElementTypeOther[@name=\"test-Cart\"]/XCUIElementTypeOther")
	public WebElement cartLogo;

	public ProductPage addToCart(WebElement element) {
		TestUtils.click(element);
		return this;

	}

	public CartPage clickOnCartLogo() {
		
		int height = cartLogo.getSize().getHeight();// 51
		int width = cartLogo.getSize().getWidth();// 51

		Point point = cartLogo.getLocation();

		System.out.println("X-->" + point.x);// 369
		System.out.println("Y-->" + point.y);// 29

		int desiredX = point.x + (width / 2);
		int desiredY = point.y + (height / 2) + 10;
		System.out.println("desiredX-->" + desiredX);// 369
		System.out.println("desiredY-->" + desiredY);// 29

		TestUtils.tap(TestSetUP.getDriver(), desiredX, desiredY);
		return new CartPage();
		
	}

	// Sauce Labs Bike Light
	public void addProductToCart(String productName, ProductPage productPage) {
		System.out.println("List Of Products-> " + productPage.listOfProducts.size());
		System.out.println("List Of Add To Carts-> " + productPage.addToCardButton.size());

		TestUtils.ScrollIntoElement( TestSetUP.getDriver(), productsHeader);
		// get the index of the Product on the page
		int index = 0;

		for (WebElement product : listOfProducts) {
			if (product.getText().equals(productName)) {
				System.out.println("inside if-> " + product.getText());
				break;
			}

			index++;
		}
		System.out.println("Index--> " + index);
		TestUtils.ScrollAndClick(TestSetUP.getDriver(), listOfProducts.get(index));
		// driver.findElement(AppiumBy.accessibilityId("test-BACK TO
		// PRODUCTS")).click();
		TestUtils.click(addTOCart);
		TestUtils.click(backToProducts);
		// TestUtils.click(addToCardButton.get(index),productName);

	}

}
