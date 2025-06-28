package testCases;

import org.testng.annotations.Test;

import pageObjects.HospitalGroupSystemPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.IConstants;
import utilities.Javautility;
import utilities.WebDriverUtility;

public class TC06_Verify_Hospital_Group_System_Page extends BaseClass {

	@Test(enabled = false)
	public void accessHospitalGroupSystemPage() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();

		boolean gspv = hgp.isAddGroupSystemPageVisiable();
		boolean gsiv = hgp.isGroupSystemIDVisiable();
		boolean gsv = hgp.isGroupSystemVisiable();

		if (gspv == true && gsiv == true && gsv == true) {

			System.out.println("Add Group System Page is Accessable with all the given Elements");

		} else {

			System.out.println("Not all the Elements are Present so Add Group System Page is not Accessable");
		}

	}

	@Test
	public void addingNewGroupSystem() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();

		// We added the Group System Details and Click Add Button
		hgp.addingNewGroupSystem(Integer.toString(Javautility.getRandomNum()), Javautility.generateRandomString());
		Thread.sleep(2000);
		hgp.isAddbtnClickable();
		WebDriverUtility.waitUntilElementLoad(driver, hgp.getSuccessMessage());
		String suMessage = hgp.getSuccessMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String errmessage = xlutil.getCellData("Error_Messages", 0, 1); 
//		System.out.println(suMessage);
//		System.out.println(errmessage);

		if (suMessage.equals(errmessage)) {

			System.out.println("New Group System Added Successfully");

		} else {

			System.out.println("Adding New Group System is Failed");
		}

	}

}
