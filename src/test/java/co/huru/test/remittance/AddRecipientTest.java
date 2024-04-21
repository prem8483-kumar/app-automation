package co.huru.test.remittance;

import co.huru.data.remittance.AddRecipientDataProvider;
import co.huru.dataObjects.Recipient;
import co.huru.dataObjects.TestData;
import co.huru.dataObjects.Profile;
import co.huru.pageObjects.remittance.AddRecipientPage;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.ReviewTransferPage;
import co.huru.pageObjects.remittance.SelectRecipientPage;
import co.huru.pageObjects.remittance.SetupTransferPage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.pageObjects.signIn.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import co.huru.utils.DataGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class AddRecipientTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(AddRecipientTest.class);

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = AddRecipientDataProvider.class)
    public void signUpAndAddRecipientTest(String testDataFile) {

        log.info("Add Recipient Test");

        log.info("Get test data");
        TestData testData = getTestDataObject(testDataFile);

        SignUpPage signUpPage = new SignUpPage(getDriver());
        signUpPage.signUp(DataGenerator.generateRandomMobileNumber(), "123456", "100900", DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        Recipient recipient = testData.getUser().getRecipients().get(0);
        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.verifyScreenHeader();
        addRecipientPage.addRecipient(recipient.getFirstName(), recipient.getLastName(), recipient.getMobileNumber(), recipient.getNickName(), recipient.getRelationship(),
                recipient.getBankAccount().getAccountNumber(), recipient.getBankAccount().getIfscCode(),
                recipient.getAddress().getAddress(), recipient.getAddress().getCity());

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(getDriver());
        reviewTransferPage.verifyScreenHeader();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = AddRecipientDataProvider.class)
    public void addRecipientTest(String testDataFile) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.verifyScreenHeader();
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        Recipient recipient = testData.getUser().getRecipients().get(0);

        addRecipientPage.verifyScreenHeader();
        addRecipientPage.addRecipient(recipient.getFirstName(), recipient.getLastName(), recipient.getMobileNumber(), recipient.getNickName(), recipient.getRelationship(),
                recipient.getBankAccount().getAccountNumber(), recipient.getBankAccount().getIfscCode(),
                recipient.getAddress().getAddress(), recipient.getAddress().getCity());

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(getDriver());
        reviewTransferPage.waitForPaymentNoteTextBox();
    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidFirstNameData", dataProviderClass = AddRecipientDataProvider.class)
    public void firstNameErrorTest(String testDataFile, String invalidFirstName) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.enterFirstName(invalidFirstName);
        addRecipientPage.validateFirstNameError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidLastNameData", dataProviderClass = AddRecipientDataProvider.class)
    public void lastNameErrorTest(String testDataFile, String invalidLastName) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.enterLastName(invalidLastName);
        addRecipientPage.validateLastNameError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidMobileNumberData", dataProviderClass = AddRecipientDataProvider.class)
    public void mobileNumberErrorTest(String testDataFile, String invalidMobileNumber) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.enterMobileNumber(invalidMobileNumber);
        addRecipientPage.clickOnContinue();
        addRecipientPage.validateMobileNumberError();
    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = AddRecipientDataProvider.class)
    public void relationRequiredErrorTest(String testDataFile) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.clickOnContinue();
        addRecipientPage.validateRelationshipRequiredError();
    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidAccountNumberData", dataProviderClass = AddRecipientDataProvider.class)
    public void accountNumberErrorTest(String testDataFile, String invalidAccountNumber) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.clickOnBankDetailsSection();
        addRecipientPage.enterAccountNumber(invalidAccountNumber);
        addRecipientPage.validateAccountNumberError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidIfscCodeData", dataProviderClass = AddRecipientDataProvider.class)
    public void ifscCodeErrorTest(String testDataFile, String invalidIfscCode) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.clickOnBankDetailsSection();
        addRecipientPage.enterIfscCode(invalidIfscCode);
        addRecipientPage.validateIfscCodeError();

    }


    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidAddressData", dataProviderClass = AddRecipientDataProvider.class)
    public void addressErrorTest(String testDataFile, String invalidAddress) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.clickOnAddressSection();
        addRecipientPage.enterAddress(invalidAddress);
        addRecipientPage.validateAddressError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "invalidCityData", dataProviderClass = AddRecipientDataProvider.class)
    public void cityErrorTest(String testDataFile, String invalidCity) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.clickOnAddressSection();
        addRecipientPage.enterCity(invalidCity);
        addRecipientPage.validateCityError();

    }

    @Test(groups = {"addRecipient"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = AddRecipientDataProvider.class)
    public void incompleteSectionErrorTest(String testDataFile) {

        log.info("Add Recipient Test");

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
        selectRecipientPage.clickOnAddRecipient();

        AddRecipientPage addRecipientPage = new AddRecipientPage(getDriver());
        addRecipientPage.clickOnContinue();
        addRecipientPage.validateIncompleteSectionsError();
    }

}
