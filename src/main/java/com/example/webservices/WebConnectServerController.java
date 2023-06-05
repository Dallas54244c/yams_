package com.example.webservices;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WebConnectServerController {
    @PostMapping("/api/server")
    public String handleRequest(@RequestBody String requestData) {
        return "Le serveur a reçu la requête:" + requestData;
    }


}
