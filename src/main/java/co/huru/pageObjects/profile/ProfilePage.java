package co.huru.pageObjects.profile;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
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

	private final By backButton = AppiumBy.accessibilityId("huru_back_button");

	private final By homeTab = By.id("com.huru:id/homeFragment");
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
	private final By addAccountButton = By.id("com.huru:id/add_account_btn");
	private final By addAccountLink = By.xpath("//android.widget.TextView[@text=\"Add\"]");
	private final By cardsTab = By.id("com.huru:id/background_card_view");

	private final By choseYourBankButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By selectBank1 = By.xpath("//android.widget.TextView[@text=\"Lean Mockbank\"]");
	private final By selectBankByText = By.xpath(String.format("//android.widget.TextView[@text=%s]", "Lean Mockbank"));

	private final By connectToBankButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__INITIAL__SUBMIT\"]");
	private final By bankAccountUserNameTextBox = By.xpath("//android.widget.EditText[@resource-id=\"username\"]");
	private final By bankAccountPasswordTextBox = By.xpath("//android.widget.EditText[@resource-id=\"password\"]");
	private final By bankAccountLoginButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__CREDENTIALS__SUBMIT\"]");
	private final By bankAccountOtpTextBox = By.xpath("//android.widget.EditText[@resource-id=\"genericMfa\"]");
	private final By bankAccountOtpSubmitButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__MFA__SUBMIT\"]");
	private final By bankAccountSuccessButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__SUCCESS__CLOSE\"]");

	private final By cashbackRewardsSection = By.id("com.huru:id/cashback_section");
	private final By cashbackBalanceText = By.xpath("//android.widget.TextView[@text=\"Cashback Balance\"]");
	private final By backButtonFromCashbackRewards = By.xpath("//android.widget.Button");

	private final By loginSettingsSection = By.id("com.huru:id/login_section");
	private final By changePinLink = By.id("com.huru:id/edit_change_passcode");
	private final By enableBiometricRadioButton = By.id("com.huru:id/biometric_switch");
	private final By biometricHeaderText = By.id("com.android.settings:id/biometric_header_description");
	private final By passcodeView = By.id("com.huru:id/passcodeView");
	private final By passCodeTextBox_1 = By.xpath("//android.widget.LinearLayout[1]/android.widget.EditText");
	private final By confirmPasscodeButton = By.id("com.huru:id/set_passcode_continue");

	private final By termsAndConditionsSection = By.id("com.huru:id/others_section1");
	private final By termsAndConditionsHeaderText = By.xpath("//android.widget.TextView[@text=\"Terms & Conditions\"]");
	private final By backButtonFromTermsAndConditions = By.xpath("//android.widget.Button");

	private final By privacyPolicySection = By.id("com.huru:id/others_section2");
	private final By privacyPolicyHeaderText = By.xpath("//android.widget.TextView[@text=\"Privacy policy\"]");
	private final By backButtonFromPrivacyPolicy = By.xpath("//android.widget.Button");

	private final By helpAndSupportSection = By.id("com.huru:id/others_section3");
	private final By helpAndSupportHeaderText = By.xpath("//android.widget.TextView[@text=\"Help & Support\"]");
	private final By backButtonFromHelpAndSupport = By.xpath("//android.widget.Button");

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

	public void editEmail(String email, String otp)
	{
		log.info("Edit email");
		waitForElementToBeVisible(editEmailLink).click();
		waitForElementToBeVisible(emailTextBox).sendKeys(email);
		waitForElementToBeVisible(emailSaveButton).click();

		log.info("Enter otp");
		waitForElementToBeVisible(otpView);
		sendNumericKeysUsingKeyboard(otp);

		log.info("Verify updated email");
		waitForElementToBeVisible(emailVerifyButton).click();
		waitForElementToBeVisible(personalDetailsSection).click();
		assertEquals(waitForElementToBeVisible(emailText).getText(), email);
	}

	public void editPhoneNumber(String phoneNumber, String otp)
	{
		log.info("Edit phone number");
		waitForElementToBeVisible(editPhoneNumberLink).click();
		waitForElementToBeVisible(phoneNumberTextBox).sendKeys(phoneNumber);
		waitForElementToBeVisible(phoneNumberSaveButton).click();

		log.info("Enter otp");
		waitForElementToBeVisible(otpView);
		sendNumericKeysUsingKeyboard(otp);

//		log.info("Verify updated phone");
//		gotToPersonalDetailsSection();
//		assertEquals(waitForElementToBeVisible(phoneNumberText).getText(), phoneNumber);
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
		waitForElementToBeVisible(cardsTab);
		navigateBack();
		waitForElementToBeVisible(paymentMethodsSection);
	}

	public void addBankAccount(String userName, String password, String otp)
	{
		log.info("Add bank account");
		if(elementNotVisible(addAccountButton)) {
			waitForElementToBeVisible(addAccountLink).click();
		} else {
			waitForElementToBeVisible(addAccountButton).click();
		}

		waitForElementToBeVisible(choseYourBankButton).click();
		waitForElementToBeVisible(selectBank1).click();
		waitForElementToBeVisible(connectToBankButton).click();

		waitForElementToBeVisible(bankAccountUserNameTextBox).sendKeys(userName);
		waitForElementToBeVisible(bankAccountPasswordTextBox).sendKeys(password);
		waitForElementToBeVisible(bankAccountLoginButton).click();

		waitForElementToBeVisible(bankAccountOtpTextBox).click();
		sendNumericKeysUsingKeyboard(otp);
		waitForElementToBeVisible(bankAccountOtpSubmitButton).click();
		waitForElementToBeVisible(bankAccountSuccessButton).click();

		waitForElementToBeVisible(addAccountLink);
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
		scrollToText("Privacy policy");
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
		scrollToText("Help and Support");
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
	}

	public void logOut()
	{
		log.info("Logout");
		gotToLogoutSection();
		logOutConfirm();

	}

	public void gotToLogoutSection()
	{
		log.info("Go to logout section");
		scrollToText("Log out");
		waitForElementToBeVisible(logoutSection).click();
	}

	public void logOutConfirm()
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

		//ToDo: Check automation feasibility
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



}
