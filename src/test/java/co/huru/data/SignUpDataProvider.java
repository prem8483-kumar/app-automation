package co.huru.data;

import co.huru.utils.DataGenerator;
import org.testng.annotations.DataProvider;

public class SignUpDataProvider {

    @DataProvider(name = "signUpData")
    public Object[][] signUpData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", DataGenerator.generateRandomPin(), DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail()},
        };
    }
}
