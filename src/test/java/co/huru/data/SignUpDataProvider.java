package co.huru.data;

import org.testng.annotations.DataProvider;

public class SignUpDataProvider {

    @DataProvider(name = "signUpData")
    public Object[][] signUpData() {
        return new Object[][] {
                {"581111111", "123456", "123789", "automation", "new.automation@gmail.com"},
        };
    }
}
