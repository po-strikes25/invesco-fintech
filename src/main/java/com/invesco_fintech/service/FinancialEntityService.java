package com.invesco_fintech.service;

import com.invesco_fintech.dto.FinancialEntityCreateRequestDTO;
import com.invesco_fintech.dto.FinancialEntityResponseDTO;
import com.invesco_fintech.dto.FinancialEntityUpdateRequestDTO;
import com.invesco_fintech.entity.FinancialEntity;

import java.util.List;

public interface FinancialEntityService
{
    /* 1. Create new Financial Entity */
    FinancialEntityResponseDTO createFinancialEntity(FinancialEntityCreateRequestDTO financialEntityRequestDTO);

    /* 2. Fetch all Financial Entities */
    List<FinancialEntity> getAllFinancialEntities();

    /* 3. Fetch Financial Entity by ID */
    FinancialEntityResponseDTO getFinancialEntityByID(String entityID);

    /* 4. Update Financial Entity by ID */
    FinancialEntityResponseDTO updateFinancialEntity(FinancialEntityUpdateRequestDTO financialEntityUpdateRequestDTO);

    /* 5. Delete Financial Entity by ID */
    void deleteFinancialEntityByID(String entityID);

    /* 6. Delete All Financial Entities */
    void deleteAllFinancialEntities();
}
