package com.alessandro.gestionale.repository;


import com.alessandro.gestionale.model.Credentials;
import org.springframework.data.repository.CrudRepository;

public interface GestionaleRepository extends CrudRepository<Credentials, Integer> {
}
