package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.CheckoutPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.SearchResultPage;

public class CheckoutPageTest {
	
	WebDriver driver;
	AccountsPage acctPage;
	LoginPage loginPage;
	SearchResultPage searchresultPage;
	CheckoutPage checkoutPage;
	
	
	

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
			checkoutPage = searchresultPage.doclickCheckout();
		
		}

     @Test
      public void checkoutPageTitleTest()
      {
    	  String title = checkoutPage.checkoutPageTitle();
          Assert.assertEquals(title, "Shopping Cart");
}



  @Test
public void checkouttableheadingsTest()
{
	  /*List<String> headings =checkoutPage.checkouttableheadings();
      List<String>actheadings = Arrays.asList("Image","Product Name","Model","Quantity","Unit Price","Total");
      Assert.assertEquals(headings, actheadings);*/
      Dimension actheadingcount = checkoutPage.checkouttableheadings();
      Assert.assertEquals(actheadingcount, 6);



}





	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}





}
