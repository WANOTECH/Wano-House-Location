package com.app.gest.immo.controller;

import com.app.gest.immo.dto.SmsRequestDTO;
import com.app.gest.immo.dto.SmsResponseDTO;
import com.app.gest.immo.implementation.SmsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/sms")
public class SmsController {
    @Autowired
    private SmsServiceImpl smsService;

    @PostMapping("/send")
    public ResponseEntity<Set<SmsResponseDTO>> sendSms(@RequestBody SmsRequestDTO smsRequestDTO) {
        Set<SmsResponseDTO> responses = smsService.sendSms(smsRequestDTO);
        return ResponseEntity.ok(responses);
    }
}
