package com.app.gest.immo.service;

import com.app.gest.immo.dto.SmsRequestDTO;
import com.app.gest.immo.dto.SmsResponseDTO;

import java.util.Set;

public interface ISmsService {
    Set<SmsResponseDTO> sendSms(SmsRequestDTO smsRequestDTO);
}
