package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ClosingPage extends BaseClass {
	@FindBy(how=How.XPATH,using="//span[text()=' Your Order Has Been Processed!']")
	WebElement confirmMsg;
	public ClosingPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean confirmation()
	{
		boolean flag=confirmMsg.isDisplayed();
		return flag;
	}

}
