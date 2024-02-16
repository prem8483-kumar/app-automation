package co.huru.test;

import co.huru.data.SignInDataProvider;
import co.huru.pageObjects.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SignInBreachTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignInBreachTest.class);

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void signInUsingResendOtpMaxAttemptTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);

        for(int i=1; i<=5; i++) {
            signInPage.waitForResendOtpLink();
            signInPage.clickResendOtpLink();
        }

        signInPage.validateOtpError();

        //ToDO: Navigate back test
    }


    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidPinData", dataProviderClass = SignInDataProvider.class)
    public void signInWithInvalidPinMaxAttemptTest(String phoneNumber, String passcode)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);

        signInPage.enterPin(passcode);
        signInPage.validatePinError();
        for(int i=2; i<=5; i++) {
            signInPage.clickOnPasscodeTextBox();
            signInPage.enterPin(passcode);
            signInPage.validatePinError();
        }
        signInPage.validateForgotPinLinkDisabled();

        //ToDO: Navigate back test

    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidOtpData", dataProviderClass = SignInDataProvider.class)
    public void signInWithInvalidOtpMaxAttemptTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);

        signInPage.enterOtp(otp);
        signInPage.validateOtpError();
        for(int i=2; i<=5; i++) {
            signInPage.enterOtp(otp);
            signInPage.validateOtpError();
        }

        //ToDo: wait for timer and generate otp link

        //ToDO: Navigate back test

    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidOtpData", dataProviderClass = SignInDataProvider.class)
    public void retryAfterBreachOtpTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);

        signInPage.enterOtp(otp);
        signInPage.validateOtpError();
        for(int i=2; i<=5; i++) {
            signInPage.enterOtp(otp);
            signInPage.validateOtpError();
        }

        //should come to enter otp screen
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidOtpData", dataProviderClass = SignInDataProvider.class)
    public void killAppAndEnterCorrectOtpAfterBreachOtpTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);

        signInPage.enterOtp(otp);
        signInPage.validateOtpError();
        for(int i=2; i<=5; i++) {
            signInPage.enterOtp(otp);
            signInPage.validateOtpError();
        }
    }

    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidOtpData", dataProviderClass = SignInDataProvider.class)
    public void killAppAndEnterInCorrectOtpAfterBreachOtpTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);

        signInPage.enterOtp(otp);
        signInPage.validateOtpError();
        for(int i=2; i<=5; i++) {
            signInPage.enterOtp(otp);
            signInPage.validateOtpError();
        }
    }


    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInWithInvalidPinData", dataProviderClass = SignInDataProvider.class)
    public void forgotPinMaxAttemptTest(String phoneNumber, String passcode)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);

        signInPage.enterPin(passcode);
        signInPage.validatePinError();
        for(int i=2; i<=5; i++) {
            signInPage.clickOnPasscodeTextBox();
            signInPage.enterPin(passcode);
            signInPage.validatePinError();
        }
        signInPage.validateForgotPinLinkDisabled();

        //ToDO: Navigate back test

    }


    @Test(enabled = false, groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void signInWithExpiredPinTest(String phoneNumber, String passcode)  {

        //ToDo: Expire PIN before test

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);
        signInPage.validatePinError();

        //ToDo: Reset expired PIN after test
    }

}
