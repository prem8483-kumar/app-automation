package co.huru.utils;

import co.huru.configs.EnvConfig;
import co.huru.pageObjects.signIn.SignInPage;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.appmanagement.ApplicationState;
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

import static org.testng.Assert.assertEquals;

public class AndroidActions {

	private static final Logger log = LogManager.getLogger(SignInPage.class);


	public Wait<AndroidDriver> getWait(AndroidDriver driver)
	{
		return new FluentWait<>(driver)
				.withTimeout(Duration.ofSeconds(Long.parseLong(EnvConfig.getProperty("timeOutInSeconds"))))
				.pollingEvery(Duration.ofSeconds(Long.parseLong(EnvConfig.getProperty("pollingTimeInSeconds"))))
				.ignoring(ElementNotInteractableException.class);
	}
    public void minimizeApp(AndroidDriver driver, long seconds)
	{
		log.info("Minimize app");
		driver.runAppInBackground(Duration.ofSeconds(seconds));
	}

	public void killAndRestartApp(AndroidDriver driver)
	{
		log.info("Get app package");
		String appPackage = driver.getCurrentPackage();

		log.info("Kill app");
		driver.terminateApp(appPackage);

		log.info("Restart app");
		driver.activateApp(appPackage);
	}

	public void killWaitAndRestartApp(AndroidDriver driver, long waitTimeInMillis)
	{
		log.info("Get app package");
		String appPackage = driver.getCurrentPackage();

		log.info("Kill app");
		driver.terminateApp(appPackage);

        try {
            Thread.sleep(waitTimeInMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Restart app");
		driver.activateApp(appPackage);
	}

	public void validateAppClosed(AndroidDriver driver)
	{
		log.info("Get app package");
		String appPackage = driver.getCurrentPackage();

		log.info("Get app state");
		assertEquals(driver.queryAppState(appPackage), ApplicationState.RUNNING_IN_FOREGROUND);
	}

	public WebElement waitForElementToBeVisible(AndroidDriver driver, By locator)
	{
		log.info("Waiting for element to be visible with locator: " +  locator);
		return getWait(driver).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBeClickable(AndroidDriver driver, By locator)
	{
		log.info("Waiting for element to be clickable with locator: " +  locator);
		return getWait(driver).until(ExpectedConditions.elementToBeClickable(locator));
	}

	public boolean waitForElementToBeDisplayed(AndroidDriver driver, By locator)
	{
		log.info("Waiting for element to be clickable with locator: " +  locator);
		return getWait(driver).until(ExpectedConditions.attributeToBe(locator, "displayed", "true"));
	}

	public boolean waitForElementToBeEnabled(AndroidDriver driver, By locator)
	{
		log.info("Waiting for element to be clickable with locator: " +  locator);
		return getWait(driver).until(ExpectedConditions.attributeToBe(locator, "enabled", "true"));
	}

	public boolean waitForElementToBeNotVisible(AndroidDriver driver, By locator)
	{
		log.info("Waiting for element to be not visible with locator: " +  locator);
		return getWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public boolean elementNotVisible(AndroidDriver driver, By locator)
	{
		log.info("Check if element is visible with locator: " +  locator);
		return getWait(driver).until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}

	public void scrollToText(AndroidDriver driver, String visibleText)
	{
		log.info("Scrolling to text : " +  visibleText);
		driver.findElement(new AppiumBy.ByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"" + visibleText + "\").instance(0))"));
	}

	public void scrollToElement(AndroidDriver driver, String resourceId)
	{
		log.info("Scrolling to element with resource-id : " +  resourceId);
		driver.findElement(new AppiumBy.ByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().resourceId(\"" + resourceId + "\").instance(0))"));
	}

	public void sendNumericKeysUsingKeyboard(AndroidDriver driver, String keys)
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

	public void pressDeleteKey(AndroidDriver driver)
	{
		driver.pressKey(new KeyEvent(AndroidKey.DEL));
	}

	public Actions getActions(AndroidDriver driver)
	{
		return new Actions(driver);
	}

	public void clickDeviceBackButton(AndroidDriver driver)
	{
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}

}
