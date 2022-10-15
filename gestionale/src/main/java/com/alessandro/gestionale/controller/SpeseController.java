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
@RequestMapping("/gestionale/spese")
public class SpeseController {
    @Autowired
    CredenzialiService credenzialiService;



    @GetMapping("/fees")
    public ResponseEntity<String> getAllCredentials() {
        return ResponseEntity.ok(null);
    }



}
