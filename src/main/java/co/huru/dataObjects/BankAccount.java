package co.huru.dataObjects;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    private String accountNumber;
    private String ifscCode;

    private String userName;
    private String password;
    private String otp;
}
