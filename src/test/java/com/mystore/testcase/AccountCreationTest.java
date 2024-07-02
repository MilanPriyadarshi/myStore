package com.mystore.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bank.dataproviders.DataProviderForAccountCreation;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LogInPage;

public class AccountCreationTest extends BaseClass {
	LogInPage logInPage;
	IndexPage indexPage;
	HomePage homePage;
	AccountCreationPage accountCreationPage;
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
	@Test(dataProvider = "AccountDetails", dataProviderClass = DataProviderForAccountCreation.class)
	public void accountCreation(String firstName,String LastName,String Semail,String tel,String Sfax,String 
			Scompany,String Sadd1,String Sadd2,String Scity,String countrys,String Sstate,String Szip,String SlogInName,String password) throws InterruptedException
	{
		indexPage=new IndexPage();
		logInPage=new LogInPage();
		homePage=new HomePage();
		logInPage=indexPage.clickOnLogIn();
		accountCreationPage=logInPage.userCreation();
		homePage=accountCreationPage.createAccount(firstName, LastName, Semail, tel, Sfax, Scompany, Sadd1, Sadd2, Scity, countrys, Sstate, Szip, SlogInName, password, password);
	}
	

}
