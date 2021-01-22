package com.pulse.Page;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generic.BasePage;

public class Author extends BasePage{

	public Author(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver,this);
		
	}
	
	
	
       
       
	
		@FindBy(xpath="//*[@id='navbar-menu']/ul/li[5]//a")
		private WebElement  pa ;
		
		
		@FindBy(xpath=" //BUTTON[contains(., \"Author New Survey\")] ")
		private WebElement   Authornewsurveybutton  ;
		
		
		
		@FindBy(xpath=" //*[@id=\"create-from-scratch\"]  ")
		private WebElement    Createfromscratch  ;
		
		
		
		
		
		@FindBy(xpath=" //*[@id='surveyName'] ")
		private WebElement    CreateSurveyName  ;
		
		
		
		@FindBy(xpath="  //*[@id=\"displayName\"]  ")
		private WebElement    DisplayName  ;
		
		
		
		@FindBy(xpath="  //*[@id=\"btn-create-survey\"]   ")
		private WebElement  CreateSurvey  ;
		
		
		@FindBy(xpath="  //*[@id=\"add-rating-scale\"]  ")
		private WebElement    RatingScaleButton   ;
		
		
		
		BasePage b=new BasePage(driver);
		
		
		
		
	//	Randomaplphanumber rr=new Randomaplphanumber();
		
	
		
		
	
		
		public void ClickonAuthorTab(){
			//	sleep(1);
			
			
			
			
			pa.click();
			
			
	//	b.Click(driver ,"//*[text()='Author']");
		
		
		}
		
		
		
		public void Authornewsurvey(){
			//	sleep(1);
			Authornewsurveybutton.click();
			}
		
		
		
		
		
		public void Createfromscra(){
			//	sleep(1);
			Createfromscratch.click();
			
			
			}
		
		
		public void typeSurveyName(){
			//	sleep(1);
			
			
			
	//		CreateSurveyName.sendKeys(rr.Random());
			
			
			
			
			}
		
		
		
		
		
		
		public void typeDisplayName(String dn){
			//	sleep(1);
			DisplayName.sendKeys(dn);;
			}
		
		
		
		public void CreateSurve(){
			//	sleep(1);
			CreateSurvey.click();
			}
		
		
		
		public void RatingScale(){
			//	sleep(1);
			RatingScaleButton.click();
			}
		
		
		
		
		
		
		
	}

	
	
	

