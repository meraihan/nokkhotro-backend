package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HouseholdRowMapper  implements RowMapper<Household> {

    @Override
    public Household mapRow(ResultSet rs, int i) throws SQLException {
        Household household = new Household();
        household.setId(rs.getInt("id"));
        household.setSmartCardId(rs.getString("smart_card_id"));
        household.setHouseholdHeadName(rs.getString("household_head_name"));
        household.setContactNumber(rs.getString("contact_number"));
        household.setStatus(Household.Status.valueOf(rs.getString("status")));
        household.setOccupation(rs.getString("occupation"));
        household.setNumOfMembers(rs.getInt("number_of_members"));
        household.setDistrictId(rs.getInt("division_id"));
        household.setDistrictId(rs.getInt("district_id"));
        household.setUpazillaId(rs.getInt("upazilla_id"));
        household.setMunicipalityId(rs.getInt("municipality_id"));
        household.setWordNo(rs.getString("word_no"));
        household.setAddress(rs.getString("address"));
        household.setLatitude(rs.getDouble("latitude"));
        household.setLongitude(rs.getDouble("longitude"));
        household.setCreatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("created_at")));
        household.setUpdatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("updated_at")));
        household.setDeletedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("deleted_at")));
        return household;
    }
}
