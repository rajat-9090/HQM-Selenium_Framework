package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import pageObjects.UserPage;
import testbase.BaseClass;
import utilities.Excelutility;
import utilities.WebDriverUtility;

public class TC04_Verify_User_Section extends BaseClass {

	@Test(enabled = false)
	public void verifyUserPage() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Entering to UserPage Sceen
		UserPage user = new UserPage(driver);
		user.accessUserSection();

		boolean firstname = user.isFirstNameVisiable();
		boolean lastname = user.isLastNameVisiable();
		boolean email = user.isEmailVisiable();
		boolean role = user.isRoleVisiable();

		if (firstname == true && lastname == true && email == true && role == true) {

			System.out.println("FirstName, LastName, Email and Role section is present in the Add-User Page");

		} else {

			System.out.println("FirstName, LastName, Email and Role section isn't present in the Add-User Page");
		}

	}


	@Test(enabled = false)
	public void verifyUserTable() throws Throwable {

		// LogIN to the Application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication();
		WebDriverUtility.waitUntilPageLoad(driver);

		// Entering to UserPage Screen
		UserPage user = new UserPage(driver);
		user.accessUserSection();

		// Calling Action class to get the page drop-down and Handing Drop-Down
		WebElement show = user.clickshowDropDown();

		WebDriverUtility.waitUntilElementLoad(driver, show);
		WebDriverUtility.selectByValue(show, "100");
		Thread.sleep(2000);

		// Fetching all the table details
		List<WebElement> firstColumnrows = user.firstColumnList();
		System.out.println(firstColumnrows.size());

		List<WebElement> secondColumnrows = user.secondColumnList();
		System.out.println(secondColumnrows.size());

		List<WebElement> thirdColumnrows = user.thirdColumnList();
		System.out.println(thirdColumnrows.size());

		List<WebElement> fourthColumnrows = user.fourthColumnList();
		System.out.println(fourthColumnrows.size());

		// Adding Data to a Existing File
		String path = System.getProperty("user.dir") + ".//testData//All_UserData.xlsx";

		// Calling Excel Utility File
		Excelutility xlutil = new Excelutility(path);

		// For First Row

		int rowIndex1 = 1;

		for (WebElement firstcolumnrownames : firstColumnrows) {

			String firstrownames = firstcolumnrownames.getText();
			System.out.print(firstrownames + "\t");

			xlutil.setCellData("AllUserDetails", rowIndex1, "First Name", firstrownames);

			rowIndex1++;
			System.out.println(rowIndex1);

			System.out.println();

		}
		// For Second Row

		int rowIndex2 = 1;

		for (WebElement secondcolumnrownames : secondColumnrows) {

			String secondrownames = secondcolumnrownames.getText();
			System.out.print(secondrownames + "\t");

			xlutil.setCellData("AllUserDetails", rowIndex2, "Last Name", secondrownames);

			rowIndex2++;
			System.out.println(rowIndex2);

			System.out.println();

		}

		// For Third Row

		int rowIndex3 = 1;

		for (WebElement thirdcolumnrownames : thirdColumnrows) {

			String thirdrownames = thirdcolumnrownames.getText();
			System.out.print(thirdrownames + "\t");

			xlutil.setCellData("AllUserDetails", rowIndex3, "Email", thirdrownames);

			rowIndex3++;
			System.out.println(rowIndex3);

			System.out.println();

		}

		// For Forth Row

		int rowIndex4 = 1;

		for (WebElement fourthcolumnrownames : fourthColumnrows) {

			String fourthrownames = fourthcolumnrownames.getText();
			System.out.print(fourthrownames + "\t");

			xlutil.setCellData("AllUserDetails", rowIndex4, "Role", fourthrownames);

			rowIndex4++;
			System.out.println(rowIndex4);

			System.out.println();

		}

	}

}
