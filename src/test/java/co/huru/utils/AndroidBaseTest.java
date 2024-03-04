package co.huru.utils;

import co.huru.configs.EnvConfig;
import co.huru.listeners.TestListener;
import co.huru.pageObjects.signIn.SignUpPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

//@Listeners({ com.epam.reportportal.testng.ReportPortalTestNGListener.class, co.huru.listeners.TestListener.class })
@Listeners({ TestListener.class })
public class AndroidBaseTest extends AppiumUtils {

	private static final Logger log = LogManager.getLogger(AndroidBaseTest.class);

	public AndroidDriver driver;

	@BeforeMethod(alwaysRun=true)
	public void createDriver() throws IOException
	{
		log.info("Creating driver");
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(EnvConfig.getProperty("deviceName"));
		options.setApp(EnvConfig.getProperty("apkFilePath"));
		options.setAutoGrantPermissions(true);

		driver = new AndroidDriver(new URL(EnvConfig.getProperty("appiumServer")), options);
	}

	@BeforeMethod(alwaysRun = true)
	public void navigateValueProps() {
		log.info("Continue value props");
		SignUpPage signUpPage = new SignUpPage(driver);
		signUpPage.navigateValueProps();
	}

	@AfterMethod(alwaysRun=true)
	public void quitDriver()
	{
		log.info("Quiting driver");
		driver.quit();
	}
	
}

/*
{
  "appium:app": "C://Repo//app-automation//src//test//resources//app-debug-version-old.apk",
  "appium:deviceName": "Pixel",
  "appium:automationName": "UiAutomator2",
  "platformName": "Android",
  "appium:autoGrantPermissions": true
}

 */
