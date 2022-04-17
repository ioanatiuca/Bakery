package com.bakery.finalproject.entity;

import com.bakery.finalproject.enums.ApplicationRole;
import com.bakery.finalproject.enums.Country;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
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
    @Column(name="client_id")
    private Integer clientId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String phoneNo;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String city;
    private String postalCode;
    @Column(nullable = false)
    private Country country;
    @OneToMany (mappedBy = "client")
    private List<Order> orderList;
    private ApplicationRole role;

}
