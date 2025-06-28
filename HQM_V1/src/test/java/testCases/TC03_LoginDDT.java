package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.DataProviders;
import utilities.WebDriverUtility;

public class TC03_LoginDDT extends BaseClass{
	
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void verify_LoginDDT(String email, String pwd, String exp) throws Throwable{
		
		logger.info("****Test-Case-03 Verifing_LoginDDT Stated****" );
		
		try {
		LoginPage login= new LoginPage(driver);
		login.loginToApplicationDDT(email,pwd);
		
		logger.info("****Login Successfully****" );
		
		boolean calculatepage=login.isCalculatePayoutScreenExists();
		
		/*Data is Valid- login success- test pass- logout
                         login failed- test fail


          Data is Invalid- login success- test fail- logout
                          login failed- test pass*/

        
		if(exp.equalsIgnoreCase("Valid")) {
			
			logger.info("****Checking Valid Login****" );
			
			if(calculatepage==true) {
				
				WebDriverUtility.waitUntilPageLoad(driver);
				login.Logout();
				Assert.assertTrue(true);
				logger.info("****Login Success with Valid Credentials****" );
			}else{
				
				Assert.assertTrue(false);
				logger.info("****Login Failed while checking with valid credentials****" );
			}
		}
		
         if(exp.equalsIgnoreCase("Invalid")) {
        	 
        	 logger.info("****Checking Invalid Login****" );
			
			if(calculatepage==true) {
				
				login.Logout();
				Assert.assertTrue(false);
				logger.info("****Login Success with Invalid Credentials****" );
				
			}else{
				
				Assert.assertTrue(true);
				logger.info("****Login Failed while checking with Invalid credentials****" );
			}
		}
         
		}catch(Exception e){
			
			Assert.fail();
		}
		
		logger.info("****Test-Case-03 Verifing_LoginDDT Ended****" );
		
		
		
	}

}
