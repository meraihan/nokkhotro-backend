package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class Beneficiary {
    private Integer id;
    private String fullName;
    private Household household;
    private String contactNumber;
    private List<BeneficiaryFingerprint> beneficiaryFingerprintList;
    private String bloodGroup;
    private MarritalStatus marritalStatus;
    private String relationWithHousehold;
    private Date dateOfBirth;
    private Gender gender;
    private String base64Img;
    private byte[] photo;
    private String photoPath;
    private String fingerprintKey1;
    private String fingerprintKey2;
    private String disability;
    private Long createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;


    public enum MarritalStatus{
        MARRIED, UNMARRIED
    }
    public enum Gender{
        MALE, FEMALE
    }
}
