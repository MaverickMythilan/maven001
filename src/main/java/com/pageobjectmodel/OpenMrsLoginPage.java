package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.baseclass.Base_Class;
import com.interfaceelements.OpenMrsInterfaceElements;
import com.srcmainresources.OpenMrsFileReaderManager;


public class OpenMrsLoginPage  extends Base_Class implements OpenMrsInterfaceElements{
	@FindBy(id = userName_id)
	private WebElement userName;
	
	@FindBy(xpath = password_xpath)
	private WebElement password;
	
	@FindBy(xpath =location_xpath)
	private WebElement location;
	
	@FindBy(xpath =logIN_xpath )
	private WebElement LogIn;
	
//	public OpenMrsLogin(WebDriver driver) {
//	PageFactory.initElements(driver, this);
//	}


	public OpenMrsLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public boolean validlogintest() {
		try {
			OpenMrsFileReaderManager data = new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(userName, data.getDataProperty("loginusername"));
			passInput(password, data.getDataProperty("loginpassword"));
			elementClick(location);
			elementClick(LogIn);
			validation(driver.getTitle(),data.getDataProperty("title"));
			
		}catch (Exception e) {
			
			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
		return true;
		
}
	public boolean invalidpasstest() {
		try {
			OpenMrsFileReaderManager data = new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(userName, data.getDataProperty("loginusername"));
			passInput(password, data.getDataProperty("loginpassword"));
			elementClick(location);
			elementClick(LogIn);
			validation(driver.getTitle(),data.getDataProperty("title"));
			
		}catch (Exception e) {
			
			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
		
		return true;
	}
	public boolean empty() {
		try {
			OpenMrsFileReaderManager data = new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(userName, data.getDataProperty("loginusername"));
			passInput(password, data.getDataProperty("loginpassword"));
			elementClick(location);
			elementClick(LogIn);
			validation(driver.getTitle(),data.getDataProperty("title"));
			
		}catch (Exception e) {
			
			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
		
		return true;
	}
	public boolean nolocation() {
		try {
			OpenMrsFileReaderManager data = new OpenMrsFileReaderManager();
			launchUrl(data.getDataProperty("url"));
			passInput(userName, data.getDataProperty("loginusername"));
			passInput(password, data.getDataProperty("loginpassword"));
			elementClick(location);
			elementClick(LogIn);
			validation(driver.getTitle(),data.getDataProperty("title"));
			
		}catch (Exception e) {
			
			Assert.fail("ERROR : OCCUR DURING VALIDATION");
		}
		
		return true;
	}
		


	private void passInput(WebElement userName2, String dataProperty) {
		// TODO Auto-generated method stub
		
	}
}