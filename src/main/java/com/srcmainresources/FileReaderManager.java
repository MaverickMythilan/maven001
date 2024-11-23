package com.srcmainresources;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Assert;

public class FileReaderManager {
	
	private static Properties property;
	private static FileInputStream fileInputStream;
	private static void setupProperty() {
		if(property == null) {
			File file = new File("C:\\Users\\MU.MYTHILAN\\eclipse-workspace\\Maven_Project\\src\\main\\java\\com\\srcmainresources\\AdactinTestData.Properties");
			try {
				fileInputStream = new FileInputStream(file);
				property.load(fileInputStream);		
			} catch (Exception e) {
				Assert.fail("ERROR : FILE NOT FOUND EXCEPTION OCCURS DUE TO THE LOADING OF PROPERTY FILE ");
			}
		}
		
	}

	public  String getDataProperty(String dataValue) {
	setupProperty();
	String browserName = property.getProperty(dataValue);
	return browserName;

}
}