/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.BaseClass;

/**
 * THis class is for verifying the cart page
 */
public class AddToCartPage extends BaseClass {
	@FindBy(how=How.ID,using="product_quantity")
	WebElement quantity;
	@FindBy(how=How.XPATH,using="//ul[@class='productpagecart']/li/a")
	WebElement addToCartBtn;
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	public void setQuantity(String quantity1)
	{
		quantity.clear();
		quantity.sendKeys(quantity1);
	}
	public OrderPage addToCart()
	{
		addToCartBtn.click();
		return new OrderPage();
	}
	

}
