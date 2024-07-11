package com.Loyalty.Loyalty.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.Loyalty.Loyalty.model.Loyalty;

public interface LoyaltyRepository extends MongoRepository<Loyalty, String> {
}
