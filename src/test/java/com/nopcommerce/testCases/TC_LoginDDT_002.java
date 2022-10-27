package com.nopcommerce.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.pageObjects.LoginPage;
import com.nopcommerce.utilities.XLUtils;

public class TC_LoginDDT_002  extends BaseClass
{
	@Test(dataProvider ="LoginData")
	public void loginTest(String user,String pwd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is opened");  //log msg
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(user);
		
		logger.info("Username is provided"); //log msg
		lp.setPassword(pwd);
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
		   //captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Login is failed");  //log msg
		}
	}
		
		
		
	
	
	
	@DataProvider(name="LoginData")
	public	String[][]  getData() throws IOException
		{
			
		String path=System.getProperty("user.dir")+"/src/test/java/com/nopcommerce/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path,"Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);// 1 0
				
			}
			
		}
	
	
			return logindata;
	
	
		}
	
	

}
