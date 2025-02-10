package com.app.gest.immo.implementation;

import com.app.gest.immo.dto.SmsRequestDTO;
import com.app.gest.immo.dto.SmsResponseDTO;
import com.app.gest.immo.service.ISmsService;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class SmsServiceImpl implements ISmsService {

    @Override
    public Set<SmsResponseDTO> sendSms(SmsRequestDTO smsRequestDTO) {
        Set<SmsResponseDTO> responses = new HashSet<>();
        OkHttpClient client = new OkHttpClient();

        smsRequestDTO.setApiKey("A04341D2-9B26-4F90-82D2-F5E7D5F5A233");
        smsRequestDTO.setPassword("AfrYan@1");

        Set<String> phoneNumbers = smsRequestDTO.getPhoneNumbers(); // Liste des numéros

        for (String phone : phoneNumbers) {
            try {
                String url = "https://app.ltmsgroup.com/bulksms/api/v1/push";
                RequestBody body = new FormBody.Builder()
                        .add("api_key", smsRequestDTO.getApiKey())
                        .add("password", smsRequestDTO.getPassword())
                        .add("sender", smsRequestDTO.getSender())
                        .add("message", smsRequestDTO.getMessage())
                        .add("phone", phone)
                        .add("flag", "long_sms")
                        .build();

                Request request = new Request.Builder()
                        .url(url)
                        .post(body)
                        .addHeader("Content-Type", "application/x-www-form-urlencoded")
                        .build();

                try (Response response = client.newCall(request).execute()) {
                    if (response.isSuccessful()) {
                        responses.add(new SmsResponseDTO(phone, "success", response.body().string()));
                    } else {
                        responses.add(new SmsResponseDTO(phone, "error", "Response not successful: " + response.message()));
                    }
                }
            } catch (IOException e) {
                responses.add(new SmsResponseDTO(phone, "error", e.getMessage()));
            }
        }

        return responses; // Renvoie l'ensemble des réponses
    }
}
