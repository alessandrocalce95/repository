package com.alessandro.gestionale.service;

import com.alessandro.gestionale.dto.FeesDto;
import com.alessandro.gestionale.model.Fees;
import com.alessandro.gestionale.repository.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeesService {

    @Autowired
    FeesRepository repository;
    private final static String MONTHLY = "Mensile";


    public List<Fees> getAllFees() {
        return repository.findAll();
    }

    public List<Fees> addFees(List<FeesDto> feesDto) {
        List<Fees> addedFees = new ArrayList<>();
        try {
            for (FeesDto feesToSave : feesDto) {
                Fees savedFees = new Fees();
                savedFees.setName(feesToSave.getName());
                savedFees.setAmount(feesToSave.getAmount());
                savedFees.setPeriodicity(feesToSave.getPeriodicity());
                savedFees.setPayday(feesToSave.getPayday());
                savedFees.setClosingDate(feesToSave.getClosingDate());
                repository.save(savedFees);
                addedFees.add(savedFees);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addedFees;
    }

    public Fees modifyFee(Long id, FeesDto newFee) {
        try {
            Optional<Fees> feeToEdit = repository.findById(id);
            if (feeToEdit.isPresent()) {
                feeToEdit.get().setName(newFee.getName());
                feeToEdit.get().setAmount(newFee.getAmount());
                feeToEdit.get().setPayday(newFee.getPayday());
                feeToEdit.get().setClosingDate(newFee.getClosingDate());
                feeToEdit.get().setPeriodicity(newFee.getPeriodicity());
                return repository.save(feeToEdit.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Fees> deleteFees(List<Long> ids) {
        List<Fees> deletedEntities = new ArrayList<>();
        try {
            for (Long id : ids) {
                Fees feesToDelete = repository.findById(id).isPresent() ? repository.findById(id).get() : null;
                if (feesToDelete != null) repository.delete(feesToDelete);
                deletedEntities.add(feesToDelete);
            }
            return deletedEntities;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deletedEntities;
    }

    public BigDecimal getMonthlyFeeAmount() {
        return repository.calculateMonthlyFees(MONTHLY);
    }
}
