package co.huru.dataObjects;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateExchangeAccountData {

    private String annualIncome;
    private String monthlyTransactionNumber;
    private String monthlyTransactionAmount;
}
