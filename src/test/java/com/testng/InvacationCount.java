package com.testng;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.baseclass.Base_Class;

public class InvacationCount extends Base_Class{
	
	@Test(priority = 5)
	private void edgeBrowser() {
		launchBrowser("edge");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID: " + Thread.currentThread().getId());
		closeBrowser();
	}
	@Test(invocationCount = 3)
	private void chromeBrowser() {
		launchBrowser("chrome");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID: " + Thread.currentThread().getId());
		closeBrowser();
	}
	@Test(priority = -5)
	private void firefoxBrowser() {
		launchBrowser("firefox");
		launchUrl("https://www.google.com/");
		System.out.println("Browser ID: " + Thread.currentThread().getId());
		closeBrowser();
	}


}
