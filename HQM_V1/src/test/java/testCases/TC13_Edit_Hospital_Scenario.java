package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HospitalPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.IConstants;
import utilities.JavaScriptUtility;
import utilities.WebDriverUtility;

public class TC13_Edit_Hospital_Scenario extends BaseClass {

	@Test(enabled = false)
	public void VerifyEditbtn() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		// Edit Process
		hp.editHospital();
		WebDriverUtility.waitUntilElementLoad(driver, hp.getAlertMessage());
		String updatemsg = hp.getAlertMessage().getText();
		JavaScriptUtility.scrolltotheElement(driver, hp.getRowData1());
		JavaScriptUtility.drawBorder(driver, hp.getRowData1());
		JavaScriptUtility.drawBorder(driver, hp.getRowData2());
		JavaScriptUtility.drawBorder(driver, hp.getRowData3());
		new BaseClass().captureScreen("Marked Row After Edit");
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlupdatemsg = xlutil.getCellData("Error_Messages", 2, 2);
		System.out.println(updatemsg);
		System.out.println(xlupdatemsg);
		if (updatemsg.equals(xlupdatemsg)) {

			System.out.println("Test Passed: Selected Hospital updated Successfully");

		} else {

			Assert.fail("Test Failed: Something went Wrong, Please and Try to Edit Again");
		}
	}

	@Test(enabled = false)
	public void VerifyEditbtnWithoutModification() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		// Edit Process without Modification
		hp.clickEditWithoutModification();
		WebDriverUtility.waitUntilElementLoad(driver, hp.getAlertMessage());
		String updatemsg = hp.getAlertMessage().getText();
		JavaScriptUtility.scrolltotheElement(driver, hp.getRowData1());
		JavaScriptUtility.drawBorder(driver, hp.getRowData1());
		JavaScriptUtility.drawBorder(driver, hp.getRowData2());
		JavaScriptUtility.drawBorder(driver, hp.getRowData3());
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlupdatemsg = xlutil.getCellData("Error_Messages", 2, 2);
		System.out.println(updatemsg);
		System.out.println(xlupdatemsg);
		if (updatemsg.equals(xlupdatemsg)) {

			System.out.println("Test Passed: Selected Hospital updated Successfully without Modification");

		} else {

			Assert.fail("Test Failed: Something went Wrong, Please and Try to Edit Again");
		}
	}

	@Test(enabled = false)
	public void VerifyCancelBtn() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		// Click Cancel
		hp.clickcancelbtn();

	}
    
	
	@Test
	public void VerifyPagination() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();
		
		boolean ahpv=hp.isAddHospitalPageVisible();
		if (ahpv == true) {

			System.out.println("Add Hospital page is Successfully displayed");

		} else {

			Assert.fail("Add Hospital page should be displayed! Please Check Again");
		}
		Thread.sleep(3000);
		List<Boolean> hgsp = hp.Pagination();
		for (boolean AllPagi : hgsp) {

			if (AllPagi == true) {

				System.out.println("This Pagination Button is Enabled: " + AllPagi);

			} else {

				Assert.fail("This Pagianation Button isn't Enabled");
			}
		}
		
	}

}
