package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.Base_Class;
import com.interfaceelements.AdactinApplicationElements;
import com.srcmainresources.FileReaderManager;

public class AdactinSearchPage extends Base_Class implements AdactinApplicationElements{
	
	@FindBy(id = location_id)
	private WebElement location;
	
	@FindBy(id = hotels_id)
	private WebElement hotels;
	
	@FindBy(id = roomType_id)
	private WebElement room_type;
	
	@FindBy(id = numberOfRooms)
	private WebElement room_nos;
	
	@FindBy(id = checkInId)
	private WebElement datepick_in;
	
	@FindBy(id = checkOutId)
	private WebElement datepick_out;
	
	@FindBy(id =adultRoom)
	private WebElement adult_room;
	 
	@FindBy(id =childRoom)
	private WebElement child_room;
	
	@FindBy(id =searchBtn)
	private WebElement submit;
	
	@FindBy(id =selectBtn_id)
	private WebElement select;
	
	@FindBy(id = continue_id)
	private WebElement continueBtn;
	
	public AdactinSearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	public void searchHotel() {
		FileReaderManager search = new FileReaderManager();
		selectByVisibleText(location, search.getDataProperty("location"));
		selectByVisibleText(hotels, search.getDataProperty("hotels"));
		selectByVisibleText(room_type, search.getDataProperty("roomType"));
		selectByVisibleText(room_nos, search.getDataProperty("numberOfRooms"));
		passValue(datepick_in,search.getDataProperty("checkInId"));
		passValue(datepick_out,search.getDataProperty("checkOutId"));
		selectByVisibleText(adult_room,search.getDataProperty ("adultRoom"));
		selectByVisibleText(child_room, search.getDataProperty("childRoom"));
		elementClick(submit);
		elementClick(select);
		elementClick(continueBtn);
		
		
		
		
		
	}
	
	

}
