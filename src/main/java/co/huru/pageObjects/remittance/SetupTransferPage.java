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

public class SetupTransferPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SetupTransferPage.class);

	public SetupTransferPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	private final By transferTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_textBank Transfer");
	private final By cashPickupTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_textCash Pickup");
	private final By walletTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_textWallet");
	private final By comingSoonBanner = AppiumBy.xpath("//android.widget.TextView[@text=\"Coming soon\"]");

	private final By exchangeIcon = AppiumBy.accessibilityId("id_currency_field_reverse_arrow");
	private final By receiverAmountTextBox = AppiumBy.xpath("//android.widget.EditText[1]");

	private final By minimumIndiaReceiverAmountError = AppiumBy.accessibilityId("id_error_msg_title");
	private final By maximumIndiaReceiverAmountError = AppiumBy.accessibilityId("id_error_msg_title");

	private final By minimumPakistanReceiverAmountError = AppiumBy.accessibilityId("id_error_msg_title");
	private final By maximumPakistanReceiverAmountError = AppiumBy.accessibilityId("id_error_msg_title");

	private final By senderAmountTextBox = AppiumBy.xpath("//android.widget.EditText[1]");

	private final By minimumSenderAmountError = AppiumBy.accessibilityId("id_error_msg_title");
	private final By maximumSenderAmountError = AppiumBy.accessibilityId("id_error_msg_title");

	private final By receiverCountryDropdown = AppiumBy.accessibilityId("receiver_country_dropdown_icon");
	private final By selectIndia = AppiumBy.accessibilityId("id_receiver_currency_rowINR (Indian Rupee)");
	private final By selectPakistan = AppiumBy.accessibilityId("id_receiver_currency_rowPKR (Pakistani Rupee)");

	private final By selectLuluExchange = AppiumBy.accessibilityId("id_eh_rp_nameLuLu Exchange");
	private final By selectGccExchange = AppiumBy.accessibilityId("id_eh_rp_nameGCC");
	private final By firstExchange = AppiumBy.accessibilityId("id_eh_details_row0");

	//ToDO: No id or reliable xpath
//	private final By exchangeImage = AppiumBy.accessibilityId("");
//	private final By exchangeName = AppiumBy.accessibilityId("");
//	private final By exchangeTransferTimeEstimate = AppiumBy.accessibilityId("");
//	private final By exchangeStatusVerified = AppiumBy.accessibilityId("");
//	private final By exchangeAmount = AppiumBy.accessibilityId("");

	private final By exchangeQuoteBreakdown = AppiumBy.accessibilityId("id_quote_breakup_cta");
	private final By quoteBreakdownModelHeader = AppiumBy.xpath("//android.widget.TextView[@text=\"Quote breakdown\"]");

	private final By quoteBreakdownYouSendValue = AppiumBy.accessibilityId("id_quote_breakdown_you_send_value");
	private final By quoteBreakdownExchangeRateValue = AppiumBy.accessibilityId("id_quote_breakdown_exchange_rate_value");
	private final By quoteBreakdownTheyReceiveValue = AppiumBy.accessibilityId("id_quote_breakdown_they_receive_value");
	private final By quoteBreakdownExchangeHouseFeeValue = AppiumBy.accessibilityId("id_quote_breakdown_exchange_house_fee_value");
	private final By quoteBreakdownEstimateTransferTimeValue = AppiumBy.accessibilityId("id_quote_breakdown_estimate_transfer_time_value");

	private final By selectFamilySupportPurposeOfTransaction = AppiumBy.accessibilityId("id_radio_button_rowPurpose of transactionFamily support");
	private final By selectSavingsPurposeOfTransaction = AppiumBy.accessibilityId("id_radio_button_rowPurpose of transactionSavings");

	private final By selectSalarySourceFund = AppiumBy.accessibilityId("id_radio_button_rowSource of fundSalary");
	private final By selectSavingsSourceFund = AppiumBy.accessibilityId("id_radio_button_rowSource of fundSavings");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(waitForElementToBeVisible(header).getText(), AppConstant.SETUP_TRANSFER_SCREEN_HEADER);
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
		waitForElementToBeClickable(walletTab).click();
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
		assertEquals(waitForElementToBeVisible(minimumSenderAmountError).getText(), AppConstant.MINIMUM_SENDER_AMOUNT_ERROR_MESSAGE);
	}

	public void validateSenderMaximumAmountError()
	{
		log.info("Validate maximum amount error");
		assertEquals(waitForElementToBeVisible(maximumSenderAmountError).getText(), AppConstant.MAXIMUM_SENDER_AMOUNT_ERROR_MESSAGE);
	}

	public void validateIndiaReceiverMinimumAmountError()
	{
		log.info("Validate minimum amount error");
		assertEquals(waitForElementToBeVisible(minimumIndiaReceiverAmountError).getText(), AppConstant.MINIMUM_INDIA_RECEIVER_AMOUNT_ERROR_MESSAGE);
	}

	public void validateIndiaReceiverMaximumAmountError()
	{
		log.info("Validate maximum amount error");
		assertEquals(waitForElementToBeVisible(maximumIndiaReceiverAmountError).getText(), AppConstant.MAXIMUM_INDIA_RECEIVER_AMOUNT_ERROR_MESSAGE);
	}

	public void validatePakistanReceiverMinimumAmountError()
	{
		log.info("Validate minimum amount error");
		assertEquals(waitForElementToBeVisible(minimumPakistanReceiverAmountError).getText(), AppConstant.MINIMUM_PAKISTAN_RECEIVER_AMOUNT_ERROR_MESSAGE);
	}

	public void validatePakistanReceiverMaximumAmountError()
	{
		log.info("Validate maximum amount error");
		assertEquals(waitForElementToBeVisible(maximumPakistanReceiverAmountError).getText(), AppConstant.MAXIMUM_PAKISTAN_RECEIVER_AMOUNT_ERROR_MESSAGE);
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

	public void clickOnExchangeQuoteBreakdown()
	{
		log.info("Click on exchange quote breakup");
		waitForElementToBeVisible(exchangeQuoteBreakdown).click();
	}

	public void verifyExchangeQuoteBreakdownModel()
	{
		log.info("Verify exchange quote breakdown model");
		assertEquals(waitForElementToBeVisible(quoteBreakdownModelHeader).getText(), AppConstant.EXCHANGE_QUOTE_BREAKDOWN_MODEL_HEADER);

		waitForElementToBeVisible(quoteBreakdownYouSendValue);
		waitForElementToBeVisible(quoteBreakdownExchangeRateValue);
		waitForElementToBeVisible(quoteBreakdownTheyReceiveValue);
		waitForElementToBeVisible(quoteBreakdownExchangeHouseFeeValue);
		waitForElementToBeVisible(quoteBreakdownEstimateTransferTimeValue);
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
