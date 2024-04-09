package co.huru.data.signIn;

import co.huru.utils.DataGenerator;
import org.testng.annotations.DataProvider;

public class SignUpDataProvider {

    @DataProvider(name = "signUpData")
    public Object[][] signUpData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", DataGenerator.generateRandomPin(), DataGenerator.generateRandomName(), DataGenerator.generateRandomEmail()},
        };
    }

    @DataProvider(name = "invalidNameData")
    public Object[][] invalidNameData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", ""},
                {DataGenerator.generateRandomMobileNumber(), "123456", "123"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "@#%"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "abc123"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "abc()"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "abc12$&"},
        };
    }

    @DataProvider(name = "invalidEmailData")
    public Object[][] invalidEmailData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", ""},
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", "123"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", "@#&"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", "ABC123"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", "abc@"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", "abc@gmail"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", "cde@gmail."},
                {DataGenerator.generateRandomMobileNumber(), "123456", "Validate", "abc123 @gmail.com"},
        };
    }

    @DataProvider(name = "setInvalidPinData")
    public Object[][] setInvalidPinData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", "name", "email@gmail.com", "111111"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "name", "email@gmail.com", "123456"},
                {DataGenerator.generateRandomMobileNumber(), "123456", "name", "email@gmail.com", "135531"},
        };
    }

    @DataProvider(name = "confirmInvalidPinData")
    public Object[][] confirmInvalidPinData() {
        return new Object[][] {
                {DataGenerator.generateRandomMobileNumber(), "123456", "name", "email@gmail.com", "100900", "1111111"},
        };
    }
}
