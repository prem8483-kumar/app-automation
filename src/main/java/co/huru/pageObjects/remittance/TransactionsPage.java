package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class TransactionsPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(TransactionsPage.class);

	public TransactionsPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");


	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(waitForElementToBeVisible(header).getText(), AppConstant.TRANSACTIONS_SCREEN_HEADER);
	}
}
