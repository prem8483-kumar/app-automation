package co.huru.dataObjects;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String address;
    private String city;
}
