package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.BeneficiaryFingerprint;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper.BeneficiaryFingerprintRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@Slf4j
@Repository
public class BeneficiaryFingerprintRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Number add(BeneficiaryFingerprint beneficiaryFingerprint) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("beneficiary_fingerprint")
                .usingGeneratedKeyColumns("id");
        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("beneficiary_id", beneficiaryFingerprint.getBeneficiary().getId());
        parameterMap.put("fingerprint_type", beneficiaryFingerprint.getFingerprintType());
        parameterMap.put("fingerprint_location", beneficiaryFingerprint.getFingerprintLocation());
        parameterMap.put("created_at", LocalDateTime.now());
        parameterMap.put("updated_at", LocalDateTime.now());
        parameterMap.put("deleted_at", LocalDateTime.now());

        try {
            log.info("Inserting to beneficiary_fingerprint table: {}", parameterMap.toString());
            return jdbcInsert.executeAndReturnKey(parameterMap);
        } catch (DataAccessException dae) {
            log.error("Beneficiary Fingerprint added failed: {}", dae.getMessage());
            return null;
        }
    }

    public boolean deleteByBeneficiaryId(Integer beneficiaryId) {
        String query = "DELETE FROM beneficiary_fingerprint WHERE beneficiary_id = ?";
        boolean deleteResult = false;
        try {
            int id = jdbcTemplate.update(query, beneficiaryId);
            if (id > 0){
                deleteResult = true;
            }
        } catch (DataAccessException dae) {
            log.error("Beneficiary delete failed, Error: {}", dae.getLocalizedMessage());
            deleteResult = false;
        } 
        return deleteResult;
    }

    public List<BeneficiaryFingerprint> getFingerPrintList(Integer beneficiaryId) {
        String query = "SELECT * FROM beneficiary_fingerprint WHERE beneficiary_id = ?";
        try {
            return jdbcTemplate.query(query, new Object[]{beneficiaryId}, new BeneficiaryFingerprintRowMapper());
        } catch (DataAccessException dae) {
            log.error("Beneficiary Fingerprint Data Not Found, Error: {}", dae.getLocalizedMessage());
            return null;
        }
    }
}
