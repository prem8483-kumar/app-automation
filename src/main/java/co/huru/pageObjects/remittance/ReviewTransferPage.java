package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class ReviewTransferPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(ReviewTransferPage.class);

	public ReviewTransferPage(AndroidDriver driver)
	{
		super(driver);
		verifyScreenHeader();
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By backButton = AppiumBy.accessibilityId("huru_back_button");

	private final By totalPaymentDetailsCta = AppiumBy.accessibilityId("id_total_to_pay_display_cta");
	private final By knowAboutFeesCta = AppiumBy.accessibilityId("id_payment_breakdown_know_about_fee_cta");

	private final By feeInfoIcon = AppiumBy.accessibilityId("id_review_screen_fee_info_icon");
	private final By paymentNoteTextBox = AppiumBy.xpath("//android.widget.EditText");

	private final By tncLink = AppiumBy.accessibilityId("id_review_screen_tnc_clickable_text");
	private final By tncBackButton = AppiumBy.xpath("//android.widget.Button");

	private final By goToPaymentCta = AppiumBy.accessibilityId("id_huru_button_text");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(waitForElementToBeVisible(header).getText(), AppConstant.REVIEW_TRANSFER_SCREEN_HEADER);
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

	public void clickOnGoToPayment()
	{
		log.info("Click on go to payment");
		waitForElementToBeVisible(goToPaymentCta).click();
	}

	public void reviewPaymentAndContinue(String paymentNote)
	{
		log.info("Review payment");
		waitForElementToBeVisible(totalPaymentDetailsCta).click();
		waitForElementToBeVisible(knowAboutFeesCta).click();
		waitForElementToBeVisible(continueButton).click();

		waitForElementToBeVisible(feeInfoIcon).click();
		waitForElementToBeVisible(continueButton).click();

		waitForElementToBeVisible(tncLink).click();
		waitForElementToBeVisible(tncBackButton).click();

		waitForElementToBeVisible(paymentNoteTextBox).sendKeys(paymentNote);
		waitForElementToBeVisible(goToPaymentCta).click();
	}
}
