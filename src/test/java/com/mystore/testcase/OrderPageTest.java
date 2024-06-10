package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LogInPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass{
	LogInPage logInPage;
	IndexPage indexPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	@BeforeMethod
	public void setup()
	{
		launchApp();
	}
	@AfterMethod
	public void teardown()
	{
		getDriver().quit();
	}
	@Test
	public void verifyOrder() {
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("makeup");
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.setQuantity("2");
		orderPage=addToCartPage.addToCart();
		double unit=orderPage.getUnitPrice();
		double actual=unit*2;
		double total=orderPage.getTotalPrice();
		Assert.assertEquals(actual, total, "Matched");
		
		
	}

}
