package com.inetBanking.Testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.inetBanking.PageObject.LoginPage;

import junit.framework.Assert;

 

public class TC001_LoginTest extends BaseClass {
	
	LoginPage loginpage;
	//SoftAssert sf = new SoftAssert();
	@Test
	public void loginTest() throws Exception
	{
		driver.get(baseURL);
		logger.info("URL is opened");
		driver.manage().window().maximize();
		
		loginpage=new LoginPage(driver);
		
		logger.info("Enter username");
		loginpage.setusername(username);
		
		logger.info("Enter password");
		loginpage.setpassword(password);
		Thread.sleep(3000);
		
		loginpage.clicksubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
		Assert.assertTrue(true);
		logger.info("Login test passed");
		}
		else
		{
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
		
	}

}
