package com.bakery.finalproject.mapper;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.enums.Country;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ClientMapper implements Mapper<Client, ClientDTO> {
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public ClientDTO entityToDTO(Client entity) {
        Country country = entity.getCountry();
        return ClientDTO.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .phoneNo(entity.getPhoneNo())
                .address(entity.getAddress())
                .city(entity.getCity())
                .postalCode(entity.getPostalCode())
                .country(country.name())
                .build();
    }

    @Override
    public Client DTOToEntity(ClientDTO dto) {
        String email = dto.getEmail();
        Client client = clientRepository.findByEmail(email).orElse(new Client());
        String country = dto.getCountry();
        client.setFirstName(dto.getFirstName());
        client.setLastName(dto.getLastName());
        client.setEmail(dto.getEmail());
        client.setPhoneNo(dto.getPhoneNo());
        client.setAddress(dto.getAddress());
        client.setCity(dto.getCity());
        client.setCountry(Country.valueOf(country.toUpperCase()));
        return client;
    }
}
