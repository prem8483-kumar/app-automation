package co.huru.pageObjects.profile;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProfilePage {

	private static final Logger log = LogManager.getLogger(ProfilePage.class);
	private AndroidDriver driver;

	public ProfilePage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
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
		getAndroidActions().waitForElementToBeVisible(driver,backButton).click();
	}

	public void gotToPersonalDetailsSection()
	{
		log.info("Go to personal details section");
		getAndroidActions().waitForElementToBeVisible(driver,personalDetailsSection).click();
	}

	public void editName(String name)
	{
		log.info("Edit name");
		getAndroidActions().waitForElementToBeVisible(driver,editNameLink).click();
		getAndroidActions().waitForElementToBeVisible(driver,nameTextBox).sendKeys(name);
		getAndroidActions().waitForElementToBeVisible(driver,nameSaveButton).click();
        assertEquals(getAndroidActions().waitForElementToBeVisible(driver,nameText).getText(), name);
	}

	public void editEmail(String email, String otp)
	{
		log.info("Edit email");
		getAndroidActions().waitForElementToBeVisible(driver,editEmailLink).click();
		getAndroidActions().waitForElementToBeVisible(driver,emailTextBox).sendKeys(email);
		getAndroidActions().waitForElementToBeVisible(driver,emailSaveButton).click();

		log.info("Enter otp");
		getAndroidActions().waitForElementToBeVisible(driver,otpView);
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,otp);

		log.info("Verify updated email");
		getAndroidActions().waitForElementToBeVisible(driver,emailVerifyButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,personalDetailsSection).click();
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,emailText).getText(), email);
	}

	public void editPhoneNumber(String phoneNumber, String otp)
	{
		log.info("Edit phone number");
		getAndroidActions().waitForElementToBeVisible(driver,editPhoneNumberLink).click();
		getAndroidActions().waitForElementToBeVisible(driver,phoneNumberTextBox).sendKeys(phoneNumber);
		getAndroidActions().waitForElementToBeVisible(driver,phoneNumberSaveButton).click();

		log.info("Enter otp");
		getAndroidActions().waitForElementToBeVisible(driver,otpView);
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,otp);

