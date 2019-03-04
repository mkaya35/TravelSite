package com.mycompany.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class HomePageTest extends TestBaseER {

//	@Test(priority=1)
//	public void validateButton(){
//		
//		
//		System.out.println(homePage.getAbout());
//		Assert.assertEquals(homePage.getAbout(), "ABOUT US");
//	}
//	
//	@Test(priority=2)
//	public void validateAbout(){
//		
//		boolean flag = homePage.validateAboutUs();
//		Assert.assertTrue(flag);
//	}
//	
//	@Test(priority=3)
//	public void validateMyAccount() throws InterruptedException{
//		
//		Thread.sleep(5000);
//		boolean flag = homePage.validateMyAccount();
//		Assert.assertTrue(flag);
//	}
//	
	
	
	@AfterMethod
	//@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}
	
}
