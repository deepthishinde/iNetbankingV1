package com.inetBanking.testCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	public static WebDriver driver;
	public Properties prop;
	public FileInputStream fis;
	//public static Logger log;
	
	public WebDriver setUp() throws IOException
	{
		fis=new FileInputStream("C:\\Users\\DEEPTHI\\eclipse-PAWAN\\inetBankingV1\\src\\test\\java\\com\\inetBanking\\utilities\\data.properties");
		prop=new Properties();
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DEEPTHI\\eclipse-PAWAN\\inetBankingV1\\Drivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromexpath"));
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DEEPTHI\\eclipse-PAWAN\\inetBankingV1\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		//LOGGER
		 //log=Logger.getLogger("eBanking");
		//PropertyConfigurator.configure("log4j.properties");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
				
	}
	
	public String captureScreenshot(String testCaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}
	
	//METHOD TO GENERATE RANDOM STRING FOR EMAIL
		public static String randomString()
		{
			String generatedString=RandomStringUtils.randomAlphabetic(5);
			return generatedString;
		}
		
		public static String randomNumber()
		{
			String generatedString2=RandomStringUtils.randomNumeric(4);
			return generatedString2;
		}
	
	@AfterClass(enabled=false)
	public void tearDown()
	{
		driver.close();;
	}

}
