package co.huru.data;

import org.testng.annotations.DataProvider;

import static co.huru.utils.DataObjectMapper.getTestDataObject;

public class SendMoneyDataProvider {

    @DataProvider(name = "sendMoneyData")
    public Object[][] sendMoneyData() {
        return new Object[][] {
                {"581111111", "246135", "123456", "1000", "India", "LuLu", "Savings", "Savings", "To Save", "1111"},
        };
    }

    @DataProvider(name = "addRecipientData")
    public Object[][] addRecipientData() {
        return new Object[][] {
                {getTestDataObject("src/test/resources/testData/addRecipient.json")},
        };
    }
}

