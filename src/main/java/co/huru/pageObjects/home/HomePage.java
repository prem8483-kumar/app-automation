package co.huru.pageObjects.home;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage {

	private static final Logger log = LogManager.getLogger(HomePage.class);
	private AndroidDriver driver;

	public HomePage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}

	private final By homeTab = By.id("com.huru:id/homeFragment");
	private final By payBillsTab = By.id("com.huru:id/payBillsFragment");
	private final By transactionsTab = By.id("com.huru:id/transactionsFragment");
	private final By sendMoneyTab = By.id("com.huru:id/sendMoneyFragment");
	private final By profileTab = By.id("com.huru:id/accountFragment");

	private final By kycCardHeader = AppiumBy.accessibilityId("id_kyc_status_header");
	private final By kycCardDescription = AppiumBy.accessibilityId("id_kyc_status_desc");


	public void kycCard()
	{
		log.info("Kyc card");
		getAndroidActions().waitForElementToBeVisible(driver,kycCardHeader);
		getAndroidActions().waitForElementToBeVisible(driver,kycCardDescription);
	}

	public void waitForHomePage()
	{
		log.info("Wait for home page");
		getAndroidActions().waitForElementToBeVisible(driver,homeTab);
	}

	public void goToHomePage()
	{
		log.info("Go to profile");
		getAndroidActions().waitForElementToBeVisible(driver,homeTab).click();
	}

	public void goToPayBillsPage()
	{
		log.info("Go to profile");
		getAndroidActions().waitForElementToBeVisible(driver,payBillsTab).click();
	}

	public void goToSendMoneyPage()
	{
		log.info("Go to profile");
		getAndroidActions().waitForElementToBeVisible(driver,sendMoneyTab).click();
	}

	public void goToTransactionsPage()
	{
		log.info("Go to profile");
		getAndroidActions().waitForElementToBeVisible(driver,transactionsTab).click();
	}

	public void goToProfilePage()
	{
		log.info("Go to profile");
		getAndroidActions().waitForElementToBeVisible(driver,profileTab).click();
	}
}
