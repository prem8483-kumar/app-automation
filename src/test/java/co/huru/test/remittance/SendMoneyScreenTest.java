package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.pageObjects.HomePage;
import co.huru.pageObjects.SendMoneyPage;
import co.huru.pageObjects.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SendMoneyScreenTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SendMoneyScreenTest.class);

    @Test(groups = {"Send Money"}, description = "Send Money", dataProvider = "sendMoneyData", dataProviderClass = SendMoneyDataProvider.class)
    public void sendMoneyTest(String phoneNumber, String passcode, String otp,
                                                 String amount, String receiverCountry, String exchange, String purpose, String fundSource)  {

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
    }
}
