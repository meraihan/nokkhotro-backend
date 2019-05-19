package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Beneficiary;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.BeneficiaryFingerprint;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.MultipartImage;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.BeneficiaryFingerprintRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.BeneficiaryRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.HouseholdRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class BeneficiaryFingerprintService {

    @Autowired
    BeneficiaryFingerprintRepository beneficiaryFingerprintRepository;
    @Autowired
    HouseholdRepository householdRepository;
    @Autowired
    BeneficiaryRepository beneficiaryRepository;

    public List<BeneficiaryFingerprint> verify(String contactNumber) throws IOException {
        int householdId = householdRepository.findHouseholdByContactNumber(contactNumber).getId();

        List<Beneficiary> beneficiaryList = beneficiaryRepository.getBeneficiaryListByHouseholdId(householdId);


        List<BeneficiaryFingerprint> fingerprintList = new ArrayList<>();

        for(Beneficiary bf : beneficiaryList) {
            fingerprintList = beneficiaryFingerprintRepository.getFingerPrintList(bf.getId());

            for (BeneficiaryFingerprint bfp : fingerprintList){
                BufferedImage originalImage = ImageIO.read(new File(bfp.getFingerprintLocation()));
                BeneficiaryFingerprint fingerprint = new BeneficiaryFingerprint();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(originalImage, "png", outputStream);
                MultipartFile multipartFile = new MultipartImage(outputStream.toByteArray(), bf.getId().toString());
                fingerprint.setFingerImage(multipartFile.getBytes());
            }
        }

        return fingerprintList;
    }

}
