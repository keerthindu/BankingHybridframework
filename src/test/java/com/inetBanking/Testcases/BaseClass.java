package com.inetBanking.Testcases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetBanking.Utilities.readConfig;

public class BaseClass  {
	readConfig readconf = new readConfig();
			
	public String baseURL=readconf.getURL() ;
	public String username =readconf.getusername();
	public String password = readconf.getpassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String brs) 
	{
		
		//System.setProperty("webdriver.chrome.driver",readconf.getchromedriver());
		//driver=new ChromeDriver();
		
		logger = LogManager.getLogger("BaseClass");
		PropertyConfigurator.configure("log4j.properties");
		
		//desired browser
		if(brs.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconf.getchromedriver());
			driver=new ChromeDriver();
		}
		else if(brs.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconf.getiedriver());
			driver=new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

	}
	
	@AfterClass
	public void teardown() 
	{
		driver.quit();
	}
	
	public void captureScreenshot(WebDriver driver, String tname) throws Exception {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"/Screenshots/" +tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomstring()
	{
		String random = RandomStringUtils.randomAlphabetic(5);
		return(random);
	}
	
	public String randomnumber()
	{
		String random = RandomStringUtils.randomNumeric(4);
		return(random);
	}

}
