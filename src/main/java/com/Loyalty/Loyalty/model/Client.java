package com.Loyalty.Loyalty.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "USER")
public class Client {
    @Id
    private String id;
    private String FirstName;
    private String LastName;
    private String email;
    private String adresse;
    private boolean optInEmail;
    private String phoneNumber;
    private String loyaltyNumber;
    private String status;

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adresse;
    }

    public void setAdress(String adresse) {
        this.adresse = adresse;
    }

    public boolean isOptInEmail() {
        return optInEmail;
    }

    public void setOptInEmail(boolean optInEmail) {
        this.optInEmail = optInEmail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLoyaltyNumber() {
        return loyaltyNumber;
    }

    public void setLoyaltyNumber(String loyaltyNumber) {
        this.loyaltyNumber = loyaltyNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
