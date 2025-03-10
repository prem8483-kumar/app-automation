package co.huru.test.home;

import co.huru.data.signIn.SignInDataProvider;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class HomeTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(HomeTest.class);

    //@Test(groups = {"Home"}, description = "Home Page", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void kycCardTest(String phoneNumber, String passcode, String otp)  {

        log.info("Home Test");
        SignInPage signInPage = new SignInPage(getDriver());
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(getDriver());
        homePage.kycCard();


    }

}
