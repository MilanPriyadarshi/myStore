package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	@FindBy(how=How.XPATH,using="//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[4]")
	WebElement unitPrice;
	@FindBy(how=How.XPATH,using="//*[@id='cart']/div/div[1]/table/tbody/tr[2]/td[6]")
	WebElement totalPrice;
	@FindBy(how=How.XPATH,using="//div[@class='pull-right mb20']/a")
	WebElement checkOutBtn;
	public OrderPage()
	{
		PageFactory.initElements(driver, this);
	}
	public Double getUnitPrice()
	{
		String up=unitPrice.getText();
		up.replaceAll("[^a-zA-Z0-9]", "");
		Double unitPrice=Double.parseDouble(up);
		return unitPrice;
	}
	public Double getTotalPrice()
	{
		String tp=totalPrice.getText();
		tp.replaceAll("[^a-zA-Z0-9]", "");
		Double totalPrice=Double.parseDouble(tp);
		return totalPrice;
	}
	public LogInPage proceedToCheckOut()
	{
		checkOutBtn.click();
		return new LogInPage();
	}



}
