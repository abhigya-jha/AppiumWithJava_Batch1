package com.w2a.android.testcases;

public class Sample {

	public static void main(String[] args) {
		String xpath = "//android.widget.TextView[@text=\"productName\"]/following-sibling::android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"]";
		System.out.println(xpath.replace("productName", "ABC"));
	}

}
