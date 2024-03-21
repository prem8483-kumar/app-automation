package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class SelectPaymentPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SelectPaymentPage.class);

	public SelectPaymentPage(AndroidDriver driver)
	{
		super(driver);
		verifyScreenHeader();
	}

	private final By header = AppiumBy.xpath("//android.widget.TextView[@text=\"Select payment method\"]");
	private final By backButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");
	private final By continueButton = AppiumBy.xpath("//android.widget.Button");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");

	private final By totalToPayDetailsCta = AppiumBy.accessibilityId("id_total_to_pay_display_cta");
	private final By knowAboutFeeCta = AppiumBy.accessibilityId("id_payment_breakdown_know_about_fee_cta");

	private final By useCashbackBalanceButton = AppiumBy.accessibilityId("id_cashback_toggle_button");
	private final By addPromoCodeCta = AppiumBy.accessibilityId("id_promo_code_add_cta");
	private final By addPromoCodeTextBox = AppiumBy.xpath("//android.widget.EditText");
	private final By addPromoCodeButton = AppiumBy.xpath("//android.widget.TextView[@text=\"Add promo code\"]");

	private final By addPaymentMethodCta = AppiumBy.xpath("(//android.widget.TextView[@text=\"Add\"])[1]");
	private final By addFirstBankAccountCta = AppiumBy.xpath("//android.widget.TextView[@text=\"Add\"]");

	private final By changePaymentMethodCta = AppiumBy.accessibilityId("id_payment_method_change_cta");
	private final By paymentMethodsModelHeader = AppiumBy.xpath("//android.widget.TextView[@text=\"Payment method\"]");
	private final By addBankAccountCta = AppiumBy.accessibilityId("id_payment_method_add_cta");

	private final By firstBankAccount = AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"id_change_payment_method_bank_name\"])[1]");

	private final By payButton = AppiumBy.accessibilityId("id_huru_button_text");

	public void verifyScreenHeader()
	{
		log.info("Verify screen header");
		assertEquals(waitForElementToBeVisible(header).getText(), AppConstant.SELECT_PAYMENT_SCREEN_HEADER);
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

	public void clickOnPayButton()
	{
		log.info("Click on pay");
		waitForElementToBeVisible(payButton).click();
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

	public void clickOnChangePaymentMethod()
	{
		log.info("Click on change payment method");
		waitForElementToBeVisible(changePaymentMethodCta).click();
	}

	public void clickOnAddPaymentMethod()
	{
		log.info("Click on add payment method");
		waitForElementToBeVisible(addPaymentMethodCta).click();
	}

	public void verifyPaymentMethodsModelHeader()
	{
		log.info("Verify payment methods model");
		assertEquals(waitForElementToBeVisible(paymentMethodsModelHeader).getText(), AppConstant.PAYMENT_METHOD_MODEL_HEADER);
	}

	public void selectFirstBankAccount()
	{
		log.info("Select first bank account");
		clickOnChangePaymentMethod();
		clickOnFirstBankAccount();
	}

	public void clickOnFirstBankAccount()
	{
		log.info("Click on first bank account");
		waitForElementToBeVisible(firstBankAccount).click();
	}

	public void clickOnAddBankAccount()
	{
		log.info("Click on add bank account");
		waitForElementToBeVisible(addBankAccountCta).click();
	}

	public void clickOnAddFirstBankAccount()
	{
		log.info("Click on add first bank account");
		waitForElementToBeVisible(addFirstBankAccountCta).click();
	}

}
