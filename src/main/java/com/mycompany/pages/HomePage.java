package com.mycompany.pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends PageFactoryBase {
	public JSEHelper jseHelper=new JSEHelper();
	
		
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	
	public FlightsHome connectflightsMenu() {
		
		return new FlightsHome(driver);
		
	}
	
	public FlightsHome clickflightsMenu() {
		jseHelper.highlight(flightTab, driver);
		flightTab.click();
		return new FlightsHome(driver);
		
	}
//public void clickflightsMenu() {
//		
//		flightTab.click();
//		
//		
//	}
	public boolean validateAboutUs(){
		js.highlight(about, driver);
 		js.drawBorder(about, driver);
 		return about.isDisplayed();
 	}
	
	public String getAbout() {
		 return  about.getText();
	}
	
//	public boolean validateMyAccount(){
//		js.highlight(myAccountButton, driver);
// 		js.drawBorder(myAccountButton, driver);
// 		return myAccountButton.isDisplayed();
// 	}
	
//	public static void main(String[] args) {
//		new HomePage(driver).clickflightsMenu();
//	}
}
