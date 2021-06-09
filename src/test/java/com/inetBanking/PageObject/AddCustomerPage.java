package com.inetBanking.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(how=How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	WebElement newcustomer;
	
	@FindBy(how=How.NAME,using="name")
	WebElement name;
	
	@FindBy(how=How.NAME,using="rad1")
	WebElement gender;
	
	@FindBy(how=How.ID_OR_NAME,using="dob")
	WebElement dob;
	
	@FindBy(how=How.NAME,using="addr")
	WebElement address;
	
	@FindBy(how=How.NAME,using="city")
	WebElement city;
	
	@FindBy(how=How.NAME,using="state")
	WebElement state;
	
	@FindBy(how=How.NAME,using="pinno")
	WebElement pincode;
	
	@FindBy(how=How.NAME,using="telephoneno")
	WebElement mobile;
	
	@FindBy(how=How.NAME,using="emailid")
	WebElement email;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	@FindBy(how=How.NAME, using ="sub")
	WebElement submit;

	
	public void newcus()
	{
		newcustomer.click();
		
	}
	
	public void Entername(String cname)
	{
		name.sendKeys(cname);
		
	}
	
	public void selectgender(String cgender)
	{
		gender.click();
		
	}
	
	public void selectdob(String mm, String dd, String yyyy)
	{
		dob.sendKeys(mm);
		dob.sendKeys(dd);
		dob.sendKeys(yyyy);
		
	}
	
	public void enteraddress(String caddress)
	{
		address.sendKeys(caddress);
		
	}
	
	public void entercity(String ccity)
	{
		city.sendKeys(ccity);
		
	}
	
	public void enterstate(String cstate)
	{
		state.sendKeys(cstate);
		
	}
	
	public void enterpincode(String cpincode)
	{
		pincode.sendKeys(String.valueOf(cpincode));  //pincode.sendKeys(String.valueOf(cpincode) -->if u provide parameter as an integer
		
	}
	
	public void entermobile(String cmobile)
	{
		mobile.sendKeys(cmobile);
		
	}
	
	public void enteremail(String cemail)
	{
		email.sendKeys(cemail);
		
	}
	
	public void enterpwd(String cpassword)
	{
		password.sendKeys(cpassword);
	}
	
	public void clicksubmit()
	{
		submit.click();
	}

}
