package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;



public class AccountsPageTest {
	WebDriver driver;
	AccountsPage acctPage;
	LoginPage loginPage;
	

	@BeforeTest
    public void setUp() throws InterruptedException
	{
		
	    driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginPage = new LoginPage(driver);
		acctPage =loginPage.doLogin("Independenceday@gmail.com","day15");
		Thread.sleep(1000);
	}
    
	@Test
	public void AccountPageTitleTest()
	{
		String actAccountPagetitle = acctPage.AccountPageTitle();
		Assert.assertEquals(actAccountPagetitle, "My Account");
	}
	
	@Test
	public void AccountPageUrlTest()
	{
		String actAccountPageUrl = acctPage.AccountPageUrl();
		Assert.assertEquals(actAccountPageUrl, "https://naveenautomationlabs.com/opencart/index.php?route=account/account");
	}
	
	@Test
	public void getAccountPageheaderListTest()
	{
		List<String> listofheaders = acctPage.getAccountPageheaderList();
		List<String> actaccountHeaderList = Arrays.asList("My Account","My Orders","My Affiliate Account","Newsletter");
		Assert.assertEquals(listofheaders,actaccountHeaderList );
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
