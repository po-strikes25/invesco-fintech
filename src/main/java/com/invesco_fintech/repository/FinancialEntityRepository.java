package com.invesco_fintech.repository;

import com.invesco_fintech.entity.FinancialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FinancialEntityRepository extends JpaRepository<FinancialEntity, Long> {
}
