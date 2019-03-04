package com.mycompany.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class FlightsHome extends PageFactoryBase {

	public FlightsHome(WebDriver driver) {
		super(driver);
	}

	public FlightsHome flightSelectFrom(String searchValue) {

		autoSuggestiveSelector(originAirport, locationListXpath, searchValue);

		return new FlightsHome(driver);

	}

	public FlightsHome flightSelectTo(String searchValue) {

		autoSuggestiveSelector(destinationAirport, locationListXpath, searchValue);

		return new FlightsHome(driver);

	}
	public FlightsHome departureDateEnter(String date1) {
		
		typeThis(departingDate, date1);
		return new FlightsHome(driver);
	}
	public FlightsHome returningDateEnter(String date2) {
		returningDate.click();
		returningDate.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		returningDate.sendKeys(Keys.DELETE);
		typeThis(returningDate, date2);
		return new FlightsHome(driver);
	}
	public FlightsHome ifNonStopHotelClick(String nonStop,String hotel) {
		advanceOptionsMenu.click();
		if(nonStop.equals("yes")) {
			nonStopOptionRadio.click();
		}
		if(hotel.equals("yes")) {
			addHotelRadio.click();
		}
		return new FlightsHome(driver);
	}
	public FlightsHome clickSearch() {
		
		flightSearchButton.click();
		return new FlightsHome(driver);
	}
	
	public String getDepartureCity() {
		
		return flightResultsDeparture.getAttribute("value");		
	}
	public String getarrivalCity() {
		
		return flightResultsArrival.getAttribute("value");		
	}
	public String getDepartDate() {
		return departingDate.getText();		
	}
	public String getFlightSearchErrorMessage() {
		return flightSelectErrorMessage.getText();
		
	}
	
//	public FlightsHome setSortOrder(String sortOrder)
//	{
//		Select sortList = new Select(selectBox);
//		sortList.selectByVisibleText(sortOrder);
//		return new FlightsHome(driver);
//	}
//
//	public String getSortOrder()
//	{
//		Select sortList = new Select(selectBox);
//		return sortList.getFirstSelectedOption().getText();
//	}
}
