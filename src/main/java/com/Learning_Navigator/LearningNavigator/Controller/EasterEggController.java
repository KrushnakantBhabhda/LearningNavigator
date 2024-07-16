package com.Learning_Navigator.LearningNavigator.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/hidden")
public class EasterEggController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/easter-egg")
    public ResponseEntity<String> getEasterEgg() {
        String url = "http://numbersapi.com/random/math";
        String response = restTemplate.getForObject(url, String.class);
        return ResponseEntity.ok(response);
    }
    
}
