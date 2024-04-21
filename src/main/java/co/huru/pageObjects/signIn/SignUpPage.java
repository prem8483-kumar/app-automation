package co.huru.pageObjects.signIn;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class SignUpPage {

	private static final Logger log = LogManager.getLogger(SignUpPage.class);
	private AndroidDriver driver;

	public SignUpPage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}


	private final By backButton = AppiumBy.accessibilityId("Navigate up");

	private final By phoneNumberScreenHeader = By.id("com.huru:id/phone_validation_header");
	private final By pinScreenHeader = By.id("com.huru:id/passcodeHeader");
	private final By confirmPinScreenHeader = By.id("com.huru:id/passcodeHeader");
	private final By otpScreenHeader = By.id("com.huru:id/phone_validation_header");
	private final By nameScreenHeader = By.id("com.huru:id/name_text");
	private final By emailScreenHeader = By.id("com.huru:id/email_text");

	private final By phoneNumberTextBox = By.id("com.huru:id/phoneNumberEt");
	private final By disclaimerCheckBox = By.id("com.huru:id/disclaimer_cb");
	private final By phoneNumberContinueButton = By.id("com.huru:id/continueBtn");

	private final By otpView = By.id("com.huru:id/otpView");
	private final By otpTextBox_1 = By.xpath("//android.widget.LinearLayout[1]/android.widget.EditText");
	private final By verifyOtpButton = By.id("com.huru:id/continueBtn");
	private final By resendOtpLink = By.id("com.huru:id/resendOtpLink");

	private final By nameTextBox = By.id("com.huru:id/name_edittext");
	private final By nameContinueButton = By.id("com.huru:id/continue_btn");
	private final By nameError = By.id("com.huru:id/error_message");

	private final By emailTextBox = By.id("com.huru:id/emailEt");
	private final By promotionalOptCheckBox = By.id("com.huru:id/checkBox");
	private final By emailContinueButton = By.id("com.huru:id/continue_btn");
	private final By emailError = By.id("com.huru:id/error_message");

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

	public void signUp(String phoneNumber, String otp, String passcode, String name, String email)  {

		log.info("Sign Up");
		enterPhoneNumberAndContinue(phoneNumber);
		enterOtp(otp);
		enterNameAndContinue(name);
		enterEmailAndContinue(email);
		enterPin(passcode);
		enterPinAndConfirm(passcode);
		skipBiometric();
		waitForHomePage();
	}

	public void navigateBack()
	{
		log.info("Navigate back");
		getAndroidActions().waitForElementToBeVisible(driver,backButton).click();
	}

	public void verifyPhoneNumberScreen() {
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,phoneNumberScreenHeader).getText(), AppConstant.PHONE_NUMBER_SCREEN_HEADER);
	}

	public void verifySetPinScreen() {
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,pinScreenHeader).getText(), AppConstant.SIGN_UP_PIN_SCREEN_HEADER);
	}

	public void verifyConfirmPinScreen() {
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,confirmPinScreenHeader).getText(), AppConstant.CONFIRM_PIN_SCREEN_HEADER);
	}

	public void verifyOtpScreen() {
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,otpScreenHeader).getText(), AppConstant.OTP_SCREEN_HEADER);
	}

	public void verifyNameScreen() {
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,nameScreenHeader).getText(), AppConstant.NAME_SCREEN_HEADER);
	}

	public void verifyEmailScreen() {
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,emailScreenHeader).getText(), AppConstant.EMAIL_SCREEN_HEADER);
	}

	public void enterPhoneNumberAndContinue(String phoneNumber)
	{
		log.info("Enter phone number");
		getAndroidActions().waitForElementToBeVisible(driver,phoneNumberTextBox).sendKeys(phoneNumber);
		getAndroidActions().waitForElementToBeVisible(driver,phoneNumberContinueButton).click();
	}

	public void enterPhoneNumber(String phoneNumber)
	{
		log.info("Enter phone number");
		getAndroidActions().waitForElementToBeVisible(driver,phoneNumberTextBox).sendKeys(phoneNumber);
	}

	public void enterOtp(String otp)
	{
		log.info("Enter otp");
		getAndroidActions().waitForElementToBeVisible(driver,otpView);
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,otp);
	}

	public void waitForResendOtpLink()
	{
		log.info("Wait for resend otp link");
		getAndroidActions().waitForElementToBeVisible(driver,resendOtpLink);
	}

	public void clickResendOtpLink()
	{
		log.info("Click resend otp link");
		getAndroidActions().waitForElementToBeVisible(driver,resendOtpLink).click();
	}

	public void enterNameAndContinue(String name)
	{
		log.info("Enter name");
		getAndroidActions().waitForElementToBeVisible(driver,nameTextBox).clear();
		getAndroidActions().waitForElementToBeVisible(driver,nameTextBox).sendKeys(name);
		getAndroidActions().waitForElementToBeVisible(driver,nameContinueButton).click();
	}

	public void enterName(String name)
	{
		log.info("Enter name");
		getAndroidActions().waitForElementToBeVisible(driver,nameTextBox).clear();
		getAndroidActions().waitForElementToBeVisible(driver,nameTextBox).sendKeys(name);
	}

	public void enterEmailAndContinue(String email)
	{
		log.info("Enter email");
		getAndroidActions().waitForElementToBeVisible(driver,emailTextBox).clear();
		getAndroidActions().waitForElementToBeVisible(driver,emailTextBox).sendKeys(email);
		getAndroidActions().waitForElementToBeVisible(driver,emailContinueButton).click();
	}

	public void enterEmail(String email)
	{
		log.info("Enter email");
		getAndroidActions().waitForElementToBeVisible(driver,emailTextBox).clear();
		getAndroidActions().waitForElementToBeVisible(driver,emailTextBox).sendKeys(email);
	}

	public void enterPin(String passcode)
	{
		log.info("Enter Pin");
		getAndroidActions().waitForElementToBeVisible(driver,passcodeView);
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,passcode);
	}

	public void enterPinAndConfirm(String passcode)
	{
		log.info("Confirm Pin");
		getAndroidActions().waitForElementToBeVisible(driver,passcodeView);
		getAndroidActions().waitForElementToBeVisible(driver,passCodeTextBox_1).click();
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,passcode);
		getAndroidActions().waitForElementToBeVisible(driver,confirmPasscodeButton).click();
	}

	public void validateSetPinError()
	{
		log.info("Validate pin error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,passcodeError).getText(), AppConstant.SET_PIN_ERROR_MESSAGE);
	}

	public void validatePinNotMatchError()
	{
		log.info("Validate pin error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,passcodeError).getText(), AppConstant.PIN_NOT_MATCH_ERROR_MESSAGE);
	}

	public void validateSamePinAsPreviousError()
	{
		log.info("Validate pin error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,passcodeError).getText(), AppConstant.SAME_PIN_AS_PREVIOUS_ERROR_MESSAGE);
	}

	public void validateNameError()
	{
		log.info("Validate pin error");
		getAndroidActions().waitForElementToBeVisible(driver,nameError);
	}

	public void validateEmailError()
	{
		log.info("Validate pin error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,emailError).getText(), AppConstant.EMAIL_ERROR_MESSAGE);
	}

	public void validateEmailRequiredError()
	{
		log.info("Validate pin error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,emailError).getText(), AppConstant.EMAIL_REQUIRED_ERROR_MESSAGE);
	}

	public void skipBiometric()
	{
		log.info("Skip biometric setup");
		getAndroidActions().waitForElementToBeVisible(driver,skipForNowLink).click();
	}

	public void waitForHomePage()
	{
		log.info("Wait for home page");
		getAndroidActions().waitForElementToBeVisible(driver,homeTab);
	}

	public void verifyPhoneNumberPreFilled(String phoneNumber)
	{
		log.info("Verify phone number prefilled");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,phoneNumberTextBox).getText(), phoneNumber);
	}

	public void verifyNamePreFilled(String name)
	{
		log.info("Enter name prefilled");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,nameTextBox).getText(), name);
	}
}
