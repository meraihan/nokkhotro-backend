package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.controller;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Beneficiary;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service.BeneficiaryService;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "/beneficiary")
public class BeneficiaryController {

    @Autowired
    private BeneficiaryService beneficiaryService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Boolean addBeneficiary(@RequestBody Beneficiary beneficiary) throws Exception {
        beneficiary.setCreatedBy(Long.valueOf(Utils.getCurrentLogedInUserId()));
        return beneficiaryService.addBeneficiary(beneficiary);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Beneficiary> householdList() {
        return beneficiaryService.beneficiaryList();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Boolean delete(@RequestBody Integer id) {
        return beneficiaryService.delete(id);
    }

    @RequestMapping(value = "/getPfByBeneficiaryId", method = RequestMethod.POST)
    public String getPfByBeneficiaryId(@RequestBody int beneficiaryId) throws IOException {
        return beneficiaryService.findProfileImage(beneficiaryId);
    }

    @RequestMapping(value = "/getProfilePhotoLocation", method = RequestMethod.POST)
    public String getProfilePhotoLocation(@RequestBody int beneficiaryId) throws IOException {
        return beneficiaryService.getProfilePath(beneficiaryId);
    }

    @RequestMapping(value = "/findById", method = RequestMethod.POST)
    public Beneficiary findById(@RequestBody int beneficiaryId) throws IOException {
        return beneficiaryService.findBeneficiaryById(beneficiaryId);
    }
}
