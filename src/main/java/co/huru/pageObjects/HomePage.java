package co.huru.pageObjects;

import co.huru.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class HomePage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(HomePage.class);

	public HomePage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	private final By homeTab = By.id("com.huru:id/homeFragment");
	private final By payBillsTab = By.id("com.huru:id/payBillsFragment");
	private final By sendMoneyTab = By.id("com.huru:id/transactionsFragment");
	private final By transactionsTab = By.id("com.huru:id/sendMoneyFragment");
	private final By profileTab = By.id("com.huru:id/accountFragment");

	//ToDo: Ask to add id for rest elements

	public void navigateBack()
	{
		log.info("Navigate back");
		waitForElementToBeVisible(backButton).click();
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
