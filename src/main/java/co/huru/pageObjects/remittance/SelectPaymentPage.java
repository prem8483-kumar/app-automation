package co.huru.pageObjects.remittance;

import co.huru.utils.AndroidActions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SelectPaymentPage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(SelectPaymentPage.class);

	public SelectPaymentPage(AndroidDriver driver)
	{
		super(driver);
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

	private final By changePaymentMethodCta = AppiumBy.xpath("//android.widget.TextView[@text=\"Change\"]");
	private final By firstBankAccount = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[1]");

	private final By addPaymentMethodCta = AppiumBy.xpath("(//android.widget.TextView[@text=\"Add\"])[1]");
	private final By addBankAccountLink = AppiumBy.xpath("//android.widget.TextView[@text=\"Add\"]");

	private final By payButton = AppiumBy.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.widget.Button");

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

	public void selectFirstBankAccount()
	{
		log.info("Select first bank account");
		waitForElementToBeVisible(firstBankAccount).click();
	}

	public void clickOnAddPaymentMethod()
	{
		log.info("Click on add payment method");
		waitForElementToBeVisible(addPaymentMethodCta).click();
	}

	public void clickOnAddBankAccount()
	{
		log.info("Click on add bank account");
		waitForElementToBeVisible(addBankAccountLink).click();
	}

	public void clickOnPayButton()
	{
		log.info("Click on pay");
		waitForElementToBeVisible(payButton).click();
	}
}
