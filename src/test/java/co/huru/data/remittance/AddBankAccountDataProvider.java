package co.huru.data.remittance;

import org.testng.annotations.DataProvider;

public class AddBankAccountDataProvider {

    @DataProvider(name = "addBankAccountData")
    public Object[][] addBankAccountData() {
        return new Object[][] {
                {"src/test/resources/testData/addBankAccount.json"},
        };
    }

    @DataProvider(name = "addBankAccountWithInvalidCredentialsData")
    public Object[][] addBankAccountWithInvalidCredentialsData() {
        return new Object[][] {
                {"src/test/resources/testData/addBankAccount.json", "prem.kumar", "prem@123"},
        };
    }

    @DataProvider(name = "addBankAccountWithInvalidOtpData")
    public Object[][] addBankAccountWithInvalidOtpData() {
        return new Object[][] {
                {"src/test/resources/testData/addBankAccount.json", "9999"},
        };
    }
}

