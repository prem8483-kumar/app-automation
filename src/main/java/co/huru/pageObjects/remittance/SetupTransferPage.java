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

	private final By transferTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_text");
	private final By cashPickupTab = AppiumBy.xpath("//android.widget.TextView[@text=\"Cash Pickup\"]");
	private final By walletTab = AppiumBy.xpath("//android.widget.TextView[@text=\"Wallet\"]");
	private final By comingSoonBanner = AppiumBy.xpath("//android.widget.TextView[@text=\"Coming soon\"]");

	private final By exchangeIcon = AppiumBy.accessibilityId("exchange_icon");
	private final By receiverAmountTextBox = AppiumBy.xpath("//android.widget.EditText[1]");

	private final By senderAmountTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By minimumAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Min single transaction amount AED 50\"]");
	private final By maximumAmountError = AppiumBy.xpath("//android.widget.TextView[@text=\"Max single transaction amount AED 15000\"]");

	private final By receiverCountryDropdown = AppiumBy.accessibilityId("receiver_country_dropdown_icon");
	private final By selectIndia = AppiumBy.xpath("//android.widget.TextView[@text=\"INR (Indian Rupee)\"]");
	private final By selectPakistan = AppiumBy.xpath("//android.widget.TextView[@text=\"PKR (Pakistani Rupee)\"]");

	private final By selectLuluExchange = AppiumBy.xpath("//android.widget.TextView[@text=\"LuLu Exchange\"]");
	private final By selectGccExchange = AppiumBy.xpath("//android.widget.TextView[@text=\"GCC\"]");
	private final By selectFirstExchange = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]");

	private final By exchangeQuoteBreakup = AppiumBy.xpath("//android.widget.TextView[@text=\"Quote breakdown\"]");
	private final By exchangeFeeInfoIcon = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View[1]");

	private final By selectFamilySupportPurposeOfTransaction = AppiumBy.xpath("//android.widget.TextView[@text=\"Family support\"]");
	private final By selectSavingsPurposeOfTransaction = AppiumBy.xpath("(//android.widget.TextView[@text=\"Savings\"])[1]");

	private final By selectSalarySourceFund = AppiumBy.xpath("//android.widget.TextView[@text=\"Salary\"]");
	private final By selectSavingsSourceFund = AppiumBy.xpath("(//android.widget.TextView[@text=\"Savings\"])[2]");

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
		waitForElementToBeVisible(exchangeIcon).click();
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

	public void validateMinimumAmountError()
	{
		log.info("Validate minimum amount error");
		waitForElementToBeVisible(minimumAmountError);
	}

	public void validateMaximumAmountError()
	{
		log.info("Validate maximum amount error");
		waitForElementToBeVisible(maximumAmountError);
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
		waitForElementToBeVisible(selectFirstExchange).click();
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

	public void selectExchangeAndContinueToRecipientScreen(String exchange)
	{
		log.info("Select exchange");

		if (exchange.equalsIgnoreCase("LuLu")) {
			waitForElementToBeVisible(selectLuluExchange).click();
		} else if (exchange.equalsIgnoreCase("GCC")){
			waitForElementToBeVisible(selectGccExchange).click();
		}

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
		//ToDo: Sometimes all exchanges does not load
		//selectExchange(exchange);
		selectAvailableExchange();
		clickOnContinue();
		selectTransactionPurpose(purpose);
		selectFundSource(fundSource);
		clickOnContinue();
	}
}
