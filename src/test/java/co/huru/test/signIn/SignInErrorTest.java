package co.huru.test.signIn;

import co.huru.data.signIn.SignInDataProvider;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.pageObjects.signIn.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class SignInErrorTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(SignInErrorTest.class);

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "invalidPhoneNumberData", dataProviderClass = SignInDataProvider.class)
    public void phoneNumberValidationTest(String phoneNumber)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(getDriver());

        signInPage.enterPhoneNumber(phoneNumber);
        if(phoneNumber.length() < 9) {
            //Valid phone number
            signInPage.validateDisclaimerCheckBoxSelected("true");
            signInPage.validatePhoneNumberContinueButtonEnabled(false);

            signInPage.clickOnDisclaimerCheckBox();
            signInPage.validatePhoneNumberContinueButtonEnabled(false);

        } else if(phoneNumber.length() > 9) {
            //Valid phone number
            signInPage.validateDisclaimerCheckBoxSelected("true");
            signInPage.validatePhoneNumberContinueButtonEnabled(true);

            signInPage.clickOnDisclaimerCheckBox();
            signInPage.validatePhoneNumberContinueButtonEnabled(false);

            signInPage.clickOnDisclaimerCheckBox();
            signInPage.validatePhoneNumberContinueButtonEnabled(true);

        } else {
            //Invalid phone number
            signInPage.validateDisclaimerCheckBoxSelected("true");
            signInPage.validatePhoneNumberError();

            signInPage.clickOnDisclaimerCheckBox();
            signInPage.validatePhoneNumberError();
        }
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "invalidPinData", dataProviderClass = SignInDataProvider.class)
    public void pinValidationTest(String phoneNumber, String passcode)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(getDriver());

        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);
        signInPage.validatePinError();
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "invalidOtpData", dataProviderClass = SignInDataProvider.class)
    public void otpValidationTest(String phoneNumber, String passcode, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(getDriver());

        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.enterPin(passcode);
        signInPage.enterOtp(otp);
        signInPage.validateOtpError();
    }

    @Test(groups = {"signIn"}, description = "Sign In", dataProvider = "signInData", dataProviderClass = SignInDataProvider.class)
    public void forgotPinSetNewPinSameAsOldPinTest(String phoneNumber, String pin, String otp)  {

        log.info("Sign In Test");
        SignInPage signInPage = new SignInPage(getDriver());
        SignUpPage signUpPage = new SignUpPage(getDriver());

        signInPage.enterPhoneNumberAndContinue(phoneNumber);
        signInPage.clickForgotPasswordLink();
        signUpPage.enterOtp(otp);
        signUpPage.enterPin(pin);
        signUpPage.enterPinAndConfirm(pin);

        signUpPage.validateSamePinAsPreviousError();
    }
}
