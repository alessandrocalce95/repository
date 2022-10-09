package com.alessandro.gestionale.service;


import com.alessandro.gestionale.model.Credentials;
import com.alessandro.gestionale.repository.GestionaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GestionaleService {

    @Autowired
    GestionaleRepository repository;

    public List<Credentials> obtainAll() {
        List<Credentials> credentials = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(credentials::add);
        return credentials;
    }


}
