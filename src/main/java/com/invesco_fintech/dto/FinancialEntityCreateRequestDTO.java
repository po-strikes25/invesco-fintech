package com.invesco_fintech.dto;

import com.invesco_fintech.enums.CompanyType;
import com.invesco_fintech.enums.StateType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FinancialEntityCreateRequestDTO
{
    private String companyName;
    private String trustName;
    private CompanyType companyType;
    private StateType registeredIn;
    private String abn;
    private String acn;

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
