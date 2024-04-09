package co.huru.data.remittance;

import co.huru.dataObjects.Profile;
import org.testng.annotations.DataProvider;

public class ReviewTransferDataProvider {


    @DataProvider(name = "reviewTransferData")
    public Object[][] reviewTransferData() {

        return new Object[][] {

                {Profile.builder()
                        .phoneNumber("554381407")
                        .pin("100900")
                        .otp("123456")
                        .build()
                },
        };
    }

}

