package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model;

import lombok.Data;

import java.util.List;

@Data
public class CompositeGeoLocation {
    private List<Division> divisionList;
    private List<District> districtList;
    private List<Upazilla> upazillaList;
    private List<PostOffice> postOfficeList;
}
