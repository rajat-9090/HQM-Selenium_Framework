package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HospitalGroupSystemPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.JavaScriptUtility;
import utilities.WebDriverUtility;

public class TC07_Group_System_Page_Negetive_Scenarios extends BaseClass {

	@Test
	public void addingNewGroupSystemwithBlankValues() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();
		Thread.sleep(3000);

		hgp.addGroupSystemwithBlankEnties();
		boolean blankerrors = hgp.isGroupSystemBlankErrorVisiable();
		JavaScriptUtility.drawBorder(driver, hgp.blankGroupSystemIDError());
		JavaScriptUtility.drawBorder(driver, hgp.blankGroupSystemError());
//		new BaseClass().captureScreen("Group System");
		JavaScriptUtility.generateAlert(driver, "I intentionaly keep the fields Blank");

		if (blankerrors == true) {

			System.out.println("Test is Passed: Can't Add New Group with Blank Fields");
		} else {

			Assert.fail("Test is Failed: Error should be visible in Screen");
		}
	}

}
