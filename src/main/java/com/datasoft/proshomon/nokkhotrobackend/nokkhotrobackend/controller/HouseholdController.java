package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.controller;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service.HouseholdService;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils.Utils;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class HouseholdController {

    @Autowired
    private HouseholdService householdService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Household addHousehold(@RequestBody Household household) {
        household.setCreatedBy(Long.valueOf(Utils.getCurrentLogedInUserId()));
        return householdService.addHousehold(household);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Household> householdList() {
        return householdService.getHouseholdList();
    }

    @RequestMapping(value = "/getHouseholdByContactNumber", method = RequestMethod.POST)
    public Household getHouseholdByContactNumber(@RequestBody String contactNumber) {
        return householdService.findHouseholdByContactNumber(new Gson().fromJson(contactNumber, String.class));
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "Hello Noman";
    }
}
