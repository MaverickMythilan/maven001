package com.interfaceelements;

import org.openqa.selenium.WebElement;

public interface AdactinApplicationElements {
	//login elements
	String username_id = "username";
	String password_name = "password";
	String Login_xpath = "//input[@type='Submit']";
	
	//search elements
	String location_id ="location";
	String hotels_id ="hotels";
	String roomType_id ="room_type";
	String numberOfRooms ="room_nos";
	String checkInId ="datepick_in";
	String checkOutId ="datepick_out";
	String adultRoom ="adult_room";
	String childRoom ="child_room";
	String searchBtn ="Submit";
	String selectBtn_id ="radiobutton_0";
	String continue_id ="continue";
	 
	//Book a hotel
	
	String firstName_id ="first_name";
	String lastName_id ="last_name";
	String address_id ="address";
	String creditNo_id ="cc_num";
	String creditType_id ="cc_type";
	String selectMonth_id ="cc_exp_month";
	String selectyear_id ="cc_exp_year";
	String cvvNumber ="cc_cvv";
	String bookNow_id ="book_now";
	String logOut_xpath ="(//input[@type'button'])[3]";
	
	

}
