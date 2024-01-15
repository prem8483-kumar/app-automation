package co.huru.data;

import org.testng.annotations.DataProvider;

public class SignInDataProvider {

    @DataProvider(name = "signInData")
    public Object[][] signInData() {
        return new Object[][] {
                {"520000000", "246135", "123456"},
        };
    }

    @DataProvider(name = "forgotPinData")
    public Object[][] forgotPinData() {
        return new Object[][] {
                {"520000000", "246135", "123456"},
        };
    }
}
