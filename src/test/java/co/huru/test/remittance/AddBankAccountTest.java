package co.huru.test.remittance;
import co.huru.data.remittance.AddBankAccountDataProvider;
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

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void signUpAndAddBankAccountTest(String testDataFile) {

        log.info("Add Bank Account Test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignUpPage signUpPage = new SignUpPage(getDriver());
        String mobileNumber = DataGenerator.generateRandomMobileNumber();
        log.info(mobileNumber);
        signUpPage.signUp(mobileNumber, "123456", "100900", DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        Recipient recipient = testData.getUser().getRecipients().get(0);
        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.addRecipient(recipient.getFirstName(), recipient.getLastName(), recipient.getMobileNumber(), recipient.getNickName(), recipient.getRelationship(),
                recipient.getBankAccount().getAccountNumber(), recipient.getBankAccount().getIfscCode(),
                recipient.getAddress().getAddress(), recipient.getAddress().getCity());

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(getDriver());
        reviewTransferPage.enterPaymentNote("Add bank account");
        reviewTransferPage.clickOnGoToPayment();

        SelectPaymentPage selectPaymentPage = new SelectPaymentPage(getDriver());
        selectPaymentPage.clickOnAddPaymentMethod();
        selectPaymentPage.clickOnAddFirstBankAccount();

        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        addBankAccountPage.addBankAccount(bankAccount.getUserName(), bankAccount.getPassword(), bankAccount.getOtp());

        selectPaymentPage.verifyPaymentMethodsModelHeader();
    }


    //ToDo: for test data purpose only - To Add first bank account, when there are already recipients added
    //@Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void addFirstBankAccountTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnAddPaymentMethod();
        selectPaymentPage.clickOnAddFirstBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);

        addBankAccountPage.verifyScreenHeader();
        addBankAccountPage.addBankAccount(bankAccount.getUserName(), bankAccount.getPassword(), bankAccount.getOtp());

        selectPaymentPage.verifyPaymentMethodsModelHeader();
    }


    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void addBankAccountTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);

        addBankAccountPage.verifyScreenHeader();
        addBankAccountPage.addBankAccount(bankAccount.getUserName(), bankAccount.getPassword(), bankAccount.getOtp());

        selectPaymentPage.verifyPaymentMethodsModelHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountWithInvalidCredentialsData", dataProviderClass = AddBankAccountDataProvider.class)
    public void addBankAccountWithInvalidCredentialsTest(String testDataFile, String userName, String password) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        addBankAccountPage.connectToLeanMockBank();
        addBankAccountPage.clickOnLogin();
        addBankAccountPage.verifyUserNameError();
        addBankAccountPage.verifyPasswordError();

        addBankAccountPage.enterUserName(userName);
        addBankAccountPage.enterPassword(password);
        addBankAccountPage.clickOnLogin();
        addBankAccountPage.verifyBankAccountNotFoundError();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountWithInvalidOtpData", dataProviderClass = AddBankAccountDataProvider.class)
    public void addBankAccountWithInvalidOtpTest(String testDataFile, String otp) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);

        addBankAccountPage.connectToLeanMockBank();
        addBankAccountPage.enterUserName(bankAccount.getUserName());
        addBankAccountPage.enterPassword(bankAccount.getPassword());
        addBankAccountPage.clickOnLogin();

        addBankAccountPage.enterOtp(otp);
        addBankAccountPage.clickOnSubmitOtp();
        addBankAccountPage.verifyOtpError();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void closeAddBankAccountSetupScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
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

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void closeAddBankAccountLoginScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        addBankAccountPage.connectToLeanMockBank();

        addBankAccountPage.clickOnBankAccountLoginScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyBackToConnectButton();

        addBankAccountPage.clickOnBankAccountLoginScreenCloseButton();
        addBankAccountPage.verifyBankAccountConnectSurveyScreenHeader();
        addBankAccountPage.clickOnBankAccountConnectSurveyConfirmAndCloseButton();

        addBankAccountPage.verifySelectBankScreenHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void closeAddBankAccountOtpScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
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

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void navigateBackFromAddBankAccountSetupScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        addBankAccountPage.clickOnChoseYourBank();
        addBankAccountPage.clickOnLeanMockBank();

        addBankAccountPage.getAndroidActions().clickDeviceBackButton(getDriver());
        addBankAccountPage.verifySelectBankScreenHeader();
    }

    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void navigateBackFromAddBankAccountLoginScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        addBankAccountPage.connectToLeanMockBank();

        addBankAccountPage.getAndroidActions().clickDeviceBackButton(getDriver());
        addBankAccountPage.verifySelectBankScreenHeader();
    }


    @Test(groups = {"addBankAccount"}, description = "Add bank account", dataProvider = "addBankAccountData", dataProviderClass = AddBankAccountDataProvider.class)
    public void navigateBackFromAddBankAccountOtpScreenTest(String testDataFile) {

        log.info("Add Bank Account Test");

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
        selectPaymentPage.clickOnChangePaymentMethod();
        selectPaymentPage.clickOnAddBankAccount();

        BankAccount bankAccount = testData.getUser().getBankAccounts().get(0);
        AddBankAccountPage addBankAccountPage = new AddBankAccountPage(getDriver());
        addBankAccountPage.connectToLeanMockBank();
        addBankAccountPage.enterUserName(bankAccount.getUserName());
        addBankAccountPage.enterPassword(bankAccount.getPassword());
        addBankAccountPage.clickOnLogin();

        addBankAccountPage.getAndroidActions().clickDeviceBackButton(getDriver());
        addBankAccountPage.verifySelectBankScreenHeader();
    }

}
