package co.huru.data.remittance;

import org.testng.annotations.DataProvider;

public class SendMoneyE2EDataProvider {

    @DataProvider(name = "sendMoneyData")
    public Object[][] sendMoneyData() {
        return new Object[][] {
                {"src/test/resources/testData/sendMoney.json"},
        };
    }

}

