package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.User;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User user = new User();
        user.setFullName(rs.getString("full_name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setPhone(rs.getString("phone"));
        user.setEmail(rs.getString("email"));
        user.setLastPasswordResetDate(Helper.timeStampToLocalDateTime(rs.getTimestamp("last_password_reset_time")));
        user.setIsEnabled(rs.getBoolean("enabled"));
        user.setCreatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("created_at")));
        user.setUpdatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("updated_at")));
        user.setDeletedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("deleted_at")));
        return user;
    }
}
