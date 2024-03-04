package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.dataObjects.BankAccount;
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

public class AddBankAccountTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(AddBankAccountTest.class);

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void addBankAccountTest(String testDataFile) {

        log.info("Add Recipient Test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectExchangeAndContinueToRecipientScreen("LuLu");

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(driver);
        selectPaymentPage.clickOnAddPaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);
        addBankAccountPage.addBankAccount(bankAccount.getUserName(), bankAccount.getPassword(), bankAccount.getOtp());

    }
}
