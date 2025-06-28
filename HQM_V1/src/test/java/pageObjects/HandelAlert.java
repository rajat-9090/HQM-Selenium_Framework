package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HandelAlert extends BasePage{
	
	
   public HandelAlert(WebDriver driver){
		
		super(driver);
		
	}
   
   @FindBy(xpath = "//span[@class='error text-danger']")
   WebElement errorAlert;
   
   public boolean istheAlertAppears() {
	   
	   try {
	   
	   return (errorAlert.isDisplayed());   //If the Element isn't Displayed then it will throw the Exception that's why the try Catch Block
	   
	   }catch (Exception e) {
		
		 return false;  
	}
		   
		   
	   
   }

}
