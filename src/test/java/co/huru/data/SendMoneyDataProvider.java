package co.huru.data;

import org.testng.annotations.DataProvider;
public class SendMoneyDataProvider {

    @DataProvider(name = "sendMoneyData")
    public Object[][] sendMoneyData() {
        return new Object[][] {
                {"src/test/resources/testData/sendMoney.json"},
        };
    }

    @DataProvider(name = "setupTransferData")
    public Object[][] setupTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json"},
        };
    }

    @DataProvider(name = "setupReverseTransferData")
    public Object[][] setupReverseTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json"},
        };
    }

    @DataProvider(name = "decimalSenderAmountTransferData")
    public Object[][] decimalSenderAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "100.50"},
        };
    }

    @DataProvider(name = "minimumSenderAmountTransferData")
    public Object[][] minimumSenderAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "49"},
        };
    }

    @DataProvider(name = "maximumSenderAmountTransferData")
    public Object[][] maximumSenderAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "15001"},
        };
    }

    @DataProvider(name = "decimalReceiverAmountTransferData")
    public Object[][] decimalReceiverAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "India", "100.50"},
                {"src/test/resources/testData/setupTransfer.json", "Pakistan", "100.50"},
        };
    }

    @DataProvider(name = "minimumReceiverAmountTransferData")
    public Object[][] minimumReceiverAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "India", "49"},
                {"src/test/resources/testData/setupTransfer.json", "Pakistan", "49"},
        };
    }

    @DataProvider(name = "maximumReceiverAmountTransferData")
    public Object[][] maximumReceiverAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "India", "15001"},
                {"src/test/resources/testData/setupTransfer.json", "Pakistan", "15001"},
        };
    }

    @DataProvider(name = "addBankAccountData")
    public Object[][] addBankAccountData() {
        return new Object[][] {
                {"src/test/resources/testData/addBankAccount.json"},
        };
    }


    @DataProvider(name = "addRecipientData")
    public Object[][] addRecipientData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json"},
        };
    }

    @DataProvider(name = "invalidFirstNameData")
    public Object[][] invalidFirstNameData() {
        return new Object[][] {
                //{"src/test/resources/testData/addRecipient.json", ""},
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
                {"src/test/resources/testData/addRecipient.json", ""},
                {"src/test/resources/testData/addRecipient.json", ""},
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
                {"src/test/resources/testData/addRecipient.json", ""},
                {"src/test/resources/testData/addRecipient.json", "999999"},
                {"src/test/resources/testData/addRecipient.json", "523333333"},
                {"src/test/resources/testData/addRecipient.json", "0000000000"},
                {"src/test/resources/testData/addRecipient.json", "abcdefghif"},
                {"src/test/resources/testData/addRecipient.json", "@@@@@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999abcde"},
                {"src/test/resources/testData/addRecipient.json", "99999@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999ab@@@@"}
        };
    }

    @DataProvider(name = "invalidAccountNumberData")
    public Object[][] invalidAccountNumberData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", ""},
                {"src/test/resources/testData/addRecipient.json", "00000000000"},
                {"src/test/resources/testData/addRecipient.json", "999999"},
                {"src/test/resources/testData/addRecipient.json", "abcdefghif"},
                {"src/test/resources/testData/addRecipient.json", "@@@@@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999abcde"},
                {"src/test/resources/testData/addRecipient.json", "99999@@@@@@"},
                {"src/test/resources/testData/addRecipient.json", "99999ab@@@@"}
        };
    }

    @DataProvider(name = "invalidIfscCodeData")
    public Object[][] invalidIfscCodeData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", ""},
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
                {"src/test/resources/testData/addRecipient.json", ""},
                {"src/test/resources/testData/addRecipient.json", ""},
                {"src/test/resources/testData/addRecipient.json", "123"},
                {"src/test/resources/testData/addRecipient.json", "@#%"},
                {"src/test/resources/testData/addRecipient.json", "abc123"},
                {"src/test/resources/testData/addRecipient.json", "abc()"},
                {"src/test/resources/testData/addRecipient.json", "abc12$&"},
        };
    }

    @DataProvider(name = "invalidCityData")
    public Object[][] invalidCityData() {
        return new Object[][] {
                {"src/test/resources/testData/addRecipient.json", ""},
                {"src/test/resources/testData/addRecipient.json", ""},
                {"src/test/resources/testData/addRecipient.json", "123"},
                {"src/test/resources/testData/addRecipient.json", "@#%"},
                {"src/test/resources/testData/addRecipient.json", "abc123"},
                {"src/test/resources/testData/addRecipient.json", "abc()"},
                {"src/test/resources/testData/addRecipient.json", "abc12$&"},
        };
    }

}

