package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.Service;


import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.model.Household;
import com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.repository.HouseholdRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReadWriteExcelFile {


    @Autowired
    HouseholdRepository householdRepository;
    public static final String XLSX_FILE_PATH = "./Chandpur_SelectedData.xlsx";

    @Test
    public void readWriteFromExcel() throws Exception {
        FileInputStream file = new FileInputStream(new File(XLSX_FILE_PATH));
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        Row row;
        for(int i=1; i<=sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);

            String id;
            if(row.getCell(0)==null){id = "0";}
            else id = row.getCell(0).toString();

            String houseHoldHeadName;
            if(row.getCell(2)==null) houseHoldHeadName="null";
            else houseHoldHeadName = row.getCell(2).toString();

            String contactNumber;
            Cell contactNo = row.getCell(23, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (contactNo != null) {
                contactNo.setCellType(CellType.STRING);
                contactNumber = "0"+contactNo.getStringCellValue();
            }
            else {
                contactNumber = null;
            }

            String occupation;
            if(row.getCell(11)==null) occupation = "null";
            else occupation = row.getCell(11).toString();

            String numOfMembers;
            if(row.getCell(12)==null) numOfMembers = "null";
            else numOfMembers = row.getCell(12).toString();

            String wordNo;
            Cell wn = row.getCell(8, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            if (wn !=null){
                wn.setCellType(CellType.STRING);
                wordNo = wn.getStringCellValue();
            } else wordNo = null;

            String address;
            if(row.getCell(7)==null) address = "null";
            else address = row.getCell(7).toString();

            try {
                Double convertIdFromStringToDouble = Double.parseDouble(id);
                int convertIdFromDoubleToInt = convertIdFromStringToDouble.intValue();
                Household household = new Household();
                household.setSlNo(convertIdFromDoubleToInt);
                household.setSmartCardId(generateSmartCardNumber(wordNo, i));
                household.setHouseholdHeadName(houseHoldHeadName);
                household.setContactNumber(contactNumber);
                household.setOccupation(occupation);
                Double convertedNumOfMembersFromString = Double.parseDouble(numOfMembers);
                int convertedNumOfMembersToInt = convertedNumOfMembersFromString.intValue();
                household.setNumOfMembers(convertedNumOfMembersToInt);
                household.setDivisionId(1);
                household.setDistrictId(2);
                household.setUpazillaId(2);
                household.setMunicipalityId(2);
                household.setStatus(Household.Status.ACTIVE);
                household.setWordNo(wordNo);
                household.setAddress(address);
                household.setCreatedBy(Long.valueOf(1));
                householdRepository.add(household);
            } catch (Exception e){
                log.error("Inserting Data Failed: {}", e);
            }
        }
        file.close();
    }

    public String generateSmartCardNumber(String wordNo, int serialNumber){
        Double convertedWordNoFromString = Double.parseDouble(wordNo);
        int convertedWordNoFromInt = convertedWordNoFromString.intValue();

        String cardNum = "20"+ "30" + "29"+ "50" +String.format("%02d" ,convertedWordNoFromInt)+
                 String.format("%06d", serialNumber);
        return cardNum;
    }

}
