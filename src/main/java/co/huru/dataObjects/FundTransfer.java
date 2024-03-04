package co.huru.dataObjects;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FundTransfer {

    private String amount;
    private String receiverCountry;
    private String exchange;
    private String transferPurpose;
    private String fundSource;

    private Recipient recipient;
    private BankAccount bankAccount;

    private ReviewPayment reviewPayment;
    private ConfirmPayment confirmPayment;


}
