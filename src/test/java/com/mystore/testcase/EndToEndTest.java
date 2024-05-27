package com.mystore.testcase;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//import org.testng.asserts.SoftAssert;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.ClosingPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LogInPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class EndToEndTest extends BaseClass{
	LogInPage logInPage;
	IndexPage indexPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	OrderConfirmationPage orderConfirmationPage;
	ClosingPage closingPage;
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
	public void endToEndTest() throws InterruptedException {
//		SoftAssert softAssert=new SoftAssert();
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct(prop.getProperty("search"));
		addToCartPage=searchResultPage.clickOnProduct();
		String quantity=prop.getProperty("quantity");
		addToCartPage.setQuantity(quantity);
		orderPage=addToCartPage.addToCart();
		int q=Integer.parseInt(quantity);
		double unit=orderPage.getUnitPrice();
		double actualp=unit*q;
		double total=orderPage.getTotalPrice();
		Assert.assertEquals(actualp, total, "Matched");
		logInPage=orderPage.proceedToCheckOut();
		orderConfirmationPage=logInPage.logIn1(prop.getProperty("username"), prop.getProperty("password"));
		closingPage=orderConfirmationPage.confirmOrderClick();
		String actual=closingPage.getConfirmationMsg();
		String expected="YOUR ORDER HAS BEEN PROCESSED!";
		Assert.assertEquals(actual, expected);
		
	}
	@AfterMethod
	public void screenShotOfFailedTestCase(ITestResult testResult) throws IOException {
		if(testResult.getStatus()==ITestResult.FAILURE)
		{
			Date date=new Date();
			String fileName= date.toString().replace(":", "_").replace("", "_")+".png";
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(".//ScreenShots//"+fileName));
		}
	}

}
