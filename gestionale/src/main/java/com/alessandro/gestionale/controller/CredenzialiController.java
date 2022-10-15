package com.alessandro.gestionale.controller;

import com.alessandro.gestionale.model.Credentials;
import com.alessandro.gestionale.service.CredenzialiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/gestionale/credenziali")
public class CredenzialiController {
    @Autowired
    CredenzialiService credenzialiService;



    @GetMapping("/full-list")
    public ResponseEntity<List<Credentials>> getAllCredentials() {
        return ResponseEntity.ok(credenzialiService.obtainAll());
    }

    @GetMapping("/specific-credential")
    public ResponseEntity<List<Credentials>> getCredentialsByParams(
            @RequestParam(value = "username", defaultValue = "username") String username,
            @RequestParam(value = "email",    defaultValue = "email")    String email,
            @RequestParam(value = "password", defaultValue = "password") String password,
            @RequestParam(value = "platform", defaultValue = "platform") String platform) {
        List<Credentials> response = credenzialiService.obtainAllByParam(username, email, password, platform);
        return ResponseEntity.ok(response);
    }

}
