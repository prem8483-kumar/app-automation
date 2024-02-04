package co.huru.data;

import org.testng.annotations.DataProvider;

public class SignUpDataProvider {

    @DataProvider(name = "signUpData")
    public Object[][] signUpData() {
        return new Object[][] {
                {"585555555", "123456", "123789", "automation", "signup123@gmail.com"},
        };
    }
}
