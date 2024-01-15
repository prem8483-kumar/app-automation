package co.huru.pageObjects;

import co.huru.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfilePage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(ProfilePage.class);

	public ProfilePage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By homeTab = By.id("com.huru:id/homeFragment");
	private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	private final By userAvatarImage = By.id("com.huru:id/userAvatar");
	private final By userNameText = By.id("com.huru:id/userName");

	private final By activateAccountButton = By.id("com.huru:id/activate_account");
	private final By activateAccountContinueButton = By.id("com.huru:id/activate_ac");
	private final By activateAccountCancelButton = By.id("com.huru:id/kyc_cancel");
	private final By outOfUaeAlertIcon = By.id("com.huru:id/alertImg");
	private final By outOfUaeAlertAcceptButton = By.id("com.huru:id/bsAction");

	private final By personalDetailsSection = By.id("com.huru:id/personal_detail_section");

	private final By editNameLink = By.id("com.huru:id/tv_Edit_name");
	private final By nameTextBox = By.id("com.huru:id/name_edittext");
	private final By nameSaveButton = By.id("com.huru:id/continue_btn");
	private final By nameText = By.id("com.huru:id/tv_Person_name");

	private final By editEmailLink = By.id("com.huru:id/tv_Edit_email_address");
	private final By emailTextBox = By.id("com.huru:id/emailEt");
	private final By emailSaveButton = By.id("com.huru:id/continue_btn");
	private final By emailText = By.id("com.huru:id/tv_email");

	private final By verifyEmailLink = By.id("com.huru:id/tv_verify_email");
	private final By emailVerifyButton = By.id("com.huru:id/continueBtn");
	private final By resendOtpLink = By.id("com.huru:id/resendOtpLink");
	private final By otpView = By.id("com.huru:id/otpView");
	private final By otpTextBox_1 = By.xpath("//android.widget.LinearLayout[1]/android.widget.EditText");

	private final By editPhoneNumberLink = By.id("com.huru:id/tv_Edit_mobile_number");
	private final By phoneNumberTextBox = By.id("com.huru:id/phoneNumberEt");
	private final By phoneNumberSaveButton = By.id("com.huru:id/continueBtn");
	private final By phoneNumberText = By.id("com.huru:id/com.huru:id/tv_mobile");

	private final By paymentMethodsSection = By.id("com.huru:id/payment_section");
	private final By bankAccountsTab = By.id("com.huru:id/background_bank_view");
	private final By cardsTab = By.id("com.huru:id/background_card_view");
	private final By addAccountButton = By.id("com.huru:id/add_account_btn");

	private final By cashbackRewardsSection = By.id("com.huru:id/cashback_section");
	private final By cashbackBalanceText = By.id("//android.widget.TextView[@text=\"Cashback Balance\"]");
	private final By backButtonFromCashbackRewards = By.id("//android.widget.Button");

	private final By loginSettingsSection = By.id("com.huru:id/login_section");
	private final By changePinLink = By.id("com.huru:id/edit_change_passcode");
	private final By enableBiometricRadioButton = By.id("com.huru:id/biometric_switch");
	private final By biometricHeaderText = By.id("com.android.settings:id/biometric_header_description");
	private final By passcodeView = By.id("com.huru:id/passcodeView");
	private final By passCodeTextBox_1 = By.xpath("//android.widget.LinearLayout[1]/android.widget.EditText");
	private final By confirmPasscodeButton = By.id("com.huru:id/set_passcode_continue");

	private final By termsAndConditionsSection = By.id("com.huru:id/others_section1");
	private final By termsAndConditionsHeaderText = By.id("//android.widget.TextView[@text=\"Terms & Conditions\"]");
	private final By backButtonFromTermsAndConditions = By.id("//android.widget.Button");

	private final By privacyPolicySection = By.id("com.huru:id/others_section2");
	private final By privacyPolicyHeaderText = By.id("//android.widget.TextView[@text=\"Privacy policy\"]");
	private final By backButtonFromPrivacyPolicy = By.id("//android.widget.Button");

	private final By helpAndSupportSection = By.id("com.huru:id/others_section3");
	private final By helpAndSupportHeaderText = By.id("//android.widget.TextView[@text=\"Help & Support\"]");
	private final By backButtonFromHelpAndSupport = By.id("//android.widget.Button");

	private final By logoutSection = By.id("com.huru:id/logout_section");
	private final By logoutContinueButton = By.id("com.huru:id/logout_continue");
	private final By logoutCancelButton= By.id("com.huru:id/cancel_btn");

	private final By appVersionText = By.id("com.huru:id/version");

	public void navigateBack()
	{
		log.info("Navigate back");
		waitForElementToBeVisible(backButton).click();
	}

	public void gotToPersonalDetailsSection()
	{
		log.info("Go to personal details section");
		waitForElementToBeVisible(personalDetailsSection).click();
	}

	public void editName(String name)
	{
		log.info("Edit name");
		waitForElementToBeVisible(editNameLink).click();
		waitForElementToBeVisible(nameTextBox).sendKeys(name);
		waitForElementToBeVisible(nameSaveButton).click();
        assertEquals(waitForElementToBeVisible(nameText).getText(), name);
	}

	public void editEmail(String email)
	{
		log.info("Edit email");
		waitForElementToBeVisible(editEmailLink).click();
		waitForElementToBeVisible(emailTextBox).sendKeys(email);
		waitForElementToBeVisible(emailSaveButton).click();
		assertEquals(waitForElementToBeVisible(emailText).getText(), email);
	}

	public void editPhoneNumber(String phoneNumber)
	{
		log.info("Edit phone number");
		waitForElementToBeVisible(editPhoneNumberLink).click();
		waitForElementToBeVisible(phoneNumberTextBox).sendKeys(phoneNumber);
		waitForElementToBeVisible(phoneNumberSaveButton).click();
		assertEquals(waitForElementToBeVisible(phoneNumberText).getText(), phoneNumber);
	}


	public void verifyEmailFromProfilePage(String otp)
	{
		log.info("Verify email from Profile page");
		waitForElementToBeVisible(verifyEmailLink).click();
		waitForElementToBeVisible(otpView);
		waitForElementToBeVisible(otpTextBox_1).click();
		sendNumericKeysUsingKeyboard(otp);
		waitForElementToBeVisible(emailVerifyButton).click();
		waitForElementToBeVisible(personalDetailsSection);
		assertTrue(waitForElementToBeNotVisible(verifyEmailLink));
	}

	public void verifyEmailFromPersonalDetailsPage(String otp)
	{
		log.info("Verify email from Personal details page");
		waitForElementToBeVisible(verifyEmailLink).click();
		waitForElementToBeVisible(otpView);
		waitForElementToBeVisible(otpTextBox_1).click();
		sendNumericKeysUsingKeyboard(otp);
		waitForElementToBeVisible(emailVerifyButton).click();
		waitForElementToBeVisible(emailText);
		assertTrue(waitForElementToBeNotVisible(verifyEmailLink));
	}

	public void gotToPaymentMethodsSection()
	{
		log.info("Go to payment methods section");
		waitForElementToBeVisible(paymentMethodsSection).click();
	}

	public void verifyPaymentMethods()
	{
		log.info("Verify payment methods");
		waitForElementToBeVisible(bankAccountsTab).click();
		waitForElementToBeVisible(addAccountButton);
		waitForElementToBeVisible(cardsTab);
		navigateBack();
		waitForElementToBeVisible(paymentMethodsSection);
	}

	public void addBankAccount()
	{
		log.info("Verify payment methods");
		waitForElementToBeVisible(bankAccountsTab).click();
		waitForElementToBeVisible(addAccountButton).click();

		//ToDo: Require Test Data for Bank Account and Id
	}

	public void gotToCashbackRewardsSection()
	{
		log.info("Go to cashback rewards section");
		waitForElementToBeVisible(cashbackRewardsSection).click();
	}

	public void verifyCashbackRewards()
	{
		log.info("Verify cashback rewards");
		waitForElementToBeVisible(cashbackBalanceText);
		waitForElementToBeVisible(backButtonFromCashbackRewards).click();
		waitForElementToBeVisible(cashbackRewardsSection);
	}

	public void gotToTermsAndConditionSection()
	{
		log.info("Go to terms & conditions section");
		waitForElementToBeVisible(termsAndConditionsSection).click();
	}

	public void verifyTermsAndConditions()
	{
		log.info("Verify Terms & Conditions");
		waitForElementToBeVisible(termsAndConditionsHeaderText);
		waitForElementToBeVisible(backButtonFromTermsAndConditions).click();
		waitForElementToBeVisible(termsAndConditionsSection);
	}

	public void gotToPrivacyPolicySection()
	{
		log.info("Go to privacy policy section");
		waitForElementToBeVisible(privacyPolicySection).click();
	}


	public void verifyPrivacyPolicy()
	{
		log.info("Verify Privacy Policy");
		waitForElementToBeVisible(privacyPolicyHeaderText);
		waitForElementToBeVisible(backButtonFromPrivacyPolicy).click();
		waitForElementToBeVisible(privacyPolicySection);
	}

	public void gotToHelpAndSupportSection()
	{
		log.info("Go to help & support section");
		waitForElementToBeVisible(helpAndSupportSection).click();
	}


	public void verifyHelpAndSupport()
	{
		log.info("Verify Help & Support");
		waitForElementToBeVisible(helpAndSupportHeaderText);
		waitForElementToBeVisible(backButtonFromHelpAndSupport).click();
		waitForElementToBeVisible(helpAndSupportSection);
	}

	public void gotToLoginSettingsSection()
	{
		log.info("Go to login settings section");
		waitForElementToBeVisible(loginSettingsSection).click();
	}


	public void changePin(String oldPassCode, String newPasscode, String otp)
	{
		log.info("Chane passcode");
		waitForElementToBeVisible(changePinLink).click();

		log.info("Enter old passcode");
		waitForElementToBeVisible(passcodeView);
		sendNumericKeysUsingKeyboard(oldPassCode);

		log.info("Enter new passcode");
		waitForElementToBeVisible(passcodeView);
		sendNumericKeysUsingKeyboard(newPasscode);

		log.info("Confirm new passcode");
		waitForElementToBeVisible(passcodeView);
		waitForElementToBeVisible(passCodeTextBox_1).click();
		sendNumericKeysUsingKeyboard(newPasscode);
		waitForElementToBeVisible(confirmPasscodeButton).click();

		log.info("Enter new passcode");
		waitForElementToBeVisible(passcodeView);
		sendNumericKeysUsingKeyboard(newPasscode);

		log.info("Enter otp");
		waitForElementToBeVisible(otpView);
		waitForElementToBeVisible(otpTextBox_1).click();
		sendNumericKeysUsingKeyboard(otp);

		log.info("Wait for home page");
		waitForElementToBeVisible(homeTab);
	}

	public void enableBiometric(String passcode)
	{
		log.info("Enable biometric");
		waitForElementToBeVisible(enableBiometricRadioButton).click();

		log.info("Enter passcode");
		waitForElementToBeVisible(passcodeView);
		sendNumericKeysUsingKeyboard(passcode);

		waitForElementToBeVisible(biometricHeaderText);
		navigateBack();
		waitForElementToBeVisible(enableBiometricRadioButton);

		//ToDo: Check automation feasibility
	}

	public void gotToLogoutSection()
	{
		log.info("Go to logout section");
		waitForElementToBeVisible(logoutSection).click();
	}

	public void logOut()
	{
		log.info("Logout confirm");
		waitForElementToBeVisible(logoutContinueButton).click();
		waitForElementToBeVisible(phoneNumberTextBox);
	}

	public void logOutCancel()
	{
		log.info("Logout cancel");
		waitForElementToBeVisible(logoutCancelButton).click();
		waitForElementToBeVisible(logoutSection);
	}

	public void activateAccount()
	{
		log.info("Activate account");
		waitForElementToBeVisible(activateAccountButton).click();
		waitForElementToBeVisible(activateAccountContinueButton).click();
		waitForElementToBeVisible(outOfUaeAlertIcon);
		waitForElementToBeVisible(outOfUaeAlertAcceptButton).click();
		waitForElementToBeVisible(activateAccountCancelButton).click();
		waitForElementToBeVisible(activateAccountButton);
	}


}
