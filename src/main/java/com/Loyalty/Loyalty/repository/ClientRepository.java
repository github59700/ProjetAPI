package com.Loyalty.Loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.Loyalty.Loyalty.model.Client;

public interface ClientRepository extends MongoRepository<Client, String> {
	Client findByLoyaltyNumber(String loyaltyNumber);
}
