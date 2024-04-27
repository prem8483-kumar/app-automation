package co.huru.pageObjects.onboarding;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class CreateExchangeAccountPage {

	private static final Logger log = LogManager.getLogger(CreateExchangeAccountPage.class);
	private AndroidDriver driver;

	public CreateExchangeAccountPage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By backButton = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.Button");

	private final By tncScreenHeader = AppiumBy.accessibilityId("id_ob_tnc_screen_header");
	private final By tncScreenDesc = AppiumBy.accessibilityId("id_ob_tnc_screen_desc");

	private final By exchangeCheckbox = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[3]");

	//private final By exchangeTnCLink = AppiumBy.accessibilityId("");
	private final By exchangeTnCBackButton = AppiumBy.xpath("//android.widget.Button");
	//private final By exchangePrivacyPolicyLink = AppiumBy.accessibilityId("");
	private final By exchangePrivacyPolicyBackButton = AppiumBy.xpath("//android.widget.Button");

	private final By huruCheckbox = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[4]");

	//private final By huruMyDetailsLink = AppiumBy.accessibilityId("");
	private final By huruMyDetailsModelContinueButton = AppiumBy.accessibilityId("id_huru_button_text");

	private final By annualIncomeTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By monthlyTransactionNumberTextBox = AppiumBy.xpath("//android.widget.EditText[2]");
	private final By monthlyTransactionAmountTextBox = AppiumBy.xpath("//android.widget.EditText[3]");

	private final By createAccountButton = AppiumBy.accessibilityId("id_huru_button_text");

	private final By annualIncomeError = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_error_msg_title\" and @text=\"Please provide valid annual income\"]");
	private final By monthlyTransactionNumberError = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_error_msg_title\" and @text=\"How many transactions you expect to make each month\"]");
	private final By monthlyTransactionAmountError = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_error_msg_title\" and @text=\"Total amount you expect to send each month\"]");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,header).getText(), AppConstant.CREATE_ACCOUNT_SCREEN_HEADER);
	}

	public void verifyTncScreen()
	{
		log.info("Verify tnc screen");
		getAndroidActions().waitForElementToBeVisible(driver,tncScreenHeader).getText();
        getAndroidActions().waitForElementToBeVisible(driver,tncScreenDesc).getText();
	}

	public void navigateBack()
	{
		log.info("Navigate back");
		getAndroidActions().waitForElementToBeVisible(driver,backButton).click();
	}

	public void clickOnContinue()
	{
		log.info("Next/Continue");
		getAndroidActions().waitForElementToBeVisible(driver,continueButton).click();
	}

	public void closeScreen()
	{
		log.info("Close screen");
		getAndroidActions().waitForElementToBeVisible(driver,closeScreen).click();
	}

	public void clickOnExchangeCheckbox()
	{
		log.info("Click on exchange checkbox");
		getAndroidActions().waitForElementToBeVisible(driver,exchangeCheckbox).click();
	}

	public void clickOnHuruCheckbox()
	{
		log.info("Click on huru checkbox");
		getAndroidActions().waitForElementToBeVisible(driver,huruCheckbox).click();
	}

	public void enterAnnualIncome(String annualIncome)
	{
		log.info("Enter annual income");
		getAndroidActions().waitForElementToBeVisible(driver,annualIncomeTextBox).sendKeys(annualIncome);
	}

	public void enterMonthlyTransactionNumber(String monthlyTransactionNumber)
	{
		log.info("Enter annual income");
		getAndroidActions().waitForElementToBeVisible(driver,monthlyTransactionNumberTextBox).sendKeys(monthlyTransactionNumber);
	}

	public void enterMonthlyTransactionAmount(String monthlyTransactionAmount)
	{
		log.info("Enter annual income");
		getAndroidActions().waitForElementToBeVisible(driver,monthlyTransactionAmountTextBox).sendKeys(monthlyTransactionAmount);
	}

	public void clickOnCreateAccountButton()
	{
		log.info("Click on create account button");
		getAndroidActions().waitForElementToBeVisible(driver,createAccountButton).click();
	}

	public void verifyAnnualIncomeError()
	{
		log.info("Verify annual income error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver, annualIncomeError).getText(), AppConstant.ANNUAL_INCOME_ERROR_MESSAGE);
	}

	public void verifyMonthlyTransactionNumberError()
	{
		log.info("Verify monthly transaction number error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver, monthlyTransactionNumberError).getText(), AppConstant.MONTHLY_TRANSACTION_NUMBER_ERROR_MESSAGE);
	}

	public void verifyMonthlyTransactionAmountError()
	{
		log.info("Verify monthly transaction amount error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver, monthlyTransactionAmountError).getText(), AppConstant.MONTHLY_TRANSACTION_AMOUNT_ERROR_MESSAGE);
	}

	//ToDo: No locators available
//	public void clickOnExchangeTnCLink()
//	{
//		log.info("Click on exchange TnC link");
//		getAndroidActions().waitForElementToBeVisible(driver,exchangeTnCLink).click();
//	}
//
//	public void clickOnExchangeTnCBackButton()
//	{
//		log.info("Click on exchange TnC back button");
//		getAndroidActions().waitForElementToBeVisible(driver,exchangeTnCBackButton).click();
//	}
//
//	public void clickOnExchangePrivacyPolicyLink()
//	{
//		log.info("Click on exchange privacy policy link");
//		getAndroidActions().waitForElementToBeVisible(driver,exchangePrivacyPolicyLink).click();
//	}
//
//	public void clickOnExchangePrivacyPolicyBackButton()
//	{
//		log.info("Click on exchange privacy policy back button");
//		getAndroidActions().waitForElementToBeVisible(driver,exchangePrivacyPolicyBackButton).click();
//	}
//
//	public void clickOnHuruMyDetailsLink()
//	{
//		log.info("Click on huru my details link");
//		getAndroidActions().waitForElementToBeVisible(driver,huruMyDetailsLink).click();
//	}
//
//	public void clickOnHuruMyDetailsModelContinueButton()
//	{
//		log.info("Click on huru my details continue button");
//		getAndroidActions().waitForElementToBeVisible(driver,huruMyDetailsModelContinueButton).click();
//	}

}
