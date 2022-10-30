package com.alessandro.gestionale.controller;

import com.alessandro.gestionale.dto.CredentialsDto;
import com.alessandro.gestionale.model.Credentials;
import com.alessandro.gestionale.service.CredenzialiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @RequestParam(value = "username", defaultValue = "username", required = false) String username,
            @RequestParam(value = "email",    defaultValue = "email", required = false)    String email,
            @RequestParam(value = "password", defaultValue = "password", required = false) String password,
            @RequestParam(value = "platform", defaultValue = "platform", required = false) String platform) {
        List<Credentials> response = credenzialiService.obtainAllByParam(username, email, password, platform);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/add-credentials")
    public ResponseEntity<List<Credentials>> postCredentials(
            @RequestBody List<CredentialsDto> credentials) {
        List<Credentials> response = credenzialiService.addCredentials(credentials);
        return ResponseEntity.ok(response);
    }

    @PatchMapping ("/edit-credentials")
    public ResponseEntity<Credentials> patchCredentials(
            @RequestParam(value = "id", defaultValue = "0") Long id,
            @RequestBody CredentialsDto newCredential) {
        Credentials response = credenzialiService.editCredentials(id, newCredential);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-credentials")
    public ResponseEntity<List<Credentials>> deleteCredentials(
            @RequestBody List<Long> ids) {
        List<Credentials> response = credenzialiService.deleteCredentials(ids);
        return ResponseEntity.ok(response);
    }


}
