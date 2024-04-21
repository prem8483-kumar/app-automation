package co.huru.test.remittance;

import co.huru.dataObjects.Profile;
import co.huru.dataObjects.TestData;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.*;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class SendMoneyE2ETest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SendMoneyE2ETest.class);

    //ToDo
    //@Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "sendMoneyData", dataProviderClass = SendMoneyE2EDataProvider.class)
    public void sendMoneyTest(String testDataFile) {

        log.info("Send Money  E2E Test");

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
}
