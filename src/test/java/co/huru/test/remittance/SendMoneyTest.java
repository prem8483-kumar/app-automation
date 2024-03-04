package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.dataObjects.ConfirmPayment;
import co.huru.dataObjects.FundTransfer;
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

public class SendMoneyTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SendMoneyTest.class);

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "sendMoneyData", dataProviderClass = SendMoneyDataProvider.class)
    public void sendMoneyTest(String testDataFile)  {

        log.info("Send Money Test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        FundTransfer fundTransfer = testData.getFundTransfers().get(0);
        setupTransferPage.setupTransfer(fundTransfer.getAmount(), fundTransfer.getReceiverCountry(), fundTransfer.getExchange(),
                fundTransfer.getTransferPurpose(), fundTransfer.getFundSource());

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(driver);
        selectPaymentPage.clickOnPayButton();

        PaymentPage paymentPage = new PaymentPage(driver);
        ConfirmPayment confirmPayment = testData.getFundTransfers().get(0).getConfirmPayment();
        paymentPage.confirmPayment(confirmPayment.getOtp());
    }
}
