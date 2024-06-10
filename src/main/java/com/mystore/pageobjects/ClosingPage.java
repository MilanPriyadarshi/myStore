package com.mystore.pageobjects;

import com.mystore.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ClosingPage extends BaseClass {
	@FindBy(how=How.XPATH,using="//span[@class='maintext']")
	WebElement confirmMsg;
	
	public ClosingPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public String getConfirmationMsg()
	{
		String res=confirmMsg.getText();
		return res;
		
	}

}
