package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;
public class OrderConfirmationPage extends BaseClass{
	@FindBy(how=How.ID,using="checkout_btn")
	WebElement confirmBtn;
	public OrderConfirmationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public ClosingPage confirmOrderClick() throws InterruptedException
	{
		confirmBtn.click();
		Thread.sleep(2000);
		return new ClosingPage();
		
	}
}
