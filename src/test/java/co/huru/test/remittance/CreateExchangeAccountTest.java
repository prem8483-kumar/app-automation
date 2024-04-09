package co.huru.test.remittance;

import co.huru.data.remittance.CreateExchangeAccountDataProvider;
import co.huru.dataObjects.CreateExchangeAccountData;
import co.huru.dataObjects.Profile;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.CreateExchangeAccountPage;
import co.huru.pageObjects.remittance.SetupTransferPage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;


public class CreateExchangeAccountTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(CreateExchangeAccountTest.class);

    //ToDo
    @Test(groups = {"createAccount"}, description = "Create exchange account", dataProvider = "createExchangeAccountData", dataProviderClass = CreateExchangeAccountDataProvider.class)
    public void createExchangeAccountTest(Profile profile, CreateExchangeAccountData createExchangeAccountData) {

        log.info("Create exchange account test");

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        CreateExchangeAccountPage createAccountPage = new CreateExchangeAccountPage(driver);
        createAccountPage.verifyScreenHeader();
        createAccountPage.clickOnExchangeCheckbox();
        createAccountPage.clickOnHuruCheckbox();
        createAccountPage.clickOnContinue();

        createAccountPage.verifyScreenHeader();
        createAccountPage.enterAnnualIncome(createExchangeAccountData.getAnnualIncome());
        createAccountPage.enterMonthlyTransactionNumber(createExchangeAccountData.getMonthlyTransactionNumber());
        createAccountPage.enterMonthlyTransactionAmount(createExchangeAccountData.getMonthlyTransactionAmount());
        createAccountPage.clickOnContinue();

    }

}
