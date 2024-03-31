package co.huru.data;

import co.huru.dataObjects.Profile;
import org.testng.annotations.DataProvider;
public class SendMoneyDataProvider {

    @DataProvider(name = "confirmPaymentData")
    public Object[][] confirmPaymentData() {
        return new Object[][] {
                {"src/test/resources/testData/sendMoney.json"},
        };
    }

    @DataProvider(name = "confirmPaymentInvalidOtpData")
    public Object[][] confirmPaymentInvalidOtpData() {
        return new Object[][] {
                {"src/test/resources/testData/sendMoney.json", "9999"},
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

    @DataProvider(name = "decimalReceiverAmountTransferData")
    public Object[][] decimalReceiverAmountTransferData() {
        return new Object[][] {
                //{"src/test/resources/testData/setupTransfer.json", "India", "1500.50"},
                {"src/test/resources/testData/setupTransfer.json", "Pakistan", "40000.50"},
        };
    }

    @DataProvider(name = "minimumSenderAmountTransferData")
    public Object[][] minimumSenderAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "49"},
        };
    }

    @DataProvider(name = "minimumReceiverAmountTransferData")
    public Object[][] minimumReceiverAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "India", "49"},
                {"src/test/resources/testData/setupTransfer.json", "Pakistan", "49"},
        };
    }

    @DataProvider(name = "maximumSenderAmountTransferData")
    public Object[][] maximumSenderAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "15001"},
        };
    }

    @DataProvider(name = "maximumReceiverAmountTransferData")
    public Object[][] maximumReceiverAmountTransferData() {
        return new Object[][] {
                {"src/test/resources/testData/setupTransfer.json", "India", "350000"},
                {"src/test/resources/testData/setupTransfer.json", "Pakistan", "1200000"},
        };
    }

    @DataProvider(name = "addPromoCodeData")
    public Object[][] addPromoCodeData() {

        return new Object[][] {

                {Profile.builder()
                        .phoneNumber("")
                        .pin("100900")
                        .otp("123456")
                        .build(),
                        "FIRST50"
                },
        };
    }



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
                {"src/test/resources/testData/addRecipient.json", "523333333"},
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

