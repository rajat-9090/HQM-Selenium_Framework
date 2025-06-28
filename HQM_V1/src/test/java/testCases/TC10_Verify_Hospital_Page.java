package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HospitalPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.IConstants;
import utilities.Javautility;
import utilities.WebDriverUtility;

public class TC10_Verify_Hospital_Page extends BaseClass {

	@Test(enabled = false)
	public void accessHospitalPage() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		boolean avev = hp.isAllValidationElementsVisible();

		if (avev == true) {

			System.out.println("All the Elements are Present and Add Hospital Page is Accessible");

		} else {

			Assert.fail("Error! Please Check the Element Again");
		}
	}

	@Test(enabled = false)
	public void verifyAddHospitalFunctionality() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		boolean ahpv = hp.isAddHospitalPageVisible();

		if (ahpv == true) {

			System.out.println("User is able to Access the Add Hospital page");

		} else {

			Assert.fail("Error! Please Check the Element Again");
		}

		hp.AddNewHospital(Integer.toString(Javautility.getRandomNum()), Javautility.generateRandomString());;
		WebDriverUtility.waitUntilElementLoad(driver, hp.getAlertMessage());
		String successmsg = hp.getAlertMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlsuccessmsg = xlutil.getCellData("Error_Messages", 4, 1);
		System.out.println(successmsg);
		System.out.println(xlsuccessmsg);
		if (successmsg.equals(xlsuccessmsg)) {

			System.out.println("New Hospital Added Successfully");

		} else {

			Assert.fail("Something went Wrong, Please check the code and Try to Add Hospital Again");
		}
	}
    
	
	@Test(enabled = false)
	public void VerifyPlusButtonFuctionality() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		HospitalPage hp = new HospitalPage(driver);
		hp.accessHospital();

		boolean ahpv = hp.isAddHospitalPageVisible();

		if (ahpv == true) {

			System.out.println("User is able to Access the Add Hospital page");

		} else {

			Assert.fail("Error! Please Check the Element Again");
		}
		//Calling Plus Method
		hp.addingNewHospitalthroughPlusButton();
		WebDriverUtility.waitUntilElementLoad(driver, hp.getAlertMessage());
		String successmsg = hp.getAlertMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlsuccessmsg = xlutil.getCellData("Error_Messages", 4, 1);
		System.out.println(successmsg);
		System.out.println(xlsuccessmsg);
		if (successmsg.equals(xlsuccessmsg)) {

			System.out.println("New Hospital Added Successfully through Plus Button");

		} else {

			Assert.fail("Something went Wrong, Please check the code and Try to Add Hospital Again");
		}
	}

}
