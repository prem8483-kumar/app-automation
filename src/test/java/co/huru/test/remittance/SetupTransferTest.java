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
        setupTransferPage.enterAmountToSend(fundTransfer.getAmount());
        setupTransferPage.selectReceiverCountry(fundTransfer.getReceiverCountry());
        setupTransferPage.selectExchange(fundTransfer.getExchange());
        setupTransferPage.clickOnContinue();
        setupTransferPage.selectTransactionPurpose(fundTransfer.getTransferPurpose());
        setupTransferPage.selectFundSource(fundTransfer.getFundSource());
        setupTransferPage.clickOnContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.verifyScreenHeader();
    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "sendMoneyData", dataProviderClass = SendMoneyDataProvider.class)
    public void minimumAmountErrorTest(String testDataFile, String minimumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.enterAmountToSend(minimumAmount);
        setupTransferPage.validateMinimumAmountError();

    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "sendMoneyData", dataProviderClass = SendMoneyDataProvider.class)
    public void maximumAmountErrorTest(String testDataFile, String maximumAmount)  {

        log.info("Setup transfer test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignInPage signInPage = new SignInPage(driver);
        Profile profile = testData.getUser().getProfile();
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.enterAmountToSend(maximumAmount);
        setupTransferPage.validateMaximumAmountError();

    }

    @Test(groups = {"setupTransfer"}, description = "Setup Transfer", dataProvider = "setupTransferData", dataProviderClass = SendMoneyDataProvider.class)
    public void noAmountErrorTest(String testDataFile) {

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

        setupTransferPage.enterAmountToSend("");
        setupTransferPage.selectExchange(fundTransfer.getExchange());
        setupTransferPage.validateContinueButtonNotVisible();

    }
}
