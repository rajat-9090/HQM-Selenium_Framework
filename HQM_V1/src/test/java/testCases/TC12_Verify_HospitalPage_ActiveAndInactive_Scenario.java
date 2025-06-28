package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HospitalPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.IConstants;
import utilities.WebDriverUtility;

public class TC12_Verify_HospitalPage_ActiveAndInactive_Scenario extends BaseClass {

	@Test
	public void VerifyActivebtn() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		hp.ActiveAndInActiveScenario();
		WebDriverUtility.waitUntilElementLoad(driver, hp.getAlertMessage());
		String activemsg = hp.getAlertMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlactivemsg = xlutil.getCellData("Error_Messages", 0, 2);
		System.out.println(activemsg);
		System.out.println(xlactivemsg);
		if (activemsg.equals(xlactivemsg)) {

			System.out.println("Test Passed: A Specific Hospital Activated Successfully");

		} else {

			Assert.fail("Test Failed: Something Went Wrong! Please Try Again");
		}
	}

	@Test(enabled = false)
	public void VerifyINActivebtn() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		hp.ActiveAndInActiveScenario();
		WebDriverUtility.waitUntilElementLoad(driver, hp.getAlertMessage());
		String activemsg = hp.getAlertMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlactivemsg = xlutil.getCellData("Error_Messages", 1, 2);
		System.out.println(activemsg);
		System.out.println(xlactivemsg);
		if (activemsg.equals(xlactivemsg)) {

			System.out.println("Test Passed: A Specific Hospital INActivated Successfully");

		} else {

			Assert.fail("Test Failed: Something Went Wrong! Please Try Again");
		}
	}

}
