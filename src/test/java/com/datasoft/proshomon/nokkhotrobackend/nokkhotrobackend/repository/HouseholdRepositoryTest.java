//package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;
//
//import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
//import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service.HouseholdService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@Slf4j
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class HouseholdRepositoryTest {
//
//    @Autowired
//    HouseholdService householdService;
//
//    @Test
////    @Ignore
//    public void add() {
//        Household household = new Household();
//        household.setHouseholdHeadName("Saidul Haque");
//        household.setContactNumber("01818397066");
//        household.setStatus(Household.Status.ACTIVE);
//        household.setOccupation("Doctor");
//        household.setNumOfMembers(6);
//        household.setDivision("Chittagong");
//        household.setDistrict("Feni");
//        household.setUpazilla("Dagonbhuiyan");
//        household.setMunicipality("Dagonbhuiyan");
//        household.setWordNo("6");
//        household.setAddress("SouthKarimpur");
//        household.setLatitude(32.654);
//        household.setLongitude(345.232);
//        Household inserted = householdService.addHousehold(household);
//        Assert.assertNotNull(inserted.getId());
//        household.setId(inserted.getId().intValue());
//        log.info("Inserted: {}", household);
//    }
//}
