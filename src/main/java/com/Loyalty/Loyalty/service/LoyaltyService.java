package com.Loyalty.Loyalty.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Loyalty.Loyalty.model.Loyalty;
import com.Loyalty.Loyalty.model.Client;
import com.Loyalty.Loyalty.repository.LoyaltyRepository;
import com.Loyalty.Loyalty.repository.ClientRepository;
import java.util.List;

@Service
public class LoyaltyService {
    @Autowired
    private LoyaltyRepository loyaltyRepository;
    @Autowired
    private ClientRepository clientRepository;

    public Loyalty createLoyalty(Loyalty loyalty) {
    	Client clientByLoyaltyNumber = clientRepository.findByLoyaltyNumber(loyalty.getLoyaltyNumber());
        if (clientByLoyaltyNumber == null) {
            throw new IllegalArgumentException("LoyaltyNumber introuvable");
        }
        return loyaltyRepository.save(loyalty);
    }

    public List<Loyalty> getAllLoyalties() {
        return loyaltyRepository.findAll();
    }
}

