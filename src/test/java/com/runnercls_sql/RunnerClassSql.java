package com.runnercls_sql;

import java.sql.SQLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.JdbcConnector;

public class RunnerClassSql {
	
public static void main(String[] args) throws SQLException {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.youtube.com/");
	String fname=JdbcConnector.getParticularData();
	driver.findElement(By.name("search_query")).sendKeys(fname);
	
}
}
