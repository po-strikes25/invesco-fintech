package com.invesco_fintech.controller;

import com.invesco_fintech.dto.FinancialEntityCreateRequestDTO;
import com.invesco_fintech.dto.FinancialEntityResponseDTO;
import com.invesco_fintech.dto.FinancialEntityUpdateRequestDTO;
import com.invesco_fintech.entity.FinancialEntity;
import com.invesco_fintech.service.FinancialEntityService;
import com.invesco_fintech.service.impl.FinancialEntityServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/invesco-fintech")
@CrossOrigin(origins = "http://localhost:8686")
@RequiredArgsConstructor
public class FinancialEntityController
{
    private static final Logger logger = LoggerFactory.getLogger(FinancialEntity.class);

    /*  final keyword is very important here
        else the lombok annotation required args constructor * */
    private final FinancialEntityServiceImpl financialEntityServiceImpl;

    /* removed @Valid */
    @PostMapping("/post-financial-entity")
    private ResponseEntity<FinancialEntityResponseDTO> createFinancialEntity(@RequestBody FinancialEntityCreateRequestDTO financialEntityCreateRequestDTO)
    {
        FinancialEntityResponseDTO financialEntityResponseDTO = financialEntityServiceImpl.createFinancialEntity(financialEntityCreateRequestDTO);

        logger.info("Received entity: {}", financialEntityResponseDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(financialEntityResponseDTO);
    }

    @GetMapping("/get-all")
    private Set<FinancialEntityResponseDTO> getAllFinancialEntities()
    {
        return financialEntityServiceImpl.getAllFinancialEntities()
                                        .stream()
                                        .map((financialEntity -> financialEntityServiceImpl.createTransactionResponseDTO(financialEntity)))
                                        .collect(Collectors.toSet());
    }

    @GetMapping("/get-financial-entity/{entityID}")
    private ResponseEntity<FinancialEntityResponseDTO> getFinancialEntityByID(@PathVariable String entityID)
    {
        FinancialEntityResponseDTO financialEntityResponseDTO = financialEntityServiceImpl.getFinancialEntityByID(entityID);

        return ResponseEntity.status(HttpStatus.FOUND).body(financialEntityResponseDTO);
    }

    @PutMapping("/put-financial-entity")
    private ResponseEntity<FinancialEntityResponseDTO> updateFinancialEntity(@RequestBody @Valid FinancialEntityUpdateRequestDTO financialEntityUpdateRequestDTO)
    {
        FinancialEntityResponseDTO financialEntityResponseDTO = financialEntityServiceImpl.updateFinancialEntity(financialEntityUpdateRequestDTO);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(financialEntityResponseDTO);
    }

    @DeleteMapping("/delete-financial-entity/{entityID}")
    private ResponseEntity<?> deleteFinancialEntityByID(@PathVariable String entityID)
    {
        financialEntityServiceImpl.deleteFinancialEntityByID(entityID);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/delete-all/")
    private ResponseEntity<?> deleteAllFinancialEntities()
    {
        financialEntityServiceImpl.deleteAllFinancialEntities();

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}