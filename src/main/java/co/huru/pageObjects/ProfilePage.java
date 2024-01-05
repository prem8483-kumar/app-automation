package co.huru.pageObjects;

import co.huru.utils.AndroidActions;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class ProfilePage extends AndroidActions {

	private static final Logger log = LogManager.getLogger(ProfilePage.class);

	public ProfilePage(AndroidDriver driver)
	{
		super(driver);
	}

	private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate up\"]");

	private final By homeTab = By.id("com.huru:id/homeFragment");
	private final By payBillsTab = By.id("com.huru:id/payBillsFragment");
	private final By sendMoneyTab = By.id("com.huru:id/transactionsFragment");
	private final By transactionsTab = By.id("com.huru:id/sendMoneyFragment");
	private final By profileTab = By.id("com.huru:id/accountFragment");

	private final By userAvatarImage = By.id("com.huru:id/userAvatar");
	private final By userNameText = By.id("com.huru:id/userName");
	private final By activateAccountButton = By.id("com.huru:id/activate_account");

	private final By personalDetailsSection = By.id("com.huru:id/personal_detail_section");
	private final By paymentMethodsSection = By.id("com.huru:id/payment_section");
	private final By cashbackRewardsSection = By.id("com.huru:id/cashback_section");
	private final By loginSettingsSection = By.id("com.huru:id/login_section");
	private final By termsAndConditionsSection = By.id("com.huru:id/others_section1");
	private final By privacyPolicySection = By.id("com.huru:id/others_section2");
	private final By helpAndSupportSection = By.id("com.huru:id/others_section3");
	private final By logoutSection = By.id("com.huru:id/logout_section");

	private final By appVersionText = By.id("com.huru:id/version");



	public void navigateBack()
	{
		log.info("Navigate back");
		waitForElementToBeVisible(backButton).click();
	}

}
