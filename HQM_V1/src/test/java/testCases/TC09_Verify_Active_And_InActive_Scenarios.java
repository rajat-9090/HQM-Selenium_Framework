package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HospitalGroupSystemPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.IConstants;
import utilities.JavaScriptUtility;
import utilities.WebDriverUtility;

public class TC09_Verify_Active_And_InActive_Scenarios extends BaseClass {

	@Test(enabled = false)
	public void VerifyActiveBtn() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();

		// Click Active Button
		hgp.accessActiveandInActiveSection();
		WebDriverUtility.waitUntilElementLoad(driver, hgp.getAlertMessage());
		String activemsg = hgp.getAlertMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlactivemsg = xlutil.getCellData("Error_Messages", 3, 1);
		System.out.println(activemsg);
		System.out.println(xlactivemsg);
		if (activemsg.equals(xlactivemsg)) {

			System.out.println("A Specific Group System Activated Successfully");

		} else {

			Assert.fail("Something Went Wrong! Please Try Again");
		}
	}

	@Test(enabled = false)
	public void VerifyINActiveBtn() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();

		// Click Active Button
		hgp.accessActiveandInActiveSection();
		WebDriverUtility.waitUntilElementLoad(driver, hgp.getAlertMessage());
		String activemsg = hgp.getAlertMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlactivemsg = xlutil.getCellData("Error_Messages", 2, 1);
		System.out.println(activemsg);
		System.out.println(xlactivemsg);
		if (activemsg.equals(xlactivemsg)) {

			System.out.println("A Specific Group System INActivated Successfully");

		} else {

			Assert.fail("Something Went Wrong! Please Try Again");
		}
	}

	@Test(enabled = false)
	public void VerifyCancelButton() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();

		// Canceling the Edit Funtion in the Midway with Cancel Button
		hgp.cancelEditFunctionality();

	}

	@Test(enabled = false)
	public void VerifyUpdateButton() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();

		// Click Update Button without Modifing the Data
		hgp.withoutEditAccessUpdate();
		WebDriverUtility.waitUntilElementLoad(driver, hgp.getUpdateMessage());
		String updatemsg = hgp.getUpdateMessage().getText();
		JavaScriptUtility.scrolltotheElement(driver, hgp.getEditRowData1());
		JavaScriptUtility.drawBorder(driver, hgp.getEditRowData1());
		JavaScriptUtility.drawBorder(driver, hgp.getEditRowData2());
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlupdatemsg = xlutil.getCellData("Error_Messages", 1, 1);
		System.out.println(updatemsg);
		System.out.println(xlupdatemsg);
		if (updatemsg.equals(xlupdatemsg)) {

			System.out.println("Selected Group System updated Successfully without Modification");

		} else {

			Assert.fail("Something went Wrong, Please check the code and Try to Update Again");
		}
	}

	@Test
	public void VerifyPagination() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();

		boolean agsp = hgp.isAddGroupSystemPageVisiable();
		if (agsp == true) {

			System.out.println("Add group system page is Successfully displayed");

		} else {

			Assert.fail("Add group system page should be displayed! Please Check Again");
		}
		Thread.sleep(3000);
		List<Boolean> hgsp = hgp.Pagination();
		for (boolean AllPagi : hgsp) {

			if (AllPagi == true) {

				System.out.println("This Pagination Button is Enabled: " + AllPagi);

			} else {

				Assert.fail("This Pagianation Button isn't Enabled");
			}
		}
	}

}
