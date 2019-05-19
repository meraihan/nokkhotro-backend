package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.PostOffice;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper.PostOfficeRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
public class PostOfficeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<PostOffice> findAll() {
        String query = "select * from postoffice";
        try {
            return jdbcTemplate.query(query, new PostOfficeRowMapper());
        } catch (DataAccessException dae) {
            log.error(dae.getMessage());
            return null;
        }
    }
}
