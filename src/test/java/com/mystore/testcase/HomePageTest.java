package com.mystore.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LogInPage;

public class HomePageTest extends BaseClass {
	LogInPage logInPage;
	IndexPage indexPage;
	HomePage homePage;
	@BeforeMethod
	public void setup()
	{
		launchApp();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test
	public void wishListCheck() throws InterruptedException, IOException {
		indexPage=new IndexPage();
		logInPage=new LogInPage();
		homePage=new HomePage();
		logInPage=indexPage.clickOnLogIn();
		homePage=logInPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		homePage.homePageScreenshot();
		boolean res=homePage.validateWishlist();
		Assert.assertTrue(res);
		
	}
	@Test
	public void orderHistoryCheck() throws InterruptedException {
		indexPage=new IndexPage();
		logInPage=new LogInPage();
		homePage=new HomePage();
		logInPage=indexPage.clickOnLogIn();
		homePage=logInPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		boolean res=homePage.validateOrderHistory();
		Assert.assertTrue(res);
		
	}
}
