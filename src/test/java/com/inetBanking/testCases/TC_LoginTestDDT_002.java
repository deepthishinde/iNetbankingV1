package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass {
	
	public WebDriver driver;
	LoginPage login;
	public static Logger log=LogManager.getLogger(BaseClass.class.getName());
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String user, String pwd) throws IOException
	{
		driver=setUp();
		prop.load(fis);
		driver.get(prop.getProperty("baseURL"));
		login=new LoginPage(driver);
		//login.setUserName(prop.getProperty("username"));
		//login.setPassword(prop.getProperty("password"));
		login.setUserName(user);
		login.setPassword(pwd);
		login.Login();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			login.ClickLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rowNum=XLUtils.getRowCount(path, "Sheet1");
		int colNum=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rowNum][colNum];
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colNum;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}

}
