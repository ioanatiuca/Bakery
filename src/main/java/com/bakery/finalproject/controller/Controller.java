package com.bakery.finalproject.controller;

import com.bakery.finalproject.entity.Client;
import com.bakery.finalproject.modelDTO.ClientDTO;
import com.bakery.finalproject.service.ClientService;
import com.bakery.finalproject.service.OrderService;
import com.bakery.finalproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/bakery")
public class Controller {
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @PostMapping("/client")
    public ResponseEntity<Client> addNewClient (@RequestBody ClientDTO clientDTO) {
        Client client = clientService.saveNewClient(clientDTO);
        return ResponseEntity.ok(client);
    }
    @DeleteMapping("/client/{email}")
    public void deleteClient (@RequestBody ClientDTO clientDTO, @PathVariable("email") String email) {
        clientService.deleteClientByEmail(clientDTO);
    }
    @PostMapping("/client/{email}")
    public ResponseEntity<Client> updateClientByEmail (@RequestBody ClientDTO clientDTO, @PathVariable("email") String email) {
        Client client = clientService.updateClientDetailsByEmail(clientDTO);
        return ResponseEntity.ok(client);
    }

}
