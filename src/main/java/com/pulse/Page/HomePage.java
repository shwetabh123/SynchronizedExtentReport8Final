package com.pulse.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class HomePage extends BasePage {
	
	
	public HomePage(WebDriver driver) 
	
	
	{
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	

	
	
	@FindBy(xpath="//I[@class='shl-icon_arrow_small_down']")
	
	private WebElement  Arrowdownfor_settings ;
	
	
	

	@FindBy(xpath="//A[contains(., \"Logout\")]   ")
	
	private WebElement  Logout_click ;
	
	
	

	public void clickArrow(){
	//	sleep(1);
		Arrowdownfor_settings.click();
		
		
		
	}
	
	
	public void Logout(){
	//	sleep(1);
		Logout_click.click();
		
		
		
	}
	
	
	

}
