package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtility {

	public static void pageresolution(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='80%'");
	}

	public static void scrolltotheElement(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void generateAlert(WebDriver driver, String message) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");

		try {

			Thread.sleep(3000);

		} catch (Exception e) {

			e.printStackTrace();
		}
		driver.switchTo().alert().accept();
	}

	public static void clickElementByJS(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static String getTitleByJS(WebDriver driver) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	public static void drawBorder(WebDriver driver, WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	
	public static void changeColoroftheElement(String color, WebElement element, WebDriver driver) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor='" + color + "'", element);
		
		try {

			Thread.sleep(3000);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
	
//	public static void flashtheElement(WebDriver driver, WebElement element) {
//		
//		String bgcolor=element.getCssValue("backgroundColor");
//		
//		for(int i=0; i < 200; i++) {
//			
//			changeColoroftheElement("#008000", element, driver);
//			changeColoroftheElement(bgcolor, element, driver);
//		}
//	}

}
