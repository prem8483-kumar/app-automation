package co.huru.pageObjects.remittance;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class AddBankAccountPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(AddBankAccountPage.class);

	public AddBankAccountPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.xpath("");
	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	private final By choseYourBankButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Choose your bank\"]");
	private final By selectLeanMockBank = By.xpath("//android.widget.TextView[@text=\"Lean Mockbank\"]");

	private final By connectToBankButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__INITIAL__SUBMIT\"]");
	private final By bankAccountUserNameTextBox = By.xpath("//android.widget.EditText[@resource-id=\"username\"]");
	private final By bankAccountPasswordTextBox = By.xpath("//android.widget.EditText[@resource-id=\"password\"]");
	private final By bankAccountLoginButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__CREDENTIALS__SUBMIT\"]");
	private final By bankAccountOtpTextBox = By.xpath("//android.widget.EditText[@resource-id=\"genericMfa\"]");
	private final By bankAccountOtpSubmitButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__MFA__SUBMIT\"]");
	private final By bankAccountSuccessButton = By.xpath("//android.widget.Button[@resource-id=\"BUTTON_ID__SUCCESS__CLOSE\"]");


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

	public void addBankAccount(String userName, String password, String otp)
	{
		log.info("Add bank account");
		waitForElementToBeVisible(choseYourBankButton).click();
		waitForElementToBeVisible(selectLeanMockBank).click();
		waitForElementToBeVisible(connectToBankButton).click();

		waitForElementToBeVisible(bankAccountUserNameTextBox).sendKeys(userName);
		waitForElementToBeVisible(bankAccountPasswordTextBox).sendKeys(password);
		waitForElementToBeVisible(bankAccountLoginButton).click();

		waitForElementToBeVisible(bankAccountOtpTextBox).click();
		sendNumericKeysUsingKeyboard(otp);
		waitForElementToBeVisible(bankAccountOtpSubmitButton).click();
		waitForElementToBeVisible(bankAccountSuccessButton).click();
	}

}
