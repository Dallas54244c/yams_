package com.example.proba;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
@ApplicationPath("/api")
public class Proba extends Application {
    public static void main(String[] args){
        SpringApplication.run(Proba.class,args);
    }


}