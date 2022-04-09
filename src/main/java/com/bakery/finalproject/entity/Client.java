package com.bakery.finalproject.entity;

import com.bakery.finalproject.enums.Country;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {
    @Id
    @GeneratedValue
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNo;
    private String address;
    private String city;
    private String postalCode;
    private Country country;
    @OneToMany
    private List<Order> orderList;
}
