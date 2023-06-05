package com.example.appariement;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.springframework.boot.SpringApplication;

@ApplicationPath("/api")
public class Appariement extends Application {
    public static void main(String[] args){
        SpringApplication.run(Appariement.class,args);
    }


}