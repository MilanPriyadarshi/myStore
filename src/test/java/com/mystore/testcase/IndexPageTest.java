package com.mystore.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;

import org.testng.*;

public class IndexPageTest extends BaseClass {
	IndexPage ip;
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
	public void verifyTitle()
	{
		ip=new IndexPage();
		String actualTitle=ip.getPageTitle();
		String expectedTitle="A place to practice your automation skills!";
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}
	@Test
	public void verifyLogo()
	{
		ip=new IndexPage();
		boolean flag=ip.validateLogo();
		Assert.assertTrue(flag);
	}

}
