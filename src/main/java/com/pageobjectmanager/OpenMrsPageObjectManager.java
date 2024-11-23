package com.pageobjectmanager;

import com.baseclass.Base_Class;
import com.pageobjectmodel.OpenMrsLoginPage;
import com.srcmainresources.OpenMrsFileReaderManager;

public class OpenMrsPageObjectManager extends Base_Class {
	private OpenMrsFileReaderManager fileReader;
	private OpenMrsLoginPage loginPage;

	public OpenMrsFileReaderManager getFileReader() {
		if (fileReader == null) {
			fileReader = new OpenMrsFileReaderManager();
		}
		return fileReader;
	}

	public OpenMrsLoginPage getLoginPage() {
		if (loginPage == null) {
			loginPage = new OpenMrsLoginPage(driver);

		}
		return loginPage;
		

	}

}
