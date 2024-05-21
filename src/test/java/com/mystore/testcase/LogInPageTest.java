package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LogInPage;

public class LogInPageTest extends BaseClass {
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
	public void verifyLogIn() throws InterruptedException
	{
		indexPage=new IndexPage();
		logInPage=new LogInPage();
		homePage=new HomePage();
		logInPage=indexPage.clickOnLogIn();
		homePage=logInPage.logIn(prop.getProperty("username"), prop.getProperty("password"));
		String actualURL=homePage.getCurrentURL();
		String expectedURL="https://automationteststore.com/index.php?rt=account/account";
		Assert.assertEquals(actualURL, expectedURL);
	}

}
