package com.alessandro.gestionale.service;


import com.alessandro.gestionale.repository.GestionaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionaleService {
    @Autowired
    GestionaleRepository repository;


}
