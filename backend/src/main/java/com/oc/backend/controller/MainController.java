package com.oc.backend.controller;

import org.keycloak.representations.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {

   

    @GetMapping(path = "/info")
    public Map getInfo(){

        Map result = new HashMap<>();
        result.put( "info", "Weclome!" );
       
        return result;
    }

}
