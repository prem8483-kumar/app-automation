package co.huru.data;

import co.huru.utils.DataGenerator;
import org.testng.annotations.DataProvider;

public class SignInDataProvider {

    @DataProvider(name = "signInData")
    public Object[][] signInData() {
        return new Object[][] {
                {"523333333", "100900", "123456"},
        };
    }

    @DataProvider(name = "signUpSignInData")
    public Object[][] signUpSignInData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", DataGenerator.generateRandomName(), "523333333", "100900", "123456"},
        };
    }

    @DataProvider(name = "forgotPinData")
    public Object[][] forgotPinData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", DataGenerator.generateRandomPin(), DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail(),
                        DataGenerator.generateRandomPin()
                },
        };
    }

    @DataProvider(name = "invalidPhoneNumberData")
    public Object[][] invalidPhoneNumberData() {
        return new Object[][] {
                {"5811111"},
                {"5811111111"},
                {"998888888"},
        };
    }

    @DataProvider(name = "invalidPinData")
    public Object[][] invalidPinData() {
        return new Object[][] {
                {"523333333", "111111"},
        };
    }

    @DataProvider(name = "invalidOtpData")
    public Object[][] invalidOtpData() {
        return new Object[][] {
                {"523333333", "100900", "111111"},
        };
    }

    @DataProvider(name = "invalidPinMaxAttemptData")
    public Object[][] invalidPinMaxAttemptData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", DataGenerator.generateRandomPin(), DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail()},
        };
    }

    @DataProvider(name = "invalidOtpMaxAttemptData")
    public Object[][] invalidOtpMaxAttemptData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", DataGenerator.generateRandomPin(), DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail(),
                        "111111"
                },
        };
    }

    @DataProvider(name = "forgotPinMaxAttemptData")
    public Object[][] forgotPinMaxAttemptData() {
        return new Object[][] {
                {"581111111", "100900", "123456"},
        };
    }
}
