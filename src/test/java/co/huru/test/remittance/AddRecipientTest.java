package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.dataObjects.Recipient;
import co.huru.dataObjects.TestData;
import co.huru.dataObjects.Profile;
import co.huru.pageObjects.remittance.AddRecipientPage;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.SelectRecipientPage;
import co.huru.pageObjects.remittance.SetupTransferPage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class AddRecipientTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(AddRecipientTest.class);

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = SendMoneyDataProvider.class)
    public void addRecipientTest(String testDataFile) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        Recipient recipient = testData.getUser().getRecipients().get(0);

        addRecipientPage.addRecipient(recipient.getFirstName(), recipient.getLastName(), recipient.getMobileNumber(),
                recipient.getNickName(), recipient.getBankAccount().getAccountNumber(), recipient.getBankAccount().getIfscCode(),
                recipient.getAddress().getAddress(), recipient.getAddress().getCity());

        selectRecipientPage.verifyScreenHeader();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidFirstNameData", dataProviderClass = SendMoneyDataProvider.class)
    public void firstNameErrorTest(String testDataFile, String invalidFirstName) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.enterFirstName(invalidFirstName);
        addRecipientPage.validateFirstNameError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidLastNameData", dataProviderClass = SendMoneyDataProvider.class)
    public void lastNameErrorTest(String testDataFile, String invalidLastName) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.enterLastName(invalidLastName);
        addRecipientPage.validateLastNameError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidMobileNumberData", dataProviderClass = SendMoneyDataProvider.class)
    public void mobileNumberErrorTest(String testDataFile, String invalidMobileNumber) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.enterMobileNumber(invalidMobileNumber);
        addRecipientPage.validateMobileNumberError();
    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = SendMoneyDataProvider.class)
    public void relationRequiredErrorTest(String testDataFile) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.clickOnContinue();
        addRecipientPage.validateRelationshipRequiredError();
    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidAccountNumberData", dataProviderClass = SendMoneyDataProvider.class)
    public void accountNumberErrorTest(String testDataFile, String invalidAccountNumber) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.clickOnBankDetailsSection();
        addRecipientPage.enterAccountNumber(invalidAccountNumber);
        addRecipientPage.validateAccountNumberError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidIfscCodeData", dataProviderClass = SendMoneyDataProvider.class)
    public void ifscCodeErrorTest(String testDataFile, String invalidIfscCode) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.clickOnBankDetailsSection();
        addRecipientPage.enterIfscCode(invalidIfscCode);
        addRecipientPage.validateIfscCodeError();

    }


    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidAddressData", dataProviderClass = SendMoneyDataProvider.class)
    public void addressErrorTest(String testDataFile, String invalidAddress) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.clickOnAddressSection();
        addRecipientPage.enterAddress(invalidAddress);
        addRecipientPage.validateAddressError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidCityData", dataProviderClass = SendMoneyDataProvider.class)
    public void cityErrorTest(String testDataFile, String invalidCity) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.clickOnAddressSection();
        addRecipientPage.enterCity(invalidCity);
        addRecipientPage.validateCityError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = SendMoneyDataProvider.class)
    public void incompleteSectionErrorTest(String testDataFile) {

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(driver);
        addRecipientPage.clickOnContinue();
        addRecipientPage.validateIncompleteSectionsError();
    }

}
