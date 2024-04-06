package co.huru.data;
import org.testng.annotations.DataProvider;

public class SetupTransferDataProvider {

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
                {"src/test/resources/testData/setupTransfer.json", "India", "1500.50"},
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


}

