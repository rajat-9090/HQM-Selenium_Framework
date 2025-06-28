package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import utilities.Fileutility;

public class LoginPage  extends BasePage{
	
//	WebDriver driver;
	
	public LoginPage(WebDriver driver){
		
		super(driver);
		
	}
	
@FindBy(id="email")
private WebElement txtEmail;

@FindBy(id="apassword")
private WebElement txtPassword;

@FindBy(how=How.XPATH, using="//button[@type='submit']")
private WebElement btnSubmit;

@FindBy(xpath="//div[contains(text(), ' Error! Invalid Credentials!. ')]")
private WebElement invalidEmailError;

@FindBy(xpath="//div[@role='alert']")
private WebElement invalidPassError;

@FindBy(xpath="//span[@class='error text-danger']")
private WebElement emailRequiedError;

@FindBy(xpath="//span[contains(text(),'Password is required!')]")
private WebElement passRequiedError;

//I have to check that these Elements are required or not//
@FindBy(xpath="//a[@id='userDropdown']")
WebElement clickUserDropdown;

@FindBy(css ="a[class='dropdown-item']")
WebElement clickLogout;

@FindBy(css ="div[class='card-header'] a")
WebElement calculatePayoutScreen;
///////////////////////////////////////////////////////////

//public WebDriver getDriver() {
//	
//	return driver;
//}

public WebElement getEmailID() {
	
	return txtEmail;
}

public WebElement getPassword() {
	
	return txtPassword;
}

public WebElement getEmailError() {
	
	return invalidEmailError;
}

public WebElement getPassError() {
	
	return invalidPassError;
}

public WebElement blankEmailError() {
	
	return emailRequiedError;
}

public WebElement blankPassError() {
	
	return passRequiedError;
}

public WebElement clickSubmitBtn() {
	
	return btnSubmit;
}


public void loginToApplicationDDT(String Email, String Pass ) throws Throwable {
	
	String url=Fileutility.getKeyValuefromProperty("url");
	driver.get(url);
	txtEmail.sendKeys(Email);
	txtPassword.sendKeys(Pass);
	btnSubmit.click();
}



public void loginToApplication() throws Throwable {
	
	String url=Fileutility.getKeyValuefromProperty("url");
	String email=Fileutility.getKeyValuefromProperty("validemail");
	String pass=Fileutility.getKeyValuefromProperty("validpass");
	driver.get(url);
//	WebDriverUtility.pageresolution(driver);
	txtEmail.sendKeys(email);
	txtPassword.sendKeys(pass);
	btnSubmit.click();
	System.out.println("****Login Successful****");
}

public void loginUnsuccessfulwithInvalidEmail() throws Throwable {
	
	String url=Fileutility.getKeyValuefromProperty("url");
	String email=Fileutility.getKeyValuefromProperty("invalidemail");
	String pass=Fileutility.getKeyValuefromProperty("validpass");
	driver.get(url);
	txtEmail.sendKeys(email);
	txtPassword.sendKeys(pass);
	btnSubmit.click();
}

public void loginUnsuccessfulwithInvalidPass() throws Throwable {
	
	String url=Fileutility.getKeyValuefromProperty("url");
	String email=Fileutility.getKeyValuefromProperty("validemail");
	String pass=Fileutility.getKeyValuefromProperty("invalidpass");
	driver.get(url);
	txtEmail.sendKeys(email);
	txtPassword.sendKeys(pass);
	btnSubmit.click();
}

public void loginUnsuccessfulwithInvalidCredentials() throws Throwable {
	
	String url=Fileutility.getKeyValuefromProperty("url");
	String email=Fileutility.getKeyValuefromProperty("invalidemail");
	String pass=Fileutility.getKeyValuefromProperty("invalidpass");
	driver.get(url);
	txtEmail.sendKeys(email);
	txtPassword.sendKeys(pass);
	btnSubmit.click();
}

public void loginUnsuccessfulwithBlankCredentials() throws Throwable {
	
	String url=Fileutility.getKeyValuefromProperty("url");
	String email=Fileutility.getKeyValuefromProperty("blankentry1");
	String pass=Fileutility.getKeyValuefromProperty("blankentry1");
	driver.get(url);
	txtEmail.sendKeys(email);
	txtPassword.sendKeys(pass);
	btnSubmit.click();
}

public void Logout() {
	
	clickUserDropdown.click();
	clickLogout.click();
}

public boolean isCalculatePayoutScreenExists() {
	
	try {
		
	return (calculatePayoutScreen.isDisplayed());
	
	}catch (Exception e) {
		
		return false;
	}
	
}


}
