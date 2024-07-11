package com.Loyalty.Loyalty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Loyalty.Loyalty.model.Client;
import com.Loyalty.Loyalty.service.ClientService;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients() {
        return new ResponseEntity<>(clientService.getAllClients(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable String id) {
        Client client = clientService.getClientById(id);
        if (client != null) {
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.createClient(client), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}/status")
    public Client updateClientStatus(@PathVariable String id, @RequestBody Map<String, Object> updates) {
        if (updates.containsKey("status")) {
            String status = (String) updates.get("status");
            return clientService.updateClientStatus(id, status);
        } else {
            throw new IllegalArgumentException("Le champ status est obligatoire");
        }
    }
}

