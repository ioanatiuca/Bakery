package com.bakery.finalproject.modelDTO;

import com.bakery.finalproject.enums.ApplicationRole;
import com.bakery.finalproject.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ClientDTO implements UserDetails {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNo;
    private String address;
    private String city;
    private String postalCode;
    private String country;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
