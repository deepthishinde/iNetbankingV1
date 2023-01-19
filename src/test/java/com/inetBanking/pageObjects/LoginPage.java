package com.inetBanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	//public WebDriver ldriver;
	public WebDriver driver;
	//Constructor is needed in order to synchronize the drivers across Test & Page classes
	//and also to Initialize objects
	public LoginPage(WebDriver driver)
	{
		//this.ldriver=rdriver;
		this.driver=driver;
	}
	
	//Xpaths & WebElements
	By UserName_xpath=By.name("uid");
	public WebElement UserName()
	{
		return driver.findElement(UserName_xpath);
	}
	
	By UserPwd_Xpath=By.name("password");
	public WebElement UserPassword()
	{
		return driver.findElement(UserPwd_Xpath);
	}
	
	By LoginSubmit_Xpath=By.name("btnLogin");
	public WebElement LoginSubmit()
	{
		return driver.findElement(LoginSubmit_Xpath);
	}
	
	By LogOut_Xpath=By.xpath("//ul[@class='menusubnav']/li[15]/a");
	public WebElement LogOut()
	{
		return driver.findElement(LogOut_Xpath);
	}
	
	//ACTION METHODS
	
	public void setUserName(String UName)
	{
		UserName().sendKeys(UName);
	}
	
	public void setPassword(String UPwd)
	{
		UserPassword().sendKeys(UPwd);
	}
	
	public void Login()
	{
		LoginSubmit().click();
	}
	
	public void ClickLogout()
	{
		LogOut().click();
	}
	
	//LOGIN METHOD FOR OTHER CLASS TESTS
	public void Login(String name, String pwd)
	{
		UserName().sendKeys(name);
		UserPassword().sendKeys(pwd);
		LoginSubmit().click();
	}

}
