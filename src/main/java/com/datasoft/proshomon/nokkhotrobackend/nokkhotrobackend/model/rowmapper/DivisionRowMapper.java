package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Beneficiary;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Division;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DivisionRowMapper implements RowMapper<Division> {
    @Override
    public Division mapRow(ResultSet rs, int i) throws SQLException {
        Division division = new Division();
        division.setId(rs.getInt("id"));
        division.setCode(rs.getInt("Code"));
        division.setName(rs.getString("Name"));
        return division;
    }
}
