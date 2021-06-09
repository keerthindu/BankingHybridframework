package com.inetBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(name="uid")
	WebElement txtusername;
	
	@FindBy(name="password")
	WebElement txtpwd;
	
	@FindBy(name="btnLogin")
	WebElement loginbtn;
	
	@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	WebElement logout;
	
	
	
	public void setusername(String uname) 
	{
		txtusername.sendKeys(uname);
	}
	
	public void setpassword(String pwd) 
	{
		txtpwd.sendKeys(pwd);
	}
	
	public void clicksubmit() 
	{
		loginbtn.click();
	}
	
	public void clikclogout()
		{
			logout.click();
		}
	

}
