package com.example.hebergeur;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class Hebergeur extends Application {
    public static void main(String[] args) {
        SpringApplication.run(Hebergeur.class, args);
    }


}