package com.listeners;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentTest;
import com.baseclass.Base_Class;

public class ExtentReport_Test {
	public static ExtentTest extenttest;
	@BeforeSuite
	public void extentTestReportStartup() {
		Base_Class base = new Base_Class() {
		};
		base.extentRepotStart(null);
	}
	@AfterSuite
	public void extentReportEnd() throws IOException {
	Base_Class base = new Base_Class() {
	};	
	base.extentTearDown(null);
	}

}
