package com.app.gest.immo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

public class SmsRequestDTO {

    @JsonIgnore
    private String apiKey;
    @JsonIgnore
    private String password;
    private String sender;
    private String message;
    private Set<String> phoneNumbers; // Liste des numéros

    // Getters et setters
    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}
