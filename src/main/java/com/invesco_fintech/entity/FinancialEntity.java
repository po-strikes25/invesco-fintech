package com.invesco_fintech.entity;

import com.invesco_fintech.enums.*;
import jakarta.persistence.*;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Data
@Entity
@Table(name = "financial_entity")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class FinancialEntity
{
    private static final Logger logger = LoggerFactory.getLogger(FinancialEntity.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entityId;

    @Column(nullable = false)
    private String companyName;

    @Column(nullable = false)
    private String trustName;

    /*postman is not taking companyType = "INC", instead takes null*/
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CompanyType companyType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StateType registeredIn;

    private String abn;
    private String acn;

    public Long getEntityId() {
        return entityId;
    }

    public void setEntityId(Long entityId) {
        this.entityId = entityId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTrustName() {
        return trustName;
    }

    public void setTrustName(String trustName) {
        this.trustName = trustName;
    }

    public CompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(CompanyType companyType) {
        this.companyType = companyType;
    }

    public StateType getRegisteredIn() {
        return registeredIn;
    }

    public void setRegisteredIn(StateType registeredIn) {
        this.registeredIn = registeredIn;
    }

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getAcn() {
        return acn;
    }

    public void setAcn(String acn) {
        this.acn = acn;
    }
}
