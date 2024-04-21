package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class PaymentPage {

	private static final Logger log = LogManager.getLogger(PaymentPage.class);
	private AndroidDriver driver;

	public PaymentPage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}

	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");

	//Do Payment
	private final By header = AppiumBy.xpath("//android.widget.TextView[@text=\"Payment Details\"]");

	private final By confirmPaymentButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__PAYMENT__SUBMIT\"]");
	private final By otpTextBox = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"genericMfa\"]");
	private final By submitOtpButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__MFA__SUBMIT\"]");
	private final By paymentDoneButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__SUCCESS__CLOSE\"]");
	private final By viewPaymentDetailsLink = AppiumBy.xpath("//android.widget.TextView[@text=\"View details\"]");

	private final By closePaymentScreen = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_PAYMENT_DETAILS\"]/android.view.View[1]/android.widget.Button");
	private final By closeOtpScreen = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_MFA\"]/android.view.View[1]/android.widget.Button");

	private final By otpError = AppiumBy.xpath("//android.widget.TextView[@text=\"The One Time Password entered is incorrect, please check it and try again\"]");

	private final By paymentProgressBar = AppiumBy.xpath("//android.widget.ProgressBar");
	private final By paymentProgressTitle = AppiumBy.accessibilityId("id_bs_title");
	private final By paymentProgressSubtitle = AppiumBy.accessibilityId("id_bs_subtitle");

	private final By paymentPendingTitle = AppiumBy.xpath("//android.widget.TextView[@text=\"Money Transfer Pending\"]");
	private final By paymentPendingSubtitle = AppiumBy.xpath("//android.widget.TextView[@text=\"We are processing your payment. We will inform you once it's done. \"]");


	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,header).getText(), AppConstant.PAYMENT_SCREEN_HEADER);
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

	public void confirmPayment(String otp)
	{
		log.info("Confirm payment");
		clickOnConfirmPayment();
		enterOtp(otp);
		clickOnSubmitOtp();
		clickOnDone();
	}

	public void clickOnConfirmPayment()
	{
		log.info("Click on confirm payment");
		getAndroidActions().waitForElementToBeVisible(driver,confirmPaymentButton).click();
	}

	public void waitForOtpTextBox()
	{
		log.info("Wait for otp text box");
		getAndroidActions().waitForElementToBeClickable(driver, otpTextBox);
	}

	public void enterOtp(String otp)
	{
		log.info("Enter otp");
		getAndroidActions().waitForElementToBeClickable(driver, otpTextBox).click();
		getAndroidActions().getActions(driver).sendKeys(otp).perform();
	}

	public void clickOnSubmitOtp()
	{
		log.info("Click on submit otp");
		getAndroidActions().waitForElementToBeVisible(driver,submitOtpButton).click();
	}

	public void clickOnDone()
	{
		log.info("Click on done");
		getAndroidActions().waitForElementToBeVisible(driver,paymentDoneButton).click();
	}

	public void clickOnViewPaymentDetails()
	{
		log.info("Click on payment details");
		getAndroidActions().waitForElementToBeVisible(driver,viewPaymentDetailsLink).click();
	}


	public void clickOnClosePaymentScreen()
	{
		log.info("Click on cancel payment");
		getAndroidActions().waitForElementToBeVisible(driver,closePaymentScreen).click();
	}

	public void verifyOtpError()
	{
		log.info("Verify otp error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,otpError).getText(), AppConstant.BANK_ACCOUNT_OTP_ERROR_MESSAGE);
	}

	public void clickOnCloseOtpScreen()
	{
		log.info("click on close otp screen");
		getAndroidActions().waitForElementToBeVisible(driver,closeOtpScreen).click();
	}

	public void verifyPaymentProcessModel()
	{
		log.info("Verify payment progress model");
		getAndroidActions().waitForElementToBeVisible(driver,paymentProgressBar);
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,paymentProgressTitle).getText(), AppConstant.PAYMENT_PROCESS_TITLE);
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,paymentProgressSubtitle).getText(), AppConstant.PAYMENT_PROCESS_SUBTITLE);
	}

	public void verifyPaymentPendingModel()
	{
		log.info("Verify payment pending model");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,paymentPendingTitle).getText(), AppConstant.PAYMENT_PENDING_TITLE);
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,paymentPendingSubtitle).getText(), AppConstant.PAYMENT_PENDING_SUBTITLE);
	}
}

