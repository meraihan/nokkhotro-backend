package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
@Repository
public class UserRepository {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User findUserByUserName(String userName) {
        String query = "SELECT id, username, password, full_name, enabled FROM user WHERE username = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{userName}, new CustomUserRowMapper());
        } catch (DataAccessException dae) {
            log.error("User Data Not Found, Error: {}", dae.getLocalizedMessage());
            return new User();
        }
    }

    public User findUserByUserId(Long userId) {
        String query = "SELECT id, username, password, full_name, enabled FROM user WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{userId}, new CustomUserRowMapper());
        } catch (DataAccessException dae) {
            log.error("User Data Not Found, Error: {}", dae.getLocalizedMessage());
            return new User();
        }
    }

    private class CustomUserRowMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setFullName(resultSet.getString("full_name"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
            user.setIsEnabled(resultSet.getBoolean("enabled"));
            return user;
        }
    }
}
