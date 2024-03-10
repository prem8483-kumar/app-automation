package co.huru.pageObjects.remittance;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertTrue;

public class SetupTransferPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SetupTransferPage.class);

	public SetupTransferPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.xpath("(//android.widget.TextView[@text=\"Send money\"])[1]");

	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	private final By transferTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_textBank Transfer");
	private final By cashPickupTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_textCash Pickup");
	private final By walletTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_textWallet");
	private final By comingSoonBanner = AppiumBy.xpath("//android.widget.TextView[@text=\"Coming soon\"]");

	private final By exchangeIcon = AppiumBy.accessibilityId("id_currency_field_reverse_arrow");
	private final By receiverAmountTextBox = AppiumBy.xpath("//android.widget.EditText[1]");

	private final By minimumIndiaReceiverAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid minimum receiving amount. It should be greater than: 1200\"]");
	private final By maximumIndiaReceiverAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid maximum receiving amount. It should be less than: 340000\"]");

	private final By minimumPakistanReceiverAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid minimum receiving amount. It should be greater than: 3800\"]");
	private final By maximumPakistanReceiverAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Invalid maximum receiving amount. It should be less than: 1140000\"]");

	private final By senderAmountTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By minimumSenderAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Min single transaction amount AED 50\"]");
	private final By maximumSenderAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Max single transaction amount AED 15000\"]");

	private final By receiverCountryDropdown = AppiumBy.accessibilityId("receiver_country_dropdown_icon");
	private final By selectIndia = AppiumBy.accessibilityId("id_receiver_currency_rowINR (Indian Rupee)");
	private final By selectPakistan = AppiumBy.accessibilityId("id_receiver_currency_rowPKR (Pakistani Rupee)");

	private final By selectLuluExchange = AppiumBy.accessibilityId("id_eh_rp_nameLuLu Exchange");
	private final By selectGccExchange = AppiumBy.xpath("id_eh_rp_nameGCC");
	private final By firstExchange = AppiumBy.accessibilityId("id_eh_details_row0");

	private final By exchangeQuoteBreakup = AppiumBy.accessibilityId("id_quote_breakup_cta");
	private final By exchangeFeeInfoIcon = AppiumBy.xpath("//android.view.View[@content-desc=\"id_quote_breakdown_exchange_house_fee_row\"]/android.view.View");

	private final By selectFamilySupportPurposeOfTransaction = AppiumBy.accessibilityId("id_radio_button_rowPurpose of transactionFamily support");
	private final By selectSavingsPurposeOfTransaction = AppiumBy.accessibilityId("id_radio_button_rowPurpose of transactionSavings");

	private final By selectSalarySourceFund = AppiumBy.accessibilityId("id_radio_button_rowSource of fundSalary");
	private final By selectSavingsSourceFund = AppiumBy.accessibilityId("id_radio_button_rowSource of fundSavings");

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

	public void clickOnTransferTab()
	{
		log.info("Click on transfer tab");
		waitForElementToBeVisible(transferTab).click();
	}

	public void clickOnCashPickupTab()
	{
		log.info("Click on cash pickup tab");
		waitForElementToBeVisible(cashPickupTab).click();
	}

	public void clickOnWalletTab()
	{
		log.info("Click on wallet tab");
		waitForElementToBeVisible(walletTab).click();
	}

	public void verifyComingSoonBanner()
	{
		log.info("Verify coming soon banner");
		waitForElementToBeVisible(comingSoonBanner);
	}

	public void validateContinueButtonNotVisible()
	{
		log.info("Validate continue button not visible");
		assertTrue(elementNotVisible(continueButton));
	}

	public void closeScreen()
	{
		log.info("Close screen");
		waitForElementToBeVisible(closeScreen).click();
	}

	public void clickOnExchangeIcon()
	{
		log.info("Click on exchange icon");

		waitForExchangeToBeAvailable();
		waitForElementToBeClickable(exchangeIcon).click();
	}

	public void waitForExchangeToBeAvailable()
	{
		log.info("Wait for exchange to be available");
		waitForElementToBeVisible(firstExchange);
	}

	public void enterSenderAmount(String amount)
	{
		log.info("Enter sender amount");
		waitForElementToBeVisible(senderAmountTextBox).clear();
		waitForElementToBeVisible(senderAmountTextBox).sendKeys(amount);
	}

	public void enterReceiverAmount(String amount)
	{
		log.info("Enter receiver amount");
		waitForElementToBeVisible(receiverAmountTextBox).clear();
		waitForElementToBeVisible(receiverAmountTextBox).sendKeys(amount);
	}

	public void validateSenderMinimumAmountError()
	{
		log.info("Validate minimum amount error");
		waitForElementToBeVisible(minimumSenderAmountError);
	}

	public void validateSenderMaximumAmountError()
	{
		log.info("Validate maximum amount error");
		waitForElementToBeVisible(maximumSenderAmountError);
	}

	public void validateIndiaReceiverMinimumAmountError()
	{
		log.info("Validate minimum amount error");
		waitForElementToBeVisible(minimumIndiaReceiverAmountError);
	}

	public void validateIndiaReceiverMaximumAmountError()
	{
		log.info("Validate maximum amount error");
		waitForElementToBeVisible(maximumIndiaReceiverAmountError);
	}

	public void validatePakistanReceiverMinimumAmountError()
	{
		log.info("Validate minimum amount error");
		waitForElementToBeVisible(minimumPakistanReceiverAmountError);
	}

	public void validatePakistanReceiverMaximumAmountError()
	{
		log.info("Validate maximum amount error");
		waitForElementToBeVisible(maximumPakistanReceiverAmountError);
	}


	public void selectReceiverCountry(String country)
	{
		log.info("Select receiver country");
		waitForElementToBeVisible(receiverCountryDropdown).click();

        if (country.equalsIgnoreCase("India")) {
            waitForElementToBeVisible(selectIndia).click();
        } else if (country.equalsIgnoreCase("Pakistan")){
            waitForElementToBeVisible(selectPakistan).click();
        }
    }

	public void selectAvailableExchange()
	{
		log.info("Select first available exchange");
		waitForElementToBeClickable(firstExchange).click();
	}

	public void clickOnExchangeBreakup()
	{
		log.info("Click on exchange breakup");
		waitForElementToBeVisible(exchangeQuoteBreakup).click();
	}

	public void clickOnExchangeFeeInfoIcon()
	{
		log.info("Click on exchange fee info icon");
		waitForElementToBeVisible(exchangeFeeInfoIcon).click();
	}

	public void selectExchange(String exchange)
	{
		log.info("Select exchange");

		if (exchange.equalsIgnoreCase("LuLu")) {
			waitForElementToBeVisible(selectLuluExchange).click();
		} else if (exchange.equalsIgnoreCase("GCC")){
			waitForElementToBeVisible(selectGccExchange).click();
		}
	}

	public void selectAvailableExchangeAndContinue()
	{
		log.info("Select exchange");
		selectAvailableExchange();

		clickOnContinue();
		clickOnContinue();
	}


	public void selectTransactionPurposeAndFundSource(String purpose, String fundSource)
	{
		selectTransactionPurpose(purpose);
		selectFundSource(fundSource);
		clickOnContinue();

	}
	public void selectTransactionPurpose(String purpose)
	{
		log.info("Select purpose of transaction");
		if (purpose.equalsIgnoreCase("Family support")) {
			waitForElementToBeVisible(selectFamilySupportPurposeOfTransaction).click();
		} else if (purpose.equalsIgnoreCase("Savings")){
			waitForElementToBeVisible(selectSavingsPurposeOfTransaction).click();
		}
	}

	public void selectFundSource(String fundSource)
	{
		log.info("Select source of fund");
		if (fundSource.equalsIgnoreCase("Salary")) {
			waitForElementToBeVisible(selectSalarySourceFund).click();
		} else if (fundSource.equalsIgnoreCase("Savings")){
			waitForElementToBeVisible(selectSavingsSourceFund).click();
		}
	}

	public void verifyFamilySupportPurposeSelected()
	{
		log.info("Check family support purpose selected");
		assertTrue(waitForElementToBeVisible(selectFamilySupportPurposeOfTransaction).isSelected());
	}

	public void verifySalarySourceSelected()
	{
		log.info("Check salary source selected");
		assertTrue(waitForElementToBeVisible(selectSalarySourceFund).isSelected());
	}

	public void setupTransfer(String amount, String receiverCountry, String exchange, String purpose, String fundSource)
	{
		log.info("Setup transfer");
		enterSenderAmount(amount);
		selectReceiverCountry(receiverCountry);
		selectAvailableExchange();
		clickOnContinue();
		selectTransactionPurpose(purpose);
		selectFundSource(fundSource);
		clickOnContinue();
	}
}
