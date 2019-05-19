package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper.HouseholdRowMapper;
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
public class HouseholdRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Household add(Household household) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("household")
                .usingGeneratedKeyColumns("id");
        HashMap<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("sl_no", household.getSlNo());
        parameterMap.put("smart_card_id", household.getSmartCardId());
        parameterMap.put("household_head_name", household.getHouseholdHeadName());
        parameterMap.put("contact_number", household.getContactNumber());
        parameterMap.put("status", household.getStatus().name());
        parameterMap.put("occupation", household.getOccupation());
        parameterMap.put("number_of_members", household.getNumOfMembers());
        parameterMap.put("division_id", household.getDistrictId());
        parameterMap.put("district_id", household.getDistrictId());
        parameterMap.put("upazilla_id", household.getUpazillaId());
        parameterMap.put("municipality_id", household.getMunicipalityId());
        parameterMap.put("word_no", household.getWordNo());
        parameterMap.put("address", household.getAddress());
        parameterMap.put("latitude", household.getLatitude());
        parameterMap.put("longitude", household.getLongitude());
        parameterMap.put("created_by", household.getCreatedBy());
        parameterMap.put("created_at", LocalDateTime.now());
        parameterMap.put("updated_at", LocalDateTime.now());
        parameterMap.put("deleted_at", LocalDateTime.now());

        try {
            log.info("Inserting to household table: {}", parameterMap.toString());
            Number autoGenId = jdbcInsert.executeAndReturnKey(parameterMap);
            if (autoGenId != null) {
                household.setId(autoGenId.intValue());
                log.info("Inserting Household Data With ID: {}", autoGenId);
                return household;
            } else {
                return household;
            }
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public List<Household> findAll() {
        String query = "select * from household";
        try {
            return jdbcTemplate.query(query, new HouseholdRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }

    public Household findHouseholdByContactNumber(String householdContactNumber) {
        String query = "SELECT * FROM household  \n" +
                "                WHERE smart_card_id=?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{householdContactNumber}, new HouseholdRowMapper());
        } catch (DataAccessException dae) {
            log.error("Household Data Not Found, Error: {}", dae.getLocalizedMessage());
            return new Household();
        }
    }
}
