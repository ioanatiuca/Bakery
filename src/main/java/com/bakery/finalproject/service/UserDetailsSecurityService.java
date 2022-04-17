package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsSecurityService implements UserDetailsService {

    private ClientRepository clientRepository;

    public UserDetailsSecurityService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    //implementarea noastra pe care io dam Springului (cand vrea sa faca logarea , o face pe baza datelor bagate de noi
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Client> optionalUser = clientRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException(email);
        }
        Client client = optionalUser.get();
        Set<GrantedAuthority> roles = new HashSet<>();
        if (client.getRole()!=null) {
            roles.add(new SimpleGrantedAuthority(client.getRole().name()));
        }else{
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return new org.springframework.security.core.userdetails
                .User(client.getEmail(), client.getPassword(), roles);
    }


}