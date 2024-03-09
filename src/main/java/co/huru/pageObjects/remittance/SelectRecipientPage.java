package co.huru.pageObjects.remittance;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SelectRecipientPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SelectRecipientPage.class);

	public SelectRecipientPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.xpath("//android.widget.TextView[@text=\"Select recipient\"]");
	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	private final By addRecipient = AppiumBy.accessibilityId("ic_new_recipient_forward");
	private final By selectFirstRecipient = AppiumBy.accessibilityId("id_recipient_item_row0");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		waitForElementToBeVisible(header);
	}

	public void navigateBack()
	{
		log.info("Navigate back");
		waitForElementToBeVisible(backButton).click();
	}

	public void clickOnContinue()
	{
		log.info("Next/Continue");
		waitForElementToBeVisible(continueButton).click();
	}

	public void closeScreen()
	{
		log.info("Close screen");
		waitForElementToBeVisible(closeScreen).click();
	}

	public void clickOnAddRecipient()
	{
		log.info("Click on add recipient");
		waitForElementToBeVisible(addRecipient).click();
	}

	public void selectFirstRecipient()
	{
		log.info("Select recipient");
		waitForElementToBeVisible(selectFirstRecipient).click();
	}
}
