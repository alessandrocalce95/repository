package com.alessandro.gestionale.controller;

import com.alessandro.gestionale.model.Credentials;
import com.alessandro.gestionale.service.GestionaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gestionale")
public class GestionaleController {
    @Autowired
    GestionaleService service;


    @PostMapping("/new-manga")
    public ResponseEntity<String> addManga() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/full-list")
    public ResponseEntity<List<Credentials>> getAllCredentials() {
        return ResponseEntity.ok(service.obtainAll());
    }

}
