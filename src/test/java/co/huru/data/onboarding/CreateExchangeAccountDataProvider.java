package co.huru.data.onboarding;

import co.huru.dataObjects.CreateExchangeAccountData;
import co.huru.dataObjects.Profile;
import org.testng.annotations.DataProvider;

public class CreateExchangeAccountDataProvider {


    @DataProvider(name = "createExchangeAccountData")
    public Object[][] createExchangeAccountData() {

        return new Object[][] {

                { Profile.builder()
                        .phoneNumber("582323232")
                        .pin("100900")
                        .otp("123456")
                        .build(),
                 CreateExchangeAccountData.builder()
                        .annualIncome("100000")
                        .monthlyTransactionNumber("10")
                        .monthlyTransactionAmount("1000")
                        .build()
                },
        };
    }

}

