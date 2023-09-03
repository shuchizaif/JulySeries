package com.qa.opencart.tests;

import java.awt.AWTException;
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
import com.qa.opencart.pages.SearchResultPage;

public class SearchResultPageTest {
	WebDriver driver;
	AccountsPage acctPage;
	LoginPage loginPage;
	SearchResultPage searchresultPage;
	
	
	
	@BeforeTest
	public void setup() throws InterruptedException
	
		{
			
			driver = new ChromeDriver();
			driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			loginPage = new LoginPage(driver);
			acctPage =loginPage.doLogin("Independenceday@gmail.com", "day15");
			searchresultPage =acctPage.doSearch("Mac");
		
		}
	
	@Test
	public void searchresultheadingtextTest()
	{
		String actsearchPageheading =  searchresultPage.searchresultheadingtext();
		Assert.assertEquals(actsearchPageheading, "Products meeting the search criteria");
	
	}
	
	@Test
	public void pageSearchTitleTest()
	{
		String acttitle = searchresultPage.pageSearchTitle();
		Assert.assertEquals(acttitle, "Search - Mac");
	}
	
	@Test
	public void searchbartextTest()
	{
		String actsearchtext = searchresultPage.searchbartext();
	    Assert.assertEquals(actsearchtext, "Mac");
	}
	
	
	@Test
	
	
	public void categoriesfiltersizeTest()
	{
		 int count =searchresultPage.categoriesfiltersize();
		 Assert.assertEquals(count, 53);
		
	}
	
	@Test
	public void searchcriteriatextTest() throws InterruptedException
	{
		String actsearchcriteriatext = searchresultPage.searchcriteriatext();
		Thread.sleep(1000);
		Assert.assertEquals(actsearchcriteriatext,"Mac");
	}
	
   /* @Test
    public void doselectcategoryTest() throws InterruptedException
    {
    	String actselecteditem = searchresultPage.doselectcategory();
    	Thread.sleep(1000);
    	Assert.assertEquals(actselecteditem, "Desktops");
    }*/
	
	@Test
	public void doclickAddtoCartTest() throws AWTException, InterruptedException 
	{
		String actcartitems =searchresultPage.doclickAddtoCart();
		Assert.assertEquals(actcartitems, "1 item(s) - $122.00");
		
	}
	@Test
	public void alertmessagediaplayTest()
	{
		String actalertmessage = searchresultPage.alertmessagediaplay();
		Assert.assertEquals(actalertmessage, " Success: You have added ");
	}
	
	
	
	/*@AfterTest
	public void tearDown()
	{
		driver.quit();
	}*/
	
  
	
	
	}
	
	
	
	
	

	
	
	
	
	
	
	


