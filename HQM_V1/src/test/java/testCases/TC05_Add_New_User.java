package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.UserPage;
import testbase.BaseClass;
import utilities.Javautility;
import utilities.WebDriverUtility;

public class TC05_Add_New_User extends BaseClass {
	
	
	@Test
	public void addNewUser() throws Throwable {
		
		
		/// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Entering to UserPage Sceen
		UserPage user = new UserPage(driver);
		user.accessUserSection();
		
		//int randomNumer=jutil.getRandomNum();
		//Integer.toString(jutil.getRandomNum());

		// Adding the User Details
		user.addingUserDetails(Integer.toString(Javautility.getRandomNum()), Integer.toString(Javautility.getRandomNum()),
				Javautility.generateRandomString() + '@' + Javautility.generateRandomString() + ".com");

		user.addUser();
		Thread.sleep(3000);

		boolean emailError = user.isemailErrorVisiable();
		boolean firstNameError = user.isfirstNameErrorVisiable();
		boolean lastNameError = user.islastNameErrorVisiable();

		if (emailError == true || firstNameError == true || lastNameError == true) {
			
            Assert.fail("Adding User Details process Failed");
			
		} else {
			
			System.out.println("Adding User Details process Passed");
		}
	}

}
