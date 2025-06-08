package com.invesco_fintech.service.impl;

import com.invesco_fintech.dto.FinancialEntityCreateRequestDTO;
import com.invesco_fintech.dto.FinancialEntityResponseDTO;
import com.invesco_fintech.dto.FinancialEntityUpdateRequestDTO;
import com.invesco_fintech.entity.FinancialEntity;
import com.invesco_fintech.repository.FinancialEntityRepository;
import com.invesco_fintech.service.FinancialEntityService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FinancialEntityServiceImpl implements FinancialEntityService
{
    private static final Logger logger = LoggerFactory.getLogger(FinancialEntityServiceImpl.class);

    private final FinancialEntityRepository financialEntityRepository;

    @Override
    public FinancialEntityResponseDTO createFinancialEntity(FinancialEntityCreateRequestDTO financialEntityRequestDTO)
    {
        FinancialEntity financialEntity = new FinancialEntity();

        financialEntity.setCompanyName(financialEntityRequestDTO.getCompanyName());
        financialEntity.setTrustName(financialEntityRequestDTO.getTrustName());
        financialEntity.setCompanyType(financialEntityRequestDTO.getCompanyType());
        financialEntity.setAbn(financialEntityRequestDTO.getAbn());
        financialEntity.setAcn(financialEntityRequestDTO.getAcn());
        financialEntity.setRegisteredIn(financialEntityRequestDTO.getRegisteredIn());

        logger.info("Received entity: {}", financialEntity);

        financialEntityRepository.save(financialEntity);

        return createTransactionResponseDTO(financialEntity);
    }

    @Override
    public List<FinancialEntity> getAllFinancialEntities()
    {
        return financialEntityRepository.findAll();
    }

    @Override
    public FinancialEntityResponseDTO getFinancialEntityByID(String entityID)
    {
        return createTransactionResponseDTO(financialEntityRepository.findById(Long.valueOf(entityID)).get());
    }

    public FinancialEntityResponseDTO createTransactionResponseDTO(FinancialEntity entity)
    {
        FinancialEntityResponseDTO  financialEntityResponseDTO = new FinancialEntityResponseDTO();

        financialEntityResponseDTO.setEntityID(entity.getEntityId());
        financialEntityResponseDTO.setCompanyName(entity.getCompanyName());
        financialEntityResponseDTO.setTrustName(entity.getTrustName());
        financialEntityResponseDTO.setAbn(entity.getAbn());
        financialEntityResponseDTO.setAcn(entity.getAcn());
        financialEntityResponseDTO.setCompanyType(entity.getCompanyType());
        financialEntityResponseDTO.setRegisteredIn(entity.getRegisteredIn());

        return financialEntityResponseDTO;
    }

    @Override
    public FinancialEntityResponseDTO updateFinancialEntity(FinancialEntityUpdateRequestDTO financialEntityUpdateRequestDTO)
    {
        FinancialEntity entity = financialEntityRepository.findById(financialEntityUpdateRequestDTO.getEntityID()).get();

        entity.setTrustName(financialEntityUpdateRequestDTO.getTrustName());
        entity.setCompanyName(financialEntityUpdateRequestDTO.getCompanyName());
        entity.setAbn(financialEntityUpdateRequestDTO.getAbn());
        entity.setAcn(financialEntityUpdateRequestDTO.getAcn());
        entity.setCompanyType(financialEntityUpdateRequestDTO.getCompanyType());
        entity.setRegisteredIn(financialEntityUpdateRequestDTO.getRegisteredIn());

        financialEntityRepository.save(entity);

        return createTransactionResponseDTO(entity);
    }

    @Override
    public void deleteFinancialEntityByID(String entityID)
    {
        financialEntityRepository.deleteById(Long.valueOf(entityID));
    }

    @Override
    public void deleteAllFinancialEntities()
    {
        financialEntityRepository.deleteAll();
    }
}
