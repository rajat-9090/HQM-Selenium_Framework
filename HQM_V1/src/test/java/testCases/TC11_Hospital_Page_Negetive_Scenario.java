package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HospitalPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.JavaScriptUtility;
import utilities.WebDriverUtility;

public class TC11_Hospital_Page_Negetive_Scenario extends BaseClass {
	
    
	@Test(enabled = false)
	public void addingNewHospitalWithBlankValues() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();
		
		hp.VerifyBlankScenarios();
		
		boolean hpbev=hp.isHospitalPageBlankErrorsVisiable();
		JavaScriptUtility.generateAlert(driver, "I intentionaly keep the fields Blank");
		if(hpbev==true) {
			
			System.out.println("Test is Passed: Can't Add New Hospital with Blank Fields");
		
		}else{
			
			Assert.fail("Test is Failed: Error should be visible in Screen");
		}
	}
	
	

}
