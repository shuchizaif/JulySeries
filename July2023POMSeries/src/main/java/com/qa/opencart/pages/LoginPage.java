package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	
		private WebDriver driver;//define WebDriver
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;//initialize earlier defined driver with driver value passed in Constructor
	}
	//By locators
	private By emailid = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPwrd =By.xpath("//a[text()='Forgotten Password'] ");
	private By login = By.xpath("//input[@value='Login'] ");
	private By rightcolumnlinks = By.xpath("//div[@class='list-group']/a");
	

	
	
	//public Page Actions/methods
	
	public String getLoginpageTitle()
	{
		String title = driver.getTitle();
		System.out.println("Login Page Title is " +title);
		return title;
	}
	
	public String getLoginPageUrl()
	{
		String URL = driver.getCurrentUrl();
        System.out.println("Login Page URL is " +URL);
		return URL;
	}
	
	public boolean isForgotPwrdLinkExist()
	{
		return driver.findElement(forgotPwrd).isDisplayed();

	}
	
	public List<String> RightColumnlinksclickable()
	{
		List<WebElement> rightcollinks = driver.findElements(rightcolumnlinks);
		List<String>collinks = new ArrayList();
		for(WebElement link : rightcollinks)
		{
			String alllinks =link.getText();
			collinks.add(alllinks);
		}
		  return collinks;
	}
 
	//Redirecting to AccountsPage when we run doLogin on LoginPage
	public AccountsPage doLogin(String userName, String Pwrd)
	{
		driver.findElement(emailid).sendKeys(userName);
		driver.findElement(password).sendKeys(Pwrd);
		driver.findElement(login).click();
		//return next Landing Page---HomePage--page chaining model
		return new AccountsPage(driver);
	}

	





}

