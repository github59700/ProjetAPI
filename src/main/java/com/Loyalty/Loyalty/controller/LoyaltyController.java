package com.Loyalty.Loyalty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.Loyalty.Loyalty.model.Loyalty;
import com.Loyalty.Loyalty.service.LoyaltyService;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/loyalty")
public class LoyaltyController {
	
    @Autowired
    private LoyaltyService loyaltyService;

    @PostMapping
    public ResponseEntity<?> createLoyalty(@RequestBody Loyalty loyalty) {	
    	try {
            Loyalty createdLoyalty = loyaltyService.createLoyalty(loyalty);
            return new ResponseEntity<>(createdLoyalty, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
        	Map<String, String> response = new HashMap<>();
            response.put("erreur", "Le numéro de fidelité entré n'existe pas en BDD");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
        	Map<String, String> response = new HashMap<>();
            response.put("erreur", "Erreur interne au niveau du serveur");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Loyalty>> getAllLoyalties() {
        return new ResponseEntity<>(loyaltyService.getAllLoyalties(), HttpStatus.OK);
    }
}

