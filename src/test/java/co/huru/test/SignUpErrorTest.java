package co.huru.test;

import co.huru.data.SignUpDataProvider;
import co.huru.pageObjects.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SignUpErrorTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignUpErrorTest.class);

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "invalidNameData", dataProviderClass = SignUpDataProvider.class)
    public void invalidNameTest(String phoneNumber, String otp, String name)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.validateNameError();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "invalidEmailData", dataProviderClass = SignUpDataProvider.class)
    public void invalidEmailTest(String phoneNumber, String otp, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.validateEmailError();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "setInvalidPinData", dataProviderClass = SignUpDataProvider.class)
    public void setInvalidPinTest(String phoneNumber, String otp, String name, String email, String pin)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);

        signUpPage.enterPin(pin);
        signUpPage.validateSetPinError();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "confirmInvalidPinData", dataProviderClass = SignUpDataProvider.class)
    public void confirmInvalidPinTest(String phoneNumber, String otp, String name, String email, String pin, String confirmPin)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(driver);

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(pin);

        signUpPage.enterPin(confirmPin);
        signUpPage.validatePinNotMatchError();
    }

}
