package co.huru.data;

import co.huru.utils.DataGenerator;
import org.testng.annotations.DataProvider;

public class SignInDataProvider {

    @DataProvider(name = "signInData")
    public Object[][] signInData() {
        return new Object[][] {
                {"581111111", "246135", "123456"},
        };
    }

    @DataProvider(name = "forgotPinData")
    public Object[][] forgotPinData() {
        return new Object[][] {
                {"581111111", DataGenerator.generateRandomPin(), "123456"},
        };
    }

    @DataProvider(name = "signInWithInvalidPinData")
    public Object[][] signInWithInvalidPinData() {
        return new Object[][] {
                {"581111111", "111111"},
        };
    }


    @DataProvider(name = "signInWithInvalidOtpData")
    public Object[][] signInWithInvalidOtpData() {
        return new Object[][] {
                {"581111111", "246135", "111111"},
        };
    }

    @DataProvider(name = "signUpSignInData")
    public Object[][] signUpSignInData() {
        return new Object[][] {
                {"585555555", "123456", "automation", "581111111", "246135", "123456"},
        };
    }
}
