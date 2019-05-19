package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.controller;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.CompositeGeoLocation;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service.CompositeGeoLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/geoLocation")
public class CompositeGeoLocationController {
    @Autowired
    CompositeGeoLocationService compositeGeoLocationService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public CompositeGeoLocation compositeGeoLocationList() {
        return compositeGeoLocationService.compositeGeoLocationList();
    }
}
