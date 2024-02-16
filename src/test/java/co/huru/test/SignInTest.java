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

        signInPage.verifyPhoneNumberScreen();
        signInPage.enterPhoneNumberAndContinue(phoneNumber);

        signInPage.verifyPinScreen();
        signInPage.enterPin(passcode);

        signInPage.verifyOtpScreen();
        signInPage.enterOtp(otp);

        signInPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpSignInData", dataProviderClass = SignInDataProvider.class)
    public void signUpAndSignInTest(String newPhoneNumber, String newNumberOtp, String name,
                                    String oldPhoneNumber, String oldNUmberPasscode, String oldNumberOtp)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(newPhoneNumber);
        signUpPage.enterOtp(newNumberOtp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.navigateBack();
        signUpPage.navigateBack();

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(oldPhoneNumber);
        signInPage.enterPin(oldNUmberPasscode);
        signInPage.enterOtp(oldNumberOtp);
        signInPage.waitForHomePage();
    }


    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void signInUsingResendOtpTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);

        signInPage.waitForResendOtpLink();
        signInPage.clickResendOtpLink();
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "forgotPinData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeTest(String phoneNumber, String newPasscode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.clickForgotPasswordLink();

        signUpPage.enterOtp(otp);
        signUpPage.enterPin(newPasscode);
        signUpPage.enterPinAndConfirm(newPasscode);

        signInPage.enterPin(newPasscode);
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "forgotPinData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeUsingEidTest(String phoneNumber, String newPasscode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.clickForgotPasswordLink();

        signUpPage.enterOtp(otp);
        signUpPage.enterPin(newPasscode);
        signUpPage.enterPinAndConfirm(newPasscode);

        signInPage.enterPin(newPasscode);
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(groups = {"signIn"}, description = "Sign In")
    public void navigateBackFromPhoneNumberScreen()  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.navigateBack();

        //ToDo Validate app is closed
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void navigateBackFromEnterPasscodeScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.navigateBack();
        signInPage.verifyPhoneNumberPreFilled(phoneNumber);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void navigateBackFromOtpScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);
        signInPage.navigateBack();
        signInPage.verifyPhoneNumberPreFilled(phoneNumber);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeNavigateBackFromOtpScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signInPage.navigateBack();
        signInPage.enterPin(passcode);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeNavigateBackFromEnterPasscodeScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signInPage.enterOtp(otp);
        signInPage.navigateBack();
        signInPage.enterPin(passcode);
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void forgotPasscodeNavigateBackFromConfirmPasscodeScreen(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signInPage.enterOtp(otp);
        signInPage.enterPin(passcode);
        signInPage.navigateBack();
        signInPage.enterPin(passcode);
    }

}
