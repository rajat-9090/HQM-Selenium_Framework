package utilities;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public static void waitUntilPageLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(IConstants.IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, IConstants.IMPLICITLY_WAIT_TIMEOUT);
//		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public static void waitUntilElementLoad(WebDriver driver, WebElement Element) {

		WebDriverWait wait = new WebDriverWait(driver, IConstants.EXPLICITLY_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.visibilityOf(Element));
	}

	public static void waitUntilUrlVisible(WebDriver driver, String partialUrl) {

		WebDriverWait wait = new WebDriverWait(driver, IConstants.EXPLICITLY_WAIT_TIMEOUT);
		wait.until(ExpectedConditions.urlContains(partialUrl));
	}

	public static void waitAndClick(WebElement element) throws InterruptedException {

		int count = 0;

		while (count < 20) {
			try {

				element.click();
				break;

			} catch (Throwable e) {

				Thread.sleep(1000);
				count++;
			}
		}

	}

	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public static void selectByVisibleText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}

	public static void mouseOverToElement(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();

	}

	public static void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).perform();
	}

	public static void leftClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.click(element).perform();
	}

	public static void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		java.util.Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if (title.contains(partialWinTitle)) {
				break;
			}

		}

	}
	
	

}
