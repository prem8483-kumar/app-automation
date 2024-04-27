package co.huru.data.onboarding;

import co.huru.dataObjects.CreateExchangeAccountData;
import co.huru.dataObjects.Profile;
import org.testng.annotations.DataProvider;

public class CreateExchangeAccountDataProvider {

    private Profile getProfileData(String phoneNumber, String pin, String otp) {
        return Profile.builder()
                .phoneNumber(phoneNumber)
                .pin(pin)
                .otp(otp)
                .build();
    }

    private CreateExchangeAccountData getCrateExchangeAccountData(String annualIncome, String monthlyTransactionNumber, String monthlyTransactionAmount) {
        return CreateExchangeAccountData.builder()
                .annualIncome(annualIncome)
                .monthlyTransactionNumber(monthlyTransactionNumber)
                .monthlyTransactionAmount(monthlyTransactionAmount)
                .build();
    }

    @DataProvider(name = "createExchangeAccountData")
    public Object[][] createExchangeAccountData() {

        return new Object[][] {
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "10", "1000")},
        };
    }

    @DataProvider(name = "annualIncomeInvalidData")
    public Object[][] annualIncomeInvalidData() {

        return new Object[][] {
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("", "10", "1000")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("abcdef", "10", "1000")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("123@#", "10", "1000")},
        };
    }

    @DataProvider(name = "monthlyTransactionNumberInvalidData")
    public Object[][] monthlyTransactionNumberInvalidData() {

        return new Object[][] {
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "", "1000")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "0", "1000")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "ab", "1000")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "1%", "1000")},
        };
    }

    @DataProvider(name = "monthlyTransactionAmountInvalidData")
    public Object[][] monthlyTransactionAmountInvalidData() {

        return new Object[][] {
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "10", "")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "10", "000")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "10", "abc")},
                {getProfileData("582323232", "100900", "123456"), getCrateExchangeAccountData("100000", "10", "24*")},
        };
    }


}

