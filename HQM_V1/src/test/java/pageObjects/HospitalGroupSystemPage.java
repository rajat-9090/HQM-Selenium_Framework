package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import utilities.Fileutility;
import utilities.JavaScriptUtility;
import utilities.Javautility;
import utilities.WebDriverUtility;

public class HospitalGroupSystemPage extends BasePage {

	public HospitalGroupSystemPage(WebDriver driver) {

		super(driver);

	}

	@FindBy(xpath = "//p[normalize-space()='Supersets']")
	private WebElement Superset;

	@FindBy(xpath = "//p[normalize-space()='Hospital Group System']")
	private WebElement HospitalGroupSystem;

	@FindBy(xpath = "//a[normalize-space()='Add Group System']")
	private WebElement addGroupSystemPage;

	@FindBy(xpath = "//label[normalize-space()='Group System ID']")
	private WebElement GroupSystemID;

	@FindBy(xpath = "//label[normalize-space()='Group System']")
	private WebElement GroupSystem;

	@FindBy(css = ".btn.btn-primary.add_btn")
	private WebElement btnAdd;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement btnCancel;

	@FindBy(xpath = "(//button[normalize-space()='Edit'])[10]")
	private WebElement btnEdit;

	@FindBy(xpath = "//tbody/tr[10]/td[1]")
	private WebElement editRowData1;

	@FindBy(xpath = "//tbody/tr[10]/td[2]")
	private WebElement editRowData2;
	
	@FindBy(xpath = "//tbody/tr[10]")
	private WebElement TenthRow;

	@FindBy(xpath = "//button[normalize-space()='Update']")
	private WebElement btnUpdate;

	@FindBy(xpath = "//select[@name='DataTables_Table_1_length']")
	private WebElement paginationDropDown;

	//////////////// Table Elements/////////////////

	@FindBy(xpath = "//tbody/tr/td[1]")
	private List<WebElement> groupSystemIDColumn;

	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement> groupSystemColumn;

	/////////////////////////////////////////////////

	@FindBy(xpath = "//input[@placeholder='Group System ID']")
	private WebElement GroupSystemIDSection;

	@FindBy(xpath = "//input[@placeholder='Group System']")
	private WebElement GroupSystemSection;

	@FindBy(xpath = "//span[normalize-space()='Group System Name only Characters'][@class='error text-danger']")
	private WebElement InvalidGroupSystemError;

	@FindBy(xpath = "//span[contains(text(), 'Group System ID is Required')]")
	private WebElement BlankGroupSystemIDError;

	@FindBy(xpath = "//span[contains(text(), 'Group System Name is Required')]")
	private WebElement BlankGroupSystemError;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement SuccessMessage;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement UpdateMessage;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement MutualAlertMessage;

	@FindBy(xpath = "//label[@for='52']")
	private WebElement btnActiveandInactive;
	
	/////////////Pagination////////////////
	@FindBy(id = "DataTables_Table_0_first")
	private WebElement btnFirst;
	
	@FindBy(id = "DataTables_Table_0_previous")
	private WebElement btnPrevious;
	
	@FindBy(id = "DataTables_Table_0_next")
	private WebElement btnNext;
	
	@FindBy(id = "DataTables_Table_0_last")
	private WebElement btnLast;
	
	@FindBy(xpath = "//a[@class='paginate_button current']")
	private WebElement btn1Page;
	
	@FindBy(xpath = "//a[@class='paginate_button ']")
	private WebElement btn2Page;
	
	//////////////////////////////////////////////////////////////////////

	public WebElement getSuccessMessage() {

		return SuccessMessage;
	}
	
	public WebElement getTenthRowData() {

		return TenthRow;
	}

	public WebElement getAlertMessage() {

		return MutualAlertMessage;
	}

	public WebElement getEditRowData1() {

		return editRowData1;
	}

	public WebElement getEditRowData2() {

		return editRowData2;
	}

	public WebElement getUpdateMessage() {

		return UpdateMessage;
	}

	public WebElement blankGroupSystemIDError() {

		return BlankGroupSystemIDError;
	}

