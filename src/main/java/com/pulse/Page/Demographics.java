package com.pulse.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic.BasePage;

public class Demographics extends BasePage{
	
	

	@FindBy(xpath=" //*[@href=\"/Pulse/Analyze\"] ")
	private WebElement  Analysebutton ;
	
	@FindBy(xpath="//input[@id='searchInputAnalyseResult']")
	private WebElement	typesearchsurveyname;
	
	
	@FindBy(xpath="//I[contains(@id, 'searchAnalyseResult')]")
	private WebElement clickonsearchicon;
	
	@FindBy(xpath="(//BUTTON[contains(., 'Analyze')])[1]")
	private WebElement clickonanalysebutton;
	
	@FindBy(xpath="//A[contains(@href, '#favorability')]")
	private WebElement Favorabilitytab;
	
	
	
	BasePage b=new BasePage(driver);

	
	
	
	
	
	
	
	public Demographics(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	
	public void clickanalysebutton()
	{
		
		b.mouseHoverToElementAndClick(driver, "//*[@id='navbar-menu']//a[@href='/Pulse/Analyze']");
		
	
	}
	
	
	/*public void typesearchsurvey(String sn)
	{
		
		b.type(driver, "//input[@id='searchInputAnalyseResult']",sn);
		
	
	}
	*/
	public void clickonsearchicon()
	{
		
		b.mouseHoverToElementAndClick(driver, "//I[contains(@id, 'searchAnalyseResult')]");
		
	
	}
	
	public void clickonanalysebutton()
	{
	
		b.mouseHoverToElementAndClick(driver,"(//BUTTON[contains(., 'Analyze')])[1]");
		
	
	}
	
	 public void clickonFavorabilitytab ()
	
	 {
			
			b.mouseHoverToElementAndClick(driver,"//A[contains(@href, '#favorability')]");
			
		
		}
		
	
	

}
