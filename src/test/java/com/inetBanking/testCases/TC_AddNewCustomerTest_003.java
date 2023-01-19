package com.inetBanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddNewCustomerPage;
import com.inetBanking.pageObjects.LoginPage;
import com.inetBanking.utilities.XLUtils;

public class TC_AddNewCustomerTest_003 extends BaseClass {
	
	public WebDriver driver;
	LoginPage login;
	AddNewCustomerPage addNew;
	public static Logger log=LogManager.getLogger(TC_AddNewCustomerTest_003.class);
	
	@BeforeClass
	public void beforeSetUp() throws IOException
	{
		driver=setUp();
		driver.get(prop.getProperty("baseURL"));
		login=new LoginPage(driver);
		login.Login(prop.getProperty("username"), prop.getProperty("password"));		
	}
	
	@Test(dataProvider="NewCustomer")
	public void addNewCustomer(String name, String address, String city, String state, String pin, String mob, String pwd) throws IOException, InterruptedException
	{
		addNew=new AddNewCustomerPage(driver);
		
		//addNew.NewCustomerClick();
		driver.get(prop.getProperty("addCustomerUrl"));

		if(driver.getTitle().equals(prop.getProperty("NewCustomerPageTitle")))
		{
			Assert.assertTrue(true);
			log.info("Logged into New Customer Entry Page & validated Title");
		}
		else
		{
			Assert.assertTrue(false);
			captureScreenshot("addNewCustomer", driver);
			log.info("Logged into Home page but Wrong title");
		}
		
		//addNew.CustomerName("Deepa");
		//addNew.CustomerGender("female");
		//addNew.CustomerDOB("23", "08", "1985");
		//Thread.sleep(3000);
		//addNew.CustomerAddr("India");
		//addNew.CustomerCity("Delhi");
		//addNew.CustomerState("KA");
		//addNew.CustomerPin(577204);
		//addNew.CustomerMobile(491150954);		
		//String email=randomString()+"@gmail.com";
		//addNew.CustomerEmail(email);
		//addNew.CustomerPassword("abcdef");
		//addNew.CustomerSubmit();
		//Thread.sleep(3000);
		
		//DATA DRIVEN FROM EXCEL SHEET
		        addNew.CustomerName(name);
				addNew.CustomerGender("female");
				addNew.CustomerDOB("23", "08", "1985");
				Thread.sleep(3000);
				addNew.CustomerAddr(address);
				addNew.CustomerCity(city);
				addNew.CustomerState(state);
				addNew.CustomerPin(pin);
				addNew.CustomerMobile(mob);
				
				String email=randomString()+"@gmail.com";
				addNew.CustomerEmail(email);
				addNew.CustomerPassword(pwd);
				addNew.CustomerSubmit();
				Thread.sleep(3000);
		
		boolean result=driver.getPageSource().contains(prop.getProperty("NewCustomerRegisterSuccess"));
		
		if(result==true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreenshot("addNewCustomer", driver);
			Assert.assertTrue(false);
		}		
		
	}
	
	
	
	@DataProvider(name="NewCustomer")
	public String[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/inetBanking/testData/LoginData.xlsx";
		
		int rowNum=XLUtils.getRowCount(path, "Sheet2");
		int colNum=XLUtils.getCellCount(path, "Sheet2", 1);
		
		String newCust[][]=new String[rowNum][colNum];
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<colNum;j++)
			{
				newCust[i-1][j]=XLUtils.getCellData(path, "Sheet2", i, j);
			}
		}
		return newCust;
	}

}
