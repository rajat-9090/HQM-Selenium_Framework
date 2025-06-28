package testCases;

import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.IConstants;
import utilities.WebDriverUtility;

public class TC01_Login_Valid_Credential extends BaseClass{
	
	
	
	@Test(priority = -1)
	public void verifyLogin() throws Throwable {
		
		
		LoginPage valid= new LoginPage(driver);
		valid.loginToApplication();
				
	}
	
	@Test
	public void verifyLoginwithInvalidEmail() throws Throwable {
		
		LoginPage ine= new LoginPage(driver);
		ine.loginUnsuccessfulwithInvalidEmail();
		WebDriverUtility.waitUntilPageLoad(driver);
		String errmsg=ine.getEmailError().getText();
		String path=IConstants.EXCEL_PATH;
		Excelutility xlutil= new Excelutility(path);
		String errmessage1=xlutil.getCellData("Error_Messages", 0, 0);
//		System.out.println(errmessage1);
//		System.out.println(errmsg);
        if(errmsg.contains(errmessage1)) {
			
			System.out.println("****Invalid Email! Login Unsuccessfull****");
			
		}else {
			
			System.out.println("****Login shouldn't be Successfull with Invalid Email****");
		}
		
		
//		Assert.assertEquals(errmsg, message.trim(), "Login Failed Due to Invalid Email");
		
	}
	
	@Test(enabled = false)
	public void verifyLoginwithInvalidPassword() throws Throwable {
		
		LoginPage ine= new LoginPage(driver);
		ine.loginUnsuccessfulwithInvalidPass();
		WebDriverUtility.waitUntilPageLoad(driver);
		String passerrmsg=ine.getPassError().getText();
		String path=IConstants.EXCEL_PATH;
		Excelutility xlutil= new Excelutility(path);
		String errmessage1=xlutil.getCellData("Error_Messages", 0, 0);
        if(passerrmsg.contains(errmessage1)) {
			
			System.out.println("****Invalid Password! Login Unsuccessfull****");
			
		}else {
			
			System.out.println("****Login shouldn't be Successfull with Invalid Pass****");
		}
	}
	
	
	@Test(enabled = false)
	public void verifyLoginwithInvalidCredentials() throws Throwable {
		
		LoginPage ine= new LoginPage(driver);
		ine.loginUnsuccessfulwithInvalidCredentials();
		WebDriverUtility.waitUntilPageLoad(driver);
		String passerrmsg=ine.getPassError().getText();
		String path=IConstants.EXCEL_PATH;
		Excelutility xlutil= new Excelutility(path);
		String errmessage1=xlutil.getCellData("Error_Messages", 0, 0);
        if(passerrmsg.contains(errmessage1)) {
			
			System.out.println("****Invalid Email and Password! Login Unsuccessfull****");
			
		}else {
			
			System.out.println("****Login shouldn't be Successfull with Invalid Email and Password****");
		}
	}
	
	
	@Test(enabled = false)
	public void verifyLoginwithBlankCredentials() throws Throwable {
		
		LoginPage ine= new LoginPage(driver);
		ine.loginUnsuccessfulwithBlankCredentials();
		WebDriverUtility.waitUntilPageLoad(driver);
		String passerrmsg=ine.blankEmailError().getText();
		String passerrmsg1=ine.blankPassError().getText();
		String path=IConstants.EXCEL_PATH;
		Excelutility xlutil= new Excelutility(path);
		String errmessage1=xlutil.getCellData("Error_Messages", 1, 0);
		String errmessage2=xlutil.getCellData("Error_Messages", 2, 0);
        if(passerrmsg.contains(errmessage1) && passerrmsg1.contains(errmessage2) ) {
			
			System.out.println("****Blank Email Field and Blank Password Field! Login Unsuccessfull****");
			
		}else {
			
			System.out.println("****Login shouldn't be Successfull with Blank Email Field and Blank Password Field****");
		}
	}
}
