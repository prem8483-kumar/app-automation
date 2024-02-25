package co.huru.dataObjects;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmPayment {

    private String otp;
}
