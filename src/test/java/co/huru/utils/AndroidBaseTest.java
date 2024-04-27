package co.huru.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import java.io.IOException;
import java.net.URL;

@Listeners({ com.epam.reportportal.testng.ReportPortalTestNGListener.class, co.huru.listeners.TestListener.class })
//@Listeners({ TestListener.class })
public class AndroidBaseTest {

	private static final Logger log = LogManager.getLogger(AndroidBaseTest.class);

	public final ThreadLocal<AppiumDriverLocalService> appiumDriverLocalService = new ThreadLocal<>();
	public final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();

	public void setAppiumDriverLocalService(AppiumDriverLocalService appiumDriverLocalService) {

		this.appiumDriverLocalService.set(appiumDriverLocalService);
	}

	public AppiumDriverLocalService getAppiumDriverLocalService() {

		return this.appiumDriverLocalService.get();
	}

	public void setDriver(AndroidDriver driver) {

		this.driver.set(driver);
	}

	public AndroidDriver getDriver() {

		return this.driver.get();
	}

//	@BeforeTest(alwaysRun = true)
//	@Parameters({"appiumServerHost","appiumServerPort"})
//	public void startAppiumServer(@Optional("127.0.0.1") String appiumServerHost, @Optional("4723") Integer appiumServerPort) {
//		log.info("Starting appium server");
//
//		setAppiumDriverLocalService(new AppiumServiceBuilder()
//				.withIPAddress(appiumServerHost)
//				.usingPort(appiumServerPort)
//				.build()
//		);
//
//		getAppiumDriverLocalService().start();
//		log.info("Appium server started: " + appiumServerHost + ":" +  appiumServerPort);
//	}

//	@AfterTest(alwaysRun = true)
//	@Parameters({"appiumServerHost","appiumServerPort"})
//	public void stopAppiumServer(@Optional("127.0.0.1") String appiumServerHost, @Optional("4723") Integer appiumServerPort) {
//		log.info("Stopping appium server");
//		getAppiumDriverLocalService().stop();
//		log.info("Appium server stopped running on : " + appiumServerHost + ":" +  appiumServerPort);
//	}

	@BeforeMethod(alwaysRun=true)
	@Parameters({"appiumServerHost","appiumServerPort", "platformName", "platformVersion", "deviceId", "apkFilePath"})
	public void createDriver(@Optional("127.0.0.1") String appiumServerHost, @Optional("4723") Integer appiumServerPort,
							 @Optional("Android")String platformName, @Optional("14")String platformVersion,
							 @Optional("emulator-5554") String deviceId, @Optional("C:\\Repo\\app-automation\\src\\test\\resources\\apk\\app-debug-dev.apk") String apkFilePath
	) throws IOException
	{
		log.info("Setting capabilities");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("udid", deviceId);
		capabilities.setCapability("app", apkFilePath);
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("autoGrantPermissions", true);

		log.info("Creating driver");
		URL url = new URL("http://" + appiumServerHost + ":" +  appiumServerPort);
		setDriver(new AndroidDriver(url, capabilities));
	}

	@AfterMethod(alwaysRun=true)
	public void quitDriver()
	{
		log.info("Quiting driver");
		getDriver().quit();
	}
	
}
