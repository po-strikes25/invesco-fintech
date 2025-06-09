package com.invesco_fintech.service.impl;

import com.invesco_fintech.dto.FinancialEntityCreateRequestDTO;
import com.invesco_fintech.dto.FinancialEntityResponseDTO;
import com.invesco_fintech.dto.FinancialEntityUpdateRequestDTO;
import com.invesco_fintech.entity.FinancialEntity;
import com.invesco_fintech.repository.FinancialEntityRepository;
import com.invesco_fintech.service.FinancialEntityService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
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
    @Transactional //what will this do?
    public FinancialEntityResponseDTO updateFinancialEntity(FinancialEntityUpdateRequestDTO financialEntityUpdateRequestDTO)
    {
        logger.info("entity: {}", financialEntityUpdateRequestDTO);

        FinancialEntity entity = financialEntityRepository.findById(financialEntityUpdateRequestDTO.getEntityID())
                .orElseThrow(() -> new EntityNotFoundException("Financial Entity not found with ID:" + financialEntityUpdateRequestDTO.getEntityID()));

        logger.info("entity: {}", entity);

        if(financialEntityUpdateRequestDTO.getTrustName() != null)
        {
            entity.setTrustName(financialEntityUpdateRequestDTO.getTrustName());
        }

        if(financialEntityUpdateRequestDTO.getCompanyName() != null)
        {
            entity.setCompanyName(financialEntityUpdateRequestDTO.getCompanyName());
        }


        if(financialEntityUpdateRequestDTO.getAbn() != null)
        {
            entity.setAbn(financialEntityUpdateRequestDTO.getAbn());
        }

        if(financialEntityUpdateRequestDTO.getAcn() != null)
        {
            entity.setAcn(financialEntityUpdateRequestDTO.getAcn());
        }

        if(financialEntityUpdateRequestDTO.getCompanyType() != null)
        {
            entity.setCompanyType(financialEntityUpdateRequestDTO.getCompanyType());
        }

        if(financialEntityUpdateRequestDTO.getRegisteredIn() != null)
        {
            entity.setRegisteredIn(financialEntityUpdateRequestDTO.getRegisteredIn());
        }

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
