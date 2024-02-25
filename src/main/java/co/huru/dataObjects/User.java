package co.huru.dataObjects;


import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    Profile profile;
    List<BankAccount> bankAccounts;
    List<Recipient> recipients;

}
