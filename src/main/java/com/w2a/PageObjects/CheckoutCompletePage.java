package com.w2a.PageObjects;

import org.openqa.selenium.support.PageFactory;

import com.w2a.TestSetUp.TestSetUP;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CheckoutCompletePage extends TestSetUP{
	
	public CheckoutCompletePage() {
		PageFactory.initElements(new AppiumFieldDecorator(TestSetUP.getDriver()), this);
	}
	
	

}
