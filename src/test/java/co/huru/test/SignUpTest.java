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
    public void signUpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

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
    public void signUpUsingResendOtpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.enterPhoneNumber(phoneNumber);

        signUpPage.waitForResendOtpLink();
        signUpPage.clickResendOtpLink();
        signUpPage.enterOtp(otp);

        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPasscode(passcode);
        signUpPage.confirmPasscode(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void dropOffAtNameScreenAndRestartSignUpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);

        log.info("Get app package");
        String appPackage = driver.getCurrentPackage();
        log.info(appPackage);

        log.info("Kill app");
        driver.terminateApp(appPackage);

        log.info("Restart app");
        driver.activateApp(appPackage);

        log.info("Continue signup");
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);
        signUpPage.enterPasscode(passcode);
        signUpPage.confirmPasscode(passcode);
        signUpPage.skipBiometric();
        signUpPage.waitForHomePage();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "signUpData", dataProviderClass = SignUpDataProvider.class)
    public void dropOffAtPinScreenAndRestartSignUpTest(String phoneNumber, String otp, String passcode, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumber(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.enterEmail(email);

        log.info("Get app package");
        String appPackage = driver.getCurrentPackage();
        log.info(appPackage);

        log.info("Kill app");
        driver.terminateApp(appPackage);

        log.info("Restart app");
        driver.activateApp(appPackage);

        log.info("Continue signup");
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
