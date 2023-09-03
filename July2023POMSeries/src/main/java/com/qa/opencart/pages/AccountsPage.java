package com.qa.opencart.pages;



import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	
	
	private WebDriver driver;
	
	public AccountsPage(WebDriver driver)
	{
		this.driver= driver;
	}
	
	
	//locators
	private By logout = By.xpath("//a[text()='Logout'])[2]");
    private By searchitem = By.xpath("//input[@name ='search'] ");
    private By searchIcon = By.xpath("//button[@class='btn btn-default btn-lg']");
    private By pageheaderlist =By.xpath("//div[@id='content']/h2");
    
    
    
  
    
    public String  AccountPageTitle()
    {
    	String actAccountTitle = driver.getTitle();
    	System.out.println("Account Page title is " + actAccountTitle);
    	return actAccountTitle;
    }
    
    public String AccountPageUrl()
    {
    	return  driver.getCurrentUrl();
    }
    
    public boolean isLogoutLinkExist()
    {
    	return driver.findElement(logout).isDisplayed();
    }
     
    public List<String> getAccountPageheaderList()
    {
    	List<WebElement> headerList =driver.findElements(pageheaderlist);
    	List<String>headersValList = new ArrayList<String>();
    	for(WebElement headerlink :headerList)
    	{
    		String text = headerlink.getText();
    		headersValList.add(text);
    		
    	}
    	  return headersValList;
		
	}
    
  //redirecting to SearchResultPage when we run doSearch on AccountPage
    public SearchResultPage doSearch(String Item)
    {
    	 driver.findElement(searchitem).sendKeys("Mac");
    	 driver.findElement(searchIcon).click();
    	 return new SearchResultPage(driver);
    	 
    }
    
   
}
