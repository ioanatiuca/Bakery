package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.entity.User;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.service.ClientService;
import com.bakery.finalproject.service.OrderService;
import com.bakery.finalproject.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/bakery/client")
@AllArgsConstructor
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/registration/new")
    public ResponseEntity<String> addNewClient (@RequestBody ClientDTO clientDTO) {
        String clientToken = clientService.saveNewClient(clientDTO);
        return ResponseEntity.ok(clientToken);
    }

    @GetMapping("/registration/confirm/{token}")
    public String confirm (@PathVariable("token") String token) {
        return clientService.confirmToken(token);
    }

//    @GetMapping(produces = "application/json")
    @RequestMapping({ "/validateLogin" })
    public User validateLogin() {
        return new User("Successfully authenticated");
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients () {
        List<Client> allClients = clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }
//    @"/registration/login"
//    public ResponseEntity<Client> loginClient (@RequestBody ClientDTO clientDTO) {
//        Client client = clientService.getClientByEmail(clientDTO.getEmail());
//        return ResponseEntity.ok(client);
//    }

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
