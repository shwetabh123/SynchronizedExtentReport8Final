package com.pulse.Page;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic.BasePage;


public class Analyse extends BasePage{
	
	

	@FindBy(xpath=" //*[@href=\"/Pulse/Analyze\"] ")
	private WebElement  Analysebutton ;
	

	@FindBy(xpath="//*[@id=\"searchInputAnalyseResult\"]")
	
	private WebElement  clickanalyzesearch ;
	
	

	@FindBy(xpath="//*[@id=\"searchAnalyseResult\"]")
	
	private WebElement  clickanalyzesearchbutton ;
	


	@FindBy(xpath="//*[text()=\"Pulled Away\"]/..//following-sibling::div//button")
	
	private WebElement  DVAnalyseCopyOfShwetabhDVSurveyConsumingAccountSA ;
	
	
	@FindBy(xpath="	//*[@id=\"analyseTabs\"]/li/a[text()=\"Reports\"]")
	
	private WebElement  	SpotLightReportsTab ;
	


	
	@FindBy(xpath="//*[@id=\"PreviousStartDate\"]")
	private WebElement  	PreviousStartDate ;
	


	@FindBy(xpath="//*[@id=\"PreviousEndDate\"] ")
	private WebElement  	PreviousEndDate ;
	

	@FindBy(xpath="(//*[@id=\"reports\"]//div[contains(@class,\"btn-group ceb-dropdown-container\")])[3] ")
	private WebElement  	Segment3Dropdown  ;
	


	@FindBy(xpath="(//*[@id=\"reports\"]//ul/li/a/label[text()=\" What is your department ?\"])[2]//input")
	private WebElement  	Segment2DemoValues  ;
	
	@FindBy(xpath="(//*[@id=\"reports\"]//div[contains(@class,\"btn-group ceb-dropdown-container\")])[4] ")
	private WebElement  	Segment4Dropdown  ;
	

	
	@FindBy(xpath="(//*[@id=\"reports\"]//ul/li/a/label[text()=\" What is your gender?\"])[3]//input")
	
	
	
	private WebElement  	Segment3DemoValues  ;
	
	
	
	
	
	@FindBy(xpath="//*[@id=\"btnSelectBenchMark\"]")
	
	
	
	private WebElement  	btnSelectBenchMark  ;
	
	
	
	@FindBy(xpath="//*[@id=\"chkBenchmark\"]")
	
	
	
	private WebElement  	VsBenchmarkCheckbox  ;
	
	
	
	
	
	
	@FindBy(xpath="//*[@id=\"analysis-settings-modal\"]//button[text()=\"Apply\"]")
	
	
	private WebElement ApplyAnalysesettings;
	
	
	
	
	@FindBy(xpath="//*[@id='btnRunReport'][text()='Run Report']")
	
	
	private WebElement RunReport;
	
	
	
	
	@FindBy(xpath="(//*[@class=\"shl-icon_settings\"])[2]")
	
	private WebElement actionbutton;
	

/*	
	@FindBy(xpath="(//*[@widget-data-event='click::downloadpreviousreport'][text()='Download'])[1]")
			
	private WebElement Download;
	*/
	
	
	BasePage b=new BasePage(driver);
	
	
	
	//getObject g=new getObject(driver);
	
	
	//ReadObject r=new ReadObject(driver);
	
	public Analyse(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver,this);
	}
	

	public void clickanalysebutton()
	{
		
		b.mouseHoverToElementAndClick(driver, "//*[@href='/Pulse/Analyze']");//using string location
		
		b.moveToElementAndClick_custom(Analysebutton);//using webelement
	
	}
	
	
	public void verifyanalysebutton()
	{
	
	
	b.verifyElementPresent(driver, " //*[@href=\"/Pulse/Analyze\"]");

	verifyElementPresent_custom(Analysebutton);
	
	}
	
	

	public void scrolldown()
	{
		
		b.SpecialKeysaction(driver, "//*[@href=\"/Pulse/Analyze\"]","Control+End");
	
				
	}
	
	

	public void clickanalyzesearch() throws IOException
	{
		
	
	clickanalyzesearch.sendKeys("Copy Of Shwetabh DV Survey - Consuming Account - SA");
	
	
	type_custom(clickanalyzesearch,"Copy Of Shwetabh DV Survey - Consuming Account - SA");

	}
	

	public void clickanalyzesearchbutton()
	{
	
	
	clickanalyzesearchbutton.click();
	
	Click_custom(clickanalyzesearchbutton);
	
	}
	
	public void DVAnalyseCopyOfShwetabhDVSurveyConsumingAccountSA()
	{
	
	DVAnalyseCopyOfShwetabhDVSurveyConsumingAccountSA.click();
	
	
	}
	public void SpotLightReportsTab()
	{
	SpotLightReportsTab.click();
	
	
	
	}
	
	
	
	public void btnSelectBenchMark()
	{
		btnSelectBenchMark.click();
	
	
	
	}
	
	
	public void VsBenchmarkCheckbox()
	{
		VsBenchmarkCheckbox.click();
	
	
	
	}
	

	
	public void ApplyAnalysesettings()
	{
		ApplyAnalysesettings.click();
	
	
	
	}
	public void PreviousStartDate()
	{
		PreviousStartDate.sendKeys("09/01/2017");
	
	
	
	}
	
	
	public void PreviousEndDate()
	{
		PreviousEndDate.sendKeys("11/01/2017");
	
	
	
	}
	
	public void Segment3Dropdown()
	{
		Segment3Dropdown.click();
	
	
	
	}
	

	public void Segment2DemoValues()
	{
		Segment2DemoValues.click();
	
	
	
	}

	

	public void Segment4Dropdown()
	{
		Segment4Dropdown.click();
	
	
	
	}
	
	

	public void Segment3DemoValues()
	{
		Segment3DemoValues.click();
	
	
	
	}




	public void RunReport()
	{
		RunReport.click();
	
	
	
	}
	
	
	
	
	public void actionbutton()
	{
		actionbutton.click();
	
	
	
	}
	
	
	
	
	/*public void Download() throws IOException, Exception
	{
	//	Download.click();
	
    g.getObject(r.getObjectRepository(), "Download", "XPATH");
	
	}
	*/
	

}
