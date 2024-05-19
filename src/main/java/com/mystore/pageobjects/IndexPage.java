package com.mystore.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass{
	@FindBy(how=How.XPATH,using="//input[@id='filter_keyword']")
	WebElement searchField;
	@FindBy(how=How.XPATH,using="//*[@id='search_form']/div/div")
	WebElement searchBtn;
	@FindBy(how=How.XPATH,using="//a[text()='Login or register']")
	WebElement logInBtn;
	
	@FindBy(how=How.XPATH,using="/html/body/div/header/div[1]/div/div[1]/a")
	WebElement logo;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	public LogInPage clickOnLogIn()
	{
		logInBtn.click();
		return new LogInPage();
	}
	public String getPageTitle()
	{
		String pageTitle=driver.getTitle();
		return pageTitle;
	}
	public boolean validateLogo()
	{
		boolean flag=false;
		flag=logo.isDisplayed();
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
	public SearchResultPage searchProduct(String productName)
	{
		searchField.clear();
		searchField.sendKeys(productName);
		searchBtn.click();
		return new SearchResultPage();
	}
	

}
