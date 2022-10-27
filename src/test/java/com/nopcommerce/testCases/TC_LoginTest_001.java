package com.nopcommerce.testCases;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.nopcommerce.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		
		driver.get(baseURL);
		logger.info("URL is opened");  //log msg
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		
		logger.info("Username is provided"); //log msg
		lp.setPassword(password);
		logger.info("Password is provided");  //log msg
		
		lp.clickLogin();
	   logger.info("Login is clicked"); //log msg
		
		Thread.sleep(5000);
		
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			logger.info("Login is Passed"); //log msg
		}else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login is failed");  //log msg
		}
	}
		
		
		
		
	}

	
	
	
	


