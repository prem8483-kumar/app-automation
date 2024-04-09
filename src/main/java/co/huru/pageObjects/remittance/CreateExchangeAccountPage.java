package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class CreateExchangeAccountPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(CreateExchangeAccountPage.class);

	public CreateExchangeAccountPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By backButton = AppiumBy.accessibilityId("huru_back_button");

	private final By exchangeCheckbox = AppiumBy.accessibilityId("id_screen_title");
	private final By exchangeTnCLink = AppiumBy.accessibilityId("id_screen_title");
	private final By exchangePrivacyPolicyLink = AppiumBy.accessibilityId("id_huru_button_text");
	private final By exchangeTnCBackButton = AppiumBy.accessibilityId("id_screen_title");
	private final By exchangePrivacyPolicyBackButton = AppiumBy.accessibilityId("id_huru_button_text");

	private final By huruCheckbox = AppiumBy.accessibilityId("id_huru_button_text");
	private final By huruMyDetailsLink = AppiumBy.accessibilityId("id_huru_button_text");
	private final By huruMyDetailsModelContinueButton = AppiumBy.accessibilityId("id_huru_button_text");

	private final By annualIncomeTextBox = AppiumBy.accessibilityId("id_huru_button_text");
	private final By monthlyTransactionNumberTextBox = AppiumBy.accessibilityId("id_huru_button_text");
	private final By monthlyTransactionAmountTextBox = AppiumBy.accessibilityId("id_huru_button_text");


	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(waitForElementToBeVisible(header).getText(), AppConstant.CREATE_ACCOUNT_SCREEN_HEADER);
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

	public void clickOnExchangeCheckbox()
	{
		log.info("Click on exchange checkbox");
		waitForElementToBeVisible(exchangeCheckbox).click();
	}

	public void clickOnHuruCheckbox()
	{
		log.info("Click on huru checkbox");
		waitForElementToBeVisible(huruCheckbox).click();
	}

	public void enterAnnualIncome(String annualIncome)
	{
		log.info("Enter annual income");
		waitForElementToBeVisible(annualIncomeTextBox).sendKeys(annualIncome);
	}

	public void enterMonthlyTransactionNumber(String monthlyTransactionNumber)
	{
		log.info("Enter annual income");
		waitForElementToBeVisible(monthlyTransactionNumberTextBox).sendKeys(monthlyTransactionNumber);
	}

	public void enterMonthlyTransactionAmount(String monthlyTransactionAmount)
	{
		log.info("Enter annual income");
		waitForElementToBeVisible(monthlyTransactionAmountTextBox).sendKeys(monthlyTransactionAmount);
	}

	public void clickOnExchangeTnCLink()
	{
		log.info("Click on exchange TnC link");
		waitForElementToBeVisible(exchangeTnCLink).click();
	}

	public void clickOnExchangeTnCBackButton()
	{
		log.info("Click on exchange TnC back button");
		waitForElementToBeVisible(exchangeTnCBackButton).click();
	}

	public void clickOnExchangePrivacyPolicyLink()
	{
		log.info("Click on exchange privacy policy link");
		waitForElementToBeVisible(exchangePrivacyPolicyLink).click();
	}

	public void clickOnExchangePrivacyPolicyBackButton()
	{
		log.info("Click on exchange privacy policy back button");
		waitForElementToBeVisible(exchangePrivacyPolicyBackButton).click();
	}

	public void clickOnHuruMyDetailsLink()
	{
		log.info("Click on huru my details link");
		waitForElementToBeVisible(huruMyDetailsLink).click();
	}

	public void clickOnHuruMyDetailsModelContinueButton()
	{
		log.info("Click on huru my details continue button");
		waitForElementToBeVisible(huruMyDetailsModelContinueButton).click();
	}

}
