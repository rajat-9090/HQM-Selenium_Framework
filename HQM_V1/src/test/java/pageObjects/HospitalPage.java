package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import testbase.BaseClass;
import utilities.Excelutility;
import utilities.Fileutility;
import utilities.IConstants;
import utilities.JavaScriptUtility;
import utilities.Javautility;
import utilities.WebDriverUtility;

public class HospitalPage extends BasePage {

	public HospitalPage(WebDriver driver) {

		super(driver);

	}

	/////////////// All The Elements/////////////////
	@FindBy(xpath = "//p[normalize-space()='Supersets']")
	private WebElement Superset;

	@FindBy(xpath = "//p[normalize-space()='Hospital']")
	private WebElement Hospital;

	@FindBy(xpath = "//a[normalize-space()='Add Hospital']")
	private WebElement addHospitalPage;

	@FindBy(xpath = "//label[normalize-space()='Group System']")
	private WebElement GroupSystem;

	@FindBy(xpath = "//label[normalize-space()='Hospital ID']")
	private WebElement HospitalID;

	@FindBy(xpath = "//label[normalize-space()='Hospital Name']")
	private WebElement HospitalName;

	@FindBy(xpath = "//select[contains(@class, 'form-control ng-untouched')]")
	private WebElement GroupSystemDropDown;

	@FindBy(xpath = "//input[@placeholder='Hospital ID']")
	private WebElement HospitalIDSection;

	@FindBy(xpath = "//input[@placeholder='Hospital Name']")
	private WebElement HospitalNameSection;

	@FindBy(xpath = "//button[normalize-space()='Add..']")
	private WebElement btnAdd;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement btnCancel;

	@FindBy(xpath = "//button[normalize-space()='Update']")
	private WebElement btnUpdate;

	@FindBy(xpath = "//button[contains(@class,'btn btn-primary')]//span//i[@class='fa fa-plus']")
	private WebElement btnPlus;

	@FindBy(name = "DataTables_Table_0_length")
	private WebElement paginationDropDown;

	@FindBy(id = "DataTables_Table_0_first")
	private WebElement paginationbtnFirst;

	@FindBy(id = "DataTables_Table_0_previous")
	private WebElement paginationbtnPrevious;

	@FindBy(id = "DataTables_Table_0_next")
	private WebElement paginationbtnNext;

	@FindBy(id = "DataTables_Table_0_last")
	private WebElement paginationbtnLast;
	
	@FindBy(xpath = "//a[normalize-space()='1']")
	private WebElement paginationbtn1;
	
	@FindBy(xpath = "//a[normalize-space()='2']")
	private WebElement paginationbtn2;

	@FindBy(xpath = "(//button[normalize-space()='Edit'])[10]")
	private WebElement btnEdit;

	@FindBy(xpath = "//label[@for='38']")
	private WebElement btnActive;

	@FindBy(xpath = "//div[@role='alert']")
	private WebElement AlertMessage;

	@FindBy(xpath = "//tbody/tr[10]/td[1]")
	private WebElement editData1;

	@FindBy(xpath = "//tbody/tr[10]/td[2]")
	private WebElement editData2;

	@FindBy(xpath = "//tbody/tr[10]/td[3]")
	private WebElement editData3;

	/////////////////// Error Elements////////////////
	@FindBy(xpath = "//span[normalize-space()='Hospital Name only characters'][@class='error text-danger']")
	private WebElement HospitalNameError;

	@FindBy(xpath = "//span[normalize-space()='Hospital ID only numbers'][@class='error text-danger']")
	private WebElement HospitalIDError;

	@FindBy(xpath = "//span[contains(text(), 'Group System is required')]")
	private WebElement blankGroupSystemError;

	@FindBy(xpath = "//span[contains(text(), 'Hospital ID is required')]")
	private WebElement blankHospitalIDError;

	@FindBy(xpath = "//span[contains(text(), 'Hospital Name is required')]")
	private WebElement blankHospitalNameError;

	//////////////// Table Column Element//////////////////
	@FindBy(xpath = "//tbody/tr/td[1]")
	private List<WebElement> HospitalIDColumn;

	@FindBy(xpath = "//tbody/tr/td[2]")
	private List<WebElement> HospitalNameColumn;

	@FindBy(xpath = "//tbody/tr/td[3]")
	private List<WebElement> GroupSystemNameColumn;

	//////////// All the Method to Call the Elemnets//////////

	public WebElement clickSupersets() {

		return Superset;
	}

	public WebElement clickHospital() {

		return Hospital;
	}

