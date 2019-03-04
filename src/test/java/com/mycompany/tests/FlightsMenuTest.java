package com.mycompany.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.mycompany.pages.FlightsHome;


public class FlightsMenuTest extends TestBaseER
{

	  
	  @Test(dataProvider="dataProvider")
	  public void flightMenuPositiveTest(String origin,String destination,String departureDate,String returnDate,String nonStop,String hotel)
	  {
		  extentTest = extent.startTest("Positive Flight test");
		homePage.clickflightsMenu().flightSelectFrom(origin).flightSelectTo(destination).
		departureDateEnter(departureDate).returningDateEnter(returnDate).ifNonStopHotelClick(nonStop, hotel).clickSearch();
				  
		  Assert.assertTrue(homePage.connectflightsMenu().getDepartureCity().contains(origin), 
	  				"Origin was not found in the search page");
		Assert.assertTrue(homePage.connectflightsMenu().getarrivalCity().contains(destination), 
				  				"destination was not found in the search page");
	
	  }
	  @Test(dataProvider="dataProvider")
	  public void flightMenuNegativeTest(String origin,String destination,String departureDate,String returnDate,String nonStop,String hotel)
	  {	
		  extentTest = extent.startTest("/negative Flight test");
		homePage.clickflightsMenu().flightSelectFrom(origin).flightSelectTo(destination).
		departureDateEnter(departureDate).returningDateEnter(returnDate).ifNonStopHotelClick(nonStop, hotel).clickSearch();
				  
		  Assert.assertTrue(homePage.connectflightsMenu().getFlightSearchErrorMessage().contains("different destination from origin")); 
	  	
	
	  }
	  
	  
	  
	  
 
}
	  

