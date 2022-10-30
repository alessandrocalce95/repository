package com.alessandro.gestionale.service;


import com.alessandro.gestionale.dto.CredentialsDto;
import com.alessandro.gestionale.model.Credentials;
import com.alessandro.gestionale.repository.CredentialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CredenzialiService {

    @Autowired
    CredentialsRepository repository;

    //ottieni lista completa credenziali
    public List<Credentials> obtainAll() {
        List<Credentials> credentials = new ArrayList<>();
        repository.findAll().iterator().forEachRemaining(credentials::add);
        return credentials;
    }

    //ottieni credenziali a seconda dei parametri di ricerca
    public List<Credentials> obtainAllByParam(String username, String email, String password, String platform) {
        return repository.findAllByParameters(username, email, password, platform);
    }

    //Aggiunge una lista di credenziali e ritorna quella aggiunte
    public List<Credentials> addCredentials(List<CredentialsDto> credentials) {
        List<Credentials> addedCredentials = new ArrayList<>();

        try {
            for (CredentialsDto credentialToSave : credentials) {
                Credentials credentialSaved = new Credentials();
                credentialSaved.setUsername(credentialToSave.getUsername());
                credentialSaved.setEmail(credentialToSave.getEmail());
                credentialSaved.setPassword(credentialToSave.getPassword());
                credentialSaved.setPlatform(credentialToSave.getPlatform());
                repository.save(credentialSaved);
                addedCredentials.add(credentialSaved);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addedCredentials;
    }


    public Credentials editCredentials(Long id , CredentialsDto newCredential) {
        try {
            Optional<Credentials> crendetialToEdit = repository.findById(id);
            if (crendetialToEdit.isPresent()) {
                crendetialToEdit.get().setEmail(newCredential.getEmail());
                crendetialToEdit.get().setPassword(newCredential.getPassword());
                crendetialToEdit.get().setPlatform(newCredential.getPlatform());
                crendetialToEdit.get().setUsername(newCredential.getUsername());
                return repository.save(crendetialToEdit.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Credentials> deleteCredentials(List<Long> ids) {
        List<Credentials> deletedEntities = new ArrayList<>();
        try {
            for (Long id : ids) {
                Credentials credentialToDelete = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
                if (credentialToDelete != null) repository.delete(credentialToDelete);
                deletedEntities.add(credentialToDelete);
            }
            return deletedEntities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deletedEntities;
    }
}
