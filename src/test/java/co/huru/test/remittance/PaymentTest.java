package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.dataObjects.ConfirmPayment;
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

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = SendMoneyDataProvider.class)
    public void confirmPaymentTest(String testDataFile)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.verifyScreenHeader();
        paymentPage.clickOnConfirmPayment();
        paymentPage.enterOtp(testData.getFundTransfers().get(0).getConfirmPayment().getOtp());
        paymentPage.clickOnSubmitOtp();
        paymentPage.clickOnDone();
        paymentPage.clickOnViewPaymentDetails();

        TransactionsPage transactionsPage = new TransactionsPage(driver);
        transactionsPage.verifyScreenHeader();

    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentInvalidOtpData", dataProviderClass = SendMoneyDataProvider.class)
    public void confirmPaymentOtpErrorTest(String testDataFile, String otp)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickOnConfirmPayment();
        paymentPage.enterOtp(otp);
        paymentPage.clickOnSubmitOtp();
        paymentPage.verifyOtpError();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = SendMoneyDataProvider.class)
    public void closePaymentScreenTest(String testDataFile)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickOnClosePaymentScreen();

        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = SendMoneyDataProvider.class)
    public void closePaymentOtpScreenTest(String testDataFile)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickOnConfirmPayment();
        paymentPage.clickOnCloseOtpScreen();

        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = SendMoneyDataProvider.class)
    public void navigateBackFromPaymentScreenTest(String testDataFile)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.verifyScreenHeader();

        paymentPage.clickDeviceBackButton();
        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = SendMoneyDataProvider.class)
    public void navigateBackFromPaymentOtpScreenTest(String testDataFile)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickOnConfirmPayment();

        paymentPage.clickDeviceBackButton();
        paymentPage.verifyPaymentProcessModel();
        paymentPage.verifyPaymentPendingModel();
        paymentPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = SendMoneyDataProvider.class)
    public void minimizeAndReopenAppOnPaymentScreenTest(String testDataFile)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.verifyScreenHeader();
        paymentPage.minimizeApp(3);

        paymentPage.clickOnConfirmPayment();
        paymentPage.enterOtp(testData.getFundTransfers().get(0).getConfirmPayment().getOtp());
        paymentPage.clickOnSubmitOtp();
        paymentPage.clickOnDone();
    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "confirmPaymentData", dataProviderClass = SendMoneyDataProvider.class)
    public void minimizeAndReopenAppOnPaymentOtpScreenTest(String testDataFile)  {

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
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
        selectPaymentPage.selectFirstBankAccount();
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickOnConfirmPayment();
        paymentPage.minimizeApp(3);

        paymentPage.enterOtp(testData.getFundTransfers().get(0).getConfirmPayment().getOtp());
        paymentPage.clickOnSubmitOtp();
        paymentPage.clickOnDone();
    }
}
