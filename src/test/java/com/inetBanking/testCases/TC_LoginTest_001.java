package com.inetBanking.testCases;

import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	public WebDriver driver;
	LoginPage login;
	public static Logger log=LogManager.getLogger(TC_LoginTest_001.class);	
	
	@Test()
	public void loginTest() throws IOException
	{
		driver=setUp();
		log.info("Driver is Initialised");
		prop.load(fis);
		driver.get(prop.getProperty("baseURL"));
		log.info("URL is Opened");
		login=new LoginPage(driver);
		login.setUserName(prop.getProperty("username"));
		log.info("Entered UserName");
		login.setPassword(prop.getProperty("password"));
		log.info("Entered Password");
		login.Login();
		log.info("Cliked Login Button");
		
		if(driver.getTitle().equals(prop.getProperty("HomeTitle")))
		{
			Assert.assertTrue(true);
			log.info("Logged into Home Page & validated Title");
		}
		else
		{
			Assert.assertTrue(false);
			captureScreenshot("loginTest", driver);
			log.info("Logged into Home page but Wrong title");
		}
		
	}

}
