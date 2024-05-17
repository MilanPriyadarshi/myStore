package com.bank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.bank.base.BaseClass;

public class IndexPage extends BaseClass{
	@FindBy(how=How.XPATH,using="//input[@name='username']")
	WebElement username;
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement password;
	@FindBy(how=How.XPATH,using="//input[@value='Log In']")
	WebElement logInBtn;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void logInAction(String uname,String pass)
	{
		username.clear();
		username.sendKeys(uname);
		password.clear();
		password.sendKeys(pass);
	}
	public String getPageTitle()
	{
		String pageTitle=driver.getTitle();
		return pageTitle;
	}

}
