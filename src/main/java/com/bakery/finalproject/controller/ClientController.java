package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bakery/client")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/registration/new")
    public ResponseEntity<String> addNewClient (@RequestBody ClientDTO clientDTO) {
        String clientToken = clientService.saveNewClient(clientDTO);
        return new ResponseEntity<String>(clientToken, HttpStatus.CREATED);
    }

    @GetMapping("/registration/confirm/{token}")
    public String confirm (@PathVariable("token") String token) {
        return clientService.confirmToken(token);
    }

//    @RequestMapping({ "/validateLogin" })
//    public User validateLogin() {
//        return new User("Successfully authenticated");
//    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAllClients () {
        List<Client> allClients = clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }
    @PostMapping("/registration/login")
    public UserDetails loginClient (@RequestBody ClientDTO clientDTO) {
        UserDetails foundClient = clientService.loadUserByUsername(clientDTO.getEmail());
        if (bCryptPasswordEncoder.matches(clientDTO.getPassword(),foundClient.getPassword())) {
            return foundClient;
        }
        return null;
    }

    @DeleteMapping("/{email}")
    public void deleteClient (@RequestBody ClientDTO clientDTO, @PathVariable("email") String email) {
        clientService.deleteClientByEmail(clientDTO);
    }
    @PostMapping("/{email}")
    public ResponseEntity<Client> updateClientByEmail (@RequestBody ClientDTO clientDTO, @PathVariable("email") String email) {
        Client client = clientService.updateClientDetailsByEmail(clientDTO);
        return ResponseEntity.ok(client);
    }


}
