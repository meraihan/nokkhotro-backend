package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Role;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class UsersRolesRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Role> resolveRolesForUser(User user) {
        String query = "SELECT ur.*, r.`name` \n" +
                "FROM users_roles ur\n" +
                "INNER JOIN role r  ON r.id = ur.role_id\n" +
                "WHERE ur.user_id = ?\n";

        try {
            return jdbcTemplate.query(query, new Object [] {user.getId()}, new RowMapper<Role>() {
                @Override
                public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Role role = new Role();
                    role.setRoleName(Role.RoleName.valueOf(rs.getString("name")));
                    return role;
                }
            });
        } catch (DataAccessException dae) {
            log.error("Failed to execute the following query:");
            log.error(query.replace("?", "{}"), user.getId());
            log.error(dae.getLocalizedMessage());
        }
        return new ArrayList<>();
    }
}
