package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddNewCustomerPage {
	public WebDriver driver;
	
	public AddNewCustomerPage(WebDriver driver)
	{
		this.driver=driver;
	}
	//XPATHS & WEBELEMENTS
	By AddNewCustomer_Xpath=By.xpath("//ul[@class='menusubnav']/li[2]/a");
	public WebElement AddNewCustomer()
	{
		return driver.findElement(AddNewCustomer_Xpath);
	}
	
	By CustomerName_Xpath=By.xpath("//input[@name='name']");
	public WebElement CName()
	{
		return driver.findElement(CustomerName_Xpath);
	}
	
	By CustomerGender_Xpath=By.xpath("//input[@name='rad1']");
	public WebElement CGender()
	{
		return driver.findElement(CustomerGender_Xpath);
	}
	
	By CustomerDOB_Xpath=By.xpath("//input[@id='dob']");
	public WebElement CDOB()
	{
		return driver.findElement(CustomerDOB_Xpath);
	}
	
	By CustomerAddr_Xpath=By.xpath("//*[@name='addr']");
	public WebElement CAddr()
	{
		return driver.findElement(CustomerAddr_Xpath);
	}
	
	By CustomerCity_Xpath=By.xpath("//*[@name='city']");
	public WebElement CCity()
	{
		return driver.findElement(CustomerCity_Xpath);
	}
	
	By CustomerState_Xpath=By.xpath("//*[@name='state']");
	public WebElement CState()
	{
		return driver.findElement(CustomerState_Xpath);
	}
	
	By CustomerPin_Xpath=By.xpath("//*[@name='pinno']");
	public WebElement CPin()
	{
		return driver.findElement(CustomerPin_Xpath);
	}
	
	By CustomerMob_Xpath=By.xpath("//*[@name='telephoneno']");
	public WebElement CMobile()
	{
		return driver.findElement(CustomerMob_Xpath);
	}
	
	By CustomerEmail_Xpath=By.name("emailid");
	public WebElement CEmail()
	{
		return driver.findElement(CustomerEmail_Xpath);
	}
	
	By CustomerPwd_Xpath=By.xpath("//*[@name='password']");
	public WebElement CPwd()
	{
		return driver.findElement(CustomerPwd_Xpath);
	}
	
	By CustomerSubmit_Xpath=By.xpath("//*[@name='sub']");
	public WebElement CSubmit()
	{
		return driver.findElement(CustomerSubmit_Xpath);
	}
	
	//ACTIONS
	public void NewCustomerClick()
	{
		AddNewCustomer().click();
	}
	
	public void CustomerName(String cName)
	{
		CName().sendKeys(cName);
	}
	
	public void CustomerGender(String cGender)
	{
		CGender().sendKeys(cGender);
	}
	
	public void CustomerDOB(String mm, String dd, String yy)
	{
		CDOB().sendKeys(mm);
		CDOB().sendKeys(dd);
		CDOB().sendKeys(yy);
	}
	
	public void CustomerAddr(String adr)
	{
		CAddr().sendKeys(adr);
	}
	
	public void CustomerCity(String city)
	{
		CCity().sendKeys(city);
	}
	
	public void CustomerState(String state)
	{
		CState().sendKeys(state);
	}
	
	public void CustomerPin(String pin)
	{
		CPin().sendKeys(pin);
	}
	
	public void CustomerMobile(String mob)
	{
		CMobile().sendKeys(mob);
	}
	
	public void CustomerEmail(String email)
	{
		CEmail().sendKeys(email);
	}
	
	public void CustomerPassword(String pwd)
	{
		CPwd().sendKeys(pwd);
	}
	
	public void CustomerSubmit()
	{
		CSubmit().click();
	}

}
