package com.mystore.pageobjects;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	@FindBy(how=How.XPATH,using="//a[@data-original-title='My wish list']")
	WebElement wishlist;
	@FindBy(how=How.XPATH,using="//a[@data-original-title='Order history']")
	WebElement orderHistory;
	public HomePage()
	{
		PageFactory.initElements(getDriver(), this);
	}
	public String getCurrentURL()
	{
		String currURL=getDriver().getCurrentUrl();
		return currURL;
	}
	public boolean validateWishlist()
	{
		boolean flag=false;
		flag=wishlist.isDisplayed();
		if(flag)
		{
			System.out.println("The element is displayed");
		}
		else
		{
			System.out.println("The element is not displayed");
		}
		return flag;
	}
	public void homePageScreenshot() throws IOException {
		Date date=new Date();
		String fileName= date.toString().replace(":", "_").replace("", "_")+".png";
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("C:\\Users\\USER\\eclipse-workspace\\myStore\\ScreenShots\\"+fileName));
		
	}
	public boolean validateOrderHistory()
	{
		boolean flag=false;
		flag=orderHistory.isDisplayed();
		if(flag)
		{
			System.out.println("The element is displayed");
		}
		else
		{
			System.out.println("The element is not displayed");
		}
		return flag;
	}
}
