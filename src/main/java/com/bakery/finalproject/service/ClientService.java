package com.bakery.finalproject.service;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.exception.NotFoundException;
import com.bakery.finalproject.mapper.ClientMapper;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ClientMapper clientMapper;

    public Client saveNewClient (ClientDTO clientDTO) {
        Client client = clientMapper.DTOToEntity(clientDTO);
        return clientRepository.save(client);
    }

    public Client updateClientDetailsByEmail (ClientDTO clientDTO) {
        String email = clientDTO.getEmail();
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Sorry, the email you entered is not found in our database. Please try again."));
        return clientRepository.save(clientMapper.DTOToEntity(clientDTO));
    }

    public void deleteClientByEmail (ClientDTO clientDTO) {
        String email = clientDTO.getEmail();
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Sorry, the email you entered is not found in our database. Please try again."));
        clientRepository.delete(client);
    }

    public List<Client> getAllClients () {
        return clientRepository.findAll();
    }

}
