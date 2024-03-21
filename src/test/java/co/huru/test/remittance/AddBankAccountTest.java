package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.dataObjects.BankAccount;
import co.huru.dataObjects.Profile;
import co.huru.dataObjects.Recipient;
import co.huru.dataObjects.TestData;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.*;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.pageObjects.signIn.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import co.huru.utils.DataGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class AddBankAccountTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(AddBankAccountTest.class);

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void signUpAndAddBankAccountTest(String testDataFile) {

        log.info("Add Bank Account Test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp(DataGenerator.generateRandomMobileNumber(), "123456", DataGenerator.generateRandomPin(), DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        Recipient recipient = testData.getUser().getRecipients().get(0);
        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.addRecipient(recipient.getFirstName(), recipient.getLastName(), recipient.getMobileNumber(), recipient.getNickName(), recipient.getRelationship(),
                recipient.getBankAccount().getAccountNumber(), recipient.getBankAccount().getIfscCode(),
                recipient.getAddress().getAddress(), recipient.getAddress().getCity());

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(driver);
        selectPaymentPage.clickOnAddPaymentMethod();
        selectPaymentPage.clickOnAddFirstBankAccount();

        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.addBankAccount(bankAccount.getUserName(), bankAccount.getPassword(), bankAccount.getOtp());

        selectPaymentPage.verifyPaymentMethodsModelHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void addBankAccountTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);

        addBankAccountPage.verifyScreenHeader();
        addBankAccountPage.addBankAccount(bankAccount.getUserName(), bankAccount.getPassword(), bankAccount.getOtp());

        selectPaymentPage.verifyPaymentMethodsModelHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountWithInvalidCredentialsData", dataProviderClass = SendMoneyDataProvider.class)
    public void addBankAccountWithInvalidCredentialsTest(String testDataFile, String userName, String password) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.connectToLeanMockBank();
        addBankAccountPage.clickOnLogin();
        addBankAccountPage.verifyUserNameError();
        addBankAccountPage.verifyPasswordError();

        addBankAccountPage.enterUserName(userName);
        addBankAccountPage.enterPassword(password);
        addBankAccountPage.clickOnLogin();
        addBankAccountPage.verifyBankAccountNotFoundError();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountWithInvalidOtpData", dataProviderClass = SendMoneyDataProvider.class)
    public void addBankAccountWithInvalidOtpTest(String testDataFile, String otp) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);

        addBankAccountPage.connectToLeanMockBank();
        addBankAccountPage.enterUserName(bankAccount.getUserName());
        addBankAccountPage.enterPassword(bankAccount.getPassword());
        addBankAccountPage.clickOnLogin();

        addBankAccountPage.enterOtp(otp);
        addBankAccountPage.clickOnSubmitOtp();
        addBankAccountPage.verifyOtpError();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void closeAddBankAccountSetupScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.clickOnChoseYourBank();
        addBankAccountPage.clickOnLeanMockBank();

        addBankAccountPage.clickOnContinueToBankAccountLoginButton();
        addBankAccountPage.clickOnBankAccountLoginScreenBackButton();

        addBankAccountPage.clickOnBankAccountSetupScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyBackToConnectButton();

        addBankAccountPage.clickOnBankAccountSetupScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyConfirmAndCloseButton();

        addBankAccountPage.verifySelectBankScreenHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void closeAddBankAccountLoginScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.connectToLeanMockBank();

        addBankAccountPage.clickOnBankAccountLoginScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyBackToConnectButton();

        addBankAccountPage.clickOnBankAccountLoginScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyConfirmAndCloseButton();

        addBankAccountPage.verifySelectBankScreenHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void closeAddBankAccountOtpScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.connectToLeanMockBank();
        addBankAccountPage.enterUserName(bankAccount.getUserName());
        addBankAccountPage.enterPassword(bankAccount.getPassword());
        addBankAccountPage.clickOnLogin();

        addBankAccountPage.clickOnBankAccountOtpScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyBackToConnectButton();

        addBankAccountPage.clickOnBankAccountOtpScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyConfirmAndCloseButton();

        addBankAccountPage.verifySelectBankScreenHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void navigateBackFromAddBankAccountSetupScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.clickOnChoseYourBank();
        addBankAccountPage.clickOnLeanMockBank();

        addBankAccountPage.clickDeviceBackButton();
        addBankAccountPage.verifySelectBankScreenHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void navigateBackFromAddBankAccountLoginScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.connectToLeanMockBank();

        addBankAccountPage.clickDeviceBackButton();
        addBankAccountPage.verifySelectBankScreenHeader();
    }


    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = SendMoneyDataProvider.class)
    public void navigateBackFromAddBankAccountOtpScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(driver);
        addBankAccountPage.connectToLeanMockBank();
        addBankAccountPage.enterUserName(bankAccount.getUserName());
        addBankAccountPage.enterPassword(bankAccount.getPassword());
        addBankAccountPage.clickOnLogin();

        addBankAccountPage.clickDeviceBackButton();
        addBankAccountPage.verifySelectBankScreenHeader();
    }

}
