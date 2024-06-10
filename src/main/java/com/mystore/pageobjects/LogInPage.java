package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.mystore.base.BaseClass;

public class LogInPage extends BaseClass{
	@FindBy(how=How.XPATH,using="//input[@name='loginname']")
	WebElement usernameField;
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement passwordField;
	@FindBy(how=How.XPATH,using="//*[@id='loginFrm']/fieldset/button")
	WebElement logInBtn;
	@FindBy(how=How.XPATH,using="//*[@id='accountFrm']/fieldset/button")
	WebElement newUserBtn;
	public LogInPage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public HomePage logIn(String uname,String pass) throws InterruptedException
	{
		
		usernameField.clear();
		usernameField.sendKeys(uname);
		passwordField.clear();
		passwordField.sendKeys(pass);
		Thread.sleep(2000);
		logInBtn.click();
		Thread.sleep(2000);
		return new HomePage();
	}
	public OrderConfirmationPage logIn1(String uname,String pass)
	{
		usernameField.clear();
		usernameField.sendKeys(uname);
		passwordField.clear();
		passwordField.sendKeys(pass);
		logInBtn.click();
		
		
		return new OrderConfirmationPage();
	}
	public AccountCreationPage userCreation()
	{
		newUserBtn.click();
		return new AccountCreationPage();
		
	}

}
