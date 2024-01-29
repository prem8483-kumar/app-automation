package co.huru.test;

import co.huru.data.SendMoneyDataProvider;
import co.huru.pageObjects.HomePage;
import co.huru.pageObjects.ProfilePage;
import co.huru.pageObjects.SendMoneyPage;
import co.huru.pageObjects.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SendMoneyTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SendMoneyTest.class);

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


    @Test(groups = {"Send Money"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = SendMoneyDataProvider.class)
    public void addRecipientTest(String phoneNumber, String passcode, String otp,
                                 String firstName, String lastName, String mobileNumber, String nickName,
                                 String accountNumber, String ifscCode,
                                 String address, String city)  {

        log.info("Add Recipient Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SendMoneyPage sendMoneyPage = new SendMoneyPage(driver);
        sendMoneyPage.selectExchange("LuLu");
        sendMoneyPage.clickOnContinue();
        sendMoneyPage.clickOnContinue();

        sendMoneyPage.addRecipient(firstName, lastName, mobileNumber, nickName, accountNumber, ifscCode, address, city);
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

    @Test(groups = {"Send Money"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void addBankAccountAsPaymentMethod(String phoneNumber, String passcode, String otp,
                                              String bankUserName, String bankPassword, String bankOtp)  {

        log.info("Add bank account as payment method test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SendMoneyPage sendMoneyPage = new SendMoneyPage(driver);
        sendMoneyPage.addPaymentMethod();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPaymentMethodsSection();
        profilePage.addBankAccount(bankUserName, bankPassword, bankOtp);

    }


}