	///////////////////////////////////////////
	public boolean isAddHospitalPageVisible() {

		try {

			return addHospitalPage.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

//	
//    public boolean isGroupSystemVisible() {
//		
//		try {
//			
//			return GroupSystem.isDisplayed();
//		
//		}catch(Exception e) {
//			
//			return false;
//		}
//	}
//    
//    public boolean isHospitalIDVisible() {
//		
//		try {
//			
//			return HospitalID.isDisplayed();
//		
//		}catch(Exception e) {
//			
//			return false;
//		}
//	}
//    
//    public boolean isHospitalNameVisible() {
//		
//		try {
//			
//			return HospitalName.isDisplayed();
//		
//		}catch(Exception e) {
//			
//			return false;
//		}
//	}
	///////////////////////////////////////////
	public boolean isAllValidationElementsVisible() {

		boolean isAddHospitalPageVisible = false;
		boolean isGroupSystemVisible = false;
		boolean isHospitalIDVisible = false;
		boolean isHospitalNameVisible = false;

		try {

			isAddHospitalPageVisible = addHospitalPage.isDisplayed();
			System.out.println(addHospitalPage.getText());

		} catch (Exception e) {

		}

		try {

			isGroupSystemVisible = GroupSystem.isDisplayed();
			System.out.println(GroupSystem.getText());

		} catch (Exception e) {

		}

		try {

			isHospitalIDVisible = HospitalID.isDisplayed();
			System.out.println(HospitalID.getText());

		} catch (Exception e) {

		}

		try {

			isHospitalNameVisible = HospitalName.isDisplayed();
			System.out.println(HospitalName.getText());

		} catch (Exception e) {

		}

		return isAddHospitalPageVisible || isGroupSystemVisible || isHospitalIDVisible || isHospitalNameVisible;

	}

	public WebElement GroupSystemSection() {

		return GroupSystemDropDown;
	}

	public WebElement HospitalIDSection() {

		return HospitalIDSection;
	}

	public WebElement HospitalNameSection() {

		return HospitalNameSection;
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

	public WebElement clickPlusButton() {

		return btnPlus;
	}

	public WebElement clickShowDropDown() {

		return paginationDropDown;
	}

	public boolean isFirstPaginationVisible() {

		try {

			return paginationbtnFirst.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public boolean isPreviousPaginationVisible() {

		try {

			return paginationbtnPrevious.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public boolean isNextPaginationVisible() {

		try {

			return paginationbtnNext.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public boolean isLastPaginationVisible() {

		try {

			return paginationbtnLast.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean is1stPaginationVisible() {

		try {

			return paginationbtn1.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}
	
	public boolean is2stPaginationVisible() {

		try {

			return paginationbtn2.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public WebElement clickEdit() {

		return btnEdit;
	}

	public WebElement clickActiveAndInActive() {

		return btnActive;
	}

	public WebElement getAlertMessage() {

		return AlertMessage;
	}

	public WebElement getRowData1() {

		return editData1;
	}

	public WebElement getRowData2() {

		return editData2;
	}

	public WebElement getRowData3() {

		return editData3;
	}

	//////////// Table Column Validation////////
	public List<WebElement> groupSystemNameColumn() {

		return GroupSystemNameColumn;
	}

	public List<WebElement> hospitalIDColumn() {

		return HospitalIDColumn;
	}

	public List<WebElement> hospitalNameColumn() {

		return HospitalNameColumn;
	}

	/////////////// Error Validation////////////////
	public boolean isHospitalNameErrorVisible() {

		try {

			return HospitalNameError.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public boolean isHospitalIDErrorVisible() {

		try {

			return HospitalIDError.isDisplayed();

		} catch (Exception e) {

			return false;
		}
	}

	public boolean isHospitalPageBlankErrorsVisiable() {

		boolean isBlankGroupSystemErrorVisible = false;
		boolean isBlankHospitalIDErrorVisible = false;
		boolean isBlankHospitalNameErrorVisible = false;

		try {

			isBlankGroupSystemErrorVisible = blankGroupSystemError.isDisplayed();

		} catch (Exception e) {

		}

		try {

			isBlankHospitalIDErrorVisible = blankHospitalIDError.isDisplayed();

		} catch (Exception e) {

		}

		try {

			isBlankHospitalNameErrorVisible = blankHospitalNameError.isDisplayed();

		} catch (Exception e) {

		}

		return isBlankGroupSystemErrorVisible || isBlankHospitalIDErrorVisible || isBlankHospitalNameErrorVisible;
	}

	public void accessHospital() {

		Superset.click();
		WebDriverUtility.waitUntilElementLoad(driver, Hospital);
		if (Hospital.isDisplayed()) {

			JavaScriptUtility.clickElementByJS(driver, Hospital);
		} else {

			Assert.fail("This Hospital Element isn't Displayed");
		}
	}

	public void AddNewHospital(String hID, String hName) {

    	WebDriverUtility.selectByVisibleText(GroupSystemDropDown, "Test Hospital");
		HospitalIDSection.sendKeys(hID);
		HospitalNameSection.sendKeys(hName);
		WebDriverUtility.waitUntilElementLoad(driver, btnAdd);
		btnAdd.click();
	}

	public void addingNewHospitalthroughPlusButton() throws Exception {

		WebDriverUtility.waitAndClick(btnPlus);
		HospitalGroupSystemPage hgsp = new HospitalGroupSystemPage(driver);
		boolean agspv = hgsp.isAddGroupSystemPageVisiable();
		if (agspv == true) {

			System.out.println("Add Group System Page is Accessible through Hospital Page");

		} else {

			Assert.fail("Error! We should Enter Group System Page");
		}
		hgsp.addingNewGroupSystem("R001S", "Test Group");
		WebDriverUtility.waitUntilElementLoad(driver, hgsp.clickAdd());
		hgsp.isAddbtnClickable();
		Thread.sleep(3000);
		System.out.println("New Group System Added Via Hospital Page");
		WebDriverUtility.waitUntilElementLoad(driver, hgsp.getSuccessMessage());
		String suMessage = hgsp.getSuccessMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String xlsumessage = xlutil.getCellData("Error_Messages", 0, 1);
		System.out.println(suMessage);
		System.out.println(xlsumessage);

		if (suMessage.equals(xlsumessage)) {

			System.out.println("New Group System Added Successfully through Hospital Page");

		} else {

			Assert.fail("Error! Adding Group System through Hospital Page Failed");
		}
		// We should Add New Hospital using newly added Group System through Plus Button
		WebDriverUtility.waitAndClick(clickHospital());
		WebDriverUtility.selectByVisibleText(GroupSystemDropDown, "Test Group");
		HospitalIDSection.sendKeys(Integer.toString(Javautility.getRandomNum()));
		HospitalNameSection.sendKeys(Javautility.generateRandomString());
		WebDriverUtility.waitUntilElementLoad(driver, btnAdd);
		btnAdd.click();

	}

	public void VerifyBlankScenarios() throws Throwable {

		AddNewHospital(Fileutility.getKeyValuefromProperty("blankentry1"),
				Fileutility.getKeyValuefromProperty("blankentry2"));

	}

	public void ActiveAndInActiveScenario() {

		JavaScriptUtility.scrolltotheElement(driver, btnActive);
		JavaScriptUtility.clickElementByJS(driver, btnActive);
	}

	public String perticularRowValuesBeforeEdit() {

		String hivalue = editData1.getText();
		String hnvalue = editData2.getText();
		String gsnvalue = editData3.getText();
		String beforeedit = (hivalue + "&" + hnvalue + "&" + gsnvalue);
		return beforeedit;
	}

	public String perticularRowValuesAfterEdit() {

		String hivalue = editData1.getText();
		String hnvalue = editData2.getText();
		String gsnvalue = editData3.getText();
		String afteredit = (hivalue + "&" + hnvalue + "&" + gsnvalue);
		return afteredit;
	}

	public void editHospital() throws Exception {

		JavaScriptUtility.scrolltotheElement(driver, btnEdit);
		WebDriverUtility.waitUntilPageLoad(driver);
		JavaScriptUtility.drawBorder(driver, editData1);
		JavaScriptUtility.drawBorder(driver, editData2);
		JavaScriptUtility.drawBorder(driver, editData3);
		new BaseClass().captureScreen("Marked Row Before Edit");
		String beforevalue = perticularRowValuesBeforeEdit();
		System.out.println("Selected Hospital Before Edit: " + beforevalue);
		JavaScriptUtility.clickElementByJS(driver, btnEdit);
		Thread.sleep(2000);
//		GroupSystemDropDown.clear();
		HospitalIDSection.clear();
		HospitalNameSection.clear();
		WebDriverUtility.selectByVisibleText(GroupSystemDropDown, "dmAI");
		HospitalIDSection.sendKeys(Integer.toString(Javautility.getRandomNum()));
		HospitalNameSection.sendKeys(Javautility.generateRandomString());
		JavaScriptUtility.clickElementByJS(driver, btnUpdate);
		Thread.sleep(2000);
		String aftervalue = perticularRowValuesAfterEdit();
		System.out.println("Selected Hospital After Edit: " + aftervalue);
		if (!beforevalue.equals(aftervalue)) {

			System.out.println("Edit Process Complete Smoothly");
		} else {

			Assert.fail("Failed! Please Check the Edit Process Again");
		}

	}

	public void clickEditWithoutModification() throws Exception {

		JavaScriptUtility.scrolltotheElement(driver, btnEdit);
		WebDriverUtility.waitUntilPageLoad(driver);
		JavaScriptUtility.drawBorder(driver, editData1);
		JavaScriptUtility.drawBorder(driver, editData2);
		JavaScriptUtility.drawBorder(driver, editData3);
		String beforevalue = perticularRowValuesBeforeEdit();
		System.out.println("Selected Hospital Before Edit: " + beforevalue);
		JavaScriptUtility.clickElementByJS(driver, btnEdit);
		JavaScriptUtility.clickElementByJS(driver, btnUpdate);
		Thread.sleep(2000);
		String aftervalue = perticularRowValuesAfterEdit();
		System.out.println("Selected Hospital After Edit: " + aftervalue);
		if (beforevalue.equals(aftervalue)) {

			System.out.println("Edit Process Complete Smoothly without Modifiaction");
		} else {

			Assert.fail("Failed! Please Check the Edit Process Again");
		}
	}

	public void clickcancelbtn() throws Exception {

		JavaScriptUtility.scrolltotheElement(driver, btnEdit);
		WebDriverUtility.waitUntilPageLoad(driver);
		JavaScriptUtility.drawBorder(driver, editData1);
		JavaScriptUtility.drawBorder(driver, editData2);
		JavaScriptUtility.drawBorder(driver, editData3);
		String beforevalue = perticularRowValuesBeforeEdit();
		System.out.println("Selected Hospital Before Edit: " + beforevalue);
		JavaScriptUtility.clickElementByJS(driver, btnEdit);
		if (btnCancel.isEnabled()) {

			JavaScriptUtility.clickElementByJS(driver, btnCancel);
			JavaScriptUtility.generateAlert(driver, "Cancel Button is Enabled and Clicked");
			new BaseClass().captureScreen("Alert Message Captured");
		}
		Thread.sleep(2000);
		String aftervalue = perticularRowValuesAfterEdit();
		System.out.println("Selected Hospital After Edit: " + aftervalue);
		if (beforevalue.equals(aftervalue)) {

			System.out.println("Test Passed: Cancel Process Complete Smoothly without Modifiaction");
		} else {

			Assert.fail("Test Failed! Please Check the Cancel Process Again");
		}

	}

	public List<Boolean> Pagination() {

		List<Boolean> paginationElements = new ArrayList<Boolean>();

		paginationElements.add(isFirstPaginationVisible());
		paginationElements.add(isPreviousPaginationVisible());
		paginationElements.add(isNextPaginationVisible());
		paginationElements.add(isLastPaginationVisible());
		paginationElements.add(is1stPaginationVisible());
		paginationElements.add(is1stPaginationVisible());
		return paginationElements;
	}
	
	public void GroupSystemInterlinkedWithHospital() throws Throwable {
		
		HospitalGroupSystemPage hgsp=new HospitalGroupSystemPage(driver);
		hgsp.addingNewGroupSystem(Fileutility.getKeyValuefromProperty("Group_System_ID"),
                                  Fileutility.getKeyValuefromProperty("Group_System"));
		hgsp.isAddbtnClickable();
		WebDriverUtility.waitUntilElementLoad(driver, hgsp.getSuccessMessage());
		String suMessage = hgsp.getSuccessMessage().getText();
		String path = IConstants.EXCEL_PATH;
		Excelutility xlutil = new Excelutility(path);
		String errmessage = xlutil.getCellData("Error_Messages", 0, 1);
		if (suMessage.equals(errmessage)) {

			System.out.println("New Group System Added Successfully");

		} else {

			System.out.println("Adding New Group System is Failed");
		}
		///////////////////Pending///////////////////////
		accessHospital();
		WebDriverUtility.selectByVisibleText(GroupSystemDropDown, Fileutility.getKeyValuefromProperty("Group_System"));
		HospitalIDSection.sendKeys(Integer.toString(Javautility.getRandomNum()));
		HospitalNameSection.sendKeys(Javautility.generateRandomString());
		WebDriverUtility.waitUntilElementLoad(driver, btnAdd);
		btnAdd.click();
		
	}

}
