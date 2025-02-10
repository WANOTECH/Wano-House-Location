package com.app.gest.immo.dto;

public class SmsResponseDTO {

    private String phone;
    private String status;
    private String message;

    public SmsResponseDTO(String phone, String status, String message) {
        this.phone = phone;
        this.status = status;
        this.message = message;
    }

    // Getters et setters
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
