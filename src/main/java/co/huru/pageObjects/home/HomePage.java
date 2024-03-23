package co.huru.pageObjects.home;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class HomePage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(HomePage.class);

	public HomePage(AndroidDriver driver)
	{
		super(driver);
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
		waitForElementToBeVisible(kycCardHeader);
		waitForElementToBeVisible(kycCardDescription);
	}

	public void goToHomePage()
	{
		log.info("Go to profile");
		waitForElementToBeVisible(homeTab).click();
	}

	public void goToPayBillsPage()
	{
		log.info("Go to profile");
		waitForElementToBeVisible(payBillsTab).click();
	}

	public void goToSendMoneyPage()
	{
		log.info("Go to profile");
		waitForElementToBeVisible(sendMoneyTab).click();
	}

	public void goToTransactionsPage()
	{
		log.info("Go to profile");
		waitForElementToBeVisible(transactionsTab).click();
	}

	public void goToProfilePage()
	{
		log.info("Go to profile");
		waitForElementToBeVisible(profileTab).click();
	}
}
