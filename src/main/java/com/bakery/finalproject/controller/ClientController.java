package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.service.ClientService;
import com.bakery.finalproject.service.OrderService;
import com.bakery.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200/client")
@RequestMapping("/api/bakery/client")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> addNewClient (@RequestBody ClientDTO clientDTO) {
        Client client = clientService.saveNewClient(clientDTO);
        return ResponseEntity.ok(client);
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
    @GetMapping
    public ResponseEntity<List<Client>> getAllClients () {
        List<Client> allClients = clientService.getAllClients();
        return ResponseEntity.ok(allClients);
    }

}
