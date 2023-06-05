package com.example.projet_yams;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestFullControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RestFullController restFullController;

    @Test
    public void testHelloEndpoint() {
        ResponseEntity<String> response = restTemplate.getForEntity(createURL("/"), String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("HELLO", response.getBody());
    }

    @Test
    public void testRollYamsEndpoint() {
        ResponseEntity<int[]> response = restTemplate.getForEntity(createURL("/home"), int[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(5, Objects.requireNonNull(response.getBody()).length);
    }

    private String createURL(String uri) {
        return "http://localhost:" + port + uri;
    }
}
