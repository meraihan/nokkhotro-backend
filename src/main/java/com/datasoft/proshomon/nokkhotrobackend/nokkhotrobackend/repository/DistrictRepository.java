package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.District;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper.DistrictRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class DistrictRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<District> findAll() {
        String query = "select * from district";
        try {
            return jdbcTemplate.query(query, new DistrictRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
