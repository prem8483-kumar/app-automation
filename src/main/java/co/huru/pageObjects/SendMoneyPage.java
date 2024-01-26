package co.huru.pageObjects;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SendMoneyPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SendMoneyPage.class);

	public SendMoneyPage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	private final By transferTab = AppiumBy.accessibilityId("id_mode_of_transfer_tab_text");
	private final By cashPickupTab = AppiumBy.xpath("//android.widget.TextView[@text=\"Cash Pickup\"]");
	private final By walletTab = AppiumBy.xpath("//android.widget.TextView[@text=\"Wallet\"]");

	//Send Money Details
	private final By amountTextBox = AppiumBy.xpath("//android.widget.EditText[1]");

	private final By receiverCountryDropdown = AppiumBy.accessibilityId("receiver_country_dropdown_icon");
	private final By selectIndia = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_receiver_currency_row_text\" and @text=\"INR (Indian Rupee)\"]");
	private final By selectPakistan = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_receiver_currency_row_text\" and @text=\"PKR (Pakistani Rupee)\"]");

	private final By selectLuluExchange = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_eh_rp_name\" and @text=\"LuLu Exchange\"]");
	private final By selectGccExchange = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_eh_rp_name\" and @text=\"GCC\"]");

	private final By selectFamilySupportPurposeOfTransaction = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_purpose_of_txn_radio_button_text\" and @text=\"Family support\"]");
	private final By selectSavingsPurposeOfTransaction = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_purpose_of_txn_radio_button_text\" and @text=\"Savings\"]");

	private final By selectSalarySourceFund = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_purpose_of_txn_radio_button_text\" and @text=\"Salary\"]");
	private final By selectSavingsSourceFund = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"id_purpose_of_txn_radio_button_text\" and @text=\"Savings\"]");

	//Add Recipient
	private final By addNewRecipient = AppiumBy.accessibilityId("id_add_new_recipient_row");
	private final By personalDetailsSection = AppiumBy.xpath("//android.widget.TextView[@text=\"Personal details\"]");
	private final By firstNameTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By lastNameTextBox = AppiumBy.xpath("//android.widget.EditText[2]");
	private final By mobileNumberTextBox = AppiumBy.xpath("//android.widget.EditText[3]");
	private final By selectRelationship = AppiumBy.xpath("//android.widget.EditText[4]");
	private final By selfAccount = AppiumBy.xpath("//android.widget.TextView[@text=\"Self account\"]");
	private final By father = AppiumBy.xpath("//android.widget.TextView[@text=\"Father\"]");
	private final By mother = AppiumBy.xpath("//android.widget.TextView[@text=\"Mother\"]");
	private final By spouse = AppiumBy.xpath("//android.widget.TextView[@text=\"Spouse\"]");
	private final By son = AppiumBy.xpath("//android.widget.TextView[@text=\"Son\"]");
	private final By daughter = AppiumBy.xpath("//android.widget.TextView[@text=\"Daughter\"]");
	private final By nickNameTextBox = AppiumBy.xpath("//android.widget.EditText[5]");

	private final By bankDetailsSection = AppiumBy.xpath("//android.widget.TextView[@text=\"Personal details\"]");
	private final By accountNumberTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By ifscCodeTextBox = AppiumBy.xpath("//android.widget.EditText[2]");

	private final By addressSection = AppiumBy.xpath("//android.widget.TextView[@text=\"Personal details\"]");
	private final By addressTextBox = AppiumBy.xpath("//android.widget.EditText[1]");
	private final By cityTextBox = AppiumBy.xpath("//android.widget.EditText[2]");

	//Select Recipient
	private final By selectFirstRecipient = AppiumBy.xpath("(//android.view.View[@content-desc=\"id_recipient_item_row\"])[1]");

	//Review/Change Payment
	private final By totalPaymentDetailsCta = AppiumBy.accessibilityId("id_total_to_pay_display_cta");
	private final By knowAboutFeesCta = AppiumBy.accessibilityId("id_payment_breakdown_know_about_fee_cta");
	private final By feeInfoIcon = AppiumBy.accessibilityId("id_review_screen_fee_info_icon");
	private final By noteTextBox = AppiumBy.xpath("//android.widget.EditText");
	private final By tncLink = AppiumBy.accessibilityId("id_review_screen_tnc_clickable_text");
	private final By tncBackButton = AppiumBy.xpath("//android.widget.Button");

	private final By useCashbackBalanceButton = AppiumBy.accessibilityId("id_cashback_toggle_button");

	private final By addPromoCodeCta = AppiumBy.accessibilityId("id_promo_code_add_cta");
	private final By addPromoCodeTextBox = AppiumBy.xpath("//android.widget.EditText");
	private final By addPromoCodeButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Add promo code\"]");

	//Add/Select payment
	private final By changePaymentMethodCta = AppiumBy.accessibilityId("id_payment_method_change_cta");
	private final By addPaymentMethodCta = AppiumBy.accessibilityId("id_payment_method_add_cta");

	//Do Payment
	private final By confirmPaymentButton = AppiumBy.id("BUTTON_ID__PAYMENT__SUBMIT");
	private final By cancelPaymentButton = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_PAYMENT_DETAILS\"]/android.view.View[1]/android.widget.Button");
	private final By otpTextBox = AppiumBy.id("genericMfa");
	private final By submitOtpButton = AppiumBy.id("BUTTON_ID__MFA__SUBMIT");
	private final By closeOtpScreen = AppiumBy.xpath("//android.view.View[@resource-id=\"STEP_MFA\"]/android.view.View[1]/android.widget.Button");
	private final By paymentDoneButton = AppiumBy.id("BUTTON_ID__SUCCESS__CLOSE");

	private final By viewPaymentDetailsLink = AppiumBy.id("//android.widget.TextView[@text=\"View details\"]");

	public void navigateBack()
	{
		log.info("Navigate back");
		waitForElementToBeVisible(backButton).click();
	}

	public void next()
	{
		log.info("Next/Continue");
		waitForElementToBeVisible(continueButton).click();
	}

	public void closeScreen()
	{
		log.info("Close screen");
		waitForElementToBeVisible(closeScreen).click();
	}

	public void enterAmountToSend(String amount)
	{
		log.info("Enter amount to send");
		waitForElementToBeVisible(amountTextBox).sendKeys(amount);
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

	public void selectExchange(String exchange)
	{
		log.info("Select exchange");

		if (exchange.equalsIgnoreCase("LuLu")) {
			waitForElementToBeVisible(selectLuluExchange).click();
		} else if (exchange.equalsIgnoreCase("GCC")){
			waitForElementToBeVisible(selectGccExchange).click();
		}
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

	public void addRecipient(String firstName, String lastName, String mobileNumber, String nickName,
							 String accountNumber, String ifscCode,
							 String address, String city)
	{
		log.info("Add recipient");
		waitForElementToBeVisible(addNewRecipient).click();

		waitForElementToBeVisible(personalDetailsSection).click();
		waitForElementToBeVisible(firstNameTextBox).sendKeys(firstName);
		waitForElementToBeVisible(lastNameTextBox).sendKeys(lastName);
		waitForElementToBeVisible(mobileNumberTextBox).sendKeys(mobileNumber);
		waitForElementToBeVisible(selectRelationship).click();
		waitForElementToBeVisible(selfAccount).click();
		waitForElementToBeVisible(nickNameTextBox).sendKeys(nickName);

		waitForElementToBeVisible(bankDetailsSection).click();
		waitForElementToBeVisible(accountNumberTextBox).sendKeys(accountNumber);
		waitForElementToBeVisible(ifscCodeTextBox).sendKeys(ifscCode);

		waitForElementToBeVisible(addressSection).click();
		waitForElementToBeVisible(addressTextBox).sendKeys(address);
		waitForElementToBeVisible(cityTextBox).sendKeys(city);

		waitForElementToBeVisible(continueButton).click();
	}

	public void selectRecipient()
	{
		log.info("Select recipient");
		waitForElementToBeVisible(selectFirstRecipient).click();
	}

	public void addPromoCode(String promoCode)
	{
		log.info("Add promo code");
		waitForElementToBeVisible(addPromoCodeCta).click();
		waitForElementToBeVisible(addPromoCodeTextBox).sendKeys(promoCode);
		waitForElementToBeVisible(addPromoCodeButton).click();
	}

	public void useCashbackBalance()
	{
		log.info("Use cashback balance");
		waitForElementToBeVisible(useCashbackBalanceButton).click();
	}

	public void selectPaymentMethod()
	{
		log.info("Select payment method");
		waitForElementToBeVisible(changePaymentMethodCta).click();
	}

	public void addPaymentMethod()
	{
		log.info("Add bank account");
		waitForElementToBeVisible(addPaymentMethodCta).click();
	}

	public void reviewPayment(String paymentNote)
	{
		log.info("Review payment");
		waitForElementToBeVisible(totalPaymentDetailsCta).click();
		waitForElementToBeVisible(knowAboutFeesCta).click();
		waitForElementToBeVisible(continueButton).click();

		waitForElementToBeVisible(feeInfoIcon).click();
		waitForElementToBeVisible(continueButton).click();

		waitForElementToBeVisible(tncLink).click();
		waitForElementToBeVisible(tncBackButton).click();

		waitForElementToBeVisible(noteTextBox).sendKeys(paymentNote);
		waitForElementToBeVisible(continueButton).click();
	}

	public void confirmPayment(String otp)
	{
		log.info("Confirm payment");
		waitForElementToBeVisible(confirmPaymentButton).click();
		waitForElementToBeVisible(otpTextBox).sendKeys(otp);
		waitForElementToBeVisible(submitOtpButton).click();
		waitForElementToBeVisible(paymentDoneButton).click();
	}

	public void cancelPayment()
	{
		log.info("Cancel payment");
	}

	public void viewPaymentDetails()
	{
		log.info("View payment details");
		waitForElementToBeVisible(viewPaymentDetailsLink).click();
		waitForElementToBeVisible(continueButton).click();

	}
}
