package co.huru.pageObjects.remittance;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class PaymentPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(PaymentPage.class);

	public PaymentPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.xpath("");
	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	//Do Payment
	private final By confirmPaymentButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__PAYMENT__SUBMIT\"]");
	private final By otpTextBox = By.xpath("//android.widget.EditText[@resource-id=\"genericMfa\"]");;
	private final By submitOtpButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__MFA__SUBMIT\"]");
	private final By paymentDoneButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__SUCCESS__CLOSE\"]");
	private final By viewPaymentDetailsLink = AppiumBy.id("//android.widget.TextView[@text=\"View details\"]");

	private final By cancelPaymentButton = By.xpath("//android.view.View[@resource-id=\"STEP_PAYMENT_DETAILS\"]/android.view.View[1]/android.widget.Button");
	private final By closeOtpScreen = By.xpath("//android.view.View[@resource-id=\"STEP_MFA\"]/android.view.View[1]/android.widget.Button");

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
		waitForElementToBeVisible(confirmPaymentButton).click();

		//driver.context("WEBVIEW_com.huru");

		waitForElementToBeVisible(otpTextBox).sendKeys(otp);
		waitForElementToBeVisible(submitOtpButton).click();
		waitForElementToBeVisible(paymentDoneButton).click();
	}

	public void cancelPayment()
	{
		log.info("Cancel payment");
	}

	public void viewPaymentDetails()
	{
		log.info("View payment details");
		waitForElementToBeVisible(viewPaymentDetailsLink).click();
		waitForElementToBeVisible(continueButton).click();
	}
}
