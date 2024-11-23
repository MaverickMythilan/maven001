package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceelements.AdactinApplicationElements;

public class AdactinBookHotel extends Base_Class implements AdactinApplicationElements { 
	
	@FindBy(id = firstName_id)
	private WebElement firstName;
	
	@FindBy(id =lastName_id)
	private WebElement lastNmae;
	
	@FindBy(id =address_id)
	private WebElement address;
	
	@FindBy(id =creditNo_id)
	private WebElement creditNo;
	 
	@FindBy(id = creditType_id)
	private WebElement creditType;
	
	@FindBy(id = selectMonth_id)
	private WebElement selectMonth;
	
	@FindBy(id = selectyear_id)
	private WebElement selectYear;
	
	@FindBy(id = cvvNumber)
	private WebElement cvv;
	
	@FindBy(id = bookNow_id)
	private WebElement bookNow;
	
	@FindBy(xpath = logOut_xpath)
	private WebElement logout;
	
	public AdactinBookHotel(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
