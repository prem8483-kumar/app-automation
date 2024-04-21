package co.huru.test.remittance;

import co.huru.data.remittance.SelectPaymentMethodDataProvider;
import co.huru.dataObjects.Profile;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.*;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SelectPaymentMethodTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SelectPaymentMethodTest.class);

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "addPromoCodeData", dataProviderClass = SelectPaymentMethodDataProvider.class)
    public void addPromoCodeTest(Profile profile, String promoCode)  {

        log.info("Add promo code test");

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(getDriver());
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(getDriver());
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(getDriver());
        selectPaymentPage.addPromoCode(promoCode);
        selectPaymentPage.verifyScreenHeader();

    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "addPromoCodeData", dataProviderClass = SelectPaymentMethodDataProvider.class)
    public void removePromoCodeTest(Profile profile, String promoCode)  {

        log.info("Add promo code test");

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(getDriver());
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(getDriver());
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(getDriver());
        selectPaymentPage.addPromoCode(promoCode);
        selectPaymentPage.clickOnRemovePromoCodeCta();
        selectPaymentPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "invalidPromoCodeData", dataProviderClass = SelectPaymentMethodDataProvider.class)
    public void invalidPromoCodeTest(Profile profile, String invalidPromoCode)  {

        log.info("Add promo code test");

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(getDriver());
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(getDriver());
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(getDriver());
        selectPaymentPage.addPromoCode(invalidPromoCode);
        selectPaymentPage.verifyInvalidPromoCodeError();
    }
}
