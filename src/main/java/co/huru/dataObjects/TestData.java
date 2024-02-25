package co.huru.dataObjects;

import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestData {

    User user;
    List<FundTransfer> fundTransfers;

}
