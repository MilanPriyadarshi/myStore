package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	@FindBy(how=How.XPATH,using="//a[@title='Skinsheen Bronzer Stick']")
	WebElement productRes;
	public SearchResultPage()
	{
		PageFactory.initElements(driver, this);
	}
	public AddToCartPage searchResult()
	{
		productRes.click();
		return new AddToCartPage();
	}

}
