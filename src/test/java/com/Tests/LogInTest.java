package com.Tests;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.BasePage.BaseClass;
import com.Pages.LogInPage;
import com.aventstack.extentreports.Status;
import com.constant.LogInPageConstants;
import com.utills.Utills;

public class LogInTest extends BaseClass {
	
	
	@Test
	public void logInTest() throws InterruptedException
	{
		LogInPage login=new LogInPage(driver);
		//navigate to  url
		openUrl(Utills.readProperties("URL"));
		Utills.Sleep(2000);//req
		//set username
		login.setUsername();
		login.setPassword();
		//click on login button
		login.clickOnLogin();
		//navigate to homepage and verify  homepage is open or not 
		Assert.assertTrue(login.isTitlePresent(driver,LogInPageConstants.homeTitile));
	}

}
