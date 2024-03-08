package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.dataObjects.FundTransfer;
import co.huru.dataObjects.Profile;
import co.huru.dataObjects.TestData;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.SelectRecipientPage;
import co.huru.pageObjects.remittance.SetupTransferPage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class SetupTransferTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SetupTransferTest.class);

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void setupTransferTest(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        FundTransfer fundTransfer = testData.getFundTransfers().get(0);

        setupTransferPage.verifyScreenHeader();
        setupTransferPage.enterSenderAmount(fundTransfer.getSenderAmount());
        setupTransferPage.selectReceiverCountry(fundTransfer.getReceiverCountry());
        setupTransferPage.selectExchange(fundTransfer.getExchangeHouse());
        setupTransferPage.clickOnContinue();
        setupTransferPage.selectTransactionPurpose(fundTransfer.getTransferPurpose());
        setupTransferPage.selectFundSource(fundTransfer.getFundSource());
        setupTransferPage.clickOnContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.verifyScreenHeader();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void setupReverseTransferTest(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        FundTransfer fundTransfer = testData.getFundTransfers().get(0);

        setupTransferPage.verifyScreenHeader();
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(fundTransfer.getReceiverCountry());
        setupTransferPage.enterReceiverAmount(fundTransfer.getReceiverAmount());

        setupTransferPage.selectExchange(fundTransfer.getExchangeHouse());
        setupTransferPage.clickOnContinue();
        setupTransferPage.selectTransactionPurpose(fundTransfer.getTransferPurpose());
        setupTransferPage.selectFundSource(fundTransfer.getFundSource());
        setupTransferPage.clickOnContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.verifyScreenHeader();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "decimalSenderAmountTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void decimalSenderAmountTransferTest(String testDataFile, String decimalAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.enterSenderAmount(decimalAmount);
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();
        setupTransferPage.clickOnContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.verifyScreenHeader();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "decimalReceiverAmountTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void decimalReceiverAmountTransferTest(String testDataFile, String country, String decimalAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);

        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(country);
        setupTransferPage.enterReceiverAmount(decimalAmount);
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();
        setupTransferPage.clickOnContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.verifyScreenHeader();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "minimumSenderAmountTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void minimumSenderAmountTransferErrorTest(String testDataFile, String minimumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.enterSenderAmount(minimumAmount);
        setupTransferPage.validateMinimumAmountError();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "minimumReceiverAmountTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void minimumReceiverAmountTransferErrorTest(String testDataFile, String country, String minimumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(country);
        setupTransferPage.enterReceiverAmount(minimumAmount);
        setupTransferPage.validateMinimumAmountError();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "maximumSenderAmountTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void maximumSenderAmountTransferErrorTest(String testDataFile, String maximumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.enterSenderAmount(maximumAmount);
        setupTransferPage.validateMaximumAmountError();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "maximumReceiverAmountTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void maximumReceiverAmountTransferErrorTest(String testDataFile, String country, String maximumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(country);
        setupTransferPage.enterReceiverAmount(maximumAmount);
        setupTransferPage.validateMaximumAmountError();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void emptySenderAmountTransferErrorTest(String testDataFile, String amount) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        FundTransfer fundTransfer = testData.getFundTransfers().get(0);

        setupTransferPage.enterSenderAmount(amount);
        setupTransferPage.selectExchange(fundTransfer.getExchangeHouse());
        setupTransferPage.validateContinueButtonNotVisible();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void emptyReceiverAmountTransferErrorTest(String testDataFile, String amount, String country) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(country);
        setupTransferPage.enterReceiverAmount(amount);
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.validateContinueButtonNotVisible();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void verifyExchangeQuoteBreakup(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchange();

        setupTransferPage.clickOnExchangeBreakup();
        setupTransferPage.clickOnExchangeFeeInfoIcon();
        setupTransferPage.closeScreen();

        setupTransferPage.clickOnExchangeBreakup();
        setupTransferPage.clickOnExchangeFeeInfoIcon();
        setupTransferPage.clickOnContinue();
        setupTransferPage.clickOnContinue();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void verifyTransferPurposeAndFundSource(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();

        setupTransferPage.verifyFamilySupportPurposeSelected();
        setupTransferPage.verifySalarySourceSelected();
        setupTransferPage.closeScreen();

        setupTransferPage.clickOnContinue();
        setupTransferPage.clickOnContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.verifyScreenHeader();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void verifyCashPickupAndWalletComingSoonBanner(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.clickOnCashPickupTab();
        setupTransferPage.verifyComingSoonBanner();

        setupTransferPage.clickOnWalletTab();
        setupTransferPage.verifyComingSoonBanner();
    }

}
