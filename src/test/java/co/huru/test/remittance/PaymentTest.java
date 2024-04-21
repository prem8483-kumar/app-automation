package co.huru.test.remittance;

import co.huru.data.remittance.PaymentDataProvider;
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

public class PaymentTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(PaymentTest.class);

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void confirmPaymentTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.verifyScreenHeader();
        paymentPage.clickOnConfirmPayment();
        paymentPage.enterOtp(testData.getFundTransfers().get(0).getConfirmPayment().getOtp());
        paymentPage.clickOnSubmitOtp();
        paymentPage.clickOnDone();
        paymentPage.clickOnViewPaymentDetails();

        TransactionsPage transactionsPage = new TransactionsPage(getDriver());
        transactionsPage.verifyScreenHeader();

    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentInvalidOtpData", dataProviderClass = PaymentDataProvider.class)
    public void confirmPaymentOtpErrorTest(String testDataFile, String otp)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.clickOnConfirmPayment();
        paymentPage.enterOtp(otp);
        paymentPage.clickOnSubmitOtp();
        paymentPage.verifyOtpError();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void closePaymentScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.clickOnClosePaymentScreen();

        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void closePaymentOtpScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.clickOnConfirmPayment();
        paymentPage.clickOnCloseOtpScreen();

        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void navigateBackFromPaymentScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.verifyScreenHeader();

        paymentPage.getAndroidActions().clickDeviceBackButton(getDriver());
        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void navigateBackFromPaymentOtpScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.clickOnConfirmPayment();

        paymentPage.getAndroidActions().clickDeviceBackButton(getDriver());
        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void minimizeAndReopenAppOnPaymentScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.verifyScreenHeader();
        paymentPage.getAndroidActions().minimizeApp(getDriver(), 3);

        paymentPage.clickOnConfirmPayment();
        paymentPage.enterOtp(testData.getFundTransfers().get(0).getConfirmPayment().getOtp());
        paymentPage.clickOnSubmitOtp();
        paymentPage.clickOnDone();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void minimizeAndReopenAppOnPaymentOtpScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.clickOnConfirmPayment();
        paymentPage.getAndroidActions().minimizeApp(getDriver(), 3);

        paymentPage.enterOtp(testData.getFundTransfers().get(0).getConfirmPayment().getOtp());
        paymentPage.clickOnSubmitOtp();
        paymentPage.clickOnDone();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void killAndRelaunchAppOnPaymentScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.verifyScreenHeader();

        paymentPage.getAndroidActions().killAndRestartApp(getDriver());

        signInPage.verifyPinScreen();
        signInPage.enterPin(profile.getPin());
        homePage.waitForHomePage();

    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = PaymentDataProvider.class)
    public void killAndRelaunchAppOnPaymentOtpScreenTest(String testDataFile)  {

        log.info("Payment test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(getDriver());
        paymentPage.clickOnConfirmPayment();
        paymentPage.waitForOtpTextBox();

        paymentPage.getAndroidActions().killAndRestartApp(getDriver());

        signInPage.verifyPinScreen();
        signInPage.enterPin(profile.getPin());
        homePage.waitForHomePage();

    }
}
