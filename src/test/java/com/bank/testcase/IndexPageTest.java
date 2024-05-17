package com.bank.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.base.BaseClass;
import com.bank.pageobjects.IndexPage;

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
		driver.quit();
	}
	@Test
	public void verifyTitle()
	{
		ip=new IndexPage();
		String actualTitle=ip.getPageTitle();
		String expectedTitle="ParaBank | Welcome | Online Banking";
		Assert.assertEquals(expectedTitle, actualTitle);
		
	}

}
