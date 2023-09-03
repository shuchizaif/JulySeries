package com.qa.opencart.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.opencart.pages.LoginPage;

public class LoginPageTest {
	
	
	WebDriver driver;
	LoginPage loginPage;
	
	
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		loginPage = new LoginPage(driver);
	}
	
	@Test
	public void loginPageTitleTest()
	{
		String acttitle =loginPage.getLoginpageTitle();
		Assert.assertEquals(acttitle, "Account Login");
	}
	
	@Test
	public void loginPageURLTest()
	{
		String actURL =loginPage.getLoginPageUrl();
		Assert.assertTrue(actURL.contains("route=account/login"));
	}
	
	@Test
	public void forgotPwrdLinkTest()
	{
		Assert.assertTrue(loginPage.isForgotPwrdLinkExist());
	}
	
	@Test
	public void RightColumnlinksclickableTest()
	{
		List<String> clicklinks =loginPage.RightColumnlinksclickable();
		List<String> expectedCollist = Arrays.asList("Login","Register","Forgotten Password","My Account","Address Book","Wish List","Order History","Downloads","Recurring payments","Reward Points","Returns","Transactions","Newsletter");
	    Assert.assertEquals(clicklinks, expectedCollist);
	   
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
