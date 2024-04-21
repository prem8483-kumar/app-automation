package co.huru.pageObjects.appLaunch;

import co.huru.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class AppLauncherPage {

	private static final Logger log = LogManager.getLogger(AppLauncherPage.class);
	private AndroidDriver driver;

	public AppLauncherPage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}

	private final By launchImage = By.id("com.huru:id/imageView4");
	private final By signUpButton = By.id("com.huru:id/signUpButton");

	public void navigateValueProps()
	{
		log.info("Navigate value prop");
		getAndroidActions().waitForElementToBeVisible(driver,signUpButton).click();
	}

}
