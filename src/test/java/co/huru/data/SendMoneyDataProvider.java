package co.huru.data;

import org.testng.annotations.DataProvider;

public class SendMoneyDataProvider {

    @DataProvider(name = "sendMoneyData")
    public Object[][] sendMoneyData() {
        return new Object[][] {
                {"581111111", "123789", "123456", "1000", "India", "LuLu", "Savings", "Savings", "To Save", "1111"},
        };
    }

    @DataProvider(name = "addRecipientData")
    public Object[][] addRecipientData() {
        return new Object[][] {
                {"581111111", "246135", "123456", "prem", "kumar", "8888888888", "Bro", "196600509966", "ICIC0001967", "nda street", "pune"},
        };
    }

    @DataProvider(name = "addBankAccountData")
    public Object[][] addBankAccountData() {
        return new Object[][] {
                {"581111111", "123789", "123456", "mr.lazaroschaefer", "CvwxAhXTfBaFKvS", "1111"},
        };
    }
}
