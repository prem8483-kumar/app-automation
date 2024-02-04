package co.huru.data;

import co.huru.utils.DataGenerator;
import org.testng.annotations.DataProvider;

public class ProfileDataProvider {

    @DataProvider(name = "userSignInData")
    public Object[][] userSignInData() {
        return new Object[][] {
                {"523333333", "100900", "123456"},
        };
    }

    @DataProvider(name = "editUserNameData")
    public Object[][] editUserNameData() {
        return new Object[][] {
                {"523333333", "100900", "123456", DataGenerator.generateRandomName()},
        };
    }

    @DataProvider(name = "editUserEmailData")
    public Object[][] editUserEmailData() {
        return new Object[][] {
                {"523333333", "100900", "123456", DataGenerator.generateRandomEmail()},
        };
    }

    @DataProvider(name = "editUserPhoneNumberData")
    public Object[][] editUserPhoneNumberData() {
        return new Object[][] {
                {"523333333", "100900", "123456", DataGenerator.generateRandomMobileNumber()},
        };
    }

    @DataProvider(name = "changeUserPinData")
    public Object[][] changeUserPinData() {
        return new Object[][] {
                {"523333333", "100900", "123456", DataGenerator.generateRandomPin()},
        };
    }

    @DataProvider(name = "addBankAccountData")
    public Object[][] addBankAccountData() {
        return new Object[][] {
                {"581111111", "123789", "123456", "mr.lazaroschaefer", "CvwxAhXTfBaFKvS", "1111"},
        };
    }
}
