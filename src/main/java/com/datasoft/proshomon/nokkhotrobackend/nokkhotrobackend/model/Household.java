package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class Household {

    private Integer id;
    private int slNo;
    private List<Beneficiary> beneficiaryList;
    private String smartCardId;
    private String householdHeadName;
    private String contactNumber;
    private Status status;
    private String occupation;
    private int numOfMembers;
    private int divisionId;
    private int districtId;
    private int upazillaId;
    private int municipalityId;
    private String wordNo;
    private String address;
    private double latitude;
    private double longitude;
    private Long createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    public enum Status {
        ACTIVE, INACTIVE
    }
}
