package com.w2a.Utilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.w2a.TestSetUp.TestSetUP;

import io.appium.java_client.AppiumDriver;

public class TestUtils extends TestSetUP {

	public static String screenshotPath;
	public static String screenshotName;

	public static void type(WebElement element, String value) {
		// Always wait for the element to be present before typing/sendKeys

		WaitForElement("visibilty", element);
		element.clear();
		element.sendKeys(value);
		extentTest.info("Entered " + value + " in username field");
	}

	public static void type(WebElement element, String value, String fieldName) {
		// Always wait for the element to be present before typing/sendKeys

		WaitForElement("visibilty", element);
		element.clear();
		element.sendKeys(value);
		extentTest.info("Entered " + "<b>" + value + "</b>" + " in " + "<b>" + fieldName + "</b>" + " Field");
	}

	public static void type(By element, String value, String fieldName) {
		// Always wait for the element to be present before typing/sendKeys

		WebElement e = WaitForElement("visibilty", element);
		e.clear();
		e.sendKeys(value);
		extentTest.info("Entered " + "<b>" + value + "</b>" + " in " + "<b>" + fieldName + "</b>" + " Field");
	}

	public static void click(WebElement element) {
		// always wait for element to be clickable before clicking
		WaitForElement("clickable", element);
		element.click();
		// extentTest.info("Clicked on login button");

	}

	public static void click(By element) {
		// always wait for element to be clickable before clicking
		WebElement e = WaitForElement("clickable", element);
		e.click();
	}

	public static void click(WebElement element, String fieldName) {
		// always wait for element to be clickable before clicking
		WaitForElement("clickable", element);
		element.click();
		extentTest.info("Clicked on " + "<b>" + fieldName + "</b>");

	}

	public static void click(By element, String fieldName) {
		// always wait for element to be clickable before clicking
		WebElement e = WaitForElement("clickable", element);
		e.click();
		extentTest.info("Clicked on " + "<b>" + fieldName + "</b>");

	}

	public static boolean isElementDisplayed(By locator) {

		try {
			TestSetUP.getDriver().findElement(locator).isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}

	}

	public static void WaitForElement(String condition, WebElement element) {
		WebDriverWait wait = new WebDriverWait(TestSetUP.getDriver(), Duration.ofSeconds(10));
		switch (condition) {
		case "visibilty":
			wait.until(ExpectedConditions.visibilityOf(element));
			break;

		case "clickable":
			wait.until(ExpectedConditions.elementToBeClickable(element));
			break;

		default:
			break;
		}
	}

	public static WebElement WaitForElement(String condition, By element) {
		WebDriverWait wait = new WebDriverWait(TestSetUP.getDriver(), Duration.ofSeconds(10));
		switch (condition) {
		case "visibilty":
			wait.until(ExpectedConditions.visibilityOf(TestSetUP.getDriver().findElement(element)));
			break;

		case "clickable":
			wait.until(ExpectedConditions.elementToBeClickable(TestSetUP.getDriver().findElement(element)));
			break;

		default:
			break;
		}
		return TestSetUP.getDriver().findElement(element);
	}

	public static void scroll(AppiumDriver driver) {
		Dimension size = driver.manage().window().getSize();

		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;

		int endX = startX;
		int endY = (int) (size.getHeight() * 0.3);

		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(200)))
				.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		driver.perform(Collections.singleton(sequence));

	}

	public static void ScrollIntoElement(AppiumDriver driver, WebElement element) {
		while (!element.isDisplayed()) {
			scroll(driver);
		}
	}

	public static void ScrollAndClick(AppiumDriver driver, WebElement element) {
		while (!element.isDisplayed()) {
			scroll(driver);
		}
		TestUtils.click(element);
	}

	public static void ScrollAndClick(AppiumDriver driver, By locator) {
		while (!isElementDisplayed(locator)) {
			scroll(driver);
		}
		TestUtils.click(locator);
	}

	public static void captureScreenshot() throws IOException {

		screenshotPath = System.getProperty("user.dir") + "/Screenshots/";

		File scrFile = TestSetUP.getDriver().getScreenshotAs(OutputType.FILE);

		Date d = new Date();

		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".png";

		FileUtils.copyFile(scrFile, new File(screenshotPath + screenshotName));

	}

	public static void tap(AppiumDriver driver, int x, int y) {
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence sequence = new Sequence(finger, 1)
				.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
				.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger, Duration.ofMillis(150)))
				.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
		driver.perform(Collections.singletonList(sequence));
		System.out.println("Tap with Coordinates");
	}

}
