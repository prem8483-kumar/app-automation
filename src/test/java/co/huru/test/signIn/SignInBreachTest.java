package co.huru.test.signIn;

import co.huru.configs.EnvConfig;
import co.huru.data.SignInDataProvider;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.profile.ProfilePage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.pageObjects.signIn.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import co.huru.utils.DataGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SignInBreachTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignInBreachTest.class);

    @Test(groups = {"signInBreach"}, description = "Sign In", dataProvider = "invalidPinMaxAttemptData", dataProviderClass = SignInDataProvider.class)
    public void invalidPinMaxAttemptTest(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp(phoneNumber, otp, pin, name, email);

        log.info("Log out");
        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.logOut();

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);

        String invalidPin = DataGenerator.reverseString(pin);
        log.info("Enter invalid pin for max attempt allowed");
        for(int i = 1; i <= Integer.parseInt(EnvConfig.getProperty("invalidPinMaxAttempt")); i++) {
            signInPage.clickOnPasscodeTextBox();
            signInPage.enterPin(invalidPin);

            signInPage.validatePinError();
        }

        log.info("Enter invalid pin again");
        signInPage.clickOnPasscodeTextBox();
        signInPage.enterPin(invalidPin);

        log.info("Validate too many attempt screen");
        signInPage.validateTooManyAttemptScreen();

        //ToDo: Check for expected
//        log.info("Kill and restart app");
//        signInPage.killAndRestartApp();
//
//        log.info("Validate too many attempt screen");
//        signInPage.validateTooManyAttemptScreen();

        log.info("Click on device back button");
        signInPage.clickDeviceBackButton();

        //ToDo: Check for expected


        log.info("Enter valid pin");
        signInPage.enterPin(pin);
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(groups = {"signInBreach"}, description = "Sign In", dataProvider = "invalidOtpMaxAttemptData", dataProviderClass = SignInDataProvider.class)
    public void invalidOtpMaxAttemptTest(String phoneNumber, String otp, String pin, String name, String email,
                                         String invalidOtp)  {

        log.info("Sign Up");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp(phoneNumber, otp, pin, name, email);

        log.info("Log out");
        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.logOut();

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(pin);

        log.info("Enter invalid otp for max attempt allowed");
        for(int i=1; i <= Integer.parseInt(EnvConfig.getProperty("invalidOtpMaxAttempt")); i++) {

            signInPage.clearOtpTextBox();
            signInPage.enterOtp(invalidOtp);
            signInPage.validateOtpError();

            signInPage.clickOnVerifyOtp();
        }

        log.info("Enter otp again");
        signInPage.clearOtpTextBox();
        signInPage.enterOtp(invalidOtp);

        log.info("Validate too many attempt screen");
        signInPage.validateTooManyAttemptScreen();

        log.info("Kill and restart app");
        signInPage.killAndRestartApp();

        log.info("Validate too many attempt screen");
        signInPage.validateTooManyAttemptScreen();

        log.info("Click on device back button");
        signInPage.clickDeviceBackButton();

        log.info("Enter valid otp");
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }


    @Test(groups = {"signInBreach"}, description = "Sign In", dataProvider = "invalidOtpMaxAttemptData", dataProviderClass = SignInDataProvider.class)
    public void retryAfterInvalidOtpMaxAttemptTest(String phoneNumber, String pin, String invalidOtp, String validOtp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(pin);

        log.info("Enter invalid otp for max attempt allowed");
        for(int i=1; i <= Integer.parseInt(EnvConfig.getProperty("invalidOtpMaxAttempt")); i++) {

            signInPage.clearOtpTextBox();
            signInPage.enterOtp(invalidOtp);
            signInPage.validateOtpError();

            signInPage.clickOnVerifyOtp();
        }

        log.info("Enter otp again");
        signInPage.clearOtpTextBox();
        signInPage.enterOtp(invalidOtp);

        log.info("Validate too many attempt screen");
        signInPage.validateTooManyAttemptScreen();

        log.info("Kill and restart app");
        signInPage.killAndRestartApp();

        log.info("Validate too many attempt screen");
        signInPage.validateTooManyAttemptScreen();

        log.info("Wait for retry button to be clickable and click");
        signInPage.waitForRetryButtonToBeClickable();
        signInPage.clickOnRetryButton();

        log.info("Enter invalid otp");
        signInPage.enterOtp(invalidOtp);
        signInPage.validateOtpError();

        log.info("Enter valid otp");
        signInPage.clearOtpTextBox();
        signInPage.enterOtp(validOtp);
        signInPage.waitForHomePage();
    }

    @Test(groups = {"signInBreach"}, description = "Sign In", dataProvider = "forgotPinMaxAttemptData", dataProviderClass = SignInDataProvider.class)
    public void forgotPinMaxAttemptTest(String phoneNumber, String pin, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.enterPhoneNumberAndContinue(phoneNumber);

        log.info("Click forgot pin link for max allowed attempt");
        for(int i=1; i<=Integer.parseInt(EnvConfig.getProperty("forgotPinMaxAttempt")); i++) {
            signInPage.clickForgotPasswordLink();
            signInPage.navigateBack();
        }

        log.info("Click forgot pin link again");
        signInPage.clickForgotPasswordLink();
        signInPage.validateTooManyAttemptScreen();

        log.info("Kill and restart app");
        signInPage.killAndRestartApp();
        signInPage.validateTooManyAttemptScreen();

        log.info("Click on device back button and click again forgot pin link");
        signInPage.clickDeviceBackButton();
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signInPage.validateTooManyAttemptScreen();

        log.info("Click on device back button and sign in with valid pin and otp");
        signInPage.clickDeviceBackButton();
        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(pin);
        signInPage.enterOtp(otp);
        signInPage.waitForHomePage();
    }

    @Test(enabled = false, groups = {"signInBreach"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
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
