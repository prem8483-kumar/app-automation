package co.huru.pageObjects;

import co.huru.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class SignUpPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SignUpPage.class);

	public SignUpPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By launchImage = By.id("com.huru:id/imageView4");
	private final By signUpButton = By.id("com.huru:id/signUpButton");

	private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	private final By phoneNumberTextBox = By.id("com.huru:id/phoneNumberEt");
	private final By disclaimerCheckBox = By.id("com.huru:id/disclaimer_cb");
	private final By phoneNumberContinueButton = By.id("com.huru:id/continueBtn");

	private final By otpView = By.id("com.huru:id/otpView");
	private final By otpTextBox_1 = By.xpath("//android.widget.LinearLayout[1]/android.widget.EditText");
	private final By verifyOtpButton = By.id("com.huru:id/continueBtn");
	private final By resendOtpLink = By.id("com.huru:id/resendOtpLink");

	private final By nameTextBox = By.id("com.huru:id/name_edittext");
	private final By nameContinueButton = By.id("com.huru:id/continue_btn");

	private final By emailTextBox = By.id("com.huru:id/emailEt");
	private final By promotionalOptCheckBox = By.id("com.huru:id/checkBox");
	private final By emailContinueButton = By.id("com.huru:id/continue_btn");

	private final By passcodeView = By.id("com.huru:id/passcodeView");
	private final By passCodeTextBox_1 = By.xpath("//android.widget.LinearLayout[1]/android.widget.EditText");
	private final By confirmPasscodeButton = By.id("com.huru:id/set_passcode_continue");
	private final By passcodeError = By.id("com.huru:id/passcode_error");

	private final By biometricImage = By.id("com.huru:id/biometricIv");
	private final By biometricHeader = By.id("com.huru:id/phone_validation_header");
	private final By biometricInfo = By.id("com.huru:id/info_passcode");
	private final By setUpBiometricButton = By.id("com.huru:id/set_passcode_continue");
	private final By skipForNowLink = By.id("com.huru:id/skip_for_now");

	private final By homeTab = By.id("com.huru:id/homeFragment");

	public void navigateValueProps()
	{
		log.info("Navigate value prop");
		waitForElementToBeVisible(signUpButton).click();
		//waitForElementToBeVisible(signUpButton).click();
		//waitForElementToBeVisible(signUpButton).click();
	}

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

	public void enterOtp(String otp)
	{
		log.info("Enter otp");
		waitForElementToBeVisible(otpView);
		sendNumericKeysUsingKeyboard(otp);
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

	public void enterName(String name)
	{
		log.info("Enter name");
		waitForElementToBeVisible(nameTextBox).clear();
		waitForElementToBeVisible(nameTextBox).sendKeys(name);
		waitForElementToBeVisible(nameContinueButton).click();

	}

	public void enterEmail(String email)
	{
		log.info("Enter email");
		waitForElementToBeVisible(emailTextBox).clear();
		waitForElementToBeVisible(emailTextBox).sendKeys(email);
		waitForElementToBeVisible(emailContinueButton).click();

	}

	public void enterPasscode(String passcode)
	{
		log.info("Enter passcode");
		waitForElementToBeVisible(passcodeView);
		sendNumericKeysUsingKeyboard(passcode);
	}

	public void confirmPasscode(String passcode)
	{
		log.info("Confirm passcode");
		waitForElementToBeVisible(passcodeView);
		waitForElementToBeVisible(passCodeTextBox_1).click();
		sendNumericKeysUsingKeyboard(passcode);
		waitForElementToBeVisible(confirmPasscodeButton).click();
	}

	public void validatePinError()
	{
		log.info("Validate pin error");
		waitForElementToBeVisible(passcodeError);
	}

	public void skipBiometric()
	{
		log.info("Skip biometric setup");
		waitForElementToBeVisible(skipForNowLink).click();
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

	public void verifyNamePreFilled(String name)
	{
		log.info("Enter name prefilled");
		assertEquals(waitForElementToBeVisible(nameTextBox).getText(), name);
	}

}
