package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.service.ClientService;
import com.bakery.finalproject.service.OrderService;
import com.bakery.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/client")
@RequestMapping("/api/bakery")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<Client> addNewClient (@RequestBody ClientDTO clientDTO) {
        Client client = clientService.saveNewClient(clientDTO);
        return ResponseEntity.ok(client);
    }
    @GetMapping("/login")
    public Principal loginClient (Principal client) {
        return client;
    }
//    public ResponseEntity<Client> loginClient (@RequestBody ClientDTO clientDTO) {
//        Client client = clientService.getClientByEmail(clientDTO.getEmail());
//        return ResponseEntity.ok(client);
//    }

    @DeleteMapping("/client/{email}")
    public void deleteClient (@RequestBody ClientDTO clientDTO, @PathVariable("email") String email) {
        clientService.deleteClientByEmail(clientDTO);
    }
    @PostMapping("/client/{email}")
    public ResponseEntity<Client> updateClientByEmail (@RequestBody ClientDTO clientDTO, @PathVariable("email") String email) {
        Client client = clientService.updateClientDetailsByEmail(clientDTO);
        return ResponseEntity.ok(client);
    }
    @GetMapping("/client")
    public ResponseEntity<List<Client>> getAllClients () {
        List<Client> allClients = clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }

}
