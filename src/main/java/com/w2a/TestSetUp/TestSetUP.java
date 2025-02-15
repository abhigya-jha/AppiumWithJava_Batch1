package com.w2a.TestSetUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;

public class TestSetUP {
	protected static ThreadLocal<Properties> props = new ThreadLocal<Properties>();
	protected static ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest extentTest;

	public static Properties getProps() {
		return props.get();
	}

	public static void setProps(Properties props) {
		TestSetUP.props.set(props);
	}

	public static AppiumDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(AppiumDriver driver) {
		TestSetUP.driver.set(driver);
	}

	@Parameters({ "platform" })
	@BeforeTest
	public void beforeTest(String platform) {
		System.out.println("Platform-> " + platform);
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/main/resources/propertyFiles/config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		TestSetUP.setProps(props);

		extent = ExtentReportSetup();

		TestSetUP.createDriver(platform);
	}

	@BeforeMethod(alwaysRun = true)
	public void setBeforeMethod(Method m) {
		extentTest = extent.createTest(m.getName());
	}

	@AfterTest
	public void afterTest() {
		extent.flush();
	}

	public static synchronized ExtentReports ExtentReportSetup() {
		htmlReporter = new ExtentSparkReporter("./TestReports/TestReport.html");

		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Appium Batch1 TestReport");
		htmlReporter.config().setReportName("Way2Automation Appium Report");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

	public static synchronized AppiumDriver createDriver(String platform) {
		System.out.println("inside create driver");
		if (platform.toLowerCase().equals("android")) {
			UiAutomator2Options options = new UiAutomator2Options().setPlatformName("Android")
					.setDeviceName(TestSetUP.getProps().getProperty("androidDeviceName"))
					.setAutomationName(TestSetUP.getProps().getProperty("androidAutomationName"))
					.setApp(TestSetUP.getProps().getProperty("androidAppPath"))
					.setAppActivity(TestSetUP.getProps().getProperty("androidAppActivity"));

			URL url = null;
			try {
				url = new URL(TestSetUP.getProps().getProperty("serverURL"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AppiumDriver driver = new AndroidDriver(url, options);

			System.out.println("App Launched->" + driver);
			TestSetUP.setDriver(driver);
			return TestSetUP.getDriver();

		} else if (platform.toLowerCase().equals("ios")) {
			UiAutomator2Options options = new UiAutomator2Options().setPlatformName("iOS")
					.setUdid(TestSetUP.getProps().getProperty("iosUDID"))
					.setDeviceName(TestSetUP.getProps().getProperty("iosDeviceName"))
					.setAutomationName(TestSetUP.getProps().getProperty("iosAutomationName"))
					.setApp(TestSetUP.getProps().getProperty("iosAppPath"));

			URL url = null;
			try {
				url = new URL(TestSetUP.getProps().getProperty("serverURL"));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			AppiumDriver driver = new IOSDriver(url, options);

			System.out.println("App Launched->" + driver);
			TestSetUP.setDriver(driver);
			return TestSetUP.getDriver();

		} else {
			return null;
		}

	}

}
