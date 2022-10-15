package com.alessandro.gestionale.repository;


import com.alessandro.gestionale.model.Credentials;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CredentialsRepository extends CrudRepository<Credentials, Integer> {
    @Query("select c from Credentials c where c.username = :username or c.email = :email or c.platform = :platform or c.password = :password")
    List<Credentials> findAllByParameters(String username, String email, String password, String platform);
}
