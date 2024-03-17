package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class PaymentPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(PaymentPage.class);

	public PaymentPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.xpath("//android.widget.TextView[@text=\"Payment Details\"]");
	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	//Do Payment
	private final By confirmPaymentButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__PAYMENT__SUBMIT\"]");
	private final By otpTextBox = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"genericMfa\"]");
	private final By submitOtpButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__MFA__SUBMIT\"]");
	private final By paymentDoneButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__SUCCESS__CLOSE\"]");
	private final By viewPaymentDetailsLink = AppiumBy.xpath("//android.widget.TextView[@text=\"View details\"]");

	private final By closePaymentScreen = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_PAYMENT_DETAILS\"]/android.view.View[1]/android.widget.Button");
	private final By closeOtpScreen = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_MFA\"]/android.view.View[1]/android.widget.Button");

	private final By otpError = AppiumBy.xpath("//android.widget.TextView[@text=\"The One Time Password entered is incorrect, please check it and try again\"]");

	private final By paymentProgressBar = AppiumBy.xpath("//android.widget.ProgressBar");
	private final By paymentStatusTitle = AppiumBy.accessibilityId("id_bs_title");
	private final By paymentStatusSubtitle = AppiumBy.accessibilityId("id_bs_subtitle");

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
		waitForElementToBeVisible(confirmPaymentButton).click();
	}

	public void enterOtp(String otp)
	{
		log.info("Enter otp");
		waitForElementToBeVisible(otpTextBox).sendKeys(otp);
	}

	public void clickOnSubmitOtp()
	{
		log.info("Click on submit otp");
		waitForElementToBeVisible(submitOtpButton).click();
	}

	public void clickOnDone()
	{
		log.info("Click on done");
		waitForElementToBeVisible(paymentDoneButton).click();
	}

	public void clickOnViewPaymentDetails()
	{
		log.info("Click on payment details");
		waitForElementToBeVisible(viewPaymentDetailsLink).click();
	}


	public void clickOnClosePaymentScreen()
	{
		log.info("Click on cancel payment");
		waitForElementToBeVisible(closePaymentScreen).click();
	}

	public void verifyOtpError()
	{
		log.info("Verify otp error");
		waitForElementToBeVisible(otpError);
	}

	public void clickOnCloseOtpScreen()
	{
		log.info("click on close otp screen");
		waitForElementToBeVisible(closeOtpScreen).click();
	}

	public void verifyPaymentProcessModel()
	{
		log.info("Verify payment progress model");
		waitForElementToBeVisible(paymentProgressBar);
		assertEquals(waitForElementToBeVisible(paymentStatusTitle).getText(), AppConstant.PAYMENT_PROCESS_TITLE);
		assertEquals(waitForElementToBeVisible(paymentStatusSubtitle).getText(), AppConstant.PAYMENT_PROCESS_SUBTITLE);
	}

	public void verifyPaymentPendingModel()
	{
		log.info("Verify payment pending model");
		assertEquals(waitForElementToBeVisible(paymentStatusTitle).getText(), AppConstant.PAYMENT_PENDING_TITLE);
		assertEquals(waitForElementToBeVisible(paymentStatusSubtitle).getText(), AppConstant.PAYMENT_PENDING_SUBTITLE);
	}
}

