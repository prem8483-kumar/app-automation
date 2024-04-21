package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class ReviewTransferPage {

	private static final Logger log = LogManager.getLogger(ReviewTransferPage.class);
	private AndroidDriver driver;

	public ReviewTransferPage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By backButton = AppiumBy.accessibilityId("huru_back_button");

	private final By sourceAmountText = AppiumBy.accessibilityId("id_source_amount");
	private final By receiverAmountText = AppiumBy.accessibilityId("id_receiver_amount receive");

	private final By receiverTitle = AppiumBy.accessibilityId("id_review_screen_title_itemReceiver");
	private final By theyReceiveTitle = AppiumBy.accessibilityId("id_review_screen_title_itemThey receive");

	private final By youSendTitle = AppiumBy.accessibilityId("id_review_screen_title_itemYou send");
	private final By feeTitle = AppiumBy.accessibilityId("id_review_screen_title_itemFee");
	private final By youPayTitle = AppiumBy.accessibilityId("id_review_screen_title_itemYou pay");

	private final By feeInfoIcon = AppiumBy.accessibilityId("id_review_screen_fee_info_icon");

	private final By paymentNoteTextBox = AppiumBy.xpath("//android.widget.EditText");

	private final By tncLink = AppiumBy.accessibilityId("id_review_screen_tnc_clickable_text");

	private final By goToPaymentCta = AppiumBy.accessibilityId("id_huru_button_text");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,header).getText(), AppConstant.REVIEW_TRANSFER_SCREEN_HEADER);
	}

	public void waitForPaymentNoteTextBox()
	{
		log.info("Enter payment note");
		getAndroidActions().waitForElementToBeVisible(driver,paymentNoteTextBox);
	}

	public void navigateBack()
	{
		log.info("Navigate back");
		getAndroidActions().waitForElementToBeVisible(driver,backButton).click();
	}

	public void clickOnContinue()
	{
		log.info("Next/Continue");
		getAndroidActions().waitForElementToBeVisible(driver,continueButton).click();
	}

	public void closeScreen()
	{
		log.info("Close screen");
		getAndroidActions().waitForElementToBeVisible(driver,closeScreen).click();
	}

	public void clickOnGoToPayment()
	{
		log.info("Click on go to payment");
		getAndroidActions().waitForElementToBeVisible(driver,goToPaymentCta).click();
	}

	public void enterPaymentNote(String paymentNote)
	{
		log.info("Enter payment note");
		getAndroidActions().waitForElementToBeVisible(driver,paymentNoteTextBox).sendKeys(paymentNote);
	}

	public void verifyReviewTransferScreen()
	{
		log.info("Verify review transfer screen");

		verifyScreenHeader();

		getAndroidActions().waitForElementToBeVisible(driver,sourceAmountText);
		getAndroidActions().waitForElementToBeVisible(driver,receiverAmountText);

		getAndroidActions().waitForElementToBeVisible(driver,receiverTitle);
		getAndroidActions().waitForElementToBeVisible(driver,theyReceiveTitle);

		getAndroidActions().waitForElementToBeVisible(driver,youSendTitle);
		getAndroidActions().waitForElementToBeVisible(driver,feeTitle);
		getAndroidActions().waitForElementToBeVisible(driver,youPayTitle);

		getAndroidActions().waitForElementToBeVisible(driver,feeInfoIcon).click();
		closeScreen();

		getAndroidActions().waitForElementToBeVisible(driver,feeInfoIcon).click();
		clickOnContinue();

		getAndroidActions().waitForElementToBeVisible(driver,tncLink).click();
		navigateBack();

		enterPaymentNote("Payment Note");
		clickOnGoToPayment();

	}
}
