package co.huru.test.remittance;

import co.huru.data.SelectPaymentMethodDataProvider;
import co.huru.dataObjects.Profile;
import co.huru.dataObjects.TestData;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.*;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class SelectPaymentMethodTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SelectPaymentMethodTest.class);

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "addPromoCodeData", dataProviderClass = SelectPaymentMethodDataProvider.class)
    public void addPromoCodeTest(Profile profile, String promoCode)  {


        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(driver);
        selectPaymentPage.addPromoCode(promoCode);
        selectPaymentPage.verifyScreenHeader();

    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "addPromoCodeData", dataProviderClass = SelectPaymentMethodDataProvider.class)
    public void removePromoCodeTest(Profile profile, String promoCode)  {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(driver);
        selectPaymentPage.addPromoCode(promoCode);
        selectPaymentPage.clickOnRemovePromoCodeCta();
        selectPaymentPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "invalidPromoCodeData", dataProviderClass = SelectPaymentMethodDataProvider.class)
    public void invalidPromoCodeTest(Profile profile, String invalidPromoCode)  {

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(driver);
        selectPaymentPage.addPromoCode(invalidPromoCode);
        selectPaymentPage.verifyInvalidPromoCodeError();
    }
}
