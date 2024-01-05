package co.huru.test;

import co.huru.data.SignUpDataProvider;
import co.huru.pageObjects.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SignUpTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignUpTest.class);

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void signUp(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPasscode(passcode);
        signUpPage.confirmPasscode(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromOtpScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.navigateBack();
        signUpPage.verifyPhoneNumberPreFilled(phoneNumber);

    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromNameScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.navigateBack();
        signUpPage.verifyPhoneNumberPreFilled(phoneNumber);

    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromEmailScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.navigateBack();
        signUpPage.verifyNamePreFilled(name);

    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromEnterPasscodeScreen(String phoneNumber, String otp, String pin, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.navigateBack();
        signUpPage.verifyPhoneNumberPreFilled(phoneNumber);
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromConfirmPasscodeScreen(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPasscode(passcode);
        signUpPage.navigateBack();
        signUpPage.enterPasscode(passcode);
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void navigateBackFromSuccessScreen(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPasscode(passcode);
        signUpPage.confirmPasscode(passcode);
        signUpPage.navigateBack();
        //ToDo
        log.info(driver.currentActivity());
    }
}
