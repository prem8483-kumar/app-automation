package co.huru.data;

import org.testng.annotations.DataProvider;
public class PaymentDataProvider {

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
}

