package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.CompositeGeoLocation;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.DistrictRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.DivisionRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.PostOfficeRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.UpazillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompositeGeoLocationService {
    @Autowired
    DivisionRepository divisionRepository;
    @Autowired
    DistrictRepository districtRepository;
    @Autowired
    UpazillaRepository upazillaRepository;
    @Autowired
    PostOfficeRepository postOfficeRepository;

    public CompositeGeoLocation compositeGeoLocationList() {
        CompositeGeoLocation compositeGeoLocation = new CompositeGeoLocation();

        compositeGeoLocation.setDivisionList(divisionRepository.findAll());
        compositeGeoLocation.setDistrictList(districtRepository.findAll());
        compositeGeoLocation.setUpazillaList(upazillaRepository.findAll());
        compositeGeoLocation.setPostOfficeList(postOfficeRepository.findAll());
        return compositeGeoLocation;
    }
}
