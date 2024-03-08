package co.huru.dataObjects;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FundTransfer {

    private String senderAmount;
    private String receiverAmount;
    private String receiverCountry;
    private String exchangeHouse;
    private String transferPurpose;
    private String fundSource;

    private Recipient recipient;
    private BankAccount bankAccount;

    private ReviewPayment reviewPayment;
    private ConfirmPayment confirmPayment;


}
