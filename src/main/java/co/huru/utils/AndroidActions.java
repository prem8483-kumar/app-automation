package co.huru.utils;

import co.huru.configs.EnvConfig;
import co.huru.pageObjects.SignInPage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class AndroidActions extends AppiumUtils {

	private static final Logger log = LogManager.getLogger(SignInPage.class);
	protected AndroidDriver driver;
	protected Wait<AndroidDriver> wait;
	
	public AndroidActions(AndroidDriver driver)
	{
		this.driver = driver;
		this.wait = new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(Long.parseLong(EnvConfig.getProperty("timeOutInSeconds"))))
				.pollingEvery(Duration.ofSeconds(Long.parseLong(EnvConfig.getProperty("pollingTimeInSeconds"))))
				.ignoring(ElementNotInteractableException.class);
	}
	
	public WebElement waitForElementToBeVisible(By locator)
	{
		log.info("Waiting for element to be visible with locator: " +  locator);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public boolean waitForElementToBeNotVisible(By locator)
	{
		log.info("Waiting for element to be not visible with locator: " +  locator);
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}


	public boolean elementDisplayed(By locator)
	{
		log.info("Check if element is displayed with locator: " +  locator);
		return driver.findElement(locator).isDisplayed();
	}

	public void moveToElement(WebElement element)
	{

		log.info("Moving to element: " +  element);
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}

	public void sendNumericKeysUsingKeyboard(String keys)
	{
		char[] keysArray = keys.toCharArray();
		for(int i=0; i<keysArray.length; i++) {
			switch (keysArray[i]) {
				case '0': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_0)); break;
				case '1': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_1)); break;
				case '2': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_2)); break;
				case '3': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_3)); break;
				case '4': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_4)); break;
				case '5': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_5)); break;
				case '6': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_6)); break;
				case '7': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_7)); break;
				case '8': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_8)); break;
				case '9': driver.pressKey(new KeyEvent(AndroidKey.DIGIT_9)); break;
				default: log.info("Wrong Key");
			}
		}
	}

}
