package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.service;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Beneficiary;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.BeneficiaryFingerprint;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.BeneficiaryFingerprintRepository;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.BeneficiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Service
public class BeneficiaryService {

    @Value("${image.location.profilepicture}")
    String photoPath;
    @Value("${image.location.fingerprint}")
    String fingerPrintPath;

    @Autowired
    BeneficiaryRepository beneficiaryRepository;
    @Autowired
    BeneficiaryFingerprintRepository beneficiaryFingerprintRepository;

    public Boolean addBeneficiary(Beneficiary beneficiary) throws Exception {
        Boolean isAdded = false;
        byte[] bytes = Base64.getDecoder().decode(beneficiary.getBase64Img());
        Path path = Paths.get(photoPath + "/"+ new Date().getTime() +".png");
        Files.write(path, bytes);
        beneficiary.setPhotoPath(path.toString());
        if (beneficiaryRepository.add(beneficiary) != null) {
            for (BeneficiaryFingerprint bf : beneficiary.getBeneficiaryFingerprintList()) {
                byte[] bytes1 = bf.getFingerImage();
                Path path1 = Paths.get(fingerPrintPath +"/" + new Date().getTime() + ".bmp");
                Files.write(path1, bytes1);
                Beneficiary newBeneficiary = new Beneficiary();
                newBeneficiary.setId(beneficiary.getId());
                bf.setBeneficiary(newBeneficiary);
                bf.setFingerprintLocation(path1.toString());
                if(beneficiaryFingerprintRepository.add(bf)!=null){
                    isAdded = true;
                } else {
                    beneficiaryRepository.deleteById(beneficiary.getId());
                    isAdded = false;
                }
            }
        }
        return isAdded;
    }

    public List<Beneficiary> beneficiaryList() {
        return beneficiaryRepository.findAll();
    }

    public Beneficiary findBeneficiaryById(int beneficiaryId) throws IOException {
        String pfLocation = getProfilePath(beneficiaryId);
        BufferedImage originalImage = ImageIO.read(new File(pfLocation));
        byte[] byteArray = toByteArrayAutoClosable(originalImage, "png");
        Beneficiary beneficiary = beneficiaryRepository.findById(beneficiaryId);
        beneficiary.setBase64Img(Base64.getEncoder().encodeToString(byteArray));
        return beneficiary;
    }

    public boolean delete(Integer id) {
        boolean isDeleted = false;
        if(beneficiaryFingerprintRepository.deleteByBeneficiaryId(id)){
            if(beneficiaryRepository.deleteById(id)){
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    public String getProfilePath(int beneficiaryId) {
        String filename = beneficiaryRepository.findById(beneficiaryId).getPhotoPath();
        return filename;
    }

    public String findProfileImage(int beneficiaryId) throws IOException {
        String pfLocation = getProfilePath(beneficiaryId);
        BufferedImage originalImage = ImageIO.read(new File(pfLocation));
        byte[] byteArray = toByteArrayAutoClosable(originalImage, "jpg");
        return Base64.getEncoder().encodeToString(byteArray);
    }

    private static byte[] toByteArrayAutoClosable(BufferedImage image, String type) throws IOException {
        try (ByteArrayOutputStream out = new ByteArrayOutputStream()){
            ImageIO.write(image, type, out);
            return out.toByteArray();
        }
    }
}
