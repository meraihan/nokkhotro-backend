package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.PostOffice;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostOfficeRowMapper implements RowMapper<PostOffice> {
    @Override
    public PostOffice mapRow(ResultSet rs, int i) throws SQLException {
        PostOffice postOffice = new PostOffice();
        postOffice.setId(rs.getInt("id"));
        postOffice.setCode(rs.getInt("PostCode"));
        postOffice.setThanaId(rs.getInt("ThanaId"));
        postOffice.setName(rs.getString("PostOffice"));
        return postOffice;
    }
}
