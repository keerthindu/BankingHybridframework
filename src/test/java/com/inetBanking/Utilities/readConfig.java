package com.inetBanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class readConfig {
	
	Properties pro;
	
	public readConfig()  
	{	//read common value from config.properties
		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	
	public String getusername()
	{
		String uname = pro.getProperty("username");
		return uname;
	}
	
	public String getpassword()
	{
		String pwd = pro.getProperty("password");
		return pwd;
	}
	
	public String getchromedriver()
	{
		String chro = pro.getProperty("chromepath");
		return chro;
	}
	
	public String getiedriver()
	{
		String ie = pro.getProperty("iepath");
		return ie;
	}
	
	

} 
