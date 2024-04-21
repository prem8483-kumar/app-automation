package co.huru.test.signIn;

import co.huru.data.signIn.SignUpDataProvider;
import co.huru.pageObjects.signIn.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SignUpErrorTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignUpErrorTest.class);

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "invalidNameData", dataProviderClass = SignUpDataProvider.class)
    public void invalidNameTest(String phoneNumber, String otp, String name)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(getDriver());

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterName(name);
        signUpPage.validateNameError();
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "invalidEmailData", dataProviderClass = SignUpDataProvider.class)
    public void invalidEmailTest(String phoneNumber, String otp, String name, String email)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(getDriver());

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);

        if(email.isEmpty()) {
            signUpPage.validateEmailRequiredError();
        } else {
            signUpPage.validateEmailError();
        }
    }

    @Test(groups = {"signUp"}, description = "Sign Up", dataProvider = "setInvalidPinData", dataProviderClass = SignUpDataProvider.class)
    public void setInvalidPinTest(String phoneNumber, String otp, String name, String email, String pin)  {

        log.info("Sign Up Test");
        SignUpPage signUpPage = new SignUpPage(getDriver());

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
        SignUpPage signUpPage = new SignUpPage(getDriver());

        signUpPage.enterPhoneNumberAndContinue(phoneNumber);
        signUpPage.enterOtp(otp);
        signUpPage.enterNameAndContinue(name);
        signUpPage.enterEmailAndContinue(email);
        signUpPage.enterPin(pin);

        signUpPage.enterPinAndConfirm(confirmPin);
        signUpPage.validatePinNotMatchError();
    }

}
