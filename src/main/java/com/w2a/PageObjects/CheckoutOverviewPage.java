package com.w2a.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.w2a.TestSetUp.TestSetUP;
import com.w2a.Utilities.TestUtils;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class CheckoutOverviewPage extends TestSetUP {

	public CheckoutOverviewPage() {
		PageFactory.initElements(new AppiumFieldDecorator(TestSetUP.getDriver()), this);

	}

	@iOSXCUITFindBy(accessibility = "test-FINISH")
	public WebElement finishButton;

	public CheckoutCompletePage clickOnFinishButton() {
		TestUtils.click(finishButton, "finishButton");
		return new CheckoutCompletePage();
	}

}
