package co.huru.data;

import org.testng.annotations.DataProvider;

public class SignInDataProvider {

    @DataProvider(name = "signInData")
    public Object[][] signInData() {
        return new Object[][] {
                {"520000000", "123789", "123456"},
        };
    }
}
