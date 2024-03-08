package co.huru.dataObjects;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipient {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String nickName;
    private String relationship;

    private BankAccount bankAccount;
    private Address address;
}
