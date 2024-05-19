package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(how=How.XPATH,using="//a[@data-original-title='My wish list']")
	WebElement wishlist;
	@FindBy(how=How.XPATH,using="//a[@data-original-title='Order history']")
	WebElement orderHistory;
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean validateWishlist()
	{
		boolean flag=false;
		flag=wishlist.isDisplayed();
		if(flag)
		{
			System.out.println("The element is displayed");
		}
		else
		{
			System.out.println("The element is not displayed");
		}
		return flag;
	}
	public boolean validateOrderHistory()
	{
		boolean flag=false;
		flag=orderHistory.isDisplayed();
		if(flag)
		{
			System.out.println("The element is displayed");
		}
		else
		{
			System.out.println("The element is not displayed");
		}
		return flag;
	}
}
