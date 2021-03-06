package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bakery")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final DaoAuthenticationProvider daoAuthenticationProvider;

    @PostMapping("/client/registration/new")
    public ResponseEntity<String> addNewClient (@RequestBody ClientDTO clientDTO) {
        String clientToken = clientService.saveNewClient(clientDTO);
        return new ResponseEntity<String>(clientToken, HttpStatus.CREATED);
    }

    @GetMapping("/client/registration/confirm/{token}")
    public String confirm (@PathVariable("token") String token) {
        return clientService.confirmToken(token);
    }


    @GetMapping("/admin/client/all")
    public ResponseEntity<List<Client>> getAllClients () {
        List<Client> allClients = clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }
    @PostMapping("/client/registration/login")
    public UserDetails loginClient (@RequestBody ClientDTO clientDTO) {
        UserDetails foundClient = clientService.loadUserByUsername(clientDTO.getEmail());
        if(bCryptPasswordEncoder.matches(clientDTO.getPassword(), foundClient.getPassword())) {
            return foundClient;
        }
        return null;
    }

    @PostMapping("/admin/client/{id}")
    public ResponseEntity<Client> updateClient (@RequestBody ClientDTO clientDTO, @PathVariable("id") Integer id) {
        Client client = clientService.updateClient(clientDTO);
        return ResponseEntity.ok(client);
    }

    @GetMapping("/client/{email}")
    public ResponseEntity<Client> findClientByEmail (@PathVariable("email") String email) {
        Client client = clientService.findByEmail(email);
        return ResponseEntity.ok(client);
    }


}
