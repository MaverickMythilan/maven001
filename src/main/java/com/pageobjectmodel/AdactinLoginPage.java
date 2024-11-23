package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresources.FileReaderManager;

public class AdactinLoginPage extends Base_Class implements AdactinApplicationElements{
	@FindBy(id = username_id)
	private WebElement username;
	
	@FindBy(name = password_name)
	private WebElement password;
	
	@FindBy(xpath = Login_xpath)
	private WebElement login;
	
	public AdactinLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public  void getAllData() {
		FileReaderManager data = new FileReaderManager();
		passValue(username, data.getDataProperty("loginusername"));
		passValue(password, data.getDataProperty("loginpassword"));
		elementClick(login);
	}

}
