package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.enums.ApplicationRole;
import com.bakery.finalproject.enums.Country;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.repository.ClientRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientMapper implements Mapper<Client, ClientDTO> {

    private ClientRepository clientRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public ClientDTO entityToDTO(Client entity) {
        Country country = entity.getCountry();
        return ClientDTO.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .phoneNo(entity.getPhoneNo())
                .address(entity.getAddress())
                .city(entity.getCity())
                .postalCode(entity.getPostalCode())
                .country(country.name())
                .role(entity.getRole().name())
                .build();
    }

    @Override
    public Client DTOToEntity(ClientDTO dto) {
        String email = dto.getEmail();
        Client client = clientRepository.findByEmail(email).orElse(new Client());
        if (dto.getEmail().equals("ioanatiuca@yahoo.com")) {
            client.setRole(ApplicationRole.ADMIN);
        } else {
            client.setRole(ApplicationRole.USER);
        }
        String country = dto.getCountry();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setEmail(email);
        client.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
        client.setPhoneNo(dto.getPhoneNo());
        client.setAddress(dto.getAddress());
        client.setCity(dto.getCity());
        client.setCountry(Country.valueOf(country.toUpperCase()));
        client.setEnabled(false);
        client.setLocked(false);
        return client;
    }
}