//		log.info("Verify updated phone");
//		gotToPersonalDetailsSection();
//		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,phoneNumberText).getText(), phoneNumber);
	}

	public void verifyEmailFromProfilePage(String otp)
	{
		log.info("Verify email from Profile page");
		getAndroidActions().waitForElementToBeVisible(driver,verifyEmailLink).click();
		getAndroidActions().waitForElementToBeVisible(driver,otpView);
		getAndroidActions().waitForElementToBeVisible(driver,otpTextBox_1).click();
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,otp);
		getAndroidActions().waitForElementToBeVisible(driver,emailVerifyButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,personalDetailsSection);
		assertTrue(getAndroidActions().waitForElementToBeNotVisible(driver,verifyEmailLink));
	}

	public void verifyEmailFromPersonalDetailsPage(String otp)
	{
		log.info("Verify email from Personal details page");
		getAndroidActions().waitForElementToBeVisible(driver,verifyEmailLink).click();
		getAndroidActions().waitForElementToBeVisible(driver,otpView);
		getAndroidActions().waitForElementToBeVisible(driver,otpTextBox_1).click();
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,otp);
		getAndroidActions().waitForElementToBeVisible(driver,emailVerifyButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,emailText);
		assertTrue(getAndroidActions().waitForElementToBeNotVisible(driver,verifyEmailLink));
	}

	public void gotToPaymentMethodsSection()
	{
		log.info("Go to payment methods section");
		getAndroidActions().waitForElementToBeVisible(driver,paymentMethodsSection).click();
	}

	public void verifyPaymentMethods()
	{
		log.info("Verify payment methods");
		getAndroidActions().waitForElementToBeVisible(driver,bankAccountsTab).click();
		getAndroidActions().waitForElementToBeVisible(driver,cardsTab);
		navigateBack();
		getAndroidActions().waitForElementToBeVisible(driver,paymentMethodsSection);
	}

	public void addBankAccount(String userName, String password, String otp)
	{
		log.info("Add bank account");
		if(getAndroidActions().elementNotVisible(driver,addAccountButton)) {
			getAndroidActions().waitForElementToBeVisible(driver,addAccountLink).click();
		} else {
			getAndroidActions().waitForElementToBeVisible(driver,addAccountButton).click();
		}

		getAndroidActions().waitForElementToBeVisible(driver,choseYourBankButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,selectBank1).click();
		getAndroidActions().waitForElementToBeVisible(driver,connectToBankButton).click();

		getAndroidActions().waitForElementToBeVisible(driver,bankAccountUserNameTextBox).sendKeys(userName);
		getAndroidActions().waitForElementToBeVisible(driver,bankAccountPasswordTextBox).sendKeys(password);
		getAndroidActions().waitForElementToBeVisible(driver,bankAccountLoginButton).click();

		getAndroidActions().waitForElementToBeVisible(driver,bankAccountOtpTextBox).click();
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,otp);
		getAndroidActions().waitForElementToBeVisible(driver,bankAccountOtpSubmitButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,bankAccountSuccessButton).click();

		getAndroidActions().waitForElementToBeVisible(driver,addAccountLink);
	}

	public void gotToCashbackRewardsSection()
	{
		log.info("Go to cashback rewards section");
		getAndroidActions().waitForElementToBeVisible(driver,cashbackRewardsSection).click();
	}

	public void verifyCashbackRewards()
	{
		log.info("Verify cashback rewards");
		getAndroidActions().waitForElementToBeVisible(driver,cashbackBalanceText);
		getAndroidActions().waitForElementToBeVisible(driver,backButtonFromCashbackRewards).click();
		getAndroidActions().waitForElementToBeVisible(driver,cashbackRewardsSection);
	}

	public void gotToTermsAndConditionSection()
	{
		log.info("Go to terms & conditions section");
		getAndroidActions().waitForElementToBeVisible(driver,termsAndConditionsSection).click();
	}

	public void verifyTermsAndConditions()
	{
		log.info("Verify Terms & Conditions");
		getAndroidActions().waitForElementToBeVisible(driver,termsAndConditionsHeaderText);
		getAndroidActions().waitForElementToBeVisible(driver,backButtonFromTermsAndConditions).click();
		getAndroidActions().waitForElementToBeVisible(driver,termsAndConditionsSection);
	}

	public void gotToPrivacyPolicySection()
	{
		log.info("Go to privacy policy section");
		getAndroidActions().scrollToText(driver,"Privacy policy");
		getAndroidActions().waitForElementToBeVisible(driver,privacyPolicySection).click();
	}

	public void verifyPrivacyPolicy()
	{
		log.info("Verify Privacy Policy");
		getAndroidActions().waitForElementToBeVisible(driver,privacyPolicyHeaderText);
		getAndroidActions().waitForElementToBeVisible(driver,backButtonFromPrivacyPolicy).click();
		getAndroidActions().waitForElementToBeVisible(driver,privacyPolicySection);
	}

	public void gotToHelpAndSupportSection()
	{
		log.info("Go to help & support section");
		getAndroidActions().scrollToText(driver,"Help and Support");
		getAndroidActions().waitForElementToBeVisible(driver,helpAndSupportSection).click();
	}

	public void verifyHelpAndSupport()
	{
		log.info("Verify Help & Support");
		getAndroidActions().waitForElementToBeVisible(driver,helpAndSupportHeaderText);
		getAndroidActions().waitForElementToBeVisible(driver,backButtonFromHelpAndSupport).click();
		getAndroidActions().waitForElementToBeVisible(driver,helpAndSupportSection);
	}

	public void gotToLoginSettingsSection()
	{
		log.info("Go to login settings section");
		getAndroidActions().waitForElementToBeVisible(driver,loginSettingsSection).click();
	}


	public void changePin(String oldPassCode, String newPasscode, String otp)
	{
		log.info("Chane passcode");
		getAndroidActions().waitForElementToBeVisible(driver,changePinLink).click();

		log.info("Enter old passcode");
		getAndroidActions().waitForElementToBeVisible(driver,passcodeView);
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,oldPassCode);

		log.info("Enter new passcode");
		getAndroidActions().waitForElementToBeVisible(driver,passcodeView);
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,newPasscode);

		log.info("Confirm new passcode");
		getAndroidActions().waitForElementToBeVisible(driver,passcodeView);
		getAndroidActions().waitForElementToBeVisible(driver,passCodeTextBox_1).click();
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,newPasscode);
		getAndroidActions().waitForElementToBeVisible(driver,confirmPasscodeButton).click();
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
		getAndroidActions().scrollToText(driver,"Log out");
		getAndroidActions().waitForElementToBeVisible(driver,logoutSection).click();
	}

	public void logOutConfirm()
	{
		log.info("Logout confirm");
		getAndroidActions().waitForElementToBeVisible(driver,logoutContinueButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,phoneNumberTextBox);
	}

	public void logOutCancel()
	{
		log.info("Logout cancel");
		getAndroidActions().waitForElementToBeVisible(driver,logoutCancelButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,logoutSection);
	}

	public void activateAccount()
	{
		log.info("Activate account");
		getAndroidActions().waitForElementToBeVisible(driver,activateAccountButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,activateAccountContinueButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,outOfUaeAlertIcon);
		getAndroidActions().waitForElementToBeVisible(driver,outOfUaeAlertAcceptButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,activateAccountCancelButton).click();
		getAndroidActions().waitForElementToBeVisible(driver,activateAccountButton);

		//ToDo: Check automation feasibility
	}

	public void enableBiometric(String passcode)
	{
		log.info("Enable biometric");
		getAndroidActions().waitForElementToBeVisible(driver,enableBiometricRadioButton).click();

		log.info("Enter passcode");
		getAndroidActions().waitForElementToBeVisible(driver,passcodeView);
		getAndroidActions().sendNumericKeysUsingKeyboard(driver,passcode);

		getAndroidActions().waitForElementToBeVisible(driver,biometricHeaderText);
		navigateBack();
		getAndroidActions().waitForElementToBeVisible(driver,enableBiometricRadioButton);

		//ToDo: Check automation feasibility
	}



}
