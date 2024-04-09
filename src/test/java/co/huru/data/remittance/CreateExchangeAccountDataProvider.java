package co.huru.data.remittance;

import co.huru.dataObjects.CreateExchangeAccountData;
import co.huru.dataObjects.Profile;
import org.testng.annotations.DataProvider;

public class CreateExchangeAccountDataProvider {


    @DataProvider(name = "createExchangeAccountData")
    public Object[][] createExchangeAccountData() {

        return new Object[][] {

                { Profile.builder()
                        .phoneNumber("582323232")
                        .pin("232323")
                        .otp("123456")
                        .build(),
                 CreateExchangeAccountData.builder()
                        .annualIncome("600000")
                        .monthlyTransactionNumber("2")
                        .monthlyTransactionAmount("10000")
                        .build()
                },
        };
    }

}

