package com.alessandro.gestionale.repository;


import com.alessandro.gestionale.model.Fees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface FeesRepository extends CrudRepository<Fees, Long> {
    List<Fees> findAll();

    @Query(value = "select SUM(AMOUNT) from fees where PERIODICITY = :periodicity AND ISNULL(CLOSING_DATE) or CLOSING_DATE > NOW()", nativeQuery = true)
    BigDecimal calculateMonthlyFees(String periodicity);

}
