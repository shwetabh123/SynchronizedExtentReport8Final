package com.pulse.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic.BasePage;

public class CompanyDirectory extends BasePage{
	
	
	public CompanyDirectory(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	

	
	

	
	@FindBy(xpath="//I[@class='shl-icon_arrow_small_down']")
	
	private WebElement  Arrowdownfor_settings ;
	
	
	
	
	
	@FindBy(xpath=" //A[@href='/Pulse/AccountSettings'] ")
	private WebElement SettingsClick ;
	
	
	
	
	
	@FindBy(xpath=" //*[@id='directory-accordion']//DIV[contains(@id, 'settings-heading')] ")
	
	private WebElement CompanyDirectory ;
	
	
	
	@FindBy(xpath=" //BUTTON[@id='menu-directory-participants'][text()='Participants'] ")
	
	private WebElement  Participants  ;
	
	
	
	@FindBy(xpath=" //*[@id='widgetDisplaySection']//*[@widget-data-event='click::uploadPartcipants'] ")
	
	private WebElement   uploadparticipantscompany   ;
	
	@FindBy(xpath=" //a[text()='sample import template'] ")
	
	
	private WebElement    DownloadSampleImportTemplate    ;
	
	
	
	public void clickArrow(){
		//	sleep(1);
			Arrowdownfor_settings.click();
			
			
			
		}
	
	public void clickSettings(){
		//	sleep(1);
		SettingsClick.click();
			
			
			
		}
	
	
	public void clickCompanyDirectory (){
		//	sleep(1);
		CompanyDirectory.click();
			
			
			
		}
	
	
	
	public void clickParticipants (){
		//	sleep(1);
		Participants.click();
			
			
			
		}
	public void clickuploadparticipantscompany (){
		//	sleep(1);
		uploadparticipantscompany.click();
			
			
			
		}
	public void clickDownloadSampleImportTemplate()
	{
		
		
		DownloadSampleImportTemplate.click();
	}
	


}
