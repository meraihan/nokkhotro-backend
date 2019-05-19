package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.rowmapper;

import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Beneficiary;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.utils.Helper;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BeneficiaryRowMapper  implements RowMapper<Beneficiary> {
    @Override
    public Beneficiary mapRow(ResultSet rs, int i) throws SQLException {
        Beneficiary beneficiary = new Beneficiary();
        beneficiary.setId(rs.getInt("id"));
        beneficiary.setFullName(rs.getString("full_name"));
        Household household = new Household();
        household.setId(rs.getInt("household_id"));
        beneficiary.setHousehold(household);
        beneficiary.setContactNumber(rs.getString("contact_number"));
        beneficiary.setBloodGroup(rs.getString("blood_group"));
        beneficiary.setMarritalStatus(Beneficiary.MarritalStatus.valueOf(rs.getString("marrital_status")));
        beneficiary.setRelationWithHousehold(rs.getString("relation_with_household"));
        beneficiary.setDateOfBirth(rs.getDate("date_of_birth"));
        beneficiary.setGender(Beneficiary.Gender.valueOf(rs.getString("gender")));
        beneficiary.setPhotoPath(rs.getString("photo_path"));
        beneficiary.setFingerprintKey1(rs.getString("fingerprint_key1"));
        beneficiary.setFingerprintKey2(rs.getString("fingerprint_key2"));
        if(rs.getString("disability")!=null){
            beneficiary.setDisability(rs.getString("disability"));
        }
        beneficiary.setCreatedBy(rs.getLong("created_by"));
        beneficiary.setCreatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("created_at")));
        beneficiary.setUpdatedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("updated_at")));
        beneficiary.setDeletedAt(Helper.timeStampToLocalDateTime(rs.getTimestamp("deleted_at")));
        return beneficiary;
    }
}
