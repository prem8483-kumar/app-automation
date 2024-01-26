package co.huru.data;

import org.testng.annotations.DataProvider;

public class SendMoneyDataProvider {

    @DataProvider(name = "sendMoneyData")
    public Object[][] sendMoneyData() {
        return new Object[][] {
                {"581111111", "123789", "123456"},
        };
    }

    @DataProvider(name = "addRecipientData")
    public Object[][] addRecipientData() {
        return new Object[][] {
                {"581111111", "123789", "123456"},
        };
    }

    @DataProvider(name = "addBankAccountData")
    public Object[][] addBankAccountData() {
        return new Object[][] {
                {"581111111", "123789", "123456", "mr.lazaroschaefer", "CvwxAhXTfBaFKvS", "1111"},
        };
    }
}
