package com.example.projet_yams;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WebConnectServerControllerTest {

    @Test
    void testHandleRequest() {
        String requestData = "Test Request Data";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        HttpEntity<String> requestEntity = new HttpEntity<>(requestData, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/server", HttpMethod.POST, requestEntity, String.class);

        assertEquals(200, responseEntity.getStatusCodeValue());
        String responseData = responseEntity.getBody();
        assertEquals("Le serveur a reçu la requête:" + requestData, responseData);
    }
}
