package com.inetBanking.Testcases;




import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.AddCustomerPage;
import com.inetBanking.PageObject.LoginPage;

public class TC003_AddCustomer extends BaseClass {
	
	@Test
	public void addNewCustomer() throws Exception
	{
		LoginPage lp = new LoginPage(driver);  //driver-from base class
		lp.setusername(username);
		logger.info("User name is provided");
		lp.setpassword(password);
		logger.info("password is provided");
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcus = new AddCustomerPage(driver);
		
		logger.info("Providing customer details...");
		
		addcus.newcus();
		addcus.Entername("Indu");
		addcus.selectgender("Male");
		addcus.selectdob("11", "13", "1995");
		Thread.sleep(3000);
		addcus.enteraddress("Nagal Nagar");
		addcus.entercity("Dindigul");
		addcus.enterstate("Tamilnadu");
		addcus.enterpincode("624003");
		addcus.entermobile("9873248974");
		
		String email =randomstring()+"@gmail.com";
		addcus.enteremail(email);
		
		addcus.enterpwd("indu");
		addcus.clicksubmit();
		
	    Thread.sleep(3000);
	    logger.info("Validation has started..");
	    boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
			{
			Assert.assertTrue(true);
			captureScreenshot(driver, "TC003_AddCustomer");
			logger.info("New customer added successfully");
			}
		else
		{
			logger.info("Adding new customer failed");
			captureScreenshot(driver, "addNewCustomer");  //driver, test case name
			Assert.assertTrue(false);
			captureScreenshot(driver, "TC003_AddCustomer");
			logger.warn("Adding new customer failed");
			
		}
		
		
	}
	
	

}
