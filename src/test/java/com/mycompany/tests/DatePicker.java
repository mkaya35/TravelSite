package com.mycompany.tests;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DatePicker extends TestBaseER{
	
	@Test
	public void datePicker() throws InterruptedException {
		extentTest = extent.startTest("date picker");
		
		String departureDateString="01/24/2020";
		//disecting string into usable ints
		int month= Integer.parseInt(departureDateString.substring(0, 2));
		int day= Integer.parseInt(departureDateString.substring(3, 5));
		int year= Integer.parseInt(departureDateString.substring(6, 10));
	
		LocalDate departDate1=LocalDate.of(year,month,day);//creating data object to format in desired manner
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM YYYY");
		
		String desiredDAte=dtf.format(departDate1);
			System.out.println(desiredDAte);
		
		driver.findElement(By.xpath("//button[@id='tab-flight-tab-hp']//span[@class='icon icon-flights']")).click();//flights menu button
			
		driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']")).click();//date field click
		
		String actual=driver.findElement(By.xpath("(//caption[@class='datepicker-cal-month-header'])[1]")).getText();
		//getting current text on the "Month year" on the top of datapicker
		
		while(!actual.equalsIgnoreCase(desiredDAte)) {
			driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']"))
			.click();
			actual=driver.findElement(By.xpath("(//caption[@class='datepicker-cal-month-header'])[1]")).getText();
			Thread.sleep(1000);//wait placed to see execution easily
			
		}
		
		driver.findElement(By.xpath("(//button[@data-day='"+day+"'])[1]")).click();//clicking element with xpath correlated with day
		
		
	}
	

}
