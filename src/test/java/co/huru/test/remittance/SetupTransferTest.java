package co.huru.test.remittance;

import co.huru.data.remittance.SetupTransferDataProvider;
import co.huru.dataObjects.FundTransfer;
import co.huru.dataObjects.Profile;
import co.huru.dataObjects.TestData;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.SetupTransferPage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class SetupTransferTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SetupTransferTest.class);

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void setupTransferTest(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        FundTransfer fundTransfer = testData.getFundTransfers().get(0);

        setupTransferPage.verifyScreenHeader();
        setupTransferPage.enterSenderAmount(fundTransfer.getSenderAmount());
        setupTransferPage.selectReceiverCountry(fundTransfer.getReceiverCountry());
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();
        setupTransferPage.selectTransactionPurpose(fundTransfer.getTransferPurpose());
        setupTransferPage.selectFundSource(fundTransfer.getFundSource());
        setupTransferPage.clickOnContinue();

    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void setupReverseTransferTest(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        FundTransfer fundTransfer = testData.getFundTransfers().get(0);

        setupTransferPage.verifyScreenHeader();
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(fundTransfer.getReceiverCountry());
        setupTransferPage.enterReceiverAmount(fundTransfer.getReceiverAmount());

        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();
        setupTransferPage.selectTransactionPurpose(fundTransfer.getTransferPurpose());
        setupTransferPage.selectFundSource(fundTransfer.getFundSource());
        setupTransferPage.clickOnContinue();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "decimalSenderAmountTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void decimalSenderAmountTransferTest(String testDataFile, String decimalAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.enterSenderAmount(decimalAmount);
        //ToDo: Single click not working
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();
        setupTransferPage.clickOnContinue();

    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "decimalReceiverAmountTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void decimalReceiverAmountTransferTest(String testDataFile, String country, String decimalAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(country);
        setupTransferPage.enterReceiverAmount(decimalAmount);
        //ToDo: Single click not working
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();
        setupTransferPage.clickOnContinue();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "minimumSenderAmountTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void minimumSenderAmountTransferErrorTest(String testDataFile, String minimumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.enterSenderAmount(minimumAmount);
        setupTransferPage.validateSenderMinimumAmountError();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "minimumReceiverAmountTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void minimumReceiverAmountTransferErrorTest(String testDataFile, String country, String minimumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(country);
        setupTransferPage.enterReceiverAmount(minimumAmount);
        if(country.equalsIgnoreCase("India")) {
            setupTransferPage.validateIndiaReceiverMinimumAmountError();
        } else if(country.equalsIgnoreCase("Pakistan")){
            setupTransferPage.validatePakistanReceiverMinimumAmountError();
        }

    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "maximumSenderAmountTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void maximumSenderAmountTransferErrorTest(String testDataFile, String maximumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.enterSenderAmount(maximumAmount);
        setupTransferPage.validateSenderMaximumAmountError();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "maximumReceiverAmountTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void maximumReceiverAmountTransferErrorTest(String testDataFile, String country, String maximumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.selectReceiverCountry(country);
        setupTransferPage.enterReceiverAmount(maximumAmount);
        if(country.equalsIgnoreCase("India")) {
            setupTransferPage.validateIndiaReceiverMaximumAmountError();
        } else if(country.equalsIgnoreCase("Pakistan")){
            setupTransferPage.validatePakistanReceiverMaximumAmountError();
        }
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void emptySenderAmountTransferErrorTest(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());

        setupTransferPage.enterSenderAmount("");
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.validateContinueButtonNotVisible();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void emptyReceiverAmountTransferErrorTest(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.clickOnExchangeIcon();
        setupTransferPage.enterReceiverAmount("");
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.validateContinueButtonNotVisible();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void verifyExchangeQuoteBreakdown(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchange();

        setupTransferPage.clickOnExchangeQuoteBreakdown();
        setupTransferPage.closeScreen();
        setupTransferPage.clickOnExchangeQuoteBreakdown();
        setupTransferPage.verifyExchangeQuoteBreakdownModel();
        setupTransferPage.clickOnContinue();

        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void verifyTransferPurposeAndFundSource(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchange();
        setupTransferPage.clickOnContinue();

        //ToDo: selected attribute is not marked as true
        //setupTransferPage.verifyFamilySupportPurposeSelected();
        //setupTransferPage.verifySalarySourceSelected();
        setupTransferPage.closeScreen();

        setupTransferPage.clickOnContinue();
        setupTransferPage.clickOnContinue();

    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void verifyCashPickupAndWalletComingSoonBanner(String testDataFile) {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(getDriver());
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.clickOnCashPickupTab();
        setupTransferPage.verifyComingSoonBanner();

        setupTransferPage.clickOnWalletTab();
        setupTransferPage.verifyComingSoonBanner();
    }

    @Test(groups = {"sendMoney"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void minimizeAndOpenAppOnSetupTransferScreenTest(String testDataFile)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);
        Profile profile = testData.getUser().getProfile();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.verifyScreenHeader();
        setupTransferPage.getAndroidActions().minimizeApp(getDriver(), 2);
        setupTransferPage.verifyScreenHeader();

    }

    @Test(groups = {"sendMoney"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SetupTransferDataProvider.class)
    public void killAndRelaunchAppOnSetupTransferScreenTest(String testDataFile)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);
        Profile profile = testData.getUser().getProfile();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.verifyScreenHeader();

        setupTransferPage.getAndroidActions().killAndRestartApp(getDriver());

        signInPage.verifyPinScreen();
        signInPage.enterPin(profile.getPin());
        homePage.waitForHomePage();

    }

}
