package co.huru.test;

import co.huru.data.ProfileDataProvider;
import co.huru.pageObjects.HomePage;
import co.huru.pageObjects.ProfilePage;
import co.huru.pageObjects.SignInPage;
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
        profilePage.editEmail(newEmail);
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "editUserPhoneNumberData", dataProviderClass = ProfileDataProvider.class)
    public void editUserPhoneNumber(String phoneNumber, String passcode, String otp, String newPhoneNumber)  {

        log.info("Edit user phone number test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPersonalDetailsSection();
        profilePage.editPhoneNumber(newPhoneNumber);
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyUserEmailAddressFromProfilePage(String phoneNumber, String passcode, String otp)  {

        log.info("Verify user email address from profile page test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.verifyEmailFromProfilePage(otp);
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
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

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void verifyPaymentMethods(String phoneNumber, String passcode, String otp)  {

        log.info("Verify user payment methods test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPaymentMethodsSection();
        profilePage.verifyPaymentMethods();
    }

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "userSignInData", dataProviderClass = ProfileDataProvider.class)
    public void addBankAccountAsPaymentMethod(String phoneNumber, String passcode, String otp)  {

        log.info("Add bank account as payment method  test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passcode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToPaymentMethodsSection();
        profilePage.addBankAccount();
        //ToDo: Id and Test data required
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

    @Test(groups = {"profile"}, description = "Profile", dataProvider = "changeUserPinData", dataProviderClass = ProfileDataProvider.class)
    public void changePin(String phoneNumber, String oldPasscode, String otp, String newPassCode)  {

        log.info("Change user pin test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, oldPasscode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToLoginSettingsSection();
        profilePage.changePin(oldPasscode, newPassCode, otp);
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
    public void logoutConfirm(String phoneNumber, String passCode, String otp)  {

        log.info("Logout confirm test");
        SignInPage signInPage = new SignInPage(driver);
        signInPage.signIn(phoneNumber, passCode, otp);

        HomePage homePage = new HomePage(driver);
        homePage.goToProfilePage();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.gotToLogoutSection();
        profilePage.logOut();
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