	public WebElement blankGroupSystemError() {

		return BlankGroupSystemError;
	}

	public WebElement clickSupersets() {

		return Superset;
	}

	public WebElement clickHospitalGroupSystem() {

		return HospitalGroupSystem;
	}
	
	public boolean isFirstButtonFromPaginationEnabled() {

		try {

			return btnFirst.isEnabled();
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isPreviousButtonFromPaginationEnabled() {

		try {

			return btnPrevious.isEnabled();
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isNextButtonFromPaginationEnabled() {

		try {

			return btnNext.isEnabled();
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean isLastButtonFromPaginationEnabled() {

		try {

			return btnLast.isEnabled();
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean is1stPageButtonFromPaginationEnabled() {

		try {

			return btn1Page.isEnabled();
		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean is2stPageButtonFromPaginationEnabled() {

		try {

			return btn2Page.isEnabled();
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isAddGroupSystemPageVisiable() {

		try {

			return addGroupSystemPage.isDisplayed();
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isGroupSystemIDVisiable() {

		try {
			return GroupSystemID.isDisplayed();
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isGroupSystemVisiable() {

		try {
			return GroupSystem.isDisplayed();
		} catch (Exception e) {

			return false;
		}
	}

	public WebElement clickAdd() {

		return btnAdd;
	}

	public WebElement clickCancel() {

		return btnCancel;
	}

	public WebElement clickEdit() {

		return btnEdit;
	}

	public WebElement clickUpdate() {

		return btnUpdate;
	}

	public WebElement clickPaginationDropDown() {

		return paginationDropDown;
	}

	// Meathods for validate column//
	public List<WebElement> groupSystemIDColumn() {

		return groupSystemIDColumn;
	}

	public List<WebElement> groupSystemColumn() {

		return groupSystemColumn;
	}
	/////////////////////////////

	public WebElement enterGroupSystemID() {

		return GroupSystemIDSection;
	}

	public WebElement enterGroupSystem() {

		return GroupSystemSection;
	}

	public boolean isGroupSystemErrorVisiable() {

		try {
			return InvalidGroupSystemError.isDisplayed();
		} catch (Exception e) {

			return false;
		}
	}

	public boolean isGroupSystemBlankErrorVisiable() {

		boolean isBlankGroupSystemIDVisible = false;
		boolean isBlankGroupSystemVisible = false;

		try {

			isBlankGroupSystemIDVisible = BlankGroupSystemIDError.isDisplayed();

		} catch (Exception e) {

		}

		try {

			isBlankGroupSystemVisible = BlankGroupSystemError.isDisplayed();

		} catch (Exception e1) {

		}

		return isBlankGroupSystemIDVisible || isBlankGroupSystemVisible;
	}

	public void accessHospitalGroupSystem() {

		Superset.click();

		if (HospitalGroupSystem.isDisplayed()) {

			HospitalGroupSystem.click();

		}
	}

	public void isAddbtnClickable() {
        
		
		if (btnAdd.isDisplayed()) {
			
			btnAdd.click();
			System.out.println("Add Button Clicked In Group Hospital Page");
		}else {
			
			Assert.fail("This Element isn't Visiable");
		}
	}

	public void addingNewGroupSystem(String grsyID, String grsy) {

		GroupSystemIDSection.sendKeys(grsyID);
		GroupSystemSection.sendKeys(grsy);
	}

	public void addGroupSystemwithBlankEnties() throws Throwable {

		String blankgrID = Fileutility.getKeyValuefromProperty("blankentry1");
		String blankgrName = Fileutility.getKeyValuefromProperty("blankentry2");
		GroupSystemIDSection.sendKeys(blankgrID);
		GroupSystemSection.sendKeys(blankgrName);
		isAddbtnClickable();
	}


	public void editGroupSystem() throws Exception {

		JavaScriptUtility.scrolltotheElement(driver, btnEdit);
		JavaScriptUtility.drawBorder(driver, editRowData1);
		JavaScriptUtility.drawBorder(driver, editRowData2);
//		new BaseClass().captureScreen("Before Edit");
		String beforevalue=perticularRowValuesBeforeEdit();
		System.out.println("Group System ID and Group System Name Before Edit: "+ beforevalue);
		JavaScriptUtility.clickElementByJS(driver, btnEdit);
		GroupSystemIDSection.clear();
		GroupSystemSection.clear();
		WebDriverUtility.waitUntilPageLoad(driver);
		GroupSystemIDSection.sendKeys(Integer.toString(Javautility.getRandomNum()));
		GroupSystemSection.sendKeys(Javautility.generateRandomString());
		JavaScriptUtility.clickElementByJS(driver, btnUpdate);
		Thread.sleep(2000);
		String aftervalue=perticularRowValuesAfterEdit();
		System.out.println("Group System ID and Group System Name After Edit: "+ aftervalue);
        if(!beforevalue.equals(aftervalue)) {
			
			System.out.println("Edit Process Complete Smoothly");
		}else {
			
			Assert.fail("Failed! Please Check the Edit Process Again");
		}

	}
	
	public void accessActiveandInActiveSection() {
		
		JavaScriptUtility.scrolltotheElement(driver, btnActiveandInactive);
		JavaScriptUtility.clickElementByJS(driver, btnActiveandInactive);
	}
	
	public String perticularRowValuesBeforeEdit() {
		
		String gsivaule=editRowData1.getText();
		String gsvalue=editRowData2.getText();
		String beforeedit=gsivaule+gsvalue;
		return beforeedit;
	}
	
    public String perticularRowValuesAfterEdit() {
		
    	String gsivaule=editRowData1.getText();
		String gsvalue=editRowData2.getText();
		String afteredit=gsivaule+gsvalue;
		return afteredit;
	}
	
	
	public void cancelEditFunctionality() throws Exception {
		
		JavaScriptUtility.scrolltotheElement(driver, btnEdit);
		String beforevalue=perticularRowValuesBeforeEdit();
		System.out.println("Group System ID and Group System Name Before Edit: "+ beforevalue);
		JavaScriptUtility.clickElementByJS(driver, btnEdit);
		JavaScriptUtility.clickElementByJS(driver, btnCancel);
		Thread.sleep(2000);
		String aftervalue=perticularRowValuesAfterEdit();
		System.out.println("Group System ID and Group System Name After Edit: "+ aftervalue);
        if(beforevalue.equals(aftervalue)) {
			
			System.out.println("Canceling the Edit Process! Checked Successfully");
		}else {
			
			Assert.fail("Failed! Please Check the Cancel Process Again");
		}

	}
	
	
	public void withoutEditAccessUpdate() throws InterruptedException {
		
		JavaScriptUtility.scrolltotheElement(driver, btnEdit);
		JavaScriptUtility.drawBorder(driver, editRowData1);
		JavaScriptUtility.drawBorder(driver, editRowData2);
		String beforevalue=perticularRowValuesBeforeEdit();
		System.out.println("Group System ID and Group System Name Before Edit: "+ beforevalue);
		JavaScriptUtility.clickElementByJS(driver, btnEdit);
		JavaScriptUtility.clickElementByJS(driver, btnUpdate);
		Thread.sleep(2000);
		String aftervalue=perticularRowValuesAfterEdit();
		System.out.println("Group System ID and Group System Name After Edit: "+ aftervalue);
        if(beforevalue.equals(aftervalue)) {
			
			System.out.println("Update Process without Modifing the Data Complete Smoothly");
		}else {
			
			Assert.fail("Failed! Please Check the Update Prosess Again");
		}
	}
	
	public List<Boolean> Pagination() {
		
		List<Boolean> paginationElements= new ArrayList<Boolean>();
		
		paginationElements.add(isFirstButtonFromPaginationEnabled());
		paginationElements.add(isPreviousButtonFromPaginationEnabled());
		paginationElements.add(isNextButtonFromPaginationEnabled());
		paginationElements.add(isLastButtonFromPaginationEnabled());
		paginationElements.add(is1stPageButtonFromPaginationEnabled());
		paginationElements.add(is2stPageButtonFromPaginationEnabled());
		return paginationElements;
	}

}
