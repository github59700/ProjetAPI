package com.Loyalty.Loyalty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Loyalty.Loyalty.model.Client;
import com.Loyalty.Loyalty.repository.ClientRepository;
import java.util.Optional;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(String id) {
        return clientRepository.findById(id).orElse(null);
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClientStatus(String id, String status) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (!optionalClient.isPresent()) {
            throw new IllegalArgumentException("ID client introuvable");
        }

        Client client = optionalClient.get();
        client.setStatus(status);

        return clientRepository.save(client);
    }
}

