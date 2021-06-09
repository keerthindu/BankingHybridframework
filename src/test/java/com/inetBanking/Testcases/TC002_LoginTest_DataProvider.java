package com.inetBanking.Testcases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;
import com.inetBanking.Utilities.xLUtility;

public class TC002_LoginTest_DataProvider extends BaseClass {
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws Exception 
	{
		LoginPage lp = new LoginPage(driver);
		lp.setusername(user);
		logger.info("User name provided");
		lp.setpassword(pwd);
		logger.info("password provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept(); //close alert
			driver.switchTo().defaultContent(); //focus on mainpage
			Assert.assertTrue(false);
			captureScreenshot(driver, "TC002_LoginTest_DataProvider");
			logger.warn("Login Failed");
		}
		else
		{
			Assert.assertTrue(true);
			lp.clikclogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept(); //close logout alert popup
			driver.switchTo().defaultContent();
			logger.info("login passed");
		}
		
	}
	
	public boolean isAlertPresent() //user defined method to check alert is present or not - login alert popup
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception
	{
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetBanking/TestData/Credentials.xlsx";
		
		int rownumb =xLUtility.getRowCount(path,"Sheet1");
		int colcount = xLUtility.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownumb][colcount];
		
		for(int i = 1;i<=rownumb;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=xLUtility.getCellData(path, "Sheet1", i, j); //1 , 0-->i, j
				
			}
		}
		return logindata;
	}

}
