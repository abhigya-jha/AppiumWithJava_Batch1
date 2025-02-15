package com.w2a.Utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.w2a.TestSetUp.TestSetUP;

public class TestListners extends TestSetUP implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		String logmessage = "<b>" + "<i>" + "Execution of " + result.getName() + " Started" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(logmessage, ExtentColor.GREY);
		extentTest.info(m);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String successMessage = "<b>" + "<i>" + "This Test Case is Passed" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(successMessage, ExtentColor.GREEN);
		extentTest.pass(m);

	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			TestUtils.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String exceptionStackTrace = Arrays.toString(result.getThrowable().getStackTrace());

		// System.out.println(failedTestCaseInfo.getThrowable().getStackTrace().toString());
		extentTest
				.fail("<details>" + "<summary>" + "<b>" + "<font color=" + "red>" + "Exception Occured:Click to see"
						+ "</font>" + "</b >" + "</summary>" + exceptionStackTrace.replaceAll(",", "<br>")
						+ "</details>" + " \n");
		try {

			extentTest.fail("<b>" + "<font color=" + "red>" + "ScreenShot of failure" + "</font>" + "</b>",
					MediaEntityBuilder.createScreenCaptureFromPath(TestUtils.screenshotPath + TestUtils.screenshotName)
							.build());
		} catch (Exception e) {

		}

		String successMessage = "<b>" + "<i>" + "This Test Case is Failed" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(successMessage, ExtentColor.RED);
		extentTest.fail(m);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String successMessage = "<b>" + "<i>" + "This Test Case is Skipped" + "</i>" + "</b>";
		Markup m = MarkupHelper.createLabel(successMessage, ExtentColor.YELLOW);
		extentTest.skip(m);

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
