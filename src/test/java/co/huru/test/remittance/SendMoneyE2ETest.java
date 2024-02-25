package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.pageObjects.HomePage;
import co.huru.pageObjects.SendMoneyPage;
import co.huru.pageObjects.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SendMoneyE2ETest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SendMoneyE2ETest.class);

    @Test(groups = {"Send Money"}, description = "Send Money", dataProvider = "sendMoneyData", dataProviderClass = SendMoneyDataProvider.class)
    public void sendMoneyFromExistingBankAccountToExistingRecipientTest(String phoneNumber, String passcode, String otp,
                                                 String amount, String receiverCountry, String exchange, String purpose, String fundSource,
                                                 String paymentNote, String paymentOtp)  {

        log.info("Send Money Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SendMoneyPage sendMoneyPage = new SendMoneyPage(driver);

        //ToDo: Issue
        //sendMoneyPage.enterAmountToSend(amount);
        sendMoneyPage.selectReceiverCountry(receiverCountry);
        sendMoneyPage.selectExchange(exchange);
        sendMoneyPage.clickOnContinue();
        sendMoneyPage.selectTransactionPurpose(purpose);
        sendMoneyPage.selectFundSource(fundSource);
        sendMoneyPage.clickOnContinue();
        sendMoneyPage.selectRecipient();

        sendMoneyPage.clickOnContinue();
        sendMoneyPage.clickOnContinue();
        //sendMoneyPage.clickOnContinue();

        sendMoneyPage.confirmPayment(paymentOtp);
        sendMoneyPage.clickOnContinue();
        sendMoneyPage.waitForSendMoneyPage();

    }

    @Test(groups = {"Send Money"}, description = "Send Money", dataProvider = "sendMoneyData", dataProviderClass = SendMoneyDataProvider.class)
    public void sendMoneyToNewRecipientTest(String phoneNumber, String passcode, String otp,
                                                 String amount, String receiverCountry, String exchange, String purpose, String fundSource,
                                                 String paymentNote, String paymentOtp)  {

        log.info("Send Money Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SendMoneyPage sendMoneyPage = new SendMoneyPage(driver);

        sendMoneyPage.enterAmountToSend(amount);
        sendMoneyPage.selectReceiverCountry(receiverCountry);
        sendMoneyPage.selectExchange(exchange);
        sendMoneyPage.selectTransactionPurpose(purpose);
        sendMoneyPage.selectFundSource(fundSource);
        sendMoneyPage.selectRecipient();

        sendMoneyPage.selectPaymentMethod();
        sendMoneyPage.reviewPaymentAndContinue(paymentNote);
        sendMoneyPage.confirmPayment(paymentOtp);
        sendMoneyPage.viewPaymentDetails();
    }
}
