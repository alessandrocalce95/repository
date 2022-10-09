package com.alessandro.gestionale.controller;

import com.alessandro.gestionale.service.GestionaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manga")
public class GestionaleController {
    @Autowired
    GestionaleService service;


    @PostMapping("/new-manga")
    public ResponseEntity<String> addManga() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/full-list")
    public ResponseEntity<String> getAllManga() {
        return ResponseEntity.ok(null);
    }

}
