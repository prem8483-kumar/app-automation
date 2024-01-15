package co.huru.test;

import co.huru.data.SignInDataProvider;
import co.huru.pageObjects.SignInPage;
import co.huru.pageObjects.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SignInTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignInTest.class);

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void signInTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "forgotPinData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscode(String phoneNumber, String newPasscode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.clickForgotPasswordLink();

        signUpPage.enterOtp(otp);
        signUpPage.enterPasscode(newPasscode);
        signUpPage.confirmPasscode(newPasscode);

        signInPage.enterPasscode(newPasscode);
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void navigateBackFromEnterPasscodeScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.navigateBack();
        signInPage.verifyPhoneNumberPreFilled(phoneNumber);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void navigateBackFromOtpScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);
        signInPage.navigateBack();
        signInPage.verifyPhoneNumberPreFilled(phoneNumber);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeNavigateBackFromOtpScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signInPage.navigateBack();
        signInPage.enterPasscode(passcode);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeNavigateBackFromEnterPasscodeScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signInPage.enterOtp(otp);
        signInPage.navigateBack();
        signInPage.enterPasscode(passcode);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeNavigateBackFromConfirmPasscodeScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signInPage.enterOtp(otp);
        signInPage.enterPasscode(passcode);
        signInPage.navigateBack();
        signInPage.enterPasscode(passcode);
    }

}
