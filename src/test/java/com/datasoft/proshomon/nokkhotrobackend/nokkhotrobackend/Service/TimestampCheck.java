package com.datasoft.proshomon.nokkhotrobackend.nokkhotrobackend.Service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.sql.Timestamp;

@Slf4j
public class TimestampCheck {

    @Test
    public void readWriteFromExcel() throws Exception {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());

        log.info("{}", timestamp);
        log.info("{}", timestamp2);

    }

}
