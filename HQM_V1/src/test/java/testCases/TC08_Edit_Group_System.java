package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HospitalGroupSystemPage;
import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.IConstants;
import utilities.JavaScriptUtility;
import utilities.WebDriverUtility;

public class TC08_Edit_Group_System extends BaseClass {

	@Test
	public void verifyEditButtoninGroupSystemPage() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Enter Hospital Group System Page
		HospitalGroupSystemPage hgp = new HospitalGroupSystemPage(driver);
		hgp.accessHospitalGroupSystem();
		
		//Edit Any Group System
		hgp.editGroupSystem();
		WebDriverUtility.waitUntilElementLoad(driver, hgp.getUpdateMessage());
		String updatemsg=hgp.getUpdateMessage().getText();
		JavaScriptUtility.scrolltotheElement(driver, hgp.getEditRowData1());
		JavaScriptUtility.drawBorder(driver, hgp.getEditRowData1());
		JavaScriptUtility.drawBorder(driver, hgp.getEditRowData2());
//		new BaseClass().captureScreen("After Edit");
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlupdatemsg = xlutil.getCellData("Error_Messages", 1, 1);
		System.out.println(updatemsg);
		System.out.println(xlupdatemsg);
		if(updatemsg.equals(xlupdatemsg)){
			
			System.out.println("Selected Group System updated Successfully");
		
		}else {
			
			Assert.fail("Something went Wrong, Please check the code and Try to Edit Again");
		}
	}

}
