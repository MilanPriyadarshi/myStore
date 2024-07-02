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

import com.bank.dataproviders.DataProviders;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.ClosingPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LogInPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;

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
		getDriver().quit();
	}
	@Test(dataProvider = "logInData", dataProviderClass = DataProviders.class)
	public void endToEndTest(String userName,String password) throws InterruptedException {
		Log.startTestCase("End-To-End");
//		SoftAssert softAssert=new SoftAssert();
		indexPage=new IndexPage();
		Log.info("User is going to search the product");
		searchResultPage=indexPage.searchProduct(prop.getProperty("search"));
		Log.info("User is going to click on the product");
		addToCartPage=searchResultPage.clickOnProduct();
		String quantity=prop.getProperty("quantity");
		Log.info("User is going to select the quantity of the product");
		addToCartPage.setQuantity(quantity);
		Log.info("User is going to add the product to cart");
		orderPage=addToCartPage.addToCart();
		int q=Integer.parseInt(quantity);
		double unit=orderPage.getUnitPrice();
		double actualp=unit*q;
		double total=orderPage.getTotalPrice();
		Log.info("Verification of total price with unit price");
		Assert.assertEquals(actualp, total, "Matched");
		Log.info("User is going to checkout");
		logInPage=orderPage.proceedToCheckOut();
		Log.info("User is going enter Username and Password");
		
		orderConfirmationPage=logInPage.logIn1(userName,password);
		Log.info("User is going to confirm the order");
		closingPage=orderConfirmationPage.confirmOrderClick();
		String actual=closingPage.getConfirmationMsg();
		String expected="YOUR ORDER HAS BEEN PROCESSED!";
		Log.info("Verification of confirmation");
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
