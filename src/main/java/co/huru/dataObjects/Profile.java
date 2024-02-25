package co.huru.dataObjects;


import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {


    private String phoneNumber;
    private String otp;
    private String name;
    private String email;
    private String pin;


}
