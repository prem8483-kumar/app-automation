package co.huru.test.remittance;

import co.huru.data.remittance.ReviewTransferDataProvider;
import co.huru.dataObjects.Profile;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.remittance.ReviewTransferPage;
import co.huru.pageObjects.remittance.SelectRecipientPage;
import co.huru.pageObjects.remittance.SetupTransferPage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ReviewTransferTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(ReviewTransferTest.class);

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "reviewTransferData", dataProviderClass = ReviewTransferDataProvider.class)
    public void reviewTransferScreenTest(Profile profile)  {

        log.info("Review transfer test");

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.verifyReviewTransferScreen();

    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "reviewTransferData", dataProviderClass = ReviewTransferDataProvider.class)
    public void minimizeAndOpenAppOnReviewTransferScreenTest(Profile profile)  {

        log.info("Review transfer test");

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.verifyScreenHeader();
        reviewTransferPage.minimizeApp(2);
        reviewTransferPage.verifyScreenHeader();

    }

    @Test(groups = {"sendMoney"}, description = "Send Money", dataProvider = "reviewTransferData", dataProviderClass = ReviewTransferDataProvider.class)
    public void killAndRelaunchAppOnReviewTransferScreenTest(Profile profile)  {

        log.info("Review transfer test");

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(profile.getPhoneNumber(), profile.getPin(), profile.getOtp());

        HomePage homePage = new HomePage(driver);
        homePage.goToSendMoneyPage();

        SetupTransferPage setupTransferPage = new SetupTransferPage(driver);
        setupTransferPage.selectAvailableExchangeAndContinue();

        SelectRecipientPage selectRecipientPage = new SelectRecipientPage(driver);
        selectRecipientPage.selectFirstRecipient();

        ReviewTransferPage reviewTransferPage = new ReviewTransferPage(driver);
        reviewTransferPage.verifyScreenHeader();
        reviewTransferPage.killAndRestartApp();

        signInPage.verifyPinScreen();
        signInPage.enterPin(profile.getPin());

        homePage.waitForHomePage();

    }
}
