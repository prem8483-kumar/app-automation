package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddBankAccountPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(AddBankAccountPage.class);

	public AddBankAccountPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.xpath("//android.widget.TextView[@text=\"Add bank account\"]");
	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	private final By choseYourBankButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By selectBankScreenHeader = AppiumBy.accessibilityId("id_screen_title");
	private final By selectLeanMockBank = AppiumBy.xpath("//android.widget.TextView[@text=\"Lean Mockbank\"]");

	private final By bankAccountSetupScreenHeader = AppiumBy.xpath("//android.widget.TextView[@text=\"Set up your account\"]");
	private final By continueToBankAccountLoginButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__INITIAL__SUBMIT\"]");
	private final By bankAccountSetupScreenCloseButton = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_INITIAL\"]/android.view.View[1]/android.widget.Button");

	private final By bankAccountUserNameTextBox = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"username\"]");
	private final By bankAccountPasswordTextBox = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"password\"]");
	private final By bankAccountLoginButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__CREDENTIALS__SUBMIT\"]");

	private final By bankAccountLoginScreenBackButton = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_CREDENTIALS\"]/android.view.View[1]/android.widget.Button[1]");
	private final By bankAccountLoginScreenCloseButton = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_CREDENTIALS\"]/android.view.View[1]/android.widget.Button[2]");

	private final By bankAccountConnectSurveyHeader = AppiumBy.xpath("//android.widget.TextView[@text=\"Are you sure you want to close?\"]");
	private final By bankAccountConnectSurveyBackToConnectButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__EXIT_SURVEY__BACK\"]");
	private final By bankAccountConnectSurveyConfirmAndCloseButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__EXIT_SURVEY__CLOSE\"]");

	private final By bankAccountOtpTextBox = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"genericMfa\"]");
	private final By bankAccountOtpSubmitButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__MFA__SUBMIT\"]");
	private final By bankAccountSuccessButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__SUCCESS__CLOSE\"]");

	private final By bankAccountOtpScreenCloseButton = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_MFA\"]/android.view.View[1]/android.widget.Button");

	private final By userNameError = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"usernameDescription\"]");
	private final By passwordError = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"passwordDescription\"]");
	private final By otpError = AppiumBy.xpath("//android.widget.TextView[@text=\"The One Time Password entered is incorrect, please check it and try again\"]");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(waitForElementToBeVisible(header).getText(), AppConstant.ADD_BANK_ACCOUNT_SCREEN_HEADER);
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

	public void clickOnChoseYourBank()
	{
		log.info("Click on chose your bank");
		waitForElementToBeVisible(choseYourBankButton).click();
	}

	public void verifySelectBankScreenHeader()
	{
		log.info("Verify select bank screen header");
		assertEquals(waitForElementToBeVisible(selectBankScreenHeader).getText(), AppConstant.SELECT_BANK_SCREEN_HEADER);
	}

	public void clickOnLeanMockBank()
	{
		log.info("Click on Lean Mock Bank");
		waitForElementToBeVisible(selectLeanMockBank).click();
	}

	public void clickOnContinueToBankAccountLoginButton()
	{
		log.info("Click on continue to bank account login button");
		waitForElementToBeVisible(continueToBankAccountLoginButton).click();
	}

	public void connectToLeanMockBank()
	{
		log.info("Connect to bank");
		clickOnChoseYourBank();
		clickOnLeanMockBank();
		clickOnContinueToBankAccountLoginButton();
	}

	public void enterUserName(String userName)
	{
		log.info("Enter user name");
		waitForElementToBeVisible(bankAccountUserNameTextBox).sendKeys(userName);
	}

	public void enterPassword(String password)
	{
		log.info("Enter password");
		waitForElementToBeVisible(bankAccountPasswordTextBox).sendKeys(password);
	}

	public void clickOnLogin()
	{
		log.info("Click on login");
		waitForElementToBeVisible(bankAccountLoginButton).click();
	}

	public void enterOtp(String otp)
	{
		log.info("Enter otp");
		waitForElementToBeVisible(bankAccountOtpTextBox).click();
		getActions().sendKeys(otp).perform();
	}

	public void clickOnSubmitOtp()
	{
		log.info("Click on submit otp");
		waitForElementToBeVisible(bankAccountOtpSubmitButton).click();
	}

	public void clickOnDone()
	{
		log.info("Click on done");
		waitForElementToBeVisible(bankAccountSuccessButton).click();
	}

	public void verifyUserNameError()
	{
		log.info("Verify user name error");
		assertEquals(waitForElementToBeVisible(userNameError).getText(), AppConstant.BANK_ACCOUNT_USER_NAME_ERROR_MESSAGE);
	}

	public void verifyPasswordError()
	{
		log.info("Verify password error");
		assertEquals(waitForElementToBeVisible(passwordError).getText(), AppConstant.BANK_ACCOUNT_PASSWORD_ERROR_MESSAGE);
	}

	public void verifyBankAccountNotFoundError()
	{
		log.info("Verify bank account not found error");
		assertTrue(waitForElementToBeVisible(passwordError).getText().contains(AppConstant.BANK_ACCOUNT_NOT_FOUND_ERROR_MESSAGE));
	}

	public void verifyOtpError()
	{
		log.info("Verify otp error");
		assertEquals(waitForElementToBeVisible(otpError).getText(), AppConstant.BANK_ACCOUNT_OTP_ERROR_MESSAGE);
	}

	public void addBankAccount(String userName, String password, String otp)
	{
		log.info("Add bank account");
		connectToLeanMockBank();

		enterUserName(userName);
		enterPassword(password);
		clickOnLogin();

		enterOtp(otp);
		clickOnSubmitOtp();
		clickOnDone();
	}

	public void verifyBankAccountSetupScreenHeader()
	{
		log.info("Verify bank account setup screen header");
		waitForElementToBeVisible(bankAccountSetupScreenHeader);
	}

	public void clickOnBankAccountSetupScreenCloseButton()
	{
		log.info("Click on bank account setup screen close button");
		waitForElementToBeVisible(bankAccountSetupScreenCloseButton).click();
	}

	public void clickOnBankAccountLoginScreenCloseButton()
	{
		log.info("Click on bank account login screen close button");
		waitForElementToBeVisible(bankAccountLoginScreenCloseButton).click();
	}
	public void clickOnBankAccountLoginScreenBackButton()
	{
		log.info("Click on bank account login screen back button");
		waitForElementToBeVisible(bankAccountLoginScreenBackButton).click();
	}

	public void verifyBankAccountConnectSurveyScreenHeader()
	{
		log.info("Verify bank account connect survey screen header");
		waitForElementToBeVisible(bankAccountConnectSurveyHeader);
	}

	public void clickOnBankAccountConnectSurveyBackToConnectButton()
	{
		log.info("Click on bank account connect survey back to connect button");
		waitForElementToBeVisible(bankAccountConnectSurveyBackToConnectButton).click();
	}
	public void clickOnBankAccountConnectSurveyConfirmAndCloseButton()
	{
		log.info("Click on bank account connect survey confirm and close button");
		waitForElementToBeVisible(bankAccountConnectSurveyConfirmAndCloseButton).click();
	}

	public void clickOnBankAccountOtpScreenCloseButton()
	{
		log.info("Click on bank account otp screen close button");
		waitForElementToBeVisible(bankAccountOtpScreenCloseButton).click();
	}


}
