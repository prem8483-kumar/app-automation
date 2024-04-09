package co.huru.test.signIn;

import co.huru.data.signIn.SignUpDataProvider;
import co.huru.pageObjects.signIn.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SignUpTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignUpTest.class);

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void signUpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.verifyPhoneNumberScreen();
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);

        signUpPage.verifyOtpScreen();
        signUpPage.enterOtp(otp);

        signUpPage.verifyNameScreen();
        signUpPage.enterNameAndContinue(name);

        signUpPage.verifyEmailScreen();
        signUpPage.enterEmailAndContinue(email);

        signUpPage.verifySetPinScreen();
        signUpPage.enterPin(passcode);

        signUpPage.verifyConfirmPinScreen();
        signUpPage.enterPinAndConfirm(passcode);

        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void signUpUsingResendOtpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);

        signUpPage.waitForResendOtpLink();
        signUpPage.clickResendOtpLink();
        signUpPage.enterOtp(otp);

        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(passcode);
        signUpPage.enterPinAndConfirm(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void dropOffAtOtpScreenAndRestartSignUpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);

        log.info("Kill and restart app");
        signUpPage.killAndRestartApp();

        log.info("Continue signup");
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);

        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(passcode);
        signUpPage.enterPinAndConfirm(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void dropOffAtOtpScreenAndRestartSignUpAfter30SecondsTest(String phoneNumber, String otp, String passcode, String name, String email) throws InterruptedException {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);

        log.info("Kill wait and restart app");
        signUpPage.killWaitAndRestartApp(30000);

        log.info("Continue signup");
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.clickResendOtpLink();
        signUpPage.enterOtp(otp);

        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(passcode);
        signUpPage.enterPinAndConfirm(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }



    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void dropOffAtNameScreenAndRestartSignUpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);

        log.info("Kill and restart app");
        signUpPage.killAndRestartApp();

        log.info("Continue signup");
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(passcode);
        signUpPage.enterPinAndConfirm(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void dropOffAtPinScreenAndRestartSignUpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);

        log.info("Kill and restart app");
        signUpPage.killAndRestartApp();

        log.info("Continue signup");
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(passcode);
        signUpPage.enterPinAndConfirm(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromOtpScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.navigateBack();
        signUpPage.verifyPhoneNumberPreFilled(phoneNumber);

    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromNameScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.navigateBack();
        signUpPage.verifyPhoneNumberPreFilled(phoneNumber);

    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromEmailScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.navigateBack();
        signUpPage.verifyNamePreFilled(name);

    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromEnterPasscodeScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.navigateBack();
        signUpPage.verifyPhoneNumberPreFilled(phoneNumber);
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromConfirmPasscodeScreen(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(passcode);
        signUpPage.navigateBack();
        signUpPage.enterPin(passcode);
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromSuccessScreen(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(passcode);
        signUpPage.enterPinAndConfirm(passcode);
        signUpPage.clickDeviceBackButton();
        signUpPage.validateAppClosed();
    }
}
