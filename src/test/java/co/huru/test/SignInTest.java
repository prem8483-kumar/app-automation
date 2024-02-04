package co.huru.test;

import co.huru.data.SignInDataProvider;
import co.huru.data.SignUpDataProvider;
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

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpSignInData", dataProviderClass = SignInDataProvider.class)
    public void signUpAndSignInTest(String newPhoneNumber, String newNumberOtp, String name,
                                    String oldPhoneNumber, String oldNUmberPasscode, String oldNumberOtp)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(newPhoneNumber);
        signUpPage.enterOtp(newNumberOtp);
        signUpPage.enterName(name);
        signUpPage.navigateBack();
        signUpPage.navigateBack();

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(oldPhoneNumber);
        signInPage.enterPasscode(oldNUmberPasscode);
        signInPage.enterOtp(oldNumberOtp);
        signInPage.waitForHomePage();
    }


    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void signInUsingResendOtpTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);

        signInPage.waitForResendOtpLink();
        signInPage.clickResendOtpLink();
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void signInUsingResendOtpMaxAttemptTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);

        for(int i=1; i<=5; i++) {
            signInPage.waitForResendOtpLink();
            signInPage.clickResendOtpLink();
        }

        signInPage.validateOtpError();
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidPinData", dataProviderClass = SignInDataProvider.class)
    public void signInWithInvalidPinTest(String phoneNumber, String passcode)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);
        signInPage.validatePinError();
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void signInWithExpiredPinTest(String phoneNumber, String passcode)  {

        //ToDo: Expire PIN before test

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);
        signInPage.validatePinError();

        //ToDo: Reset expired PIN after test
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidPinData", dataProviderClass = SignInDataProvider.class)
    public void signInWithInvalidPinMaxAttemptTest(String phoneNumber, String passcode)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);

        signInPage.enterPasscode(passcode);
        signInPage.validatePinError();
        for(int i=2; i<=5; i++) {
            signInPage.clickOnPasscodeTextBox();
            signInPage.enterPasscode(passcode);
            signInPage.validatePinError();
        }
        signInPage.validateForgotPinLinkDisabled();

    }


    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidOtpData", dataProviderClass = SignInDataProvider.class)
    public void signInWithInvalidOtpTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);
        signInPage.enterOtp(otp);
        signInPage.validateOtpError();
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidOtpData", dataProviderClass = SignInDataProvider.class)
    public void signInWithInvalidOtpMaxAttemptTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumber(phoneNumber);
        signInPage.enterPasscode(passcode);

        signInPage.enterOtp(otp);
        signInPage.validateOtpError();
        for(int i=2; i<=5; i++) {
            signInPage.enterOtp(otp);
            signInPage.validateOtpError();
        }

        //ToDo: wait for timer and generate otp link

    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "forgotPinData", dataProviderClass = SignInDataProvider.class)
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
    public void forgotPinSetNewPinSameAsOldPin(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);

        signInPage.enterPhoneNumber(phoneNumber);

        signInPage.clickForgotPasswordLink();
        signUpPage.enterOtp(otp);
        signUpPage.enterPasscode(passcode);
        signUpPage.confirmPasscode(passcode);
        signUpPage.validatePinError();

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
