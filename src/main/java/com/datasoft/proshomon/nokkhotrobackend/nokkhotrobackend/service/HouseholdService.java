package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Beneficiary;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.BeneficiaryFingerprintRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.BeneficiaryRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseholdService {

    @Autowired
    HouseholdRepository householdRepository;
    @Autowired
    BeneficiaryRepository beneficiaryRepository;
    @Autowired
    BeneficiaryFingerprintRepository fingerprintRepository;

    public Household addHousehold(Household household) {
        household.setStatus(Household.Status.ACTIVE);
        return householdRepository.add(household);
    }

    public List<Household> getHouseholdList() {
        return householdRepository.findAll();
    }

    public Household findHouseholdByContactNumber(String contactNumber) {
        Household household = householdRepository.findHouseholdByContactNumber(contactNumber);
        List<Beneficiary> beneficiaryList = beneficiaryRepository.getBeneficiaryListByHouseholdId(household.getId());
        household.setBeneficiaryList(beneficiaryList);
        return household;
    }
}

