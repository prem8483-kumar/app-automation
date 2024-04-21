package co.huru.pageObjects.remittance;

import co.huru.constants.AppConstant;
import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import static org.testng.Assert.assertEquals;

public class SelectPaymentPage {

	private static final Logger log = LogManager.getLogger(SelectPaymentPage.class);
	private AndroidDriver driver;

	public SelectPaymentPage(AndroidDriver driver)
	{
		this.driver = driver;
	}

	public AndroidActions getAndroidActions() {
		return new AndroidActions();
	}

	private final By header = AppiumBy.accessibilityId("id_screen_title");
	private final By continueButton = AppiumBy.accessibilityId("id_huru_button_text");
	private final By closeScreen = AppiumBy.accessibilityId("Close sheet");
	private final By backButton = AppiumBy.accessibilityId("huru_back_button");

	private final By totalToPayDetailsCta = AppiumBy.accessibilityId("id_total_to_pay_display_cta");
	private final By knowAboutFeeCta = AppiumBy.accessibilityId("id_payment_breakdown_know_about_fee_cta");

	private final By useCashbackBalanceButton = AppiumBy.accessibilityId("id_cashback_toggle_button");

	private final By addPromoCodeCta = AppiumBy.accessibilityId("id_promo_code_add_cta");
	private final By addPromoCodeTextBox = AppiumBy.xpath("//android.widget.EditText");
	private final By addPromoCodeButton = AppiumBy.accessibilityId("huru_progress_button_text");

	private final By removePromoCodeCta = AppiumBy.accessibilityId("id_promo_code_remove_cta");

	private final By invalidPromoCodeError = AppiumBy.xpath("//android.widget.TextView[@text=\"Promocode is not valid. Please try another code\"]");

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
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,header).getText(), AppConstant.SELECT_PAYMENT_SCREEN_HEADER);
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

	public void clickOnPayButton()
	{
		log.info("Click on pay");
		getAndroidActions().waitForElementToBeVisible(driver,payButton).click();
	}

	public void clickOnAddPromoCodeCta()
	{
		log.info("Click on add promo code");
		getAndroidActions().waitForElementToBeVisible(driver,addPromoCodeCta).click();
	}

	public void enterPromoCode(String promoCode)
	{
		log.info("Enter promo code");
		getAndroidActions().waitForElementToBeVisible(driver,addPromoCodeTextBox).sendKeys(promoCode);
	}

	public void clickOnAddPromoCodeButton()
	{
		log.info("Click on  add promo code button");
		getAndroidActions().waitForElementToBeVisible(driver,addPromoCodeButton).click();
	}

	public void clickOnRemovePromoCodeCta()
	{
		log.info("Click on add promo code");
		getAndroidActions().waitForElementToBeVisible(driver,removePromoCodeCta).click();
	}

	public void verifyInvalidPromoCodeError()
	{
		log.info("Verify invalid promo code error");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,invalidPromoCodeError).getText(), AppConstant.INVALID_PROMO_CODE_ERROR_MESSAGE);
	}

	public void addPromoCode(String promoCode)
	{
		log.info("Add promo code");
		clickOnAddPromoCodeCta();
		enterPromoCode(promoCode);
		clickOnAddPromoCodeButton();
	}

	public void useCashbackBalance()
	{
		log.info("Use cashback balance");
		getAndroidActions().waitForElementToBeVisible(driver,useCashbackBalanceButton).click();
	}

	public void clickOnChangePaymentMethod()
	{
		log.info("Click on change payment method");
		getAndroidActions().waitForElementToBeVisible(driver,changePaymentMethodCta).click();
	}

	public void clickOnAddPaymentMethod()
	{
		log.info("Click on add payment method");
		getAndroidActions().waitForElementToBeVisible(driver,addPaymentMethodCta).click();
	}

	public void verifyPaymentMethodsModelHeader()
	{
		log.info("Verify payment methods model");
		assertEquals(getAndroidActions().waitForElementToBeVisible(driver,paymentMethodsModelHeader).getText(), AppConstant.PAYMENT_METHOD_MODEL_HEADER);
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
		getAndroidActions().waitForElementToBeVisible(driver,firstBankAccount).click();
	}

	public void clickOnAddBankAccount()
	{
		log.info("Click on add bank account");
		getAndroidActions().waitForElementToBeVisible(driver,addBankAccountCta).click();
	}

	public void clickOnAddFirstBankAccount()
	{
		log.info("Click on add first bank account");
		getAndroidActions().waitForElementToBeVisible(driver,addFirstBankAccountCta).click();
	}

}
