package co.huru.data;

import org.testng.annotations.DataProvider;

public class ProfileDataProvider {

    @DataProvider(name = "userSignInData")
    public Object[][] userSignInData() {
        return new Object[][] {
                {"520000000", "246135", "123456"},
        };
    }

    @DataProvider(name = "editUserNameData")
    public Object[][] editUserNameData() {
        return new Object[][] {
                {"520000000", "246135", "123456", "kumar"},
        };
    }

    @DataProvider(name = "editUserEmailData")
    public Object[][] editUserEmailData() {
        return new Object[][] {
                {"520000000", "246135", "123456", "edit@gmail.com"},
        };
    }

    @DataProvider(name = "editUserPhoneNumberData")
    public Object[][] editUserPhoneNumberData() {
        return new Object[][] {
                {"520000000", "246135", "123456", "523333333"},
        };
    }

    @DataProvider(name = "changeUserPinData")
    public Object[][] changeUserPinData() {
        return new Object[][] {
                {"520000000", "246135", "123456", "987432"},
        };
    }

    @DataProvider(name = "addBankAccountData")
    public Object[][] addBankAccountData() {
        return new Object[][] {
                {"581111111", "123789", "123456", "mr.lazaroschaefer", "CvwxAhXTfBaFKvS", "1111"},
        };
    }
}
