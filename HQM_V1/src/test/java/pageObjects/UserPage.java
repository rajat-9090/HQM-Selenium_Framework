package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.WebDriverUtility;

public class UserPage extends BasePage{
	
//	public WebElement element;
	

	public UserPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	
	@FindBy(xpath="//p[normalize-space()='Administration']")
	private WebElement administrationSection;
	
	@FindBy(xpath="//p[normalize-space()='Users']")
	private WebElement userSection;
	
	@FindBy(xpath ="//span[text()=' Email only characters']")
	private WebElement emailError;
	
	@FindBy(xpath ="(//span[normalize-space()='Last Name only characters'])[3]")
	private WebElement lastNameError;
	
	@FindBy(xpath ="(//span[normalize-space()='First Name only characters'])[3]")
	private WebElement firstNameError;
	
	//Elements for validate columns
	@FindBy(xpath="//tbody/tr//td[1]")
	private List<WebElement> firstColumn;
	
	@FindBy(xpath="//tbody/tr//td[2]")
	private List<WebElement> secondColumn;
	
	@FindBy(xpath="//tbody/tr//td[3]")
	private List<WebElement> thirdColumn;
	
	@FindBy(xpath="//tbody/tr//td[4]")
	private List<WebElement> fourthColumn;
	////////////////////////////////
	
	
	@FindBy(xpath="//select[starts-with(@name, 'DataTables_Table')]")
	private WebElement showDropdown;
	
	@FindBy(xpath="//input[@placeholder='First Name']")
	private WebElement firstNameSection;
	
	@FindBy(xpath="//input[@placeholder='Last Name']")
	private WebElement lastNameSection;
	
	@FindBy(xpath="//input[@placeholder='Email ']")
	private WebElement emailSection;
	
	@FindBy(css="select[formcontrolname='Role']")
	private WebElement roleDropdown;
	
	@FindBy(xpath="//button[normalize-space()='Add..']")
	private WebElement btnAdd;
	
	@FindBy(xpath="//button[normalize-space()='Cancel']")
	private WebElement btnCancel;
	
	@FindBy(xpath="//button[normalize-space()='Update']")
	private WebElement btnUpdate;
	
	@FindBy(xpath="(//button[normalize-space()='Edit'])[20]")
	private WebElement btnEdit;
	
	//Validate Propose
	@FindBy(xpath="//label[normalize-space()='First Name']")
	private WebElement firstName;
	
	@FindBy(xpath="//label[normalize-space()='Last Name']")
	private WebElement lastName;
	
	@FindBy(xpath="//label[normalize-space()='Email']")
	private WebElement email;
	
	@FindBy(xpath="//label[normalize-space()='Role']")
	private WebElement role;
	
	
	//Validate Fields
    public boolean isFirstNameVisiable() {
		
    	try {
		return firstName.isDisplayed();
    	}catch(Exception e) {
    		
    		return false;
    	}
	}
    
    public boolean isLastNameVisiable() {
		
    	try {
		return lastName.isDisplayed();
        }catch(Exception e) {
    		
    		return false;
    	}
	}
    
    public boolean isEmailVisiable() {
		
    	try {
    		return email.isDisplayed();
            }catch(Exception e) {
        		
        		return false;
        	}
	}
    
    public boolean isRoleVisiable() {
		
    	try {
    		return role.isDisplayed();
            }catch(Exception e) {
        		
        		return false;
        	}
	}
    
    public boolean isemailErrorVisiable() {
		
    	try {
    		return emailError.isDisplayed();
            }catch(Exception e) {
        		
        		return false;
        	}
	}
    
    public boolean isfirstNameErrorVisiable() {
		
    	try {
    		return firstNameError.isDisplayed();
            }catch(Exception e) {
        		
        		return false;
        	}
	}
    
    public boolean islastNameErrorVisiable() {
		
    	try {
    		return lastNameError.isDisplayed();
            }catch(Exception e) {
        		
        		return false;
        	}
	}
	////////////////////
    
	public WebElement clickAdministration() {
		
		return administrationSection;
	}
	
    public WebElement clickUser() {
		
		return userSection;
	}
    
    public WebElement clickshowDropDown() {
		
		return showDropdown;
	}
    
    public WebElement enterFirstName() {
		
		return firstNameSection;
	}
    
    public WebElement enterLastName() {
		
		return lastNameSection;
	}
    
    public WebElement enterEmail() {
		
		return emailSection;
	}
    
    public WebElement clickRoleDropDown() {
		
		return roleDropdown;
	}
    
    public WebElement clickAdd() {
		
		return btnAdd;
	}
    
    public WebElement clickCancel() {
		
		return btnCancel;
	}
    
    public WebElement clickUpdate() {
		
		return btnUpdate;
	}
    
    public WebElement clickEdit() {
		
		return btnEdit;
	}
	
	//Methods for Operate
	public void addUser() {
		
		btnAdd.sendKeys(Keys.ENTER);
	}
	
    public void cancelUser() {
		
    	btnCancel.sendKeys(Keys.ENTER);
	}
    
    public void accessUserSection() {
    	
    	administrationSection.click();
    	if(userSection.isDisplayed()) {
    		
    		userSection.click();
    	}
    	
    	
    }
	
	
	public void addingUserDetails(String fname, String lname, String eId) {
		
		firstNameSection.sendKeys(fname);
		lastNameSection.sendKeys(lname);
		emailSection.sendKeys(eId);
		WebDriverUtility.selectByVisibleText(roleDropdown, "View_Role");
		
	}
	
		
	//Meathods for validate column//
	public List<WebElement> firstColumnList() {
		
		return firstColumn;
	}
	
    public List<WebElement> secondColumnList() {
		
		return secondColumn;
	}
    
    public List<WebElement> thirdColumnList() {
		
		return thirdColumn;
	}
    
    public List<WebElement> fourthColumnList() {
		
		return fourthColumn;
	}
    ////////////////////////////////
	
	
	public void clickShowDropDown() {
		
		WebDriverUtility.mouseOverToElement(driver, showDropdown);
		System.out.println("DropDown Clicked");
		
	}

}
