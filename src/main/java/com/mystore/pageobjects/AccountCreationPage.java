package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_firstname']")
	WebElement fname;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_lastname']")
	WebElement lname;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_email']")
	WebElement email;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_telephone']")
	WebElement telephone;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_fax']")
	WebElement fax;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_company']")	
	WebElement company;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_address_1']")
	WebElement add1;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_address_2']")
	WebElement add2;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_city']")
	WebElement city;
	@FindBy(how=How.XPATH,using = "//select[@id='AccountFrm_zone_id']")
	WebElement state;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_postcode']")
	WebElement zip;
	@FindBy(how=How.XPATH,using = "//select[@id='AccountFrm_country_id']")
	WebElement country;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_loginname']")
	WebElement logInName;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_password']")
	WebElement pwd;
	@FindBy(how=How.XPATH,using = "//input[@id='AccountFrm_confirm']")
	WebElement cpwd;
	@FindBy(how=How.XPATH,using = "//input[@id=\"AccountFrm_agree\"]")
	WebElement termAndElementCon;
	@FindBy(how=How.XPATH,using = "//input[@id=\"AccountFrm_newsletter1\"]")
	WebElement subscribe;
	@FindBy(how=How.XPATH,using = "//button[@title='Continue']")
	WebElement continueBtn;
	public AccountCreationPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public HomePage createAccount(String firstName,String LastName,String Semail,String tel,String Sfax,String 
			Scompany,String Sadd1,String Sadd2,String Scity,String countrys,String Sstate,String Szip,String SlogInName,String password,String cpassword) throws InterruptedException
	{
		fname.sendKeys(firstName);
		lname.sendKeys(LastName);
		email.sendKeys(Semail);
		
		telephone.sendKeys(tel);
		
		fax.sendKeys(Sfax);
		company.sendKeys(Scompany);
		add1.sendKeys(Sadd1);
		add2.sendKeys(Sadd2);
		city.sendKeys(Scity);
//		country.click();
		Select select=new Select(country);
		select.selectByVisibleText("India");
//		state.click();
		Select select1=new Select(state);
		select1.selectByVisibleText("Orissa");
		
		zip.sendKeys(Szip);
		logInName.sendKeys(SlogInName);
		pwd.sendKeys(password);
		cpwd.sendKeys(cpassword);
		termAndElementCon.click();
		subscribe.click();
		continueBtn.click();
		Thread.sleep(3000);
		return new HomePage();

		
		
		
	}

}