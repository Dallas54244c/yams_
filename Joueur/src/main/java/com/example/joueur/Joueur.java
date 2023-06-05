package com.example.joueur;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.springframework.boot.SpringApplication;

@ApplicationPath("/api")
public class Joueur extends Application {
    public static void main(String[] args){
        SpringApplication.run(Joueur.class,args);
    }


}