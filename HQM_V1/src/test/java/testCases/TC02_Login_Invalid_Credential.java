package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testbase.BaseClass;

public class TC02_Login_Invalid_Credential extends BaseClass{
	
	@Test
	public void LoginwithInvalidDetails() throws Throwable{
		
		logger.info("****Test-Case-02 Strating****");
		
		LoginPage login_invalid= new LoginPage(driver);
		login_invalid.loginToApplication();
		
//		HandelAlert alert= new HandelAlert(driver);
//		boolean appalert=alert.istheAlertAppears();
		
		boolean calculatepage=login_invalid.isCalculatePayoutScreenExists();
		assertEquals(calculatepage, true, "The WebElement Is Wrong");
		
		logger.info("****Test-Case-02 Ended****" );
	}

}
