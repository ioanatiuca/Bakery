package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ClientDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String address;
    private String city;
    private String postalCode;
    private String country;
}
