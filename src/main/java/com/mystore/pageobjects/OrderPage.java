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
		PageFactory.initElements(getDriver(), this);
	}
	public double getUnitPrice()
	{
		String up=unitPrice.getText();
		String up1=up.replaceAll("[^a-zA-Z0-9]","");
		double upd=Double.parseDouble(up1);
		double rup=upd/100;
		return rup;
//		up.replaceAll("[^a-zA-Z0-9]", "");
//		double unitPrice=Double.parseDouble(up);
//		return unitPrice;
	}
	public Double getTotalPrice()
	{
		String tp=totalPrice.getText();
		String tp1=tp.replaceAll("[^a-zA-Z0-9]", "");
		double totalPrice=Double.parseDouble(tp1);
		double rtp=totalPrice/100;
		return rtp;
	}
	public LogInPage proceedToCheckOut()
	{
		checkOutBtn.click();
		return new LogInPage();
	}



}
