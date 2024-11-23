package com.runnerclass;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.Base_Class;
import com.pageobjectmanager.OpenMrsPageObjectManager;
import com.pageobjectmanager.PageObjectManager;

public class OpenMrs_Runner extends Base_Class {
	OpenMrsPageObjectManager pageobjectmanager = new OpenMrsPageObjectManager();
@BeforeTest	
	public void setup() {
	launchBrowser(pageobjectmanager.getFileReader().getDataProperty("browser"));
	}
@Test
	
	private void  validlogintest() {
		Assert.assertTrue(pageobjectmanager.getLoginPage().validlogintest());
	}
	@Test
	private void  invalidpasstest() {
		Assert.assertTrue(pageobjectmanager.getLoginPage().invalidpasstest());
	}
	@Test
	private void  empty() {
		Assert.assertTrue(pageobjectmanager.getLoginPage().empty());
	}@Test
	private void  nolocation() {
		Assert.assertTrue(pageobjectmanager.getLoginPage().nolocation());
	}
	
	
	

}
