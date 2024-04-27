package co.huru.test.onboarding;

import co.huru.data.onboarding.CreateExchangeAccountDataProvider;
import co.huru.dataObjects.CreateExchangeAccountData;
import co.huru.dataObjects.Profile;
import co.huru.pageObjects.appLaunch.AppLauncherPage;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.onboarding.CreateExchangeAccountPage;
import co.huru.pageObjects.remittance.SelectRecipientPage;
import co.huru.pageObjects.remittance.SetupTransferPage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class CreateExchangeAccountTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(CreateExchangeAccountTest.class);


    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void createExchangeAccountTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        //homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyScreenHeader();

        createAccountPage.verifyTncScreen();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.enterAnnualIncome(createExchangeAccountData.getAnnualIncome());
        createAccountPage.enterMonthlyTransactionNumber(createExchangeAccountData.getMonthlyTransactionNumber());
        createAccountPage.enterMonthlyTransactionAmount(createExchangeAccountData.getMonthlyTransactionAmount());
        createAccountPage.clickOnCreateAccountButton();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void navigateBackFromCreateAccountTnCScreenTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyTncScreen();

        createAccountPage.navigateBack();
        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void navigateBackFromCreateAccountYourDetailsScreenTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());

        createAccountPage.verifyTncScreen();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.navigateBack();
        setupTransferPage.verifyScreenHeader();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "annualIncomeInvalidData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void annualIncomeErrorTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyScreenHeader();

        createAccountPage.verifyTncScreen();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.enterAnnualIncome(createExchangeAccountData.getAnnualIncome());
        createAccountPage.verifyAnnualIncomeError();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "monthlyTransactionNumberInvalidData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void monthlyTransactionNumberErrorTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyScreenHeader();

        createAccountPage.verifyTncScreen();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.enterAnnualIncome(createExchangeAccountData.getAnnualIncome());
        createAccountPage.enterMonthlyTransactionNumber(createExchangeAccountData.getMonthlyTransactionNumber());

        createAccountPage.verifyMonthlyTransactionNumberError();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "monthlyTransactionAmountInvalidData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void monthlyTransactionAmountErrorTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyScreenHeader();

        createAccountPage.verifyTncScreen();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.enterAnnualIncome(createExchangeAccountData.getAnnualIncome());
        createAccountPage.enterMonthlyTransactionNumber(createExchangeAccountData.getMonthlyTransactionNumber());
        createAccountPage.enterMonthlyTransactionAmount(createExchangeAccountData.getMonthlyTransactionAmount());

        createAccountPage.verifyMonthlyTransactionAmountError();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void minimizeAndOpenAppOnCreateAccountTnCScreenTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyTncScreen();

        createAccountPage.getAndroidActions().minimizeApp(getDriver(), 2);
        createAccountPage.verifyTncScreen();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void killAndRelaunchAppOnCreateAccountTnCScreenTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyTncScreen();

        createAccountPage.getAndroidActions().killAndRestartApp(getDriver());
        signInPage.verifyPinScreen();
        signInPage.enterPin(profile.getPin());
        homePage.waitForHomePage();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void minimizeAndOpenAppOnAccountBeingActivatedScreenTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyScreenHeader();

        createAccountPage.verifyTncScreen();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.enterAnnualIncome(createExchangeAccountData.getAnnualIncome());
        createAccountPage.enterMonthlyTransactionNumber(createExchangeAccountData.getMonthlyTransactionNumber());
        createAccountPage.enterMonthlyTransactionAmount(createExchangeAccountData.getMonthlyTransactionAmount());
        createAccountPage.clickOnCreateAccountButton();

        createAccountPage.getAndroidActions().minimizeApp(getDriver(), 2);
        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(getDriver());
        selectRecipientPage.verifyScreenHeader();
    }

    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void killAndRelaunchAppOnAccountBeingActivatedScreenTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        AppLauncherPage appLauncherPage = new AppLauncherPage(getDriver());
        appLauncherPage.navigateValueProps();

        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(getDriver());
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(getDriver());
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(getDriver());
        createAccountPage.verifyScreenHeader();

        createAccountPage.verifyTncScreen();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.enterAnnualIncome(createExchangeAccountData.getAnnualIncome());
        createAccountPage.enterMonthlyTransactionNumber(createExchangeAccountData.getMonthlyTransactionNumber());
        createAccountPage.enterMonthlyTransactionAmount(createExchangeAccountData.getMonthlyTransactionAmount());
        createAccountPage.clickOnCreateAccountButton();

        createAccountPage.getAndroidActions().killAndRestartApp(getDriver());
        signInPage.verifyPinScreen();
        signInPage.enterPin(profile.getPin());
        homePage.waitForHomePage();
    }


}
