package com.example.projet_yams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example", "com.example.webservices"})
public class ProjetYamsApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ProjetYamsApplication.class);
    }
    public static void main(String[] args) {
        SpringApplication.run(ProjetYamsApplication.class, args);

        // Création des données de la demande
        String requestData = "Hello, Yams Server!";
        // Définition de l'en-tête de la requête
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        // Création d'entités de demande
        HttpEntity<String> requestEntity = new HttpEntity<>(requestData, headers);
        // Envoi d'une requête POST
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "http://localhost:8080/api/server", HttpMethod.POST, requestEntity, String.class);
        //Obtenir les données de la réponse
        String responseData = responseEntity.getBody();
        System.out.println("Réponse du serveur :" + responseData);

    }

    public static int[] rollDice() {
        int[] dice = new int[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            dice[i] = random.nextInt(6) + 1;
        }
        return dice;
    }

    public static int[] rerollDice(int[] dice, int[] keep) {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            if (!contains(keep, i)) {
                dice[i] = random.nextInt(6) + 1;
            }
        }
        return dice;
    }

    public static boolean contains(int[] arr, int val) {
        for (int i : arr) {
            if (i == val) {
                return true;
            }
        }
        return false;
    }

    public static int[] chooseDiceToKeep(int[] dice) {
        int[] keep = new int[5];
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            if (random.nextBoolean()) {
                keep[i] = 1;
            }
        }
        return keep;
    }

    public static int chooseCategory(int[] dice) {
        Random random = new Random();
        return random.nextInt(13);
    }
}
