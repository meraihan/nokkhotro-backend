package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.controller;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.BeneficiaryFingerprint;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service.BeneficiaryFingerprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/fingerprint")
public class BeneficiaryFingerPrintController {


    @Autowired
    BeneficiaryFingerprintService beneficiaryFingerprintService;

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public List<BeneficiaryFingerprint> verify(@RequestBody String householdContactNumber) throws IOException {
        return beneficiaryFingerprintService.verify(householdContactNumber);
    }
}
