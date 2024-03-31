package co.huru.data;

import co.huru.dataObjects.Profile;
import org.testng.annotations.DataProvider;

public class SelectPaymentMethodDataProvider {


    @DataProvider(name = "addPromoCodeData")
    public Object[][] addPromoCodeData() {

        return new Object[][] {

                {Profile.builder()
                        .phoneNumber("554381407")
                        .pin("100900")
                        .otp("123456")
                        .build(),
                        "FIRST50"
                },
        };
    }

    @DataProvider(name = "invalidPromoCodeData")
    public Object[][] invalidPromoCodeData() {

        return new Object[][] {

                {Profile.builder()
                        .phoneNumber("554381407")
                        .pin("100900")
                        .otp("123456")
                        .build(),
                        "INVALID"
                },
        };
    }

}

