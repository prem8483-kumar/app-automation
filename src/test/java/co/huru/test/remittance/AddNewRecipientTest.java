package co.huru.test.remittance;

import co.huru.data.SendMoneyDataProvider;
import co.huru.dataObjects.TestData;
import co.huru.pageObjects.HomePage;
import co.huru.pageObjects.SendMoneyPage;
import co.huru.pageObjects.SignInPage;
import co.huru.utils.AndroidBaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class AddNewRecipientTest extends AndroidBaseTest {

    private static final Logger log = LogManager.getLogger(AddNewRecipientTest.class);

    @Test(groups = {"Send Money"}, description = "Add recipient", dataProvider = "addRecipientData", dataProviderClass = SendMoneyDataProvider.class)
    public void addRecipientTest(TestData testData)  {

        System.out.println(testData.getUser().getRecipients().get(0).getFirstName());


//        log.info("Add Recipient Test");
//        SignInPage signInPage = new SignInPage(driver);
//        signInPage.signIn(phoneNumber, passcode, otp);
//
//        HomePage homePage = new HomePage(driver);
//        homePage.goToSendMoneyPage();
//
//        SendMoneyPage sendMoneyPage = new SendMoneyPage(driver);
//        sendMoneyPage.selectExchange("LuLu");
//        sendMoneyPage.clickOnContinue();
//        sendMoneyPage.clickOnContinue();
//
//        sendMoneyPage.addRecipient(firstName, lastName, mobileNumber, nickName, accountNumber, ifscCode, address, city);
    }

}
