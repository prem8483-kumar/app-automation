package co.huru.pageObjects;

import co.huru.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SignInPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SignInPage.class);

	public SignInPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	private final By phoneNumberTextBox = By.id("com.huru:id/phoneNumberEt");
	private final By disclaimerCheckBox = By.id("com.huru:id/disclaimer_cb");
	private final By phoneNumberContinueButton = By.id("com.huru:id/continueBtn");

	private final By passcodeView = By.id("com.huru:id/passcodeView");
	private final By passcodeTextBox_1 = By.xpath("//android.widget.LinearLayout[@resource-id=\"com.huru:id/passcodeView\"]/android.widget.LinearLayout[1]/android.widget.EditText");
	private final By passcodeContinueButton = By.id("com.huru:id/set_passcode_continue");
	private final By forgotPasscodeLink = By.id("com.huru:id/forgot_passcode");
	private final By passcodeError = By.id("com.huru:id/passcode_error");

	private final By otpView = By.id("com.huru:id/otpView");
	private final By otpTextBox_1 = By.xpath("//androidx.compose.ui.platform.ComposeView[@resource-id=\"com.huru:id/otpView\"]/android.view.View/android.view.View[1]/android.widget.EditText/android.view.View");
	private final By verifyOtpButton = By.id("com.huru:id/continueBtn");
	private final By resendOtpLink = By.id("com.huru:id/resendOtpLink");
	private final By otpError = By.id("com.huru:id/error_message");

	private final By homeTab = By.id("com.huru:id/homeFragment");

	public void navigateBack()
	{
		log.info("Navigate back");
		waitForElementToBeVisible(backButton).click();
	}

	public void enterPhoneNumber(String phoneNumber)
	{
		log.info("Enter phone number");
		waitForElementToBeVisible(phoneNumberTextBox).sendKeys(phoneNumber);
		waitForElementToBeVisible(phoneNumberContinueButton).click();
	}

	public void enterPasscode(String passcode)
	{
		log.info("Enter passcode");
		waitForElementToBeVisible(passcodeView);
		sendNumericKeysUsingKeyboard(passcode);
	}

	public void clickOnPasscodeTextBox()
	{
		log.info("Click on passcode text box");
		waitForElementToBeVisible(passcodeTextBox_1).click();
	}

	public void clickForgotPasswordLink()
	{
		log.info("Click forgot password link");
		waitForElementToBeVisible(forgotPasscodeLink).click();
	}

	public void clickOnOtpTextBox()
	{
		log.info("Click on otp text box");
		waitForElementToBeVisible(otpTextBox_1).click();
	}

	public void enterOtp(String otp)
	{
		log.info("Enter otp");
		waitForElementToBeVisible(otpView);
		sendNumericKeysUsingKeyboard(otp);
	}

	public void validatePinError()
	{
		log.info("Validate pin error");
		waitForElementToBeVisible(passcodeError);
	}

	public void validateForgotPinLinkDisabled()
	{
		log.info("Validate forgot pin link disabled");
		assertTrue(waitForElementToBeNotVisible(forgotPasscodeLink));
	}


	public void validateOtpError()
	{
		log.info("Validate otp error");
		waitForElementToBeVisible(otpError);
	}

	public void waitForResendOtpLink()
	{
		log.info("Wait for resend otp link");
		waitForElementToBeVisible(resendOtpLink);
	}

	public void clickResendOtpLink()
	{
		log.info("Click resend otp link");
		waitForElementToBeVisible(resendOtpLink).click();
	}

	public void waitForHomePage()
	{
		log.info("Wait for home page");
		waitForElementToBeVisible(homeTab);
	}

	public void verifyPhoneNumberPreFilled(String phoneNumber)
	{
		log.info("Verify phone number prefilled");
		assertEquals(waitForElementToBeVisible(phoneNumberTextBox).getText(), phoneNumber);
	}

	public void signIn(String phoneNumber, String passcode, String otp) {
		log.info("Sign In");
		enterPhoneNumber(phoneNumber);
		enterPasscode(passcode);
		enterOtp(otp);
		waitForHomePage();
	}

}
