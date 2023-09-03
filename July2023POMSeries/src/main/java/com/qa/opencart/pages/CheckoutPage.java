package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {
  WebDriver driver;
	
	
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	

//locators
	private By tableheading = By.xpath("//div[@class='table-responsive']//thead ");// verify size or text of heading items
	
	
	//Action Methods
	public String checkoutPageTitle()
	{
		String title = driver.getTitle();
	     System.out.println("Checkout Page title is " +title);
		return title;
	}

   /*public List<String> checkouttableheadings()
{
	List<WebElement> allheadings = driver.findElements(tableheading);
	List<String>headingValList = new ArrayList<String>();
	for(WebElement heading :allheadings)
	{
		String texts = heading.getText();
		headingValList.add(texts);
		
	}
	  return headingValList;
	
   
}*/

public Dimension checkouttableheadings()
{
	Dimension headingstext =driver.findElement(tableheading).getSize();
	return headingstext;
}










}
