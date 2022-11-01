package com.alessandro.gestionale.controller;

import com.alessandro.gestionale.dto.CredentialsDto;
import com.alessandro.gestionale.dto.FeesDto;
import com.alessandro.gestionale.model.Credentials;
import com.alessandro.gestionale.model.Fees;
import com.alessandro.gestionale.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/gestionale/spese")
public class SpeseController {
    @Autowired
    FeesService service;



    @GetMapping("/fees")
    public ResponseEntity<List<Fees>> getAllCredentials() {
        return ResponseEntity.ok(service.getAllFees());
    }

    @PostMapping("/add-fees")
    public ResponseEntity<List<Fees>> insertFees(
            @RequestBody List<FeesDto> feesDto) {
        List<Fees> response = service.addFees(feesDto);
        return ResponseEntity.ok(response);
    }

    @PatchMapping ("/edit-fees")
    public ResponseEntity<Fees> editFees(
            @RequestParam(value = "id", defaultValue = "0") Long id,
            @RequestBody FeesDto newFee) {
        Fees response = service.modifyFee(id, newFee);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/delete-fees")
    public ResponseEntity<List<Fees>> deleteFees(
            @RequestBody List<Long> ids) {
        List<Fees> response = service.deleteFees(ids);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fees-monthly-amount")
    public ResponseEntity<BigDecimal> getMonthlyFeeAmount() {

        return ResponseEntity.ok(service.getMonthlyFeeAmount());
    }





}
