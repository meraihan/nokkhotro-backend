//package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;
//
//import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Beneficiary;
//import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
//import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.MultipartImage;
//import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service.BeneficiaryService;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayOutputStream;
//import java.io.File;
//import java.util.Date;
//
//@Slf4j
//@SpringBootTest
//@RunWith(SpringRunner.class)
//public class BeneficiaryRepositoryTest {
//
//    @Autowired
//    BeneficiaryService beneficiaryService;
//
//    @Test
////    @Ignore
//    public void add() throws Exception {
//        Beneficiary beneficiary = new Beneficiary();
//        beneficiary.setFullName("Emrajul Naim");
//        beneficiary.setContactNumber("01600776987");
//        Household household = new Household();
//        household.setId(10);
//        beneficiary.setHousehold(household);
//        beneficiary.setBloodGroup("B+");
//        beneficiary.setMarritalStatus(Beneficiary.MarritalStatus.MARRIED);
//        beneficiary.setRelationWithHousehold("Brother");
//        beneficiary.setDateOfBirth(new Date());
//        beneficiary.setGender(Beneficiary.Gender.MALE);
//
//        BufferedImage originalImage = ImageIO.read(new File("/home/rayhan/Downloads/myfather.jpg"));
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ImageIO.write( originalImage, "jpg", baos );
//        baos.flush();
//        MultipartFile multipartFile = new MultipartImage(baos.toByteArray(), "myfather");
////        beneficiary.setPhoto(multipartFile.toString());
//
//        beneficiary.setPhotoPath("/home/rayhan/download/");
//        beneficiary.setFingerprintKey1("ad32423jhg23jh423jh423jh4g23jh4g23jh4");
//        beneficiary.setFingerprintKey2("asdsa2344234n23b4jk23jh423jh423jh4g23j");
//        beneficiary.setDisability("Something");
//        beneficiaryService.addBeneficiary(beneficiary);
////        Assert.assertNotNull(insertedId);
////        beneficiary.setId(insertedId.intValue());
//        log.info("Inserted: {}", beneficiary);
//    }
//}
