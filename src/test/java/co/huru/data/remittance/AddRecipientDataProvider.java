package co.huru.data.remittance;

import org.testng.annotations.DataProvider;

public class AddRecipientDataProvider {

    @DataProvider(name = "addRecipientData")
    public Object[][] addRecipientData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json"},
        };
    }

    @DataProvider(name = "invalidFirstNameData")
    public Object[][] invalidFirstNameData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", "123"},
                {"src/test/resources/testData/addRecipient.json", "@#%"},
                {"src/test/resources/testData/addRecipient.json", "abc123"},
                {"src/test/resources/testData/addRecipient.json", "abc()"},
                {"src/test/resources/testData/addRecipient.json", "abc12$&"},
        };
    }

    @DataProvider(name = "invalidLastNameData")
    public Object[][] invalidLastNameData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", "123"},
                {"src/test/resources/testData/addRecipient.json", "@#%"},
                {"src/test/resources/testData/addRecipient.json", "abc123"},
                {"src/test/resources/testData/addRecipient.json", "abc()"},
                {"src/test/resources/testData/addRecipient.json", "abc12$&"},
        };
    }

    @DataProvider(name = "invalidMobileNumberData")
    public Object[][] invalidMobileNumberData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", "abcdefghif"},
                {"src/test/resources/testData/addRecipient.json", "@@@@@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999abcde"},
                {"src/test/resources/testData/addRecipient.json", "99999@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999ab@@@@"},
                {"src/test/resources/testData/addRecipient.json", "999999"},
                {"src/test/resources/testData/addRecipient.json", "623333333"},
        };
    }

    @DataProvider(name = "invalidAccountNumberData")
    public Object[][] invalidAccountNumberData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", "abcdefghif"},
                {"src/test/resources/testData/addRecipient.json", "@@@@@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999abcde"},
                {"src/test/resources/testData/addRecipient.json", "99999@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999ab@@@@"},
                {"src/test/resources/testData/addRecipient.json", "999999"},
        };
    }

    @DataProvider(name = "invalidIfscCodeData")
    public Object[][] invalidIfscCodeData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", "999999"},
                {"src/test/resources/testData/addRecipient.json", "abcdefghif"},
                {"src/test/resources/testData/addRecipient.json", "@@@@@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999abcde"},
                {"src/test/resources/testData/addRecipient.json", "99999@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999ab@@@@"}
        };
    }

    @DataProvider(name = "invalidAddressData")
    public Object[][] invalidAddressData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", "@#%"},
                {"src/test/resources/testData/addRecipient.json", "abc()"},
                {"src/test/resources/testData/addRecipient.json", "abc12$&"},
        };
    }

    @DataProvider(name = "invalidCityData")
    public Object[][] invalidCityData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", "123"},
                {"src/test/resources/testData/addRecipient.json", "@#%"},
                {"src/test/resources/testData/addRecipient.json", "abc123"},
                {"src/test/resources/testData/addRecipient.json", "abc()"},
                {"src/test/resources/testData/addRecipient.json", "abc12$&"},
        };
    }

}

