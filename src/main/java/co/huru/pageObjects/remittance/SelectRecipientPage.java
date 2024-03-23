package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class SelectRecipientPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SelectRecipientPage.class);

	public SelectRecipientPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By backButton = AppiumBy.accessibilityId("huru_back_button");

	private final By addRecipient = AppiumBy.accessibilityId("ic_new_recipient_forward");
	private final By selectFirstRecipient = AppiumBy.accessibilityId("id_recipient_item_row0");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(waitForElementToBeVisible(header).getText(), AppConstant.SELECT_RECIPIENT_SCREEN_HEADER);
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
