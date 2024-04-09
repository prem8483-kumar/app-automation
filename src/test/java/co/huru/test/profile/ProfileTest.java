package co.huru.test.profile;

import co.huru.data.profile.ProfileDataProvider;
import co.huru.pageObjects.home.HomePage;
import co.huru.pageObjects.profile.ProfilePage;
import co.huru.pageObjects.signIn.SignInPage;
import co.huru.pageObjects.signIn.SignUpPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class ProfileTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(ProfileTest.class);

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "editUserNameData", dataProviderClass = ProfileDataProvider.class)
    public void editUserName(String phoneNumber, String passcode, String otp, String newName)  {

        log.info("Edit user name test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPersonalDetailsSection();
        profilePage.editName(newName);
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "editUserEmailData", dataProviderClass = ProfileDataProvider.class)
    public void editUserEmail(String phoneNumber, String passcode, String otp, String newEmail)  {

        log.info("Edit user email address test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPersonalDetailsSection();
        profilePage.editEmail(newEmail, otp);
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "editUserPhoneNumberData", dataProviderClass = ProfileDataProvider.class)
    public void editUserPhoneNumber(String phoneNumber, String otp, String pin, String name, String email, String newPhoneNumber)  {

        log.info("Edit user phone number test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp(phoneNumber, otp, pin, name, email);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPersonalDetailsSection();
        profilePage.editPhoneNumber(newPhoneNumber, otp);

        profilePage.gotToLogoutSection();
        profilePage.logOutConfirm();

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(newPhoneNumber, pin, otp);
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "changeUserPinData", dataProviderClass = ProfileDataProvider.class)
    public void changePin(String phoneNumber, String otp, String pin, String name, String email,
                          String newPin)  {

        log.info("Change user pin test");
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.signUp(phoneNumber, otp, pin, name, email);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToLoginSettingsSection();
        profilePage.changePin(pin, newPin, otp);

        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, newPin, otp);
    }

    //Already being covered in edit email flow
    @Test(enabled = false, groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyUserEmailAddressFromProfilePage(String phoneNumber, String passcode, String otp)  {

        log.info("Verify user email address from profile page test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyEmailFromProfilePage(otp);
    }

    //Already being covered in edit email flow
    @Test(enabled = false, groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyUserEmailAddressFromPersonalDetailsPage(String phoneNumber, String passcode, String otp)  {

        log.info("Verify user email address form personal details page test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPersonalDetailsSection();
        profilePage.verifyEmailFromPersonalDetailsPage(otp);
    }

    //add account button removed
    @Test(enabled = false, groups = {"profile"}, description = "Profile", dataProvider = "addBankAccountData", dataProviderClass = ProfileDataProvider.class)
    public void addBankAccountAsPaymentMethod(String phoneNumber, String passcode, String otp,
                                              String bankUserName, String bankPassword, String bankOtp)  {

        log.info("Add bank account as payment method  test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPaymentMethodsSection();
        profilePage.addBankAccount(bankUserName, bankPassword, bankOtp);

    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyCashbackRewards(String phoneNumber, String passcode, String otp)  {

        log.info("Verify cashback rewards test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToCashbackRewardsSection();
        profilePage.verifyCashbackRewards();
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyTermsAndConditions(String phoneNumber, String passcode, String otp)  {

        log.info("Verify terms & conditions test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToTermsAndConditionSection();
        profilePage.verifyTermsAndConditions();
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyPrivacyPolicy(String phoneNumber, String passcode, String otp)  {

        log.info("Verify privacy policy test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPrivacyPolicySection();
        profilePage.verifyPrivacyPolicy();
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyHelpAndSupport(String phoneNumber, String passcode, String otp)  {

        log.info("Verify help & support test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToHelpAndSupportSection();
        profilePage.verifyHelpAndSupport();
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void logoutConfirm(String phoneNumber, String passCode, String otp)  {

        log.info("Logout confirm test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passCode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToLogoutSection();
        profilePage.logOutConfirm();
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void logoutCancel(String phoneNumber, String passCode, String otp)  {

        log.info("Logout cancel test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passCode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToLogoutSection();
        profilePage.logOutCancel();
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void enableBiometric(String phoneNumber, String passcode, String otp)  {

        log.info("Enable biometric test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToLoginSettingsSection();
        profilePage.enableBiometric(passcode);
    }


    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void activateAccount(String phoneNumber, String passCode, String otp)  {

        log.info("Activate account test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passCode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.activateAccount();
    }
}
